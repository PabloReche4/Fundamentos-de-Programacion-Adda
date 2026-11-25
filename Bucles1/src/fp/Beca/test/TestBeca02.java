package fp.Beca.test;

import java.util.List;

import fp.Beca.Beca;
import fp.Beca.FactoriaBeca;

public class TestBeca02 {

	public static void main(String[] args) {
		List<Beca> becas = FactoriaBeca.leerBecas("data/becas.csv");
		System.out.println("Numero de cancniones " + becas.size());
		for (Beca b : becas) {
			System.out.println(b);
		}
	}

}
