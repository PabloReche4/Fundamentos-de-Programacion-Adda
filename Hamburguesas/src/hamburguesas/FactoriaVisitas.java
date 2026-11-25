package hamburguesas;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaVisitas {

	public static Competicion leePartidos(String rutaFichero){
		List<Visita>res=new ArrayList<>();
		List<String>lineas=Ficheros.leeFichero("error en apertura", rutaFichero);
		for(String linea : lineas.subList(1, lineas.size()-1)) {
		res.add(parseaVisita(linea));
	
}
		return new Competicion(res.stream());
}
//Email;Ciudad;CP;FechaHoraEntrada;Temperatura;FechaHoraSalida;Evaluaciones
// usuario2@example.com;Sevilla;41006;04/06/2024 11:14;34;04/06/2024 14:14;[Brothers: (5, 7, 10, 8) - Umbrella: (6, 5, 7, 7)]

	public static Visita parseaVisita(String linea) {
		String[] trozos=linea.split(";");
		Checkers.check("Formato no valido",trozos.length==7);
		String email=trozos[0].trim();
		String ciudad=trozos[1].trim();
		String cp=trozos[2].trim();
		LocalDateTime entrada=LocalDateTime.parse(trozos[3].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		Double temperatura=Double.valueOf(trozos[4].trim());
		LocalDateTime salida=LocalDateTime.parse(trozos[5].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		List<Evaluacion>evaluaciones=parseaLista(trozos[6].trim());
		return new Visita(email, ciudad, cp, entrada, salida, temperatura, evaluaciones);
	}

	private static List<Evaluacion> parseaLista(String a) {
		List<Evaluacion>res=new ArrayList<>();
		String limpia=a.replace("[", "").replace("]", "").trim();
		String [] trozos=limpia.split("-");
		for (String t:trozos) {
			res.add(parseaEvaluacion(t.strip()));	
		}
		return res;
	}

	private static Evaluacion parseaEvaluacion(String l) {
		String limpia=l.replace("(", "").replace(")", "");
		String [] trozos= limpia.split(":");
		Checkers.check("Formato no valido", trozos.length==2);
		String nombre=trozos[0].trim();
		String[] valoraciones=trozos[1].split(",");
		Checkers.check("formato no valido", valoraciones.length==4);
		Integer presentacion=Integer.valueOf(trozos[0].trim());
		Integer puntoCarne=Integer.valueOf(trozos[1].trim());
		Integer calidadPan=Integer.valueOf(trozos[2].trim());
		Integer calidadIngredientes=Integer.valueOf(trozos[3].trim());
				
		return new Evaluacion(nombre, presentacion, puntoCarne, calidadPan, calidadIngredientes);
	}
}