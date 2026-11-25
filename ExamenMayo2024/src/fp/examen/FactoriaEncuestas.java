package fp.examen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaEncuestas {
	public static EstadisticasEncuestas leerEncuestas(String ruta) {
		List<Encuesta>encuestas=new ArrayList<Encuesta>();
		List<String>lineas=Ficheros.leeFichero("error en lectura", "data/encuestas_electorales.csv");
		for(String linea:lineas.subList(1, lineas.size())) {
			encuestas.add(parsearEncuesta(linea));
		}
		return new EstadisticasEncuestas(encuestas.stream());
		
	}
	public static Encuesta  parsearEncuesta(String lineaCSV) {
		Checkers.checkNoNull(lineaCSV);
		String []trozos=lineaCSV.split(",");
		Checkers.check("Factoria Encuestas::FormatoNoValido", trozos.length==8);
		String nombre=trozos[0].strip();
		LocalDate fechaComienzo=LocalDate.parse(trozos[1].strip());
		LocalDate fechaFin=LocalDate.parse(trozos[2].strip());
		Integer numEncuestados=Integer.valueOf(trozos[3].strip());
		String pais=trozos[4].strip();
		TipoEncuesta tipo=parseaTipoEncuesta(trozos[5].strip());
		Double porcentajeIndecisos=Double.valueOf(trozos[6].strip());
		List<Resultado>resultados=parseaResultados(trozos[7].strip());
		return new Encuesta(nombre, fechaComienzo, fechaFin, numEncuestados, pais, tipo, porcentajeIndecisos, resultados);
		}

	private static List<Resultado> parseaResultados(String cad) {
		String clean=cad.replace("'", "").replace("(", "").replace(")", "");
		String [] trozos=clean.split(";");
		List <Resultado>res=new ArrayList<>();
		for(String trozo:trozos) {
			res.add(parseaResultado(trozo.strip()));
			
		}
		return res;
	}

	private static Resultado parseaResultado(String trozo) {
		String [] trozos=trozo.split(":");
		Checkers.check("Formato no valido", trozos.length==2);
		String partido=trozos[0].strip();
		Double porcentaje=Double.valueOf(trozos[1].strip());
		return new Resultado(partido, porcentaje);
	}

	private static TipoEncuesta parseaTipoEncuesta(String strip) {
		return TipoEncuesta.valueOf(strip.toUpperCase());
	}
}
