package fp.netflix.test;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import fp.netflix.examen.*;


public class TestNetflix {
	private static <K, V> void imprimeMap(final Map<K, V> map) { 
		map.entrySet().stream() 
		.forEach(entry -> System.out.println( entry.getKey() + " , " +  
		entry.getValue()));
	}
	public static <E> void imprimeColeccion(Collection<E> coleccion) { 
		  coleccion.stream() 
		         .forEach(x -> System.out.println(x));
	}
	public static void main(String[] args) {
		CatalogoNetflix c = FactoriaNetflix.leeNetflix("data/titulos_netflix.csv");
		System.out.println(c);
		testEjercicio1(c);
		testEjercicio2(c); 
		testEjercicio3(c,List.of("comedy", "action")); 
//		testEjercicio4(c); 
//		testEjercicio5(c, "action", 5); 
//		testEjercicio6(c);
		
		}
//	private static void testEjercicio6(CatalogoNetflix c) {
//		System.out.println("------------------------------");
//		System.out.println("Ejercicio4.6:");
//		System.out.println(c.getPorcentajeTemporadasSeriesPorAnyo());
//		
//	}
	private static void testEjercicio1(CatalogoNetflix c) {
		System.out.println("------------------------------");
		System.out.println("Ejercicio4.1:");
		System.out.println(c.getProduccionesPorGenero());
		
		
	}
	private static void testEjercicio2(CatalogoNetflix c) {
		System.out.println("-----------------------------");
		System.out.println("Ejercicio4.2:");
		System.out.println(c.getGeneros());
		
	}
	private static void testEjercicio3(CatalogoNetflix c, List<String> generos) {
		System.out.println("--------------------------------");
		System.out.println("Ejercicio4.3:");
		System.out.println(c.getTitulosDeGenerosOrdenadosPorTamanyo(generos));
		
	}
//	private static void testEjercicio4(CatalogoNetflix c) {
//		System.out.println("------------------------------");
//		System.out.println("Ejercicio4.4:");
//		System.out.println(c.getGeneroConMayorPopularidadAcumulada());
//		
//	}
//	private static void testEjercicio5(CatalogoNetflix c, String string, int i) {
//		System.out.println("------------------------------");
//		System.out.println("Ejercicio4.5");
//		System.out.println(c.getMediaTopNScoresDeGeneroPorAnyo(string, i));
//		
//	}

}

