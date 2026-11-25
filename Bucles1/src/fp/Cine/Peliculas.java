package fp.Cine;

import java.time.LocalDate;

import utiles.Checkers;

public class Peliculas implements Comparable<Peliculas> {
		private String titulo;
		private LocalDate fecha_de_estreno;
		private Integer duracion;
		
		public TipoMetraje tipoDeMetraje() {
			TipoMetraje res = TipoMetraje.LARGOMETRAJE;
			if (this.duracion<30) {
				res = TipoMetraje.CORTOMETRAJE;
			}
			else {
				if (this.duracion<=60) {
				res = TipoMetraje.MEDIOMETRAJE;					
				}
			}
			return res;
		}

		public String formatoCorto(){
			return this.titulo + "(" + this.fecha_de_estreno.getYear() + ") ";
			
		}
				//Constructor
		public Peliculas(String titulo, LocalDate fecha_de_estreno, Integer duracion) {
			Checkers.checkNoNull(titulo,duracion,fecha_de_estreno);
			Checkers.check("La duracion debe ser >0", duracion>0);
			this.titulo = titulo;
			this.fecha_de_estreno = fecha_de_estreno;
			this.duracion = duracion;
		}

		public Peliculas(String titulo) {
			this(titulo,LocalDate.MIN,1);
		}

		public String getTitulo() {
			return titulo;
		}

		public LocalDate getFecha_de_estreno() {
			return fecha_de_estreno;
		}

		public void setFecha_de_estreno(LocalDate fecha_de_estreno) {
			Checkers.checkNoNull(fecha_de_estreno);
			this.fecha_de_estreno = fecha_de_estreno;
		}

		public Integer getDuracion() {
			return duracion;
		}

		public void setDuracion(Integer duracion) {
			Checkers.checkNoNull(duracion);
			Checkers.check("La duracion debe ser >0", duracion>0);
			this.duracion = duracion;
		}

		@Override
		public String toString() {
			return "Peliculas [titulo=" + titulo + ", fecha_de_estreno=" + fecha_de_estreno + ", duracion=" + duracion
					+ ", tipoDeMetraje()=" + tipoDeMetraje() + ", formatoCorto()=" + formatoCorto() + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fecha_de_estreno == null) ? 0 : fecha_de_estreno.hashCode());
			result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Peliculas))
				return false;
			Peliculas other = (Peliculas) obj;
			if (fecha_de_estreno == null) {
				if (other.fecha_de_estreno != null)
					return false;
			} else if (!fecha_de_estreno.equals(other.fecha_de_estreno))
				return false;
			if (titulo == null) {
				if (other.titulo != null)
					return false;
			} else if (!titulo.equals(other.titulo))
				return false;
			return true;
		}
		
		public int compareTo(Peliculas p) {
			int res = this.getFecha_de_estreno().compareTo(p.getFecha_de_estreno());
			//este compareTo esta programado en LocalDate por ser getfechadeestreno LocalDate
			if (res==0) {
				res=this.getTitulo().compareTo(p.getTitulo());
			}
			return res;
		}
}

