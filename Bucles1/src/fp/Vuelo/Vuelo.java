package fp.Vuelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vuelo implements Comparable <Vuelo> {
		private String codigo;
		private String origen;
		private String destino;
		private LocalDateTime fechaDeSalida;
		private Integer numeroDePlazas;
		private Integer numeroDePasajeros;
		private Boolean completo;
		
		public String cadenaConFormato() {
			return "(" + this.codigo + ") " + this.origen + "-" + this.destino + " " +
					this.fechaDeSalida;
		}

		public LocalDateTime getFechaDeSalida() {
			return fechaDeSalida;
		}

		public void setFechaDeSalida(LocalDateTime fechaDeSalida) {
			this.fechaDeSalida = fechaDeSalida;
		}

		public Integer getNumeroDePasajeros() {
			return numeroDePasajeros;
		}

		public void setNumeroDePasajeros(Integer numeroDePasajeros) {
			this.numeroDePasajeros = numeroDePasajeros;
		}

		public String getCodigo() {
			return codigo;
		}

		public String getOrigen() {
			return origen;
		}

		public String getDestino() {
			return destino;
		}

		public Integer getNumeroDePlazas() {
			return numeroDePlazas;
		}

		public Boolean getCompleto() {
			return completo;
		}

		public Vuelo(String codigo, String origen, String destino, LocalDateTime fechaDeSalida,
				Integer numeroDePlazas,Integer numeroDePasajeros, Boolean completo) {
			this.codigo = codigo;
			this.origen = origen;
			this.destino = destino;
			this.fechaDeSalida = fechaDeSalida;
			this.numeroDePlazas = numeroDePlazas;
			this.numeroDePasajeros = numeroDePasajeros;
			this.completo = completo;
		}

		public Vuelo(String codigo, String origen, String destino, LocalDateTime fechaDeSalida,
				Integer numeroDePlazas, Boolean completo) {
			this.codigo = codigo;
			this.origen = origen;
			this.destino = destino;
			this.fechaDeSalida = fechaDeSalida;
			this.numeroDePlazas = numeroDePlazas;
			this.numeroDePasajeros = 0;
			this.completo = completo;
		}
		
			@Override
			public int hashCode() {
				return Objects.hash(codigo, completo, destino, fechaDeSalida, numeroDePasajeros, numeroDePlazas,
						origen);
			}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vuelo other = (Vuelo) obj;
			return Objects.equals(codigo, other.codigo) && Objects.equals(completo, other.completo)
					&& Objects.equals(destino, other.destino) && Objects.equals(fechaDeSalida, other.fechaDeSalida)
					&& Objects.equals(numeroDePasajeros, other.numeroDePasajeros)
					&& Objects.equals(numeroDePlazas, other.numeroDePlazas) && Objects.equals(origen, other.origen);
		}

		public int compareTo(Vuelo o) {
			int res = this.getCodigo().compareTo(o.getCodigo());
			if(res == 0)
				res = this.getOrigen().compareTo(o.getOrigen());
			if (res == 0)
				res = this.getDestino().compareTo(o.getDestino());
			if (res == 0)
				res = this.getFechaDeSalida().compareTo(o.getFechaDeSalida());
			return res;
		}
		
		public boolean Equals (Object o) {
			boolean res=false;
			if (o instanceof Vuelo) {
				Vuelo v = (Vuelo) o;
				res=this.codigo.equals(v.codigo) && this.origen.equals(v.origen);
			}
			return res;
			
		}
		
		
}
