package fp.futbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class Partido implements Comparable <Partido> {
	private LocalDate fecha;
	private String equipoLocal;
	private String equipoVisitante;
	private Long espectadores;
	private Competicion competicion;
	private List<ResultadoParcial> resultadosParciales;
	

	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getEquipoLocal() {
		return equipoLocal;
	}


	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	public String getEquipoVisitante() {
		return equipoVisitante;
	}


	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}


	public Long getEspectadores() {
		return espectadores;
	}


	public void setEspectadores(Long espectadores) {
		this.espectadores = espectadores;
	}


	public Competicion getCompeticion() {
		return competicion;
	}


	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}


	public List<ResultadoParcial> getResultadosParciales() {
		return resultadosParciales;
	}


	public void setResultadosParciales(List<ResultadoParcial> resultadosParciales) {
		this.resultadosParciales = new ArrayList<>(resultadosParciales);
	}


	public Partido(LocalDate fecha, String equipoLocal, String equipoVisitante,
			Long espectadores, Competicion competicion,
			List<ResultadoParcial> resultadosParciales) {
		this.fecha=fecha;
		this.equipoLocal=equipoLocal;
		this.equipoVisitante=equipoVisitante;
		this.espectadores= espectadores;
		this.competicion=competicion;
		Checkers.check("Resultados parciales incorrecto", estaOrdenado(resultadosParciales));
		this.resultadosParciales= resultadosParciales;
	}

	 
	 private Boolean estaOrdenado(List<ResultadoParcial> resultadosParciales) { 
		 Boolean res = true; 
		 int indAnt = 0; 
		 for (int i=1; i < resultadosParciales.size(); i++) { 
			 Integer minutoAnt = resultadosParciales.get(indAnt).minuto(); 
			 Integer minutoAct = resultadosParciales.get(i).minuto(); 
			 if (! (minutoAnt< minutoAct)) { 
				 res = false; 
				 break; 
	   } 
			 indAnt = i; 
	  } 
		 return res;   	
	 } 
   public Integer getGolesLocal() {
	   return resultadosParciales.get(resultadosParciales.size()-1)
			   .golesLocal();
   }
   public Integer getGolesVisitante() {
	   return resultadosParciales.get(resultadosParciales.size()-1)
			   .golesVisitante();
   }
   public Integer getMinutoUltimoGol() {
	   return resultadosParciales.get(resultadosParciales.size() - 1).minuto();
   }
   public List<Integer>getMinutos(){
	   return resultadosParciales.stream()
			   .map(ResultadoParcial::minuto)
			   .filter(x->!x.equals(Integer.valueOf(0)))
			   .toList();
   }
   public int compareTo(Partido p) {
	   int res=this.getFecha().compareTo(p.getFecha());
			   if (res==0) {
				   res=this.getEquipoLocal().compareTo(p.getEquipoLocal());
				   		if(res==0) {
				   			res=this.getGolesVisitante().compareTo(p.getGolesVisitante());
				   		}
			   }
			return res;
			   
	   
   }
}
