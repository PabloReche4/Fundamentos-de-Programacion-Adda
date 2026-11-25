package fp.tipos.música.test;

import java.util.List;

import fp.tipos.música.Canción;
import fp.tipos.música.FactoriaCanción;

public class TestCanción03 {

	public static void main(String[] args) {
		List<Canción> canciones=FactoriaCanción.leeCanción("data/canciones.csv");
		System.out.println("Número de canciones: "+canciones.size());
		for (Canción c: canciones) {
			System.out.println(c);
		}

	}

}
