package fp.tipos.cine.test;

import java.util.ArrayList;
import java.util.List;

import fp.tipos.cine.FactoríaPelícula;
import fp.tipos.cine.Película;

public class TestPelícula02 {

	public static void main(String[] args) {
		
		List<Película> películas=FactoríaPelícula.leePelículas("data/peliculas.csv");
		System.out.println("Número de Peliculas: "+películas.size());
		System.out.println("Las 3 primeras");
		for (Película p:películas.subList(0, 3)) {
			System.out.println(p);
		}
	}

}
