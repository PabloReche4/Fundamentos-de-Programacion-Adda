package fp.futbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class Partido implements Comparable<Partido>{
	private LocalDate fechaPartido;
	private String equipoLocal;
	private String equipoVisitante;
	private Integer númeroEspectadores;
	private Competicion competición;
	private List<ResultadoParcial> resultadosParciales;
	
	public Partido(LocalDate fechaPartido, String equipoLocal, String equipoVisitante, Integer númeroEspectadores,
			Competicion competición, List<ResultadoParcial> resultadosParciales) {
		this.fechaPartido = fechaPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.númeroEspectadores = númeroEspectadores;
		this.competición = competición;
		this.resultadosParciales = new ArrayList<ResultadoParcial> (resultadosParciales);
		Checkers.check("Los minutos parciales no están bien ordenados",chequeaMinutosParciales(resultadosParciales));
	}
	
	private boolean chequeaMinutosParciales(List<ResultadoParcial> resultados) {
		boolean res=true;
		int minutoAnterior=0;
		for (ResultadoParcial r:resultados) {
			if (r.minuto()<minutoAnterior) {
				res=false;
				break;
			}
			else {
				minutoAnterior=r.minuto();
			}
		}
		return res;
	}

	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public Integer getNúmeroEspectadores() {
		return númeroEspectadores;
	}

	public Competicion getCompetición() {
		return competición;
	}

	public List<ResultadoParcial> getResultadosParciales() {
		return new ArrayList<ResultadoParcial>(resultadosParciales);
	}
	public Integer golesLocal() {
		return this.resultadosParciales.get(this.resultadosParciales.size()-1).golesLocal();
		
		
	}
	public Integer golesVisitante() {
		return this.resultadosParciales.get(this.resultadosParciales.size()-1).golesVisitante();
	}
	public List<Integer> minutos(){
		List<Integer> res=new ArrayList<Integer>();
		for (ResultadoParcial r: this.resultadosParciales) {
			res.add(r.minuto());
		}
		return res;
	}

	@Override
	public String toString() {
		return "Partido [fechaPartido=" + fechaPartido + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
				+ equipoVisitante + ", númeroEspectadores=" + númeroEspectadores + ", competición=" + competición
				+ ", resultadosParciales=" + resultadosParciales + "]";
	}
	
	public int compareTo(Partido p) {
		int res=this.getFechaPartido().compareTo(p.getFechaPartido());
		if(res==0) {
			res=this.getEquipoLocal().compareTo(p.getEquipoLocal());
			if (res==0) {
				res=this.getEquipoVisitante().compareTo(p.getEquipoVisitante());
			}
		}
		return res;
	}
	
	
	
	
}
