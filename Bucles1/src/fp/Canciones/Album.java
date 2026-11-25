package fp.Canciones;

import java.util.List;

import utiles.Checkers;

public class Album {
	
		private String nombre;
		private String id;
		private Integer popularidad;
		private Integer añoDePublicacion;
		private Tipo tipoDelAlbum;
		private List<Cancion> canciones;
		private List<String>imagenes;		
		private Boolean urlImagenes(List<String> imagenes) {
			boolean res=false;
			for(String i : imagenes) {
				if(!(i.startsWith("http"))) {
					res = true;
					break;
				}
			}
			return res;
		}
		
public Album(String nombre, String id, Integer popularidad, Integer añoDePublicacion, Tipo tipoDelAlbum,
				List<Cancion> canciones, List<String> imagenes) {
	
			Checkers.check("el id debe tener 22 caracteres", getId().length()==22);
			Checkers.check("la popularidad debe estar comprendida entre 0 y 100, ambos inclusive",0<=popularidad && popularidad<=100);
			Checkers.check("la url de todas las imágenes del álbum debe comenzar por “http”", urlImagenes(imagenes));

			this.nombre = nombre;
			this.id = id;
			this.popularidad = popularidad;
			this.añoDePublicacion = añoDePublicacion;
			this.tipoDelAlbum = tipoDelAlbum;
			this.canciones = canciones;
			this.imagenes = imagenes;
		}

		public String getNombre() {
			return nombre;
		}

		public String getId() {
			return id;
		}

		public Integer getPopularidad() {
			return popularidad;
		}

		public Integer getAñoDePublicacion() {
			return añoDePublicacion;
		}

		public Tipo getTipoDelAlbum() {
			return tipoDelAlbum;
		}

		public List<Cancion> getCanciones() {
			return canciones;
		}

		public List<String> getImagenes() {
			return imagenes;
		}

		public String toString() {
			return "Album [nombre=" + nombre + ", id=" + id + ", popularidad=" + popularidad + ", añoDePublicacion="
					+ añoDePublicacion + ", tipoDelAlbum=" + tipoDelAlbum + ", canciones=" + canciones.size() + ", imagenes="
					+ imagenes.size() + "]";
		}
		
		public void incorporaCancion(Cancion c) {
			if(!(canciones.contains(c))) {
				this.canciones.add(c);
			}
		}
		
		public void incorporaCancion(Cancion c, int posicion) {
			Checkers.check("IllegalArgumentException", 0<=posicion && posicion<=canciones.size());
			if(!(canciones.contains(c))){
				this.canciones.add(posicion, c);
			}
		}
		public void eliminaCancion(Cancion c) {
			if(!(canciones.contains(c))){
				this.canciones.remove(c);
			}
		}
		
		public void eliminaCancion(int posicion) {
			this.canciones.remove(posicion);
		}
		
		public void incorporaImagen(String ruta) {
			this.imagenes.add(ruta);
		}
		
		public void eliminaImagen(int posicion) {
			Checkers.check("IllegalArgumentException", 0<=posicion && posicion<=canciones.size());
			this.imagenes.remove(posicion);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Album))
				return false;
			Album other = (Album) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	
}
