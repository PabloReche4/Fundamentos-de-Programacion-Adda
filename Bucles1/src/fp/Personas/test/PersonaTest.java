package fp.Personas.test;

import java.time.LocalDate;

import fp.Persona.Personas;

public class PersonaTest {

	public static void main(String[] args) {
		Personas p1 = new Personas("Alfonso", "Ramírez Caetano", "77847259X",
				LocalDate.of(2005, 10, 20));
		System.out.println(p1);
		System.out.println(p1.edad());
	}
}
