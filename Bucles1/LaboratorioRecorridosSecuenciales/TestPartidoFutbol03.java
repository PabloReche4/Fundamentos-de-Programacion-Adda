package fp.tipos.futbol.test;

import java.util.ArrayList;
import java.util.List;

import fp.tipos.cine.FactoríaPelícula;
import fp.tipos.cine.Película;
import fp.tipos.futbol.FactoríaPartidoFutbol;
import fp.tipos.futbol.PartidoFutbol;

public class TestPartidoFutbol03 {

	public static void main(String[] args) {
		
		List<PartidoFutbol> misPartidos=FactoríaPartidoFutbol.leePartidos("data/partidos.csv");
		System.out.println("Número de Partidos: "+misPartidos.size());
		System.out.println("Los 5 primeros");
		for (PartidoFutbol p:misPartidos.subList(0, 5)) {
			System.out.println(p);
		}
	}

}
