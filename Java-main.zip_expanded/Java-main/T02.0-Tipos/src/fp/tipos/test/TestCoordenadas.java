package fp.tipos.test;

import fp.tipos.Coordenadas;

public class TestCoordenadas {

	public static void main(String[] args) {
	
		Coordenadas c1 = new Coordenadas (90.0, -180.0);
		System.out.println(c1);
		Coordenadas c2 = new Coordenadas (-90.0, 180.0);
		System.out.println(c2);
		System.out.println(c1.latitud());
		System.out.println(c1.longitud());
		System.out.println(c1.getDistancia(c2));
		
	}

}
