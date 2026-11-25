package fp.PartidoFutbol.test;

import java.time.LocalDate;

import fp.PartidoFutbol.PartidoFutbol;

public class TestPartidoFutbol {

	public static void main(String[] args) {
		PartidoFutbol p1 = new PartidoFutbol(LocalDate.now(), "Sevilla", "Betis",3 ,0);
		PartidoFutbol p2 = new PartidoFutbol(LocalDate.now(), "Sevilla", "Betis",3 ,2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.compareTo(p2));
	}

}
