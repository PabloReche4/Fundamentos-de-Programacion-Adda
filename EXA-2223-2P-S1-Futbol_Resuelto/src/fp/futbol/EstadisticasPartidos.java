package fp.futbol;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasPartidos {
	private List<Partido> partidos;
	
	public EstadisticasPartidos(Stream<Partido> sp) {
		this.partidos=sp.collect(Collectors.toList());
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public Integer numPartidos() {
		return this.partidos.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partidos == null) ? 0 : partidos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof EstadisticasPartidos))
			return false;
		EstadisticasPartidos other = (EstadisticasPartidos) obj;
		if (partidos == null) {
			if (other.partidos != null)
				return false;
		} else if (!partidos.equals(other.partidos))
			return false;
		return true;
	}
	
	public String toString() {
		String res="";
		for (Partido p:this.partidos) {
			res+=p+"\n";
		}
		return res;
	}
	
	public Integer getNumGolesEquipos(Set<String> equipos) {
		int res=0;
		for (Partido p:this.partidos) {
			if (equipos.contains(p.getEquipoLocal())) {
				res+=p.golesLocal();
			}
			if (equipos.contains(p.getEquipoVisitante())) {
				res+=p.golesVisitante();
			}
		}
		return res;
	}
	
	public Integer getNumGolesDespuesMinuto(Integer minutoUmbral) {
		return this.partidos.stream()
				.flatMap(p->p.getResultadosParciales().stream())
				.filter(rp->rp.minuto()>minutoUmbral)
				.mapToInt(rp->1).sum();
	}
	
	public SortedSet<Partido> getNPartidosMasEspectadores(Integer n){
		Comparator<Partido> cmp1=Comparator.comparing(Partido::getNúmeroEspectadores);
		Comparator<Partido> cmp2=cmp1.reversed();
		Comparator<Partido> cmp3=Comparator.comparing(p->p.golesLocal()+p.golesVisitante());
		Comparator<Partido> cmp4=cmp3.thenComparing(Comparator.naturalOrder());
		
		return this.partidos.stream()
				.sorted(cmp2)
				.limit(n)
				.collect(Collectors.toCollection(()->new TreeSet<Partido>(cmp4)));
	}
	
	public Competicion getCompeticionMasEspectadores(Integer mes) {
		return this.partidos.stream()
				.filter(p->p.getFechaPartido().getMonthValue()==mes)
				.collect(Collectors.groupingBy(Partido::getCompetición,
						Collectors.summingInt(Partido::getNúmeroEspectadores)))
				.entrySet().stream()
				.max(Comparator.comparing(Entry::getValue))
				.get().getKey();
	}
	
	public Map<Competicion, Partido> getPartidoGolMasTardioPorCompeticion(){
		return this.partidos.stream()
				.collect(Collectors.groupingBy(Partido::getCompetición,
						Collectors.collectingAndThen(Collectors.toList(),
								l->partidoMásTardío(l))));
	}
	private Partido partidoMásTardío(List<Partido>l) {
		Comparator<Partido> cmp=Comparator.comparing(p->p.minutos().get(p.minutos().size()-1));
		return l.stream()
				.max(cmp).get();
	}

	
}
