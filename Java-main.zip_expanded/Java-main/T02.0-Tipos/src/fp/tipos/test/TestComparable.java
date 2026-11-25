package fp.tipos.test;

import fp.tipos.*;
public class TestComparable {

	public static void main(String[] args) {
		  Punto p1 = new PuntoImpl();
		  Punto p2 = new PuntoImpl(0.0, -1.0);
		  Punto p3 = new PuntoImpl(1.0, -1.0);
		  Punto p4 = new PuntoImpl(0.0, 0.0);
		  
		  System.out.println("¿Quién va antes p1 o p2?" 
				  	+ p1.compareTo(p2));
		  System.out.println("¿Quién va antes p1 o p2?" 
				  	+ p2.compareTo(p1));
		  System.out.println("¿Quién va antes p2 o p3?" 
				  	+ p2.compareTo(p3));
		  System.out.println("¿Quién va antes p1 o p4?" 
				  	+ p1.compareTo(p4));



	}

}
