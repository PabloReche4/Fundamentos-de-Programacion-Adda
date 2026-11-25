package fp.Beca.test;

import java.util.Comparator;

import fp.Beca.Beca;
import fp.Beca.TipoBeca;

public class BecaTest {

	public static void main(String[] args) {
		Beca b1 = new Beca("47890", 4900.0, 7, TipoBeca.ORDINARIA);
		System.out.println(b1);
		Beca b2 = new Beca("434",TipoBeca.MOVILIDAD);
		System.out.println(b2);
		Beca b3 = new Beca("47891",4900.0, 3, TipoBeca.EMPRESA);
		System.out.println(b3);
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println(b3.compareTo(b1));
		System.out.println(b1.compareTo(b3));
		System.out.println(b1.compareTo(b2));
		
	}	
	
}
