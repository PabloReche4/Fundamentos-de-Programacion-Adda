package fp.tipos.test;

import java.time.LocalDate;

public class TestIgualdad {

	public static void main(String[] args) {
		LocalDate f1 = LocalDate.of(2021, 5, 1);
		LocalDate f2 = LocalDate.of(2021, 5, 1);
		Boolean b1 = f1==f2;
		System.out.println(b1);
		Boolean b2 = f1.equals(f2);
		System.out.println(b2);
		LocalDate f3= f2;
		Boolean b3 = f2==f3;
		System.out.println(b3);
		Boolean b4= f2.equals(f3);
		System.out.println(b4);
		LocalDate f4 = LocalDate.now();
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
		System.out.println(f3.hashCode());
		System.out.println(f4.hashCode());
		
	}

}
