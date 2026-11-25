package fp.tipos.universidad.test;

import java.util.List;

import fp.tipos.cine.FactoríaPelícula;
import fp.tipos.cine.Película;
import fp.tipos.universidad.Beca;
import fp.tipos.universidad.FactoríaBeca;

public class TestBeca03 {

	public static void main(String[] args) {
		
		List<Beca> becas=FactoríaBeca.leeBecas("data/becas.csv");
		System.out.println("Número de Becas: "+becas.size());
		for (Beca b:becas) {
			System.out.println(b);
		}
	}

}
