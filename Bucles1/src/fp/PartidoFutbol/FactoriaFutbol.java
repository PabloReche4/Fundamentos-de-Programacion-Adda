package fp.PartidoFutbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import utiles.Checkers;
import utiles.Ficheros;

public class FactoriaFutbol {
	
	public static List<PartidoFutbol> leerPartidos (String ruta){
		
		List<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();
		List<String> lineas = Ficheros.leeFichero("error en lectura de partidos", "data/partidos.csv");
		for(String linea : lineas.subList(1, lineas.size())) {
			partidos.add(parseaPartidos(linea));
		}
		return partidos;
	}

	private static PartidoFutbol parseaPartidos(String linea) {
		
		Checkers.checkNoNull(linea);
		String [] trozos = linea.split(";");
		Checkers.check("No tienen todos los argumentos", trozos.length==5);
		
		LocalDate fecha = LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		String casa = trozos[1].trim();
		String fuera = trozos[2].trim();
		Integer golCasa = Integer.valueOf(trozos[3].trim());
		Integer golFuera = Integer.valueOf(trozos[4].trim());
		
		return new PartidoFutbol(fecha, casa, fuera, golCasa, golFuera);
	}
}
