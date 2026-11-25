package fp.tipos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fp.tipos.CursoConPracticas;
import fp.tipos.NivelDificultad;
import fp.tipos.TipoCertificacion;

public class TestCursoConPracticas {

	public static void main(String[] args) {
		List<String> empresas = new ArrayList<>();
		Collections.addAll(empresas, "Oracle", "IBM");		
		CursoConPracticas cp = new CursoConPracticas ("ABC2456",
				"J2EE","UNED", LocalDate.of(2024, 2, 1),
				LocalDate.of(2024, 2, 29),
				1,TipoCertificacion.CURSO,
				3.9, NivelDificultad.INTERMEDIO,
				20, false,empresas, 40);
		System.out.println("Antes "+ cp.getEmpresas());
		empresas.add("Oracle");
		System.out.println("Despues "+ cp.getEmpresas());
		System.out.println("=".repeat(60));
		List<String> lista = cp.getEmpresas();
		System.out.println("Antes"+ cp.getEmpresas());
		System.out.println("Antes"+ cp);
		lista.add("IBM");
		System.out.println("Despues"+ cp.getEmpresas());
		System.out.println("Despues"+ cp);

		
	}

}
