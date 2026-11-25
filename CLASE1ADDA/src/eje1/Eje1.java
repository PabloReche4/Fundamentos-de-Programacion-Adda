package eje1;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Eje1 {

	public static void main(String[] args) {
		List<String> lista1 = List.of("Hola", "como", "estas");
		Stream<String> s1 = lista1.stream();

//RANGE		
		IntStream rg = IntStream.range(0, 3);
		rg.forEach(System.out::println);
//ITERATOR
		UnaryOperator<Integer> nx = e -> e + 2;
		Predicate<Integer> uo = x -> x < 21;
		Stream<Integer> gen = Stream.iterate(10, uo, nx);
		gen.forEach(System.out::println);

//FILTER
		List<Integer> lista2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> p2 = x -> x % 2 == 0;
		lista2.stream().filter(p2).forEach(System.out::println);

//LIMIT
		lista2.stream().limit(5).forEach(System.out::println);
//MAP
		lista2.stream().map(x -> x + 2).forEach(System.out::println);
//FLATMAP
		lista2.stream().flatMap(x -> Stream.of(x, x + 2)).forEach(System.out::println);

//ALLMATCH
		Boolean todosPar = lista2.stream().allMatch(x -> x % 2 == 0);
		System.out.println(todosPar);
//ANYMATCH
		Boolean menor20 = lista2.stream().anyMatch(x -> x > 20);
		System.out.println(menor20);
//NONEMATCH
		Boolean todosMenor20 = lista2.stream().noneMatch(x -> x > 20);
		System.out.println(todosMenor20);
//JOINING
		String joining = s1.collect(Collectors.joining("-", "¡", "!"));
		System.out.println(joining);
//REDUCE
		Integer sum = lista2.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);
		Integer mup = lista2.stream().reduce(1, (x, y) -> x * y);
		System.out.println(mup);
		Boolean div = lista2.stream().allMatch(x -> x % 5 == 0);
		System.out.println(div);

		// TRANSFORMACION ALGORITMOS

	}

	public static Integer sum(List<Integer> lista2) {
		return lista2.stream().mapToInt(x -> x).sum();

	}

	public static Integer sum1(List<Integer> lista2) {
		Integer x = 0;
		for (Integer xy : lista2) {
			x = x + xy;
		}
		return x;

	}

	public static boolean esPar(List<Integer> lista2) {
		return lista2.stream().allMatch(x -> x % 2 == 1);
	}

	public static boolean multiplo5(List<Integer> lista2) {
		Boolean a = true;
		Integer i = 0;
		return a = multiplo5(a, i, lista2);
	}

	private static Boolean multiplo5(Boolean a, Integer i, List<Integer> lista2) {
		if (i < lista2.size() && a) {
			a = multiplo5(lista2.get(i) % 5 == 0, i + 1, lista2);
		}
		return a;
	}

}