package fp.geonames.test;

import fp.geonames.FactoriaPaises;
import fp.geonames.PaisesDelMundo;

public class Paises_test {
	public static void main(String[] args) {
		PaisesDelMundo p = FactoriaPaises.leePaises("data/csvPais");
	
		testLectura(p);
	
	
	}

	
	public static void testLectura(PaisesDelMundo p) {
		p.getPaises().stream().forEach(e->System.out.println(e));
	}
}
