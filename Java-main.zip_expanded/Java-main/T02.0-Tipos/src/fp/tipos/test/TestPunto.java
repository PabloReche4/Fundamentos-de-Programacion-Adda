package fp.tipos.test;

import fp.tipos.Punto;
import fp.tipos.PuntoImpl;

public class TestPunto {

	public static void main(String[] args) {
		Punto p1= new PuntoImpl();
		Punto p5= new PuntoImpl("(2.0, -1.0)");
		System.out.println(p5);
//
//		System.out.println(p1.getX());
//		System.out.println(p1.getY());
//		System.out.println(p2.getX());
//		System.out.println(p2.getY());
//		
////		p1.setX(2.6);
////		p2.setY(-3.0);
//		System.out.println(p1.getX());
//		System.out.println(p2.getY());
//		Double d = p1.getDistancia(p2);
//		System.out.println(d);
//	
//		
//		System.out.println(p1);
		
		Punto p2= new PuntoImpl(2.0, 5.0);
		Punto p3= new PuntoImpl(2.0, 5.0);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println (p2==p3);
		System.out.println (p2.equals(p3));
		String s = "Hola";
		System.out.println(p2.equals(s));
		
		
		
	}

}
