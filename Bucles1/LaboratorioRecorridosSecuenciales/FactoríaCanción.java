package fp.tipos.musica;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import útiles.Checkers;
import útiles.Ficheros;

public class FactoríaCanción {
	public static List<Canción> leerCanciones(String ruta){
		List<Canción> canciones=new ArrayList<Canción>();
		List<String> líneas=Ficheros.leeFichero("Error en lectura de canciones",
				             "data/canciones.csv");	
		for (String línea:líneas.subList(1,líneas.size())) {
			canciones.add(parseaCanción(línea));
		}
		return canciones;
		
	}
	
	private static Canción parseaCanción(String línea) {
		Checkers.checkNoNull(línea);
		String[] trozos=línea.split(",");
		Checkers.check("Canción mal formateada",trozos.length==5);
		String título = trozos[0].trim();
		String artista = trozos[1].trim();
		Duration duración = parseaDuración(trozos[2].trim());
		LocalDate fechaLanzamiento = LocalDate.parse(trozos[3].trim(),
				         DateTimeFormatter.ofPattern("y/M/d"));
		Género género = Género.valueOf(trozos[4].trim().toUpperCase());
		
		return new Canción(título, artista, duración, fechaLanzamiento, género);
	}
	private static Duration parseaDuración(String d) {
		String[] trozos=d.split(":");
		return Duration.parse("PT"+trozos[0].trim()+"M"+
								   trozos[1].trim()+"S");
	}
}
