package fp.Hotel;

public class Hotel {
	private String nombre;
	private String direccion;
	private String ciudad;
	private String telefono;
	private String cadenaHotelera;
	private String descripcion;
	private CategoriaHotelera categoriaDelHotel;
	private TipoAlojamiento tipoDeAlojamiento;
	private CategoriaPrecio categoriaDePrecio;
	private Float puntuacion;
	private Integer numeroDeComentarios;
	private Boolean admiteMascotas;
	private Boolean adaptado;
	
	
	//Constructores:
	public Hotel(String nombre, String direccion, String ciudad, String telefono, String cadenaHotelera,
			String descripcion, CategoriaHotelera categoriaDelHotel, TipoAlojamiento tipoDeAlojamiento,
			CategoriaPrecio categoriaDePrecio, Float puntuacion, Integer numeroDeComentarios, Boolean admiteMascotas,
			Boolean adaptado) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.cadenaHotelera = cadenaHotelera;
		this.descripcion = descripcion;
		this.categoriaDelHotel = categoriaDelHotel;
		this.tipoDeAlojamiento = tipoDeAlojamiento;
		this.categoriaDePrecio = categoriaDePrecio;
		this.puntuacion = puntuacion;
		this.numeroDeComentarios = numeroDeComentarios;
		this.admiteMascotas = admiteMascotas;
		this.adaptado = adaptado;
	}
	
	public Hotel(String nombre, String direccion, String ciudad, String telefono, String cadenaHotelera, CategoriaHotelera categoriaDelHotel) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.cadenaHotelera = cadenaHotelera;
		this.categoriaDelHotel = categoriaDelHotel;
		this.categoriaDePrecio = CategoriaPrecio.MEDIA;
		this.numeroDeComentarios = 0;
		this.admiteMascotas = false;
		this.adaptado = false;
	}
	
	public Hotel(String nombre, String cadenaHotelera, CategoriaHotelera categoriaDelHotel) {
		this.nombre = nombre;
		this.cadenaHotelera = cadenaHotelera;
		this.categoriaDelHotel = categoriaDelHotel;
		this.categoriaDePrecio = CategoriaPrecio.MEDIA;
		this.numeroDeComentarios = 0;
		this.admiteMascotas = false;
		this.adaptado = false;
	}

	public String cadenaConFormato() {
		return this.nombre + " - " + this.descripcion + "(" + estrellas() + ")";
	}
	
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

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCadenaHotelera() {
		return cadenaHotelera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public CategoriaHotelera getCategoriaDelHotel() {
		return categoriaDelHotel;
	}

	public TipoAlojamiento getTipoDeAlojamiento() {
		return tipoDeAlojamiento;
	}

	public CategoriaPrecio getCategoriaDePrecio() {
		return categoriaDePrecio;
	}

	public Float getPuntuacion() {
		return puntuacion;
	}

	public Integer getNumeroDeComentarios() {
		return numeroDeComentarios;
	}

	public Boolean getAdmiteMascotas() {
		return admiteMascotas;
	}

	public Boolean getAdaptado() {
		return adaptado;
	}

	public String toString() {
		return "Hotel [nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono
				+ ", cadenaHotelera=" + cadenaHotelera + ", descripcion=" + descripcion + ", categoriaDelHotel="
				+ categoriaDelHotel + ", tipoDeAlojamiento=" + tipoDeAlojamiento + ", categoriaDePrecio="
				+ categoriaDePrecio + ", puntuacion=" + puntuacion + ", numeroDeComentarios=" + numeroDeComentarios
				+ ", admiteMascotas=" + admiteMascotas + ", adaptado=" + adaptado + ", cadenaConFormato()="
				+ cadenaConFormato();
	}

	
	
	
	
}