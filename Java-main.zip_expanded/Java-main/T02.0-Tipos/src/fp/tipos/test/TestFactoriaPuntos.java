package fp.tipos.test;

import java.util.List;

import fp.tipos.FactoriaPuntos;
import fp.tipos.Punto;

public class TestFactoriaPuntos {

	public static void main(String[] args) {
		// Test de la factoria pero de manera informal
		Punto cero= FactoriaPuntos.create();
		System.out.println("Metodo factoria sin parametros" + cero);
		Punto p2= FactoriaPuntos.create(4.0, -1.5);
		System.out.println("Metodo factoria con parametros" + p2);
		Punto p3= FactoriaPuntos.create("(1.0, 1.5)");
		System.out.println("Metodo factoria a partir de String" + p3);
		Punto p4= FactoriaPuntos.create(4.0);
		System.out.println("Metodo factoria con un parametro" + p4);
		Punto p5= FactoriaPuntos.create(p3);
		System.out.println("Metodo factoria copia" + p5);
		List<Punto> puntos = FactoriaPuntos.createPuntos("src/data/puntos.txt");
		System.out.println("Metodo factoria para coleccion de archivos" + puntos);
	}

}
