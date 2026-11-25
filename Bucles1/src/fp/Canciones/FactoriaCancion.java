package fp.Canciones;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import utiles.Checkers;
import utiles.Ficheros;

public class FactoriaCancion {
	public static List<Cancion> leerCanciones (String ruta){
		List<Cancion> canciones = new ArrayList<Cancion>();
		List<String> lineas = Ficheros.leeFichero("error en lectura de canciones", "data/canciones.csv");
		for(String linea : lineas.subList(1, lineas.size())) {
			canciones.add(parseaCancion(linea));
		}
		return canciones;
	}
	
	private static Cancion parseaCancion(String linea) {
		Checkers.checkNoNull(linea);
		String [] trozos = linea.split(",");
		Checkers.check("No tienen todos los argumentos", trozos.length==5);
		String titulo = trozos[0].trim();
		String artista = trozos[1].trim();
		Duration duracion = parseaDuracion(trozos[2].trim());
		LocalDate fechaLanzamiento = LocalDate.parse(trozos[3].trim(), DateTimeFormatter.ofPattern("y/M/d"));
		Genero genero = Genero.valueOf(trozos[4].trim().toUpperCase());
		
		return new Cancion(titulo, artista, duracion, fechaLanzamiento,genero);
	}

	private static Duration parseaDuracion(String d) {
		String [] trozos = d.split(":");
		return Duration.parse("PT" + trozos[0].trim() + "M" + trozos[1].trim() + "S");
	}
}
