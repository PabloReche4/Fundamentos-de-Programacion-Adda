package jugadores;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasJugadores {

	Set<Jugador> j;
	
	 public Integer numJugadores() {
		 return this.j.size();
	 }
	 
	 public EstadisticasJugadores(Stream<Jugador> jugadores) {
		 this.j = jugadores.collect(Collectors.toSet());
	 }

	@Override
	public String toString() {
		String res = "";
		for(Jugador jugador : this.j) {
			res += jugador + "\n";
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(j);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticasJugadores other = (EstadisticasJugadores) obj;
		return Objects.equals(j, other.j);
	}
	 
	//EJERCICIO 1 -----------------------------------------------------------------------------------------
	
	public Long getNumeroLesionesDistintas(Integer umbralClasificacion) {
		return j.stream()
				.filter(i->i.equipo.clasificacion()<umbralClasificacion)
				.flatMap(j->j.lesiones.stream())
				.distinct()
				.count()
				;
	}	
	
	
	//EJERCICIO 2 -----------------------------------------------------------------------------------------

	public List<String> getNJugadoresMasJovenesPosicionSinLesion(Posicion p, Integer n) {
		return j.stream()
				.filter(j -> j.getPosicion().equals(p) && j.getLesiones().isEmpty())
				.sorted(Comparator.comparing(Jugador::getEdad))
				.map(Jugador::getNombre)
				.limit(n)
				.collect(Collectors.toList());
	}
	//EJERCICIO 3--------------------------------------------------------------------------------------------
	public  Equipo getEquipoMasJugadoresConGolesSuperiorMedia() {
		Map<Equipo, Long>aux=j.stream()
				.filter(x->x.getGoles()>mediaGoles())
				.collect(Collectors.groupingBy(Jugador::getEquipo,Collectors.counting()));
		return aux.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
				
		
	}
	private Double mediaGoles() {
		return j.stream()
				.collect(Collectors.averagingDouble(Jugador::getGoles));
				
				
	}
	//EJERCICIO 4---------------------------------------------------------------------------------------------
	public  Boolean todosEquiposTienenJugadorLesionado() {
		Map<Equipo, Boolean>aux=j.stream()
				.collect(Collectors.groupingBy(Jugador::getEquipo,Collectors.collectingAndThen(Collectors.toList(), e->alMenosUnLesionado(e))));
		return aux.entrySet().stream()
				.anyMatch(e->!e.getValue().equals(true));
	}
	private Boolean alMenosUnLesionado(List<Jugador> jugador) {
		return jugador.stream()
				.anyMatch(x->!x.getLesiones().isEmpty());
				
	}
	//EJERCICIO 5-----------------------------------------------------------------------------------------------
	public  SortedMap<Equipo, String> getNombreJugadorConMayorSumaGAPorEquipo(){
		Map<Equipo, Jugador>res=new HashMap<>();
		for(Jugador m:j) {
			
			
		}
		
	}
	
}
