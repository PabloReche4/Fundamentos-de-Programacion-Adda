package fp.examen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasEncuestas {
private final List <Encuesta> encuestas;
	public EstadisticasEncuestas(Stream<Encuesta>encuestas) {
	this.encuestas=encuestas.collect(Collectors.toList());
	}
	public List<Encuesta> getEncuestas() {
		return new ArrayList<Encuesta>(encuestas);
	}
	@Override
	public String toString() {
		return "EstadisticasEncuestas [encuestas=" + encuestas + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(encuestas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof EstadisticasEncuestas))
			return false;
		EstadisticasEncuestas other = (EstadisticasEncuestas) obj;
		return Objects.equals(encuestas, other.encuestas);
	}
	public Double getMediaNumEncuestadosConsultorayFecha (String consultora, LocalDate fechaMaxima) {
		return encuestas.stream()
				.filter(x->x.getNombre().equals(consultora)&& x.getFechaFin().isBefore(fechaMaxima))
				.mapToInt(Encuesta::getNumEncuestados)
				.average()
				.orElse(0.0);
	}
	public Encuesta getEncuestaMasEncuestadosPorDia(TipoEncuesta tipo) {
		Comparator <Encuesta>c=Comparator.comparing(Encuesta::getRatioEncuestadosDia);
		return encuestas.stream()
				.filter(x->x.getTipo().equals(tipo))
				.max(c)
				.get();
	}
	public List<String> getPartidosMasFrecuentesOrdenados(Integer n){
		Map<String, Long>contarPartidos=
				encuestas.stream().flatMap(e->e.getResultados().stream())
				.collect(Collectors.groupingBy(Resultado::partido, Collectors.counting()));
		Comparator<Map.Entry<String, Long>>c=Map.Entry.comparingByValue();
		return contarPartidos.entrySet().stream()
					.sorted(c.reversed())
					.limit(n)
					.map(Map.Entry::getKey)
					.toList();
	}
	public SortedMap<String, Boolean> getSuperaEncuestadosPorPais(Integer umbral) { 
		 return encuestas.stream() 
		  .collect(Collectors.groupingBy( 
		   Encuesta::getPais,  
		   TreeMap::new,  
		   Collectors.collectingAndThen(Collectors.toList(),  
		    		encuestas -> todasEncuestasSuperanUmbral( encuestas, umbral)))); 
		} 
	private Boolean todasEncuestasSuperanUmbral(List<Encuesta> encuestas, Integer umbral) {
		
		return encuestas.stream()
				.allMatch(e->e.getNumEncuestados()>umbral);
	}
	public Map<String, SortedSet<String>> getPaisesPorPartidoMayorPorcentaje( 
			Double umbralPorcentaje) {
		Map<String, SortedSet<String>>res=new HashMap<>();
			for(Encuesta e:encuestas) {
				for(Resultado r:e.getResultados()) {
					if(r.porcentaje()>umbralPorcentaje) {
						String clave=r.partido();
							if(res.containsKey(clave)) {
								res.get(clave).add(e.getPais());
							}else {
								SortedSet <String>c=new TreeSet<>();
								c.add(e.getPais());
								res.put(clave, c);
							}
					}
				}
			}
			return res;
	}
	
	
}

