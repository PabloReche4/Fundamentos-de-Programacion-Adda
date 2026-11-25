package fp.PartidoFutbol;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import utiles.Checkers;
//el record ya imoklementa el hash code y el equals
public record PartidoFutbolRecord(LocalDateTime fecha, String equipoLocal,
		String equipoVisitante, Integer golesLocal, Integer golesVisitante)
	implements Comparable<PartidoFutbolRecord>{	
	
	public PartidoFutbolRecord {
		Checkers.checkNoNull(equipoLocal,equipoVisitante,golesLocal,golesVisitante,fecha);
		Checkers.check("El equipo visitante no puede ser la cadena vacia", !equipoVisitante.equals(""));
		Checkers.check("El equipo local no puede ser la cadena vacia", !equipoLocal.equals(""));
		Checkers.check("Goles del local>=0", golesLocal>=0);
		Checkers.check("Goles del visitante>=0", golesVisitante>=0);
	}
	
	public ResultadoQuiniela resultado() {
		ResultadoQuiniela res = ResultadoQuiniela.EQUIS;
		if (this.golesLocal>this.golesVisitante) {
			//this.golesLocal.compareTo(this.golesVisitante)>0 es otra forma pero no para envolturas
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
		return this.fecha.toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yy")) + "->" + 
		this.equipoLocal + " vs " + this.equipoVisitante + ": " + this.golesLocal + "-" + this.golesVisitante
		+ "(" + aux + ")"; 
	}

	public int compareTo(PartidoFutbolRecord p) {
		int res =this.fecha().compareTo(p.fecha());
		if(res == 0) {
			res = this.equipoLocal().compareTo(p.equipoLocal());
			if(res == 0) {
				res = this.equipoVisitante().compareTo(p.equipoVisitante());
			}
		}
		return res;
	}

}
