package fp.futbol;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import fp.utiles.Checkers;

	




public class FactoriaPartidos {

	public static EstadisticasPartidos leePartidos(String ruta) {
		EstadisticasPartidos res = null;
		try {
			Stream<Partido> sv = Files.lines(Paths.get(ruta))
									    .skip(1)
										.map(FactoriaPartidos::parseaPartido);
			res = new EstadisticasPartidos(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + ruta);
			e.printStackTrace();
		}
		return res;
	}
	private static final String DELIMITADOR_PRINCIPAL = ";"; 
	private static final String DELIMITADOR_SECUNDARIO = ","; 
	private static final String DELIMITADOR_RESULTADO = "-"; 
	public static Partido parseaPartido(String s) {
		Checkers.checkNoNull(s);
		String [] splits=s.split(DELIMITADOR_PRINCIPAL);
		String msg= String.format("Formato no válido", s);
		Checkers.check(msg, splits.length==6);
		LocalDate fecha=parseaFecha(splits[0].trim());
		String equipoLocal= splits[1].trim();
		String equipoVisitante=splits[2].trim();
		Long espectadores= Long.valueOf(splits[3].trim());
		Competicion competicion=Competicion.valueOf(splits[4].trim());
		List <ResultadoParcial>goles=parseaResultadoParcial(splits[5].trim());
		return new Partido(fecha, equipoLocal, equipoVisitante, espectadores, competicion, goles);
	}
	private static List<ResultadoParcial> parseaResultadoParcial(String cad) {
				Checkers.checkNoNull(cad);
				String limpia=cad.replace("[", "").replace("]", "").trim();
				String [] splits=limpia.split(DELIMITADOR_SECUNDARIO);
				List <ResultadoParcial> lg= new ArrayList<>();
				 for (String s: splits) { 
				  lg.add(parseaResultado(s)); 
	} 
	  return lg;  
	}
	private static ResultadoParcial parseaResultado(String cad) {
			Checkers.checkNoNull(cad);
			String [] splits=cad.split(DELIMITADOR_RESULTADO);
			String msg= String.format("Formato no válido", cad);
			Checkers.check(msg, splits.length==3);
			Integer minuto=Integer.valueOf(splits[0].trim());
			Integer golesLocal=Integer.valueOf(splits[1].trim());
			Integer golesVisitante=Integer.valueOf(splits[2].trim());
			return new ResultadoParcial(minuto, golesLocal, golesVisitante);
			
			
	}
	private static LocalDate parseaFecha(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/M/Y"));
	}
}	