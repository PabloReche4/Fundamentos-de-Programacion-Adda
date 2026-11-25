package fp.PartidoFutbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utiles.Checkers;

public class PartidoFutbol implements Comparable <PartidoFutbol> {
	private LocalDate fecha;
	private String equipoLocal;
	private String equipoVisitante;
	private Integer golesLocal;
	private Integer golesVisitante;
	
	public ResultadoQuiniela resultado() {
		ResultadoQuiniela res = ResultadoQuiniela.EQUIS;
		if (this.golesLocal>this.golesVisitante) {
			res = ResultadoQuiniela.UNO;
		}
		else {
			if(this.golesLocal<this.golesVisitante) {
				res = ResultadoQuiniela.DOS;
			}
		}
		return res;
	}
	public String formatoCorto() {
		char aux = '2';
		if (resultado()==ResultadoQuiniela.UNO) {
			aux = '1';	
		}
		else {
			if (resultado()==ResultadoQuiniela.EQUIS) {
				aux = 'X';
			}
		}
		return this.fecha.format(DateTimeFormatter.ofPattern("dd-MM-yy")) + "->" + 
		this.equipoLocal + " vs " + this.equipoVisitante + ": " + this.golesLocal + "-" + this.golesVisitante
		+ "(" + aux + ")"; 
	}
	public PartidoFutbol(LocalDate fecha, String equipoLocal, String equipoVisitante, Integer golesLocal,
			Integer golesVisitante) {
		Checkers.checkNoNull(equipoLocal,equipoVisitante,golesLocal,golesVisitante,fecha);
		Checkers.check("El equipo visitante no puede ser la cadena vacia", !equipoVisitante.equals(""));
		Checkers.check("El equipo local no puede ser la cadena vacia", !equipoLocal.equals(""));
		Checkers.check("Goles del local>=0", golesLocal>=0);
		Checkers.check("Goles del visitante>=0", golesVisitante>=0);
		this.fecha = fecha;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public Integer getGolesLocal() {
		return golesLocal;
	}
	public Integer getGolesVisitante() {
		return golesVisitante;
	}
	@Override
	public String toString() {
		return "PartidoFutbol [fecha=" + fecha + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + ", resultado()=" + resultado()
				+ ", formatoCorto()=" + formatoCorto() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoLocal == null) ? 0 : equipoLocal.hashCode());
		result = prime * result + ((equipoVisitante == null) ? 0 : equipoVisitante.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((golesLocal == null) ? 0 : golesLocal.hashCode());
		result = prime * result + ((golesVisitante == null) ? 0 : golesVisitante.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PartidoFutbol))
			return false;
		PartidoFutbol other = (PartidoFutbol) obj;
		if (equipoLocal == null) {
			if (other.equipoLocal != null)
				return false;
		} else if (!equipoLocal.equals(other.equipoLocal))
			return false;
		if (equipoVisitante == null) {
			if (other.equipoVisitante != null)
				return false;
		} else if (!equipoVisitante.equals(other.equipoVisitante))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (golesLocal == null) {
			if (other.golesLocal != null)
				return false;
		} else if (!golesLocal.equals(other.golesLocal))
			return false;
		if (golesVisitante == null) {
			if (other.golesVisitante != null)
				return false;
		} else if (!golesVisitante.equals(other.golesVisitante))
			return false;
		return true;
	}
	@Override
	public int compareTo(PartidoFutbol o) {
		int res = this.getFecha().compareTo(o.getFecha());
		if(res == 0) {
			res = this.getEquipoLocal().compareTo(o.getEquipoLocal());
		if (res == 0) {
			res = this.getEquipoVisitante().compareTo(o.getEquipoVisitante());			
		}
	}	
		return res;
	}
	public Integer puntosLocal() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer puntosVisitante() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}