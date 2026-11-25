package fp.figuras.test;

import fp.figuras.TrianguloImpl;
import fp.figuras.TrianguloImpl2;
import fp.figuras.Triangulo;
import fp.figuras.*;

public class TestFiguras {

	public static void main(String[] args) {

		// 1. Crear un objeto de tipo TrianguloImpl
		TrianguloImpl triangul1= new TrianguloImpl();
		Triangulo triangul2= new TrianguloImpl2();
		
		int num =2;
		double real=2.5;
		String cadena="Hola";
		
		triangul1.hacerVisible();
		triangul1.cambiarColor("blue");
		triangul1.moverHorizontalmenteDespacio(200);
		
		triangul2.hacerVisible();
		
		Circulo circulo1 = new CirculoImpl();
		Cuadrado cuadrado1 = new CuadradoImpl();
		Monigote monigote1 = new MonigoteImpl();
		
		circulo1.hacerVisible();
		cuadrado1.hacerInvisible();
		monigote1.hacerVisible();
		monigote1.moverHorizontalmenteDespacio(-100);
	}

}
