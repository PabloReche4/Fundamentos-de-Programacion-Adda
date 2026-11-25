package fp.geonames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


import fp.utiles.Checkers;

public class FactoriaPaises {
	public static PaisesDelMundo  leePaises(String ruta) {
		PaisesDelMundo res=null;
		try {
			Stream<Pais> sv=Files.lines(Paths.get(ruta))
					.skip(1)
					.map(FactoriaPaises::parsearPais);
			res= new PaisesDelMundo(sv);
			}catch(IOException e) {
				System.out.println("No se ha encontrado el fichero"+ruta);
				e.printStackTrace();
			}
		return res;
	}
	
	
	
	
	private static Pais parsearPais(String lineaCSV) {
		Checkers.checkNoNull(lineaCSV);
		String[] trozos= lineaCSV.split(";");
		Checkers.check("Formato incorrecto.", trozos.length == 9 );
		
		String codigoISO = trozos[0].trim();
		String nombre= trozos[1].trim();
		Long poblacion= Long.valueOf(trozos[2].trim());
		Double area= Double.valueOf(trozos[3].trim());
		String capital= trozos[4].trim();
		Continente continente= parseaContinente(trozos[5].trim());
		String moneda= trozos[6].trim();
		List<Idioma> idiomas= parseaLista(trozos[7].trim());
		Set<String> paisesVecinos = parseaSet(trozos[8].trim());
		
		return new Pais(codigoISO, nombre, poblacion, area, capital, continente, moneda,idiomas, paisesVecinos);
	}			
	private static Set<String> parseaSet(String cad){
		Set<String> res = new HashSet<>();
		String [] trozos = cad.split(",");
		for(String t:trozos) {
			if(!t.isEmpty()) {
				res.add(t.trim());
			}
		}
		return res;
	}
	private static Idioma parseaIdioma(String cad) {
		Checkers.checkNoNull(cad);
		String[] trozos= cad.split(":");
		Checkers.check("Formato incorrecto.", trozos.length == 2);
		
		String nombre= trozos[0].trim();
		Double porcentaje= Double.valueOf(trozos[1].trim());
		
		return new Idioma(nombre, porcentaje);
	}
	private static List<Idioma> parseaLista(String cad){
		List<Idioma> res= new ArrayList<>();
		String [] trozos = cad.split(",");
		for(String t:trozos) {
			if(!t.isEmpty()) {
				res.add(parseaIdioma(t.trim()));
			}
		}
		return res;
	}
	private static Continente parseaContinente(String s) {
		switch(s) {
		case "AF": return Continente.AFRICA;
		case "AN": return Continente.ANTARCTICA;
		case "AS": return Continente.ASIA;
		case "EU": return Continente.EUROPE;
		case "NA": return Continente.NORTH_AMERICA;
		case "OC": return Continente.OCEANIA;
		case "SA": return Continente.SOUTH_AMERICA;
		default: return null;
		}
	}
	}