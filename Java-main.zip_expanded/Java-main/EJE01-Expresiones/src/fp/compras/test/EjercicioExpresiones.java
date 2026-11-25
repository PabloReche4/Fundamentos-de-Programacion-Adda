package fp.compras.test;

import java.time.LocalDateTime;

import fp.compras.Compra;

public class EjercicioExpresiones {

	public static void main(String[] args) {
		// Crea 4 objetos de tipo compra
		Compra compra1 = new Compra("40961226C", 
				"Mercadona", "Cadiz", 
				LocalDateTime.of(2019, 2, 24, 5, 33),
				LocalDateTime.of(2019, 2, 24, 5, 57), 
				8.65);

		Compra compra2 = new Compra("86302030G", 
				"Mercadona", "Malaga", 
				LocalDateTime.of(2019, 2, 24, 10, 1),
				LocalDateTime.of(2019, 2, 24, 10, 34), 
				188.65);

		Compra compra3 = new Compra("37089432T", 
				"Mas", "Granada", 
				LocalDateTime.of(2019, 2, 24, 10, 9),
				LocalDateTime.of(2019, 2, 24, 12, 56), 
				60.43);

		Compra compra4 = new Compra("97785005E", 
				"Mercadona", "Malaga", 
				LocalDateTime.of(2019, 2, 24, 13, 58),
				LocalDateTime.of(2019, 2, 24, 15, 48), 
				17.43);
		System.out.println("Compra 1:"+ compra1);
		System.out.println("Compra 2:"+ compra2);
		System.out.println("Compra 3:"+ compra3);
		System.out.println("Compra 4:"+ compra4);
		
		Boolean exp=null;
		System.out.println("1. ¿Fue la compra1 realizada en Malaga y se gastó más de 60 euros?");
		// La expexpión con == no se debe usar con objetos
		// compra1.getProvincia()== "Malaga"
		exp= compra1.getProvincia().equals("Malaga") 
				&& compra1.getTotalCompra() > 60;
		System.out.println(exp);
		
		System.out.println("2. ¿Fue la compra3 realizada antes "+""
				+ "del 28 de febrero de 2019 a las 17:35?");
		exp= compra3.getFechaSalida().isBefore(
				LocalDateTime.of(2019,2,28,17,35));
		System.out.println(exp);		
		
		System.out.println("3. ¿Fueron la compra1 o la compra3 realizadas en Mercadona?");
		exp = compra1.getSupermercado().equals("Mercadona")
				|| compra3.getSupermercado().equals("Mercadona");
		System.out.println(exp);
		System.out.println("4.¿Fueron la compra2 y la compra3 realizadas el mismo día?");
		exp = compra2.getFechaLlegada().toLocalDate().equals(compra3.getFechaLlegada().toLocalDate());
		exp = compra2.getFechaLlegada().toLocalDate().isEqual(compra3.getFechaLlegada().toLocalDate());
		System.out.println(exp);
		
		System.out.println("5.¿La compra1 y la compra4 fueron realizadas el mismo día y el cliente de la compra1 salió antes de la "+
		"tienda que el cliente de la compra4?");
		exp= compra1.getFechaLlegada().toLocalDate().equals(compra4.getFechaLlegada().toLocalDate())
				&& compra1.getFechaSalida().isBefore(compra4.getFechaSalida());
		System.out.println(exp);
		
		System.out.println(
				"6. ¿Fueron la compra2 y la compra4 realizadas en el mismo supermercado y alguna superó los 100 euros?");
		exp= compra2.getSupermercado().equals(compra4.getSupermercado())
				&& (compra2.getTotalCompra()>100 
						|| compra4.getTotalCompra()>100);
		System.out.println(exp);
		
		System.out.println("7. ¿Se gastó en la compra2 más "+
		       "del doble que en la compra3?");
		exp= compra2.getTotalCompra() > compra3.getTotalCompra()*2;
		System.out.println(exp);
		
		System.out.println("8. ¿Supera la media de las 4 compras los 100 euros?");
		
		System.out.println(exp);
	}

}
