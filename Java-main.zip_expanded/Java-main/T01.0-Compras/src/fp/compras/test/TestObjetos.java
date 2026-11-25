package fp.compras.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import fp.compras.*;

public class TestObjetos {

	public static void main(String[] args) {
		
		//Creando objetos con métodos de factoria
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		
		LocalDate fecha1 = LocalDate.of(2024, 1, 1);
		System.out.println(fecha1);
		
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);
		
		LocalTime hora1=LocalTime.of(10, 30);
		System.out.println(hora1);
		
		//Creando objetos con métodos constructores
		LocalDateTime fechahoraLlegada = 
				LocalDateTime.of(2024,2,2,15,30);
		LocalDateTime fechahoraSalida =
				LocalDateTime.of(2024, 2,2,16,0);
		Compra compra1 = new Compra(
				"12345689D", "Mercadona","Sevilla",
				fechahoraLlegada, fechahoraSalida,
				95.9);
		System.out.println(compra1);

			//TODO terminar la tarea de la clase del día 2
		boolean b =true;
		boolean b1 =false;
		char c = 'A';
		char c1 = '1';
		char c2 = '\n';
		int n1 = 5;
		int n2=-5;
		long l1 = 7;
		long l2 = -7;
		float f1 = -5.3f;
		float f2 = 5.3F;
		double d1 = 5.3;
		double d2= -5.3;
		Boolean b3=true;
		String s =b3.toString();
		Character c3='B';
		
		
		int num1=5, num2 = -2, num3 =0;
		boolean flag1 = true, flag2 = false;

		
		b3= num1 > num2 || flag2;
		// 5 > -2 
		// true || ... (evaluación perezosa)
		// true  ==> boolean
		
		b3= num1 < num2 && num3 >= 0;
		
		// 5 <-2 
		// false  && num3 >= 0;
					// 0 >=0
		// false  && true
		// false
		
		int contador=7;
		//b3= 1<contador<10;
		// 1<contador
		// 1<7 
		// true ==> boolean
		// true <10 
		b3 = 1<contador && contador<10;
		// 1<contador
		// 1<7 
		// true && contador<10
		//  true && 7<10
		// true && true
		// true (boolean)
		
		double radio = 5.1;
		double area = PI * Math.pow(radio, 2);
		
		String s1 ="Numero "+ 1;
	
	}

}
