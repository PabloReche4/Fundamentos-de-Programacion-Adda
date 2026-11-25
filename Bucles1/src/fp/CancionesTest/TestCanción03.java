package fp.CancionesTest;

import java.util.List;

import fp.Canciones.Cancion;
import fp.Canciones.FactoriaCancion;

public class TestCanción03 {

	public static void main(String[] args) {
		List<Cancion> canciones=FactoriaCancion.leerCanciones("data/canciones.csv");
		System.out.println("Número de canciones: "+canciones.size());
		for (Cancion c: canciones) {
			System.out.println(c);
		}

	}

}
