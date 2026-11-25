package eje1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Recursividad {

	public static void main(String[] args) {

	}

	public static Integer factorial_recursivo(Integer num) {
		Integer res = null;
		if (num == 1 || num == 0) {
			res = 1;

		} else {
			res = num * factorial_recursivo(num - 1);
		}
		return res;
	}

	public static Integer factorial_imperativo(Integer n) {
		Integer res = 1;
		Integer i = 1;
		while (i <= n) {
			res = res * i;
			i++;
		}
		return res;
	}

	public static Integer factorial_funcional(Integer n) {
		return IntStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
	}

	public static List<Long> listaPrimos_imp(Long n) {
		List<Long> res = new ArrayList<>();
		Long e = 2L;
		while (e < n) {
			if (esPrimo(e)) {
				res.add(e);
			}
			e++;
		}
		return res;
	}

	private static boolean esPrimo(Long e) {
		if (e < 2)
			return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(e)).allMatch(i -> e % i != 0);

	}

	static <E> boolean estaOrdenada(List<E> ls, Comparator<E> cmp) {
		return estaOrdenada(ls, 0, cmp);

	}

	static <E> boolean estaOrdenada(List<E> ls, int i, Comparator<E> cmp) {
		Boolean r = true;
		Integer n = ls.size();
		if (n - 1 >= 2) {
			r = cmp.compare(ls.get(i), ls.get(i + 1)) <= 0 && estaOrdenada(ls, i + 1, cmp);
		}
		return r;

	}

	public static String solucionRecursivaNoFinal(Integer a, Integer b) {
		String r = null;
		if (a < 5 || b < 5) {
			r = String.format("(%d)", a * b);

		} else {
			r = String.format("%d", a + b) + solucionRecursivaNoFinal(a / 2, b - 2);
		}
		return r;
	}

	public static String solucionIterativa(Integer a, Integer b) {
		String ac = "";
		while (!(a < 5 || b < 5)) {
			ac = String.format("%s%d", ac, a + b);
			a /= 2;
			b -= 2;
		}
		return ac + String.format("(%d)", a * b);
	}

	private static record Tupla(String ac, Integer a, Integer b) {
		public static Tupla of(String ba, Integer a, Integer b) {
			return new Tupla(ba, a, b);
		}

		public static Tupla first(Integer a, Integer b) {
			return of("", a, b);
		}

		public Tupla next() {
			return of(ac + String.format("%d", a + b), a / 2, b - 2);
		}
	}

	public static String solucionFuncional(Integer a, Integer b) {
		Tupla t = Stream.iterate(Tupla.first(a, b), e -> e.next()).filter(e -> e.a() < 5 || e.b() < 5).findFirst()
				.get();

		return t.ac() + String.format("(%d)", t.a() * t.b());
	}

	public static String solucionRecursivaFinal(Integer a, Integer b) {
		return recFinal("", a, b);
	}

	private static String recFinal(String ac, Integer a, Integer b) {
		String r = null;
		if (a < 5 || b < 5) {
			r = ac + String.format("(%d)", a * b);
		} else {
			r = recFinal(ac + String.format("%d", a + b), a / 2, b - 2);
		}
		return r;
	}

	// recursividad
	public static String divisible5(Integer a) {
		String r = null;
		if (a % 5 == 0) {
			r = String.format("Es divisible %d", a);
		} else {
			r = String.format("No es divisible %d", a);
		}
		return r;
	}

	// si cadena.length()>=5-->"("+ cadena +") + toString(Integer)
	// otro caso -->cadena +"a", int+1
	public static String recursividadCadena(String cad, Integer a) {
		String res = null;
		if (cad.length() >= 5) {
			res = String.format("(%s),%d)", cad, a);

		} else {
			res = String.format("(%s)%d", cad + "a", a + 1);
		}
		return res;

	}

	public static Integer fibonacci(Integer a) {
		List<Integer> ls = new ArrayList<>();
		ls.add(0);
		ls.add(1);
		for (int i = 2; i <= a; i++) {
			ls.add(ls.get(i - 1) + ls.get(i - 2));
		}
		return ls.get(a);
	}

}
