package fp.Cine.test;

import java.time.LocalDate;

import fp.Cine.Peliculas;

public class TestPelicula01 {

	public static void main(String[] args) {
			Peliculas p1= new Peliculas("E.T.",LocalDate.now(),100);
			Peliculas p2 = new Peliculas("Billie Elliot",LocalDate.now(),200);
			System.out.println("p1: "+p1);
			p1.setDuracion(20);
			System.out.println("p2: "+p2);
			System.out.println(p1.compareTo(p2));
			System.out.println(p2.compareTo(p1));
	}

}
