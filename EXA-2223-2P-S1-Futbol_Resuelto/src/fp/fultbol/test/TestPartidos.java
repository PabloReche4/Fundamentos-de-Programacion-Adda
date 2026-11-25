package fp.fultbol.test;

import java.util.Map.Entry;
import java.util.Set;
import fp.futbol.Competicion;
import fp.futbol.EstadisticasPartidos;
import fp.futbol.FactoriaPartidos;
import fp.futbol.Partido;

public class TestPartidos {

	public static void main(String[] args) {
		EstadisticasPartidos ep=FactoriaPartidos.leePartidos("data/partidos.txt");
//		visualizaPartidos(ep);
//		testGetNumGolesEquipos(ep);
//		testGetNumGolesDespuesMinuto(ep);
//		testGetNPartidosMasEspectadores(ep);
//		testGetCompeticionMasEspectadores(ep);
//		testGetPartidoGolMasTardioPorCompeticion(ep);
	}
	private static void visualizaPartidos(EstadisticasPartidos e) {
		System.out.println("Número de partidos leidos:"+e.numPartidos());
		System.out.println(e.getPartidos().get(0));
	}
	
	private static void testGetNumGolesEquipos(EstadisticasPartidos ep) {
		try {
			System.out.println("\n4.1. getNumGolesEquipos ");
			Set<String> equipos1=Set.of("Sevilla", "RealBetis");
			System.out.println(equipos1+"-->"+ep.getNumGolesEquipos(equipos1));
			Set<String> equipos2=Set.of("RealMadrid", "Barcelona");
			System.out.println(equipos2+"-->"+ep.getNumGolesEquipos(equipos2));
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void testGetNumGolesDespuesMinuto(EstadisticasPartidos ep) {
		try {
			System.out.println("\n4.2. getNumGolesDespuesMinuto ");
			System.out.println("90-->"+ep.getNumGolesDespuesMinuto(90));
			System.out.println("90-->"+ep.getNumGolesDespuesMinuto(100));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void testGetNPartidosMasEspectadores(EstadisticasPartidos ep) {
		try {
			System.out.println("\n4.3. getNPartidosMasEspectadores ");
			System.out.println("3-->");
			for(Partido p:ep.getNPartidosMasEspectadores(3)) {
				System.out.println(p);
			}
			System.out.println("5-->");
			for(Partido p:ep.getNPartidosMasEspectadores(5)) {
				System.out.println(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void testGetCompeticionMasEspectadores(EstadisticasPartidos ep) {
		try {
			System.out.println("\n4.4. getCompeticionMasEspectadores ");
			System.out.println("1-->"+ep.getCompeticionMasEspectadores(1));
			System.out.println("10-->"+ep.getCompeticionMasEspectadores(10));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void testGetPartidoGolMasTardioPorCompeticion(EstadisticasPartidos ep) {
		try {
			System.out.println("\n4.5. getPartidoGolMasTardioPorCompeticion ");
			for(Entry<Competicion,Partido> par:ep.getPartidoGolMasTardioPorCompeticion().entrySet()) {
				System.out.println(par);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
