package fp.Hotel;

public record HotelRecord(String nombre, String direccion, String ciudad,String telefono,
		String cadenaHotelera, String descripcion,CategoriaHotelera categoriaDelHotel,
		TipoAlojamiento tipoDeAlojamiento, CategoriaPrecio categoriaDePrecio,
		Float puntuacion, Integer numeroDeComentarios, Boolean admiteMascotas,
		Boolean adaptado) {
		
	public String estrellas() {
		String res = "N/A";
		if (categoriaDelHotel == CategoriaHotelera.UNA) {
			res = "*";
		}
		if (categoriaDelHotel == CategoriaHotelera.DOS) {
			res = "**";
		}
		if (categoriaDelHotel == CategoriaHotelera.TRES) {
			res = "***";
		}
		if (categoriaDelHotel == CategoriaHotelera.CUATRO) {
			res = "****";
		}
		if (categoriaDelHotel == CategoriaHotelera.CINCO) {
			res = "*****";
		}
		return res;
		
	}
	public String cadenaConFormato() {
		return this.nombre + " - " + this.descripcion + "(" + estrellas() + ")";
	}
	
	public HotelRecord(String nombre, String direccion, String ciudad, String telefono, String cadenaHotelera, CategoriaHotelera categoriaDelHotel) {
		this(nombre,direccion,ciudad,telefono,cadenaHotelera," ", categoriaDelHotel, TipoAlojamiento.APARTAMENTO, CategoriaPrecio.MEDIA, 0f, 0, false, false);
	}
	
	//public HotelRecord(String nombre, String cadenaHotelera, CategoriaHotelera categoriaDelHotel) {

	//}
	
	
}
