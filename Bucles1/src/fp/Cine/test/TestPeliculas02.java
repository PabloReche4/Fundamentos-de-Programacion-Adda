package fp.Cine.test;

import java.util.List;

import fp.Canciones.Cancion;
import fp.Canciones.FactoriaCancion;
import fp.Cine.FactoriaCine;
import fp.Cine.Peliculas;

public class TestPeliculas02 {

	public static void main(String[] args) {
		List<Peliculas> peliculas = FactoriaCine.leerPeliculas("data/peliculas.csv");
		System.out.println("Numero de cancniones " + peliculas.size());
		for (Peliculas p : peliculas) {
			System.out.println(p);
		}
	}

}
