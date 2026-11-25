package fp.compras.test;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


import fp.compras.Compra;
public class EjercicioExpresiones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Compra compra1=new Compra("40961226C","Mercadona","Cadiz",
				LocalDateTime.of(2019, 02, 24,5,33),
				LocalDateTime.of(2019,  02, 24, 5, 57),
				8.65);
		Compra compra2=new Compra("86302030G","Mercadona","Malaga",
				LocalDateTime.of(2019, 02, 24,10,01),
				LocalDateTime.of(2019,  02, 24, 10, 34),
				188.65);
		Compra compra3=new Compra("37089432T","Mas","Granada",
				LocalDateTime.of(2019, 02, 24,10,9),
				LocalDateTime.of(2019,  02, 24, 12,56),
				60.43);
		Compra compra4=new Compra("97785005E","Mercadona","Malaga",
				LocalDateTime.of(2019, 02, 24,13,58),
				LocalDateTime.of(2019,  02, 24,15,48),
				17.43);
		System.out.println("Compra 1:" + compra1);
		System.out.println("Compra 2:" + compra2);
		System.out.println("Compra 3:" + compra3);
		System.out.println("Compra 4:" + compra4);
		
		Boolean exp=null;
		Character exp1;
		Duration exp2;
		
		
		//1.
		System.out.println("¿Fue la `compra2` realizada en Malaga y se gastó más de 60 euros?");
		// La expresión con == no se debe usar con objetos
		// compra1.getProvincia()== "Malaga"
		exp = compra2.getProvincia().equals("Malaga") && compra2.getTotalCompra()>60;
		System.out.println(exp);
		//2.
		System.out.println("¿Fue la `compra3` realizada antes del 28 de febrero de 2019 a las 17:35?");
		exp = compra3.getFechaLlegada().isBefore(LocalDateTime.of(2019,02,28,17,35));
		System.out.println(exp);
		//3.
		System.out.println("¿Fueron la `compra1` o la `compra3` realizadas en Mercadona?");
		exp = compra1.getSupermercado().equals("Mercadona") || compra3.getSupermercado().equals("Mercadona");
		System.out.println(exp);
		//4.
		System.out.println("¿Fueron la `compra2` y la `compra3` realizadas el mismo día?");
		exp = compra2.getFechaLlegada().toLocalDate().equals(compra3.getFechaLlegada().toLocalDate());
		exp = compra2.getFechaLlegada().toLocalDate().isEqual(compra3.getFechaLlegada().toLocalDate()); //isEqual para fechas solo, equals puede ser cualquier tipo
		System.out.println(exp);
		//5.
		System.out.println("¿La `compra1` y la `compra4` fueron realizadas el mismo día y el cliente de la compra1 salió antes de la tienda que el cliente de la compra4?");
		exp = compra1.getFechaLlegada().toLocalDate().equals(compra4.getFechaLlegada().toLocalDate())&& compra1.getFechaSalida().isBefore(compra4.getFechaSalida());
		System.out.println(exp);
		//6.
		System.out.println("¿Fueron la `compra2` y la `compra4` realizadas en el mismo supermercado y alguna superó los 100 euros?");
		exp = compra2.getSupermercado().equals(compra4.getSupermercado()) && (compra2.getTotalCompra()>100 || compra4.getTotalCompra()>100);
		System.out.println(exp);
		//7.
		System.out.println("¿Se gastó en la `compra2` más del doble que en la `compra3`?");
		exp = compra2.getTotalCompra()>=2*(compra3.getTotalCompra());
		System.out.println(exp);
		//8.
		System.out.println("¿Supera la media de las 4 compras los 100 euros?");
		exp = ((compra1.getTotalCompra() + compra4.getTotalCompra() + compra3.getTotalCompra() + compra2.getTotalCompra())/4)>100;
		System.out.println(exp);
		//9.
		System.out.println("¿Es par el mes de la `compra2`?");
		//exp =compra2.getFechaLlegada().getDayOfMonth()%2;
		System.out.println(exp);
		//10.
		System.out.println("¿Se realizó la `compra3` en horario de tarde (entre las 15:00 y las 21:00)?");
		exp = compra3.getFechaLlegada().isAfter(LocalDateTime.of(2019,02,28, 15, 00)) && compra3.getFechaSalida().isBefore(LocalDateTime.of(2019, 02, 28, 15, 00));
		System.out.println(exp);
		//11.
		System.out.println("¿Fue lunes el día de la `compra4`?");
		exp = compra4.getFechaLlegada().getDayOfWeek().equals(DayOfWeek.MONDAY);
		System.out.println(exp);
		//12.
		System.out.println("¿El dni de la `compra3` comienza por 9?");
		exp = compra3.getDNI().startsWith("9");
		System.out.println(exp);
		//13.
		System.out.println("¿Cuál es la letra del dni del cliente de la `compra1`?");
		exp1 = compra1.getDNI().charAt(8);
		System.out.println(exp1);
		//14.
		System.out.println("¿Cuánto tiempo ha estado en la tienda el cliente de la `compra3`?");
		exp2= Duration.between(compra3.getFechaLlegada(), compra3.getFechaSalida());
		System.out.println(exp2);
		
      
		
	}
	

       
       
       
       
	}


