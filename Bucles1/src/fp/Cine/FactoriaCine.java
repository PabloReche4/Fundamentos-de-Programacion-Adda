package fp.Cine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import utiles.Checkers;
import utiles.Ficheros;

public class FactoriaCine {
	public static List<Peliculas> leerPeliculas (String ruta){
		List<Peliculas> peliculas = new ArrayList<Peliculas>();
		List<String> lineas = Ficheros.leeFichero("error en lectura de peliculas", "data/peliculas.csv");
		for(String linea : lineas.subList(1, lineas.size())) {
			peliculas.add(parseaPelicula(linea));
		}
		return peliculas;
	}

	private static Peliculas parseaPelicula(String linea) {
		Checkers.checkNoNull(linea);
		String [] trozos = linea.split(";");
		Checkers.check("No tienen todos los argumentos", trozos.length==3);
		String titulo = trozos[0].trim();
		Integer duracion = Integer.valueOf(trozos[1].trim().substring(0,trozos[1].trim().length()-4));
		LocalDate fechaDeEstreno = LocalDate.parse(trozos[2].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		
		return new Peliculas(titulo, fechaDeEstreno, duracion);
	}
}
