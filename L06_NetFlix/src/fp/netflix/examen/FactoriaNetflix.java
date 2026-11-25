package fp.netflix.examen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaNetflix {
	public static CatalogoNetflix leeNetflix(String rutaFichero) {
		List <ProduccionNetflix> prod=  new ArrayList<ProduccionNetflix>();
		try {
			List <String>lineas=Ficheros.leeFichero("Error apertura"+rutaFichero, rutaFichero);
			for(String linea:lineas.subList(1, lineas.size()-1)) {
				prod.add(parsearNetflix(linea));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new CatalogoNetflix(prod.stream());
	}

	private static ProduccionNetflix parsearNetflix(String linea) {
		Checkers.checkNoNull(linea);
		String [] trozos=linea.split(",");
		Checkers.check("No tienen los mismos argumentos", trozos.length==8);
		String titulo=trozos[0].trim();
		Tipo tipo=Tipo.valueOf(trozos[1].trim());
		Integer añoProduccion=Integer.valueOf(trozos[2].trim());
		Duration duracion=Duration.ofMinutes(Long.valueOf(trozos[3].trim()));
		Set<String>generos=parseaGeneros(trozos[4].trim());
		Integer numTemporadas=Integer.valueOf(trozos[5].trim());
		Double score=Double.valueOf(trozos[6].trim());
		Long popularidad=Long.valueOf(trozos[7].trim());
		return new ProduccionNetflix(titulo, tipo, añoProduccion, duracion, generos, numTemporadas, score, popularidad);
	}

	private static Set<String> parseaGeneros(String trim) {
		Checkers.checkNoNull(trim);
		Set <String> aux=new HashSet<>();
		trim=trim.replace("[", "").replace("]", "").replaceAll("", "");
		for(String generos:trim.split(";")) {
			aux.add(generos);
		}
		return aux;
	}
}
