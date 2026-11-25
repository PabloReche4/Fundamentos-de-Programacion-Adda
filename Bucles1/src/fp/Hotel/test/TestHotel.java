package fp.Hotel.test;

import fp.Hotel.CategoriaHotelera;
import fp.Hotel.CategoriaPrecio;
import fp.Hotel.Coordenada;
import fp.Hotel.Hotel;
import fp.Hotel.TipoAlojamiento;

public class TestHotel {

	public static void main(String[] args) {
		Hotel h1 = new Hotel("Alfonso XII","Calle Miguel Delibes nº3","Sevilla","670790550",
				"NH hoteles","El " + TipoAlojamiento.HOTEL + " mas lujoso de Sevilla",
				CategoriaHotelera.CUATRO,TipoAlojamiento.HOTEL,CategoriaPrecio.LUJO,
				(float) 4,367,true,false);
		System.out.println(h1);
		Hotel h2 = new Hotel("Julio III", "Calle Rey Don Pedro", "Granada", "678567456", "Java Hotels",CategoriaHotelera.CINCO);
		System.out.println(h2);
		Hotel h3 = new Hotel("Santiago VI", "Infinity Group", CategoriaHotelera.DOS);
		System.out.println(h3);
	}

}
