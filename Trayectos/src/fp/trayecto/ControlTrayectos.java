package fp.trayecto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControlTrayectos {
private List<Trayecto>trayectos;
private Integer numTrayectos;
	public ControlTrayectos(Stream<Trayecto> stream) {
		
	}
	public List<Trayecto> getTrayectos() {
		return new ArrayList<>(trayectos);
	}
	public Integer getNumTrayectos() {
		return numTrayectos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(trayectos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ControlTrayectos))
			return false;
		ControlTrayectos other = (ControlTrayectos) obj;
		return Objects.equals(trayectos, other.trayectos);
	}
	@Override
	public String toString() {
		return "ControlTrayectos [trayectos=" + trayectos + "]";
	}
	public List<String> getParadasEmpresas(Set<Empresa> empresas, Character c){
		return trayectos.stream()
				.filter(x->empresas.contains(x.getEmpresa()))
				.flatMap(x->x.getParadas().stream())
				.filter(x->c.equals(x.charAt(0)))
				.collect(Collectors.toList());
	}
	public SortedSet<Trayecto> getNTrayectosMasPasajeros(Integer n){
		Comparator<Trayecto>cmp=Comparator.comparing(Trayecto::getFechaHora).thenComparing(Comparator.naturalOrder());
		return trayectos.stream()
				.sorted(Comparator.comparing(Trayecto::getUsuarios).reversed())
				.limit(n)
				.collect(Collectors.toCollection(()->new TreeSet<>(cmp)));
	}
	public String getLineaMasPasajeros(Integer mes) {
		Map<String, Integer>res=trayectos.stream()
				.filter(x->mes.equals(x.getFechaHora().getMonthValue()))
				.collect(Collectors.groupingBy(Trayecto::getNombre,Collectors.summingInt(Trayecto::getUsuarios)));
		return res.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.map(Map.Entry::getKey)
				.orElse(null);
	}
	public Map<Empresa, Trayecto> getTrayectoMasTiempoRecorridoPorEmpresa(){
		Comparator<Trayecto>cmp=Comparator.comparing(Trayecto::getTiempoRecorrido);
		return trayectos.stream()
				.collect(Collectors.groupingBy(Trayecto::getEmpresa,Collectors.collectingAndThen(Collectors.maxBy(cmp), Optional::get)));
	}
	public Integer getTotalUsuarios(String parada, LocalTime hora) {
		Integer numUsuarios=0;
		for (Trayecto t:trayectos) {
			LocalTime horaLlegada=null;
			int i=t.getParadas().indexOf(parada);
			if(i==0) {
				horaLlegada=t.getFechaHora().toLocalTime();
				
			}else if(i>0) {
				horaLlegada=t.getHoraLlegadaParada(i-1);
				
			}
			if(horaLlegada!=null && hora.isBefore(horaLlegada)) {
				numUsuarios+=t.getUsuarios();
			}
		}
		return numUsuarios;
	}
	

}
