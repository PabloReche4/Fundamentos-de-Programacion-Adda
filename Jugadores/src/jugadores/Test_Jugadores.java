package jugadores;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Test_Jugadores {

	public static void main(String[] args) {

		EstadisticasJugadores jugadores = FactoriaJugadores.leeJugadores("Jugadores/jugadores.txt");
		imprimeJugadores();
		System.out.println("EJERCICIO 4.1==============================================");
		testGetNumeroLesionesDistintas(jugadores, 6);
		testGetNumeroLesionesDistintas(jugadores, 2);
		System.out.println("\nEJERCICIO 4.2============================================");
		testGetNJugadoresMasJovenesPosicionSinLesion(jugadores, Posicion.DELANTERO, 3);
		testGetNJugadoresMasJovenesPosicionSinLesion(jugadores, Posicion.CENTROCAMPISTA,3);
//		System.out.println("\nEJERCICIO 4.3============================================");
//		testGetEquipoMasJugadoresConGolesSuperiorMedia(jugadores);
//		System.out.println("\nEJERCICIO 4.4============================================");
//		testTodosEquiposTienenJugadorLesionado(jugadores);
//		System.out.println("\nEJERCICIO 4.5============================================");
//		testGetNombreJugadorConMayorRatioPorEquipo(jugadores);
	}
	
	public static void imprimeJugadores() {
		EstadisticasJugadores jug = FactoriaJugadores.leeJugadores("Jugadores/jugadores.txt");
		jug.j.stream().limit(3).forEach(e->System.out.println(e));			
	}
	
//	private static<T> void mostrarColeccion(Collection<T> col) {
//		col.stream()
//			.map(e -> "\t" + e)
//			.forEach(System.out::println);
//	}
	private static void testGetNumeroLesionesDistintas(EstadisticasJugadores jugadores,	Integer umbralClasificacion) {
			try {
				Long res = jugadores.getNumeroLesionesDistintas(umbralClasificacion);
				String msg = String.format("El número de lesiones distintas de los " + umbralClasificacion + " primeros equipos es: ");
				System.out.println(msg);
				System.out.println(res);
			} catch (Exception e) {
				System.out.println("Capturada excepción inesperada");
				System.out.println(e.getMessage());
			}
	}
	
	private static void testGetNJugadoresMasJovenesPosicionSinLesion(EstadisticasJugadores jugadores, Posicion p, Integer n) {
		try {
			List<String> res =
					jugadores.getNJugadoresMasJovenesPosicionSinLesion(p,n);
			String msg = String.format("Los %d jugadores más jovenes sin lesión de la posicion %s son: ",n, p);
			System.out.println(msg);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("Capturada excepción inesperada");
			System.out.println(e.getMessage());
		}
	}
//		
//	private static void testGetEquipoMasJugadoresConGolesSuperiorMedia(EstadisticasJugadores jugadores) {
//		try {
//			Equipo res = jugadores.getEquipoMasJugadoresConGolesSuperiorMedia();
//			String msg = String.format("El equipo con mayor número de jugadores con goles por encima de la media es: ");
//			System.out.println(msg);
//			System.out.println(res);
//			} catch (Exception e) {
//				System.out.println("Capturada excepción inesperada");
//				System.out.println(e.getMessage());
//			}
//	}
//	
//	private static void testTodosEquiposTienenJugadorLesionado(EstadisticasJugadores jugadores) {
//			try {
//				Boolean res = jugadores.todosEquiposTienenJugadorLesionado();
//				String msg = String.format("¿Todos los equipos tienen al menos un jugador que ha sufrido una lesion?: ");
//				System.out.println(msg);
//				System.out.println(res);
//			} catch (Exception e) {
//				System.out.println("Capturada excepción inesperada");
//				System.out.println(e.getMessage());
//			}
//	}
	
//	private static void testGetNombreJugadorConMayorRatioPorEquipo(EstadisticasJugadores jugadores) {
//		try {
//		Map<Equipo, String> res = jugadores.getNombreJugadorConMayorSumaGAPorEquipo();
//		String msg = String.format("Los nombres de jugadores con mayor ratio goles/asistencias por equipo son: ");
//		System.out.println(msg);
//		mostrarColeccion(res.entrySet());
//		} catch (Exception e) {
//			System.out.println("Capturada excepción inesperada");
//			System.out.println(e.getMessage());
//		}
//	}

}
