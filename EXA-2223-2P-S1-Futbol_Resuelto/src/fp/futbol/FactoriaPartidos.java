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
	private static Partido parseaPartido(String lineaCSV) {
		String[] trozos=lineaCSV.split(";");
		Checkers.check("La línea está mal troceada",trozos.length==6);
		LocalDate fechaPartido = LocalDate.parse(trozos[0].trim(),DateTimeFormatter.ofPattern("d/M/y"));
		String equipoLocal = trozos[1].trim();
		String equipoVisitante = trozos[2].trim();
		Integer númeroEspectadores = Integer.valueOf(trozos[3].trim());
		Competicion competición =Competicion.valueOf(trozos[4].trim().toUpperCase()) ;
		List<ResultadoParcial> resultadosParciales=parseaResultados(trozos[5].trim());
		return new Partido(fechaPartido, equipoLocal, equipoVisitante, númeroEspectadores, competición, resultadosParciales);
	}
	private static List<ResultadoParcial> parseaResultados(String r){
		List<ResultadoParcial> res=new ArrayList<ResultadoParcial>();
		r=r.replace("[","").replace("]","");
		for (String trozo: r.split(",")) {
			String[] partes=trozo.split("-");
			res.add(new ResultadoParcial(Integer.valueOf(partes[0].trim()),
										 Integer.valueOf(partes[1].trim()), 
										 Integer.valueOf(partes[2].trim())));
			
		}
		return res;
	}
}

	