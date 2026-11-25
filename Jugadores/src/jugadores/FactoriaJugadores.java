package jugadores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaJugadores {
	
	public static EstadisticasJugadores leeJugadores(String fichero) {
		List<String> lineas = Ficheros.leeFichero("error leyendo fichero", fichero);
		List<Jugador> res = new ArrayList<>();
		for(String linea : lineas.subList(1, lineas.size()-1)) {
			res.add(parseaJugadores(linea));
		}
		return new EstadisticasJugadores(res.stream());
	}
	
	private static Jugador parseaJugadores(String linea) {
		Checkers.checkNoNull(linea);
		String [] t = linea.split(";");
		Checkers.check("formato de linea no valido", t.length == 9);
		
		String nombre = t[0].trim();
		LocalDate fechaN = LocalDate.parse(t[1].strip(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Posicion pos = Posicion.valueOf(t[2].trim());
		Integer goles = Integer.valueOf(t[3].trim());
		Integer asis = Integer.valueOf(t[4].trim());
		List<String> lesiones = parseaListas(t[5]);
		Equipo equipo = new Equipo(t[6].trim(), Integer.valueOf(t[7].trim()), t[8].trim());
		
		return new Jugador(nombre, fechaN, pos, goles, asis, lesiones, equipo);
	}
	
	//[Tobillo izquierdo, Gemelo derecho, Gemelo derecho]

	private static List<String> parseaListas(String string) {
		List<String> res = new ArrayList<>();
		string = string.replace("[", "").replace("]", "").replaceAll("", "");
		for (String e : string.split(",")) {
			res.add(e);
		}
		return res;
	}

}
