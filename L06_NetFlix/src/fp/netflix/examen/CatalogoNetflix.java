package fp.netflix.examen;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogoNetflix {
private SortedSet <ProduccionNetflix>producciones;

	public CatalogoNetflix(Stream<ProduccionNetflix>producciones) {
		this.producciones = producciones.collect(Collectors.toCollection(
				()->new TreeSet<ProduccionNetflix>
				(Comparator.comparing(ProduccionNetflix::getAñoProduccion)
						.thenComparing(Comparator.naturalOrder()))));
//		public CatalogoNetflix(Stream<ProduccionNetflix> stream) { 
//			Comparator<ProduccionNetflix> cmp =  
//			Comparator.comparing(ProduccionNetflix::anyo) 
//			.thenComparing(Comparator.naturalOrder()); 
//			this.producciones = stream.collect( 
//			Collectors.toCollection(() -> new TreeSet<>(cmp))); 
//			} 
	}


	public SortedSet<ProduccionNetflix> getProducciones() {
		return new TreeSet<>(producciones);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((producciones == null) ? 0 : producciones.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CatalogoNetflix))
			return false;
		CatalogoNetflix other = (CatalogoNetflix) obj;
		if (producciones == null) {
			if (other.producciones != null)
				return false;
		} else if (!producciones.equals(other.producciones))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CatalogoNetflix [producciones=" + producciones + "]";
	}
	public Map<String, Set<ProduccionNetflix>>getProduccionesPorGenero(){
		Map<String,Set<ProduccionNetflix>>res=new HashMap<>();
		for(ProduccionNetflix p:producciones) {
			for(String g:p.getGeneros()) {
				if(res.containsKey(g)) {  //si existe, lo encadeno
					res.get(g).add(p);
				}else {//sino lo creo nuevo
					Set<ProduccionNetflix>lo=new HashSet<>();
					lo.add(p);
					res.put(g, lo);
				}
			}
			
		}
		return res;
	}
	public SortedSet<String>getGeneros(){
		return producciones.stream()
				.flatMap(p->p.getGeneros().stream())
				.collect(Collectors.toCollection(TreeSet::new));
		
	}
	public  List<String>getTitulosDeGenerosOrdenadosPorTamanyo(List<String>genres) {
		Comparator<ProduccionNetflix>cmp=Comparator.comparing((ProduccionNetflix p)->p.getGeneros().size()).
				thenComparing((ProduccionNetflix p)->p.getTitulo().length());
		return producciones.stream()
				.filter(t->t.getGeneros().containsAll(genres))
				.sorted(cmp.reversed())
				.map(ProduccionNetflix::getTitulo)
				.collect(Collectors.toList());
	
	}
	public String getGeneroConMayorPopularidadAcumulada() {
		Map<String,Set<ProduccionNetflix>>aux=getProduccionesPorGenero();
		Map<String, Long>aux1=aux.entrySet().stream()
				.collect(Collectors.toMap(e->e.getKey(), e->popularidadAcumulada(e.getValue())));
		return aux1.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.get()
				.getKey();
	}
	private Long popularidadAcumulada(Set<ProduccionNetflix>p) {
		return p.stream()
				.mapToLong(d->d.getPopularidad())
				.sum();
	}
	public SortedMap<Integer,Double>getMediaTopNScoresDeGeneroPorAnyo(String g, Integer n){
		Comparator<ProduccionNetflix>cmp=Comparator.comparing(p->p.getScore());
		Comparator<ProduccionNetflix>cmp1=cmp.reversed();
		
		return producciones.stream()
				.filter(p->p.getGeneros().contains(g))
				.sorted(cmp1)
				.limit(n)
				.collect(Collectors.
						groupingBy(ProduccionNetflix::getAñoProduccion,TreeMap::new,
								Collectors.averagingDouble(e->e.getScore())));
	}
	public SortedMap<Integer, String> getTituloDeTipoMasPopularPorAnyo(Tipo tipo){
		return producciones.stream()
				.filter(p->p.getTipo().equals(tipo))
				.collect(Collectors.groupingBy(ProduccionNetflix::getAñoProduccion,
						()->new TreeMap<>(Comparator.reverseOrder()),
						Collectors.collectingAndThen(Collectors.maxBy
								(Comparator.comparing(ProduccionNetflix::getPopularidad)), 
								m->m.get().getTitulo())));
	}
	public Double getDuracionMediaDeAnyoYTipo(Tipo tipo, Integer año) {
		return producciones.stream()
				.filter(p->p.getAñoProduccion().equals(año)&&p.getTipo().equals(tipo))
				.mapToLong(p->p.getDuracion().toMinutes())
				.average()
				.getAsDouble();
	}
	public List<Integer> getAnyosConScoreMedioSuperiorA(Double umbralScore){
		return producciones.stream()
				.filter(x->x.getScore()>umbralScore)
				.map(ProduccionNetflix::getAñoProduccion)
				.sorted()
				.toList();
				
				
	}
	public Map<Integer, Double> getPorcentajeTemporadasSeriesPorAnyo(){
		Double r= producciones.stream()
				.mapToDouble(ProduccionNetflix::getNumTemporadas).sum();
		return producciones.stream().collect(Collectors.groupingBy(ProduccionNetflix::getAñoProduccion, 
				Collectors.collectingAndThen(Collectors.summingInt(ProduccionNetflix::getNumTemporadas), 
						i->i/r*100)));
				
	}
	}
