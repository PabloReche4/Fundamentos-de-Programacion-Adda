package fp.Canciones;

import java.time.Duration;


import java.time.LocalDate;
import java.util.Objects;

import utiles.Checkers;
//asi tiene criterio de ordenacion
public class Cancion implements Comparable<Cancion>{

		private String titulo;
		private String artista;
		private Duration duracion;
		private LocalDate fechaLanzamiento;
		private Genero genero;
		//private String formatoCorto; ya que es una compuesta de otras
		
		//Constructor
		
		public Cancion(String titulo, String artista) {
			Checkers.checkNoNull(titulo,artista);
			//para no romper los metodos de abajo hashcode y equals
			this.titulo = titulo;
			this.artista = artista;
			this.duracion=Duration.ZERO;
			this.fechaLanzamiento=null;
			this.genero=null;
		}

		public Cancion(String titulo, String artista, Duration duracion, LocalDate fechaLanzamiento, Genero genero) {
			this.titulo = titulo;
			this.artista = artista;
			this.duracion = duracion;
			this.fechaLanzamiento = fechaLanzamiento;
			this.genero = genero;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			Checkers.checkNoNull(titulo);
			this.titulo = titulo;
		}

		public String getArtista() {
			return artista;
		}

		public void setArtista(String artista) {
			Checkers.checkNoNull(artista);
			this.artista = artista;
		}

		public Duration getDuracion() {
			return duracion;
		}

		public void setDuracion(Duration duracion) {
			Checkers.checkNoNull(duracion);
			Checkers.check("La duracion >=0",duracion.compareTo(Duration.ZERO)>=0);
			this.duracion = duracion;
		}

		public LocalDate getFechaLanzamiento() {
			return fechaLanzamiento;
		}

		public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
			this.fechaLanzamiento = fechaLanzamiento;
		}

		public Genero getGenero() {
			return genero;
		}

		public void setGenero(Genero genero) {
			this.genero = genero;
		}
		
		public String formatoCorto() {
			return this.titulo+"(" + this.artista+") "+this.duracion.toMinutesPart() +
					":" + this.duracion.toSecondsPart();
		}

		@Override
		public String toString() {
			return "Cancion [titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion
					+ ", fechaLanzamiento=" + fechaLanzamiento + ", genero=" + genero + ", formatoCorto()="
					+ formatoCorto() + "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((artista == null) ? 0 : artista.hashCode());
			result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
			result = prime * result + ((fechaLanzamiento == null) ? 0 : fechaLanzamiento.hashCode());
			result = prime * result + ((genero == null) ? 0 : genero.hashCode());
			result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Cancion))
				return false;
			Cancion other = (Cancion) obj;
			if (artista == null) {
				if (other.artista != null)
					return false;
			} else if (!artista.equals(other.artista))
				return false;
			if (duracion == null) {
				if (other.duracion != null)
					return false;
			} else if (!duracion.equals(other.duracion))
				return false;
			if (fechaLanzamiento == null) {
				if (other.fechaLanzamiento != null)
					return false;
			} else if (!fechaLanzamiento.equals(other.fechaLanzamiento))
				return false;
			if (genero != other.genero)
				return false;
			if (titulo == null) {
				if (other.titulo != null)
					return false;
			} else if (!titulo.equals(other.titulo))
				return false;
			return true;
		}

		//Criterio de ordenacion
		public int compareTo(Cancion c) {
			int res = this.getArtista().compareTo(c.getArtista());
			if (res==0) {
				res=this.getTitulo().compareTo(c.getTitulo());
			}
			return res;
		}
}

