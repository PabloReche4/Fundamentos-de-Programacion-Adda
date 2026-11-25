package fp.Beca;

import java.util.ArrayList;
import java.util.List;

import utiles.Checkers;
import utiles.Ficheros;

public class FactoriaBeca {
	public static List<Beca> leerBecas (String ruta){
		List<Beca> becas = new ArrayList<Beca>();
		List<String> lineas = Ficheros.leeFichero("error en lectura de becas", "data/becas.csv");
		for(String linea : lineas.subList(1, lineas.size())) {
			becas.add(parseaBecas(linea));
		}
		return becas;
	}

	private static Beca parseaBecas(String linea) {
		
		Checkers.checkNoNull(linea);
		String [] trozos = linea.split(",");
		Checkers.check("No tienen todos los argumentos", trozos.length==4);
		String codigo = trozos[0].trim();
		Double cuantiaTot = Double.valueOf(trozos[1].trim());
		Integer duracion =Integer.valueOf( trozos[2].trim());
		TipoBeca tipo = TipoBeca.valueOf(trozos[3].trim().toUpperCase());
		
		return new Beca(codigo, cuantiaTot, duracion, tipo);
	}
}
