package fp.trayecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;


public class FactoriaTrayecto {
//	public static Competicion leePartidos(String rutaFichero){
//		List<Visita>res=new ArrayList<>();
//		List<String>lineas=Ficheros.leeFichero("error en apertura", rutaFichero);
//		for(String linea : lineas.subList(1, lineas.size()-1)) {
//		res.add(parseaVisita(linea));
public static ControlTrayectos leeTrayectos(String ruta) {
		List<Trayecto>res=new ArrayList<>();
		List<String>lineas=Ficheros.leeFichero("error en apertura", ruta);
		for(String linea:lineas.subList(1, lineas.size()-1)) {
			res.add(parsearTrayecto(linea));
		}
		return new ControlTrayectos(res.stream());
	}
//19/4/2023 10:30;Line1;TUSA;146;E234;[21-A345, 42-G234, 17-H234]

public static Trayecto parsearTrayecto(String linea) {
	String[]trozos=linea.split(";");
	Checkers.check("longitud incorrecta", trozos.length==6);
	LocalDateTime fechaHora=LocalDateTime.parse(trozos[0].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	String nombre=trozos[1].trim();
	Empresa empresa=Empresa.valueOf(trozos[2].trim().toUpperCase());
	Integer usuarios=Integer.parseInt(trozos[3].trim());
	String paradaInicial=trozos[4].trim();
	List<Etapa>recorrido=parseaLista(trozos[5].trim());
	return new Trayecto(fechaHora,nombre, empresa, usuarios, paradaInicial, recorrido);
}

private static List<Etapa> parseaLista(String a) {
	List<Etapa>res=new ArrayList<>();
	String limpia=a.replace("[", "").replace("]", "").trim();
	if (limpia!="") {
		String[]trozos=limpia.split(",");
		for(String trozo:trozos) {
			String[]t=trozo.split("-");
			Checkers.check("longitud incorrecta", t.length==2);
			Integer minutos=Integer.parseInt(trozos[0].trim());
			String parada=trozos[1].trim();
			res.add(new Etapa(parada, minutos));
		}
	}
	return res;
}
}
