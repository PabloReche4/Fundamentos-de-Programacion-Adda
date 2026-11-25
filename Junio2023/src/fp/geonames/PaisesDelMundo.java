package fp.geonames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaisesDelMundo {
	private SortedSet<Pais> paises;
	private LocalDateTime fechaYHoraActualizacion;
	public Integer numPaises() {
		return paises.size();
	}
	
	public PaisesDelMundo(LocalDateTime l, Stream<Pais> p) {
		this.paises= p.collect(Collectors.toCollection(TreeSet::new));
		this.fechaYHoraActualizacion= l;
	}
	public PaisesDelMundo(Stream<Pais> sv) {
		this.paises= sv.collect(Collectors.toCollection(TreeSet::new));
		this.fechaYHoraActualizacion=LocalDateTime.now();
		
	}

	public SortedSet<Pais> getPaises() {
		return paises;
	}

	public LocalDateTime getFechaYHoraActualizacion() {
		return fechaYHoraActualizacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaYHoraActualizacion, paises);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisesDelMundo other = (PaisesDelMundo) obj;
		return Objects.equals(fechaYHoraActualizacion, other.fechaYHoraActualizacion)
				&& Objects.equals(paises, other.paises);
	}

	@Override
	public String toString() {
		return "PaisesDelMundo [paises=" + paises + ", fechaYHoraActualizacion=" + fechaYHoraActualizacion + "]";
	}
	public Double porcentajeAreaDeContinente(Continente cont) {
		Double areaMundo = paises.stream()
				.mapToDouble(Pais::getArea)
				.sum();
				Double areaContinente = paises.stream()
				.filter(pais -> pais.getContinente().equals(cont))
				.mapToDouble(Pais::getArea)
				.sum();
				return areaContinente / areaMundo;
				
		
	}
	public List<String>nombresDeVecinos(String pais){
	  Set<String>res=paises.stream()
			  .filter(p->pais.equals(p.getNombre()))
			  .flatMap(p->p.getPaisesVecinos().stream())
			  .collect(Collectors.toSet());
	  return paises.stream()
			  .filter(p->res.contains(p.getCodigoISO()))
			  .map(p->p.getNombre())
			  .sorted()
			  .toList()
			  ;
				
				
	}
	public SortedMap<String,List<String>>paisesPorIdiomas(){
		SortedMap<String, List<String>>res=new TreeMap<>();
		for(Pais p:paises) {
			for(Idioma i: p.getIdiomas()) {
				String clave=i.nombre();
					if(res.containsKey(clave)) {
						res.get(clave).add(p.getNombre());				
						}else {
							List<String>l=new ArrayList<String>();
							l.add(p.getNombre());
							res.put(clave, l);
						}		
			}		
		}
		for(List<String>l:res.values()) {
			Collections.sort(l);
		}
		return res;
	}
	public SortedMap<String, String>paisMayorPoblacionPorMoneda(){
		Comparator<Pais>c=Comparator.comparing(Pais::getMoneda).thenComparing(Pais::getDensidadPoblacion);
		return paises.stream()
				.collect(Collectors.groupingBy(Pais::getMoneda,TreeMap::new,
						Collectors.collectingAndThen(Collectors.maxBy(c), opt->opt.get().getNombre())));
	}
	public List<String>vecinosMasFrecuentes(Integer n){
	Comparator<Pais>cmp=Comparator.comparing((Pais p)->p.getPaisesVecinos().size()).reversed();
		return paises.stream()
				.sorted(cmp)
				.limit(n)
				.map(p->p.getNombre())
				.sorted()
				.collect(Collectors.toList());
	}

}

	


