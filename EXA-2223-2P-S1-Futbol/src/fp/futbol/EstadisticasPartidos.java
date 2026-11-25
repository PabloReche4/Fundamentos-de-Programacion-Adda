	package fp.futbol;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasPartidos {
	private List <Partido> partidos;
	private Integer numPartidos;
		public EstadisticasPartidos(Stream<Partido>streamPartidos) {
				this.numPartidos= this.partidos.size();
				this.partidos=streamPartidos.collect(Collectors.toList());
    
		}
		public List<Partido> getPartidos() {
			return partidos;
		}
		public void setPartidos(List<Partido> partidos) {
			this.partidos = partidos;
		}
		public Integer getNumPartidos() {
			return numPartidos;
		}
		public void setNumPartidos(Integer numPartidos) {
			this.numPartidos = numPartidos;
		}
		@Override
		public String toString() {
			return "EstadisticasPartidos [partidos=" + partidos + ", numPartidos=" + numPartidos + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(numPartidos, partidos);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EstadisticasPartidos other = (EstadisticasPartidos) obj;
			return Objects.equals(numPartidos, other.numPartidos) && Objects.equals(partidos, other.partidos);
		}
		public Integer getNumGolesEquipos(Set<String> equipos) {
			Integer numg=0;
			for (Partido p:partidos) {
				if (equipos.contains(p.getEquipoLocal())) {
					numg +=p.getGolesLocal();
				}else if (equipos.contains(p.getEquipoVisitante())) {
					numg +=p.getGolesVisitante();
				}
				
			}
			return numg;
		}
		public Integer getNumGolesDespuesMinuto(Integer minutoUmbral) {
			Long res= partidos.stream()
					 .flatMap(x->x.getMinutos().stream())
					 .filter(x->x.compareTo(minutoUmbral)>0)
					 .count();
			return res.intValue();
					
		}
		public SortedSet<Partido> getNPartidosMasEspectadores(Integer n){
		    Function<Partido, Integer>fGoles=partido->partido.getGolesLocal()+partido.getGolesVisitante();
		    Comparator<Partido>cmpGoles=Comparator.comparing(fGoles).thenComparing(Comparator.naturalOrder());
		    return partidos.stream()
		    		.sorted(Comparator.comparing(Partido::getEspectadores).reversed())
		    		.limit(n)
		    		.collect(Collectors.toCollection(()->new TreeSet <>(cmpGoles)));
		}
		public Competicion getCompeticionMasEspectadores(Integer mes) {
			Map<Competicion, Long> espXCompeticion = partidos.stream() 
					  .filter(x -> mes.equals(x.getFecha().getMonthValue())) 
					  .collect(Collectors.groupingBy( 
					   Partido::getCompeticion,  
					   Collectors.summingLong(Partido::getEspectadores)));  
					 return espXCompeticion.entrySet().stream() 
					  .max(Map.Entry.comparingByValue()) 
					  .map(Map.Entry::getKey) 
					  .get();
//					 return partidos.stream()
	//	                .filter(p -> p.getFecha().getMonthValue() == mes)
//		                .collect(Collectors.groupingBy(Partido::getCompeticion, Collectors.summingInt(Partido::getEspectadores)))
//		                .entrySet().stream()
//		                .max(Map.Entry.comparingByValue())
//		                .orElseThrow(NoSuchElementException::new)
//		                .getKey()
		}
		public Map<Competicion, Partido> getPartidoGolMasTardioPorCompeticion(){
			
			return partidos.stream()
					.collect(Collectors.groupingBy(Partido::getCompeticion,
							Collectors.collectingAndThen(Collectors.maxBy(
												Comparator.comparing(Partido::getMinutoUltimoGol)), opt->opt.get())));
		}
			
}
