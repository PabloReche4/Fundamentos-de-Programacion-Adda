package fp.CancionesTest;

import java.time.Duration;

import fp.Canciones.Cancion;

public class TestCancion01 {

	public static void main(String[] args) {
			//PaDTbHcMd.eS
			Cancion  c1=new Cancion("Rosas Azules","Yung Beef");
			Cancion c2 = new Cancion("Intro","Cecilio G");
			c1.setDuracion(Duration.ofSeconds(200));
			c1.setDuracion(Duration.parse("PT5M30.2S"));
			System.out.println("Formato corto de c1: "+c1.formatoCorto());	
			System.out.println("c1 ordenado con c2=" + c2.compareTo(c1));
			System.out.println("c1 ordenado con c2=" + c1.compareTo(c2));
	}
}
