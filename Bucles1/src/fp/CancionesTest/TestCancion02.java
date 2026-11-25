package fp.CancionesTest;

import java.util.List;

import fp.Canciones.Cancion;
import fp.Canciones.FactoriaCancion;

public class TestCancion02 {

	public static void main(String[] args) {
		List<Cancion> miscanciones = FactoriaCancion.leerCanciones("dta/canciones.csv");
		System.out.println("Numero de cancniones " + miscanciones.size());
		for (Cancion c : miscanciones) {
			System.out.println(c);
		}
	}

}
