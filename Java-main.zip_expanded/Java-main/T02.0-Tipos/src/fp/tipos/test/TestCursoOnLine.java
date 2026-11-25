package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.CursoOnLine;
import fp.tipos.NivelDificultad;
import fp.tipos.TipoCertificacion;

public class TestCursoOnLine {

	public static void main(String[] args) {
		try {
			CursoOnLine c = new CursoOnLine("ABC2456", "Introduccion a Java", "UNED", LocalDate.now(),
					LocalDate.now().plusMonths(1), 1, TipoCertificacion.CURSO, 3.9, NivelDificultad.PRINCIPIANTE, 20,
					false);
			System.out.println(c);
			// .....
			c.setDuracion(1);
			System.out.println(c);
			Double m = 5/.0;
			System.out.println(m);
		} catch (IllegalArgumentException e) {
			System.out.println("He capturado la excepcion con mensaje " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Capturada excepcion" + e.getMessage());
		}
		
		System.out.println("Programa terminado");
	}

}
