package fp.PartidoFutbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import utiles.Checkers;

public class Competicion {
	private String nombre;
	private Integer año;       
	private List<PartidoFutbol> partidos;
	
	public Integer numeroDePartidos(List<PartidoFutbol>partidos) {
		return partidos.size();
	}

	public Competicion( String nombre, Integer año, List<PartidoFutbol> partidos) {
		Checkers.checkNoNull(nombre,año);
		this.nombre = nombre;
		this.año = año;
		this.partidos = new ArrayList<PartidoFutbol>();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getAño() {
		return año;
	}

	public List<PartidoFutbol> getPartidos() {
		return partidos;
	}

	public String toString() {
		return "Competicion [nombre=" + nombre + ", año=" + año + ", numeroDePartidos()="
				+ numeroDePartidos(partidos) + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((año == null) ? 0 : año.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Competicion))
			return false;
		Competicion other = (Competicion) obj;
		if (año == null) {
			if (other.año != null)
				return false;
		} else if (!año.equals(other.año))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void incorporaPartido(PartidoFutbol p) {
		if(!(partidos.contains(p))) {
			partidos.add(0,p);
		}
	}
	
	public void incorporaPartidos(List<PartidoFutbol> partidos) {
		this.partidos.addAll(partidos);
	}
	public Integer getVictoriasVisitantes() {
		Integer res=0;
		for(PartidoFutbol p:partidos) {
			if(p.getGolesLocal()<p.getGolesVisitante()) {
				res+=1;
			}
			
		}
		return res;
	}
	public Integer getTotalGolesMarcados(String equipo) {
		Integer res=0;
		for(PartidoFutbol p:partidos) {
			if(p.getEquipoLocal().equals(equipo)||p.getEquipoVisitante().equals(equipo)) {
				res+=1;
			}
		}
		return res;
	}
	public Set<String> getEquipos(){
		Set<String>res=new HashSet<>();
		for(PartidoFutbol p:partidos) {
			Collections.addAll(res,p.getEquipoLocal(), p.getEquipoVisitante());
		}
		return res;
	}
	public PartidoFutbol getPartidoMasGoles() {
		Integer maxGoles=null;
		PartidoFutbol res=null;
		for(PartidoFutbol p:partidos) {
			int golesTotal=p.getGolesLocal()+p.getGolesVisitante();
			if(maxGoles.equals(null)||golesTotal>maxGoles) {
				maxGoles=golesTotal;
				res=p;
			}
		}
		return res;
	}
	
	public Map<ResultadoQuiniela, Integer> contarNumPartidosPorResultado(){
		Map<ResultadoQuiniela, Integer> res=new HashMap<>();
		for(PartidoFutbol p:partidos) {
			ResultadoQuiniela clave=p.resultado();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave)+1);
				
			}else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	public Map <String, Integer> getClasificacionFinal(){
		Map<String, Integer>res=new HashMap<>();
		for(PartidoFutbol p:partidos) {
			agregaAMap(res,p.getEquipoLocal(), p.puntosLocal());
			agregaAMap(res,p.getEquipoVisitante(), p.puntosVisitante());
		}
	return res;
	}

	private static Map<String, Integer> agregaAMap(Map<String, Integer> res, String clave, Integer valor) {
		if (res.containsKey(clave)) {
			res.put(clave, res.get(clave)+valor);
		}else {
			res.put(clave, valor);
		}
		return res;
		
		
	}
	public Map<String, Integer> contarPartidosGanadosPorEquipo(){
		Map<String, Integer>res=new HashMap<>();
		for(PartidoFutbol p:partidos) {
			if(p.getGolesLocal()>p.getGolesVisitante()) {
				if(res.containsKey(p.getEquipoLocal())) {
					res.put(p.getEquipoLocal(), res.get(p.getEquipoLocal()+1));
				}else {
					res.put(p.getEquipoLocal(), 1);
				}
			}else if(p.getGolesLocal()<p.getGolesVisitante()) {
				if(res.containsKey(p.getEquipoVisitante())) {
					res.put(p.getEquipoVisitante(), res.get(p.getEquipoVisitante()+1));
				}else {
					res.put(p.getEquipoVisitante(), 1);
				}
			}	
		}
		return res;	
	}
	public SortedMap<LocalDate, List<PartidoFutbol>> getPartidosPorFecha (){
		SortedMap<LocalDate, List<PartidoFutbol>>res=new TreeMap<>();
		for(PartidoFutbol p:partidos) {
			LocalDate clave=LocalDate.of(p.getFecha().getYear(), p.getFecha().getMonth(), p.getFecha().getDayOfMonth());
			if(res.containsKey(clave)) {
				res.get(clave).add(p);
			}else {
				List<PartidoFutbol>lista=new ArrayList<>();
				res.put(clave, lista);
			}
			
		}
		return res;
	}
	public SortedMap<Integer, Set<String>> equiposPorNumeroPartidosGanados(){
		SortedMap<Integer, Set<String>> res=new TreeMap<>();
		Map<String, Integer> mapPartidos = contarPartidosGanadosPorEquipo();
		for (Entry<String, Integer> par: mapPartidos.entrySet()) {
			Integer clave= par.getValue();
			if(res.containsKey(clave)) {
				res.get(clave).add(par.getKey());
			}else {
				Set<String> conj = new HashSet<>();
				res.put(clave, conj);
			}
		}
		return res;
	}
	
}