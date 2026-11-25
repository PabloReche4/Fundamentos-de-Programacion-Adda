	package hamburguesas;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Competicion {
private SortedSet<Visita>visitas;

private static final Comparator<Visita>cmp=Comparator.comparing(Visita::getCodigoPostal).thenComparing(Comparator.naturalOrder());

public SortedSet<Visita>getVisitas(){
	SortedSet<Visita> res= new TreeSet<>(cmp);
	res.addAll(visitas);
	return res;
	

}
	public Competicion(Stream<Visita> stream) {
		this.visitas=stream.collect(Collectors.toCollection(()->new TreeSet<>(cmp)));
	}
	@Override
	public String toString() {
		return "Competicion [visitas=" + visitas + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(visitas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Competicion))
			return false;
		Competicion other = (Competicion) obj;
		return Objects.equals(visitas, other.visitas);
	}
	 public SortedSet<String> getEmailsOrdenados (Duration d){
		 Double temperaturaMedia=visitas.stream().collect(Collectors.averagingDouble(Visita::getTemperatura));
		 return visitas.stream().filter(x->x.getTemperatura().compareTo(temperaturaMedia)<0&& x.getTiempoTranscurrido().compareTo(d)<0)
				 .map(Visita::getEmail)
				 .collect(Collectors.toCollection(TreeSet::new));
		 
	 }
	 public  Integer getTotalVisitasComilones() {
		 Double mediaVisitas=visitas.stream().collect(Collectors.averagingInt(Visita::getNumEvaluaciones));
		 return visitas.stream().filter(v->v.getNumEvaluaciones()>mediaVisitas)
				 .collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue));
	 }
	 public String getPeorHamburgueseriaPorCalidadIngredientes() {
		 return mediaCalidadIngredientes().entrySet().stream()
				 .min(Comparator.comparing(Map.Entry::getValue))
				 .map(Map.Entry::getKey)
				 .orElse(null);
		 }
	 private Map<String, Double> mediaCalidadIngredientes() {
		 return visitas.stream()
				 .flatMap(x->x.getEvaluaciones().stream())
				 .collect(Collectors.groupingBy(Evaluacion::hamburgueseria,Collectors.averagingInt(Evaluacion::calidadIngredientes)));
	 }
	 public Map<String, String> getTopComilonPorCPEnDia(LocalDate d){
		 Comparator<Visita>cmp=Comparator.comparing(Visita::getNumEvaluaciones ).thenComparing(Visita::getEntrada);
		 return visitas.stream()
				 .filter(x->x.getEntrada().toLocalDate().equals(d))
				 .collect(Collectors.groupingBy(Visita::getCodigoPostal, Collectors.collectingAndThen(Collectors.maxBy(cmp), o->o.get().getEmail())));
				 
	 }
	 
	 }
