package fp.examen.test;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

import fp.examen.*;


public class Test {

	public static void main(String[] args) {
		EstadisticasEncuestas est=FactoriaEncuestas.leerEncuestas("data/encuestas_electorales.csv");
		System.out.println("Numero de encuestas :" + est.getEncuestas().size());
		for(Encuesta en : est.getEncuestas()) {
			System.out.println(en);
		}
		System.out.println("\n");
		System.out.println("Ejercicio 1"+"=".repeat(80));
		testgetMediaNumEncuestadosConsultorayFecha(est,"Consultora A",LocalDate.of(2024, 5, 29));
		testgetMediaNumEncuestadosConsultorayFecha(est,"Consultora B",LocalDate.of(2024, 5, 26));
		System.out.println("Ejercicio 2"+"=".repeat(80));
		testgetEncuestaMasEncuestadosPorDia(est, TipoEncuesta.TELEFONICA);
		testgetEncuestaMasEncuestadosPorDia(est, TipoEncuesta.PRESENCIAL);
		System.out.println("Ejercicio 3"+"=".repeat(80));
		testgetPartidosMasFrecuentesOrdenados(est, 5);
		System.out.println("Ejercicio 4"+"=".repeat(80));
		testgetSuperaEncuestadosPorPais(est, 3500);
		System.out.println("Ejercicio 5"+"=".repeat(80));
		testgetPaisesPorPartidoMayorPorcentaje(est, 90.);
		testgetPaisesPorPartidoMayorPorcentaje(est, 97.);
	}


	private static void testgetMediaNumEncuestadosConsultorayFecha(EstadisticasEncuestas est, String string,
			LocalDate of) {
		try {
			Double m=est.getMediaNumEncuestadosConsultorayFecha(string, of);
			String msg=String.format("La media de la consultora %s con	fecha de fin anterior a %s es %f", string, of, m); 
			System.out.println(msg);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	private static void testgetEncuestaMasEncuestadosPorDia(EstadisticasEncuestas est, TipoEncuesta tipo) {
		try {
			Encuesta r=est.getEncuestaMasEncuestadosPorDia(tipo);
			String msg=String.format("\tLa encuesta de tipo %s con mayor ratio de encuestados por día es :\n%s ", tipo, r); 
			System.out.println(msg);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void testgetPartidosMasFrecuentesOrdenados(EstadisticasEncuestas est, int i) {
		try {
			List<String>r=est.getPartidosMasFrecuentesOrdenados(i);
			String msg=String.format("\tLos %d partidos más frecuentes en las encuestas son:\n%s", i, r);
			System.out.println(msg);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void testgetSuperaEncuestadosPorPais(EstadisticasEncuestas est, int i) {
		try {
			SortedMap<String, Boolean>r=est.getSuperaEncuestadosPorPais(i);
		 String msg=String.format("\t¿Todas las encuestas de estos países superan los %s encuestados?:\n%s ", i, r);
		 System.out.println(msg);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void testgetPaisesPorPartidoMayorPorcentaje(EstadisticasEncuestas est, double d) {
		try {
		Map<String, SortedSet<String>>r=est.getPaisesPorPartidoMayorPorcentaje(d);
		String msg=String.format("\tPaíses donde cada partido ha obtenido un porcentaje de votos superior a %1f :\n%s ", d, r); 
		System.out.println(msg);
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}



	



	
	 
		
	


