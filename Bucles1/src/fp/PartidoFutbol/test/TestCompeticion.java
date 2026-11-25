package fp.PartidoFutbol.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fp.PartidoFutbol.Competicion;
import fp.PartidoFutbol.PartidoFutbol;

public class TestCompeticion {

	public static void main(String[] args) {		
		//1.
		PartidoFutbol p1 = new PartidoFutbol(LocalDate.now(), "Sevilla", "Betis",3 ,0);
		PartidoFutbol p2 = new PartidoFutbol(LocalDate.of(2023,3,5), "Recre", "Jerezano",3 ,2);
		PartidoFutbol p3 = new PartidoFutbol(LocalDate.of(2023,6,17), "Malaga", "Rayo",3 ,1);
		PartidoFutbol p4 = new PartidoFutbol(LocalDate.of(2023,5,17), "Madrid", "Barça",3 ,1);
		//2.
		List<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();
		Competicion c1 = new Competicion("La Liga",2023,partidos) ;
		//3.
		System.out.println(c1);
		//4.
		System.out.println(c1.getPartidos());
		//5.
		c1.incorporaPartido(p1);
		//6.
		System.out.println(c1);
		//7.
		System.out.println(c1.getPartidos());
		//8.
		partidos.add(p4);
		partidos.add(p3);
		partidos.add(p2);
		System.out.println(partidos);
		System.out.println(partidos.size());
		//9.
		c1.incorporaPartidos(partidos);
		//10.
		System.out.println(c1);
		//11.
		System.out.println(c1.getPartidos());
	}

}
