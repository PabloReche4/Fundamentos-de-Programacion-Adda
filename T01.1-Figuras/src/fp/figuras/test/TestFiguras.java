package fp.figuras.test;

import fp.figuras.*;

public class TestFiguras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. Crear un objeto de tipo TrianguloImpl
		TrianguloImpl triangul1= new TrianguloImpl();
		Triangulo triangul2= new TrianguloImpl2();
		
		TrianguloImpl triangul3= new TrianguloImpl();
		CirculoImpl circul1= new CirculoImpl();
		CuadradoImpl cuadradul1= new CuadradoImpl();
		MonigoteImpl monigotul1= new MonigoteImpl();
		
		
		triangul1.hacerVisible();
		triangul1.cambiarColor("blue");
		triangul1.moverHorizontalmenteDespacio(200);
		
		triangul2.hacerVisible();
		triangul3.hacerVisible();
		triangul3.moverVerticalmenteDespacio(-100);
		circul1.hacerVisible();
		cuadradul1.hacerVisible();
		monigotul1.hacerVisible();
	}

}

