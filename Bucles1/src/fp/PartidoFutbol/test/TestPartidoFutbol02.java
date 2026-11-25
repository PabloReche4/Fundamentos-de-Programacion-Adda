package fp.PartidoFutbol.test;

import java.util.List;

import fp.Beca.Beca;
import fp.Beca.FactoriaBeca;
import fp.PartidoFutbol.FactoriaFutbol;
import fp.PartidoFutbol.PartidoFutbol;
import fp.PartidoFutbol.PartidoFutbolRecord;

public class TestPartidoFutbol02 {

	public static void main(String[] args) {
		List<PartidoFutbol> partidos = FactoriaFutbol.leerPartidos("data/partidos.csv");
		System.out.println("Numero de partidos " + partidos.size());
		for (PartidoFutbol b : partidos) {
			System.out.println(b);
		}
	}

}
