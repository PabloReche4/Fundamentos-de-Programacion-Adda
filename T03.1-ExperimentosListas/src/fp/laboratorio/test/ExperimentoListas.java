package fp.laboratorio.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fp.laboratorio.Estudiante;
import fp.laboratorio.EstudianteImpl;

public class ExperimentoListas {

	public static void main(String[] args) {

		Estudiante e1 = new EstudianteImpl("Ada", "Lovelace", "adalov");
		Estudiante e2 = new EstudianteImpl("Grace", "Murray", "gramur");
		Estudiante e3 = new EstudianteImpl("Frances", "Allen", "fraall");
		Estudiante e4 = new EstudianteImpl("Hedy", "Lamarr", "hedlam");
		Estudiante e5 = new EstudianteImpl("Radia", "Perlman", "ritper");
		Estudiante e6 = new EstudianteImpl("Margaret", "Hamilton", "marham");

		// Crea una lista vacía de estudiantes
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();

		// Creamos una lista de enteros inmutable
		List<Integer> enteros1 = List.of(2, 3, 4);
		// enteros1.add(5);

		// Añade 5 estudiantes (e1-e5) a la lista
		estudiantes.add(e1);
		estudiantes.add(e2);
		estudiantes.add(e3);
		estudiantes.add(e4);
		estudiantes.add(e5);

		// Visualiza el nmero de estudiantes que tiene la lista
		System.out.println(estudiantes.size());

		// Visualiza los estudiantes de las posiciones 0, 1 y 5.
		System.out.println(estudiantes.get(0));
		System.out.println(estudiantes.get(1));
		try {
			System.out.println(estudiantes.get(5));
		} catch (Exception e) {
			System.out.println("Excepción capturada " + e.getMessage());
		}
		// Visualiza, de los estudiantes 2 y 4 solo su uvus.
		System.out.println(estudiantes.get(2).getUVUS());
		System.out.println(estudiantes.get(4).getUVUS());

		// Inserta el estudiante e6 como tercer estudiante de la lista
		System.out.println("Antes " + estudiantes);
		estudiantes.add(2,e6);
		System.out.println("Despues " + estudiantes);
		
		// Busca la posición de la estudiante que se llama Frances Allen.
		int posicion =buscarEstudiantePorNombreyApellidos(estudiantes, "Frances", "Allen");
		int indx = estudiantes.indexOf("Frances Allen");
		System.out.println(posicion);
		System.out.println(indx);
		int indx2 = estudiantes.indexOf(e3);
		System.out.println(indx2);
		
		// Obten una sublista con los estudiantes de la posici�n 1 a la 4.
		List<Estudiante> sublista = estudiantes.subList(1, 4);

		// Visualiza ambas listas
		System.out.println(sublista);
		System.out.println(estudiantes);

		// Elimina de la sublista el segundo estudiante (�ndice 1).
		sublista.remove(1);

		// Muestra ambas listas.
		System.out.println(sublista);
		System.out.println(estudiantes);

		// Muestras ambas listas, pero haciendo que haya un estudiante por línea.
		mostrarIterable(sublista);
		System.out.println("=".repeat(80));
		mostrarIterable(estudiantes);
	}

	private static void mostrarIterable(Iterable<Estudiante> lista) {
		for (Estudiante e : lista) {
			System.out.println(e);
		}
	}

	public static Integer buscarEstudiantePorNombreyApellidos(List<Estudiante> lista, String nombre, String apellidos) {
		int pos = -1;
		for (int i = 0; i < lista.size(); i++) {
			Estudiante e = lista.get(i);
			if (e.getNombre().equals(nombre) && e.getApellidos().equals(apellidos)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

}
