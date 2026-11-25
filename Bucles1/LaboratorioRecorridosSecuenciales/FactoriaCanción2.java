package fp.tipos.música;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import útiles.Checkers;

public class FactoriaCanción2 {
	public static List<Canción> leeCanción(String ruta){
		List<Canción> canciones=new ArrayList<Canción>();
		try {
			List<String> líneas=Files.readAllLines(Paths.get(ruta));
			for (String línea: líneas.subList(1, líneas.size())) {
				canciones.add(parseaCanción(línea));
			}
		}catch(Exception e){
			System.out.println("Error leyendo el fichero: "+e);
		}
		return canciones;
	}
	private static Canción parseaCanción(String línea) {
		Checkers.checkNoNull(línea);
		String[] trozos=línea.split(",");
		Checkers.check("Canción mal troceada ",trozos.length==5);
		String título = trozos[0].trim();
		String artista = trozos[1].trim();
		Duration duración=parseaDuración(trozos[2].trim());
		LocalDate fechaLanzamiento=LocalDate.parse(trozos[3].trim(),
				DateTimeFormatter.ofPattern("y/M/d"));
		Género genero=Género.valueOf(trozos[4].trim().toUpperCase());
		return new Canción(título, artista, duración, fechaLanzamiento, genero);
	}
	private static Duration parseaDuración(String s) {
		String[] trozos=s.split(":");
		return Duration.parse("PT"+trozos[0].trim()+"M"+trozos[1].trim()+"S");
	}
}
