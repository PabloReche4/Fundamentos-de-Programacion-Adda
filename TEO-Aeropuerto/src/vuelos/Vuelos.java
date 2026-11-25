package vuelos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
//BLOQUE 1
public class Vuelos {
	private String nombre;
	private List<Vuelo> vuelos;
	
	public Vuelos(String nombre, List<Vuelo> vuelos) {
		this.nombre= nombre;
		this.vuelos= vuelos;
		
	}
	public Integer numVuelos() {
		return vuelos.size();
	}
	
	public Integer numPasajeros() {
		return vuelos.stream()
				.mapToInt(Vuelo::getNumPasajeros)
				.sum();
	}
	public Double precioMedio() {
		return vuelos.stream()
				.mapToDouble(Vuelo::getPrecio)
				.average()
				.orElse(0.0);
	}
	public Integer numDestinos() {
		return (int) vuelos.stream()
				.map(Vuelo::destino)
				.distinct()
				.count();
		
	}
	public int hashCode() {
		return Objects.hash(nombre, vuelos);
		
	}
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Vuelos other= (Vuelos)obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(vuelos, other.vuelos);
	
	}
	public Integer getNumPasajerosDestino(String destino) {
		return vuelos.stream()
				.filter(v->v.destino().equals(destino))
				.mapToInt(Vuelo::getNumPasajeros)
				.sum();
		
	}
	public void incorporaVuelo(Vuelo v) {
		vuelos.add(v);
	}
	public void incorporaVuelos(Collection<Vuelo> vuelos) {
		vuelos.addAll(vuelos);
	}
	public void eliminaVuelo(Vuelo v) {
		vuelos.remove(v);
	}
	public void ordena() {
		vuelos.sort(Comparator.naturalOrder());
	}
	public Boolean existeVueloDestino(String destino) {
		return vuelos.stream()
				.anyMatch(v->v.destino().equals(destino));
	}
	public String toString() {
		return vuelos.stream()
				.map(Vuelo::toString)
				.collect(Collectors.joining("\n"));
	}
	//BLOQUE 4
	public Boolean existeVueloConDestino(String d) {
		return vuelos.stream()
				.anyMatch(v->v.destino().equals(d));
			
	}
	public Boolean  vuelosConMinPasajeros(Integer n) {
		return vuelos.stream()
				.allMatch(v->v.getNumPasajeros()>=n);
	}
	public Long vuelosAlDia(LocalDate fecha) {
		return vuelos.stream()
				.filter(v->v.getFecha().equals(fecha))
				.count();
	}
	public List<Vuelo> vuelosDespuesFecha(LocalDate fecha){
		return vuelos.stream()
				.filter(v->v.getFecha().isAfter(fecha))
				.collect(Collectors.toList());
		
	}
	public Set<String> destinosAntesFecha(LocalDate fecha){
		return vuelos.stream()
				.filter(v->v.getFecha().equals(fecha))
				.map(Vuelo::destino)
				.collect(Collectors.toSet());
	}
	public Integer pasajerosDestinos(Set<String> destinos) {
		return vuelos.stream()
				.filter(v->destinos.contains(v.destino()))
				.mapToInt(Vuelo::getNumPasajeros)
				.sum();
	}
	public Double precioMedioPorMes(Integer mes) {
		return vuelos.stream()
				.filter(v->v.getFecha().getMonthValue()==mes)
				.mapToDouble(Vuelo::getPrecio)
				.average()
				.orElse(0);
	}
	public Double recaudacionAño(Integer año) {
		return vuelos.stream()
				.filter(v->v.getFecha().getYear()==año)
				.mapToDouble(v->v.getNumPasajeros()*v.getPrecio())
				.sum();
	}
	public Vuelo maxOcupacion() {
		return vuelos.stream()
				.max(Comparator.comparingInt(Vuelo::getNumPasajeros))
				.orElse(null);
	}
	public String codigoMenorPrecioDestino(String destino) {
		return vuelos.stream()
				.filter(v->v.destino().equals(destino))
				.min(Comparator.comparing(Vuelo::getPrecio))
				.orElse(null)
				.getCodigo();
	}
	public List<Vuelo> nVuelosBaratos(Integer n) {
		return vuelos.stream()
				.sorted(Comparator.comparing(Vuelo::getPrecio))
				.limit(n)
				.collect(Collectors.toList());
	}
	public List<Vuelo> nVuelosMayorDuracion(Integer n){
		return vuelos.stream()
				.sorted(Comparator.comparing(Vuelo::getDuracion))
				.limit(n)
				.collect(Collectors.toList());
	}
//	Bloque 5
	public Integer destinosDiferentes(LocalDate f){
		Long res=vuelos.stream()
				.filter(x->x.getFecha().equals(f))
				.map(Vuelo::destino)
				.count();
	   return res.intValue();
			
	}
	public Set<Vuelo>vuelosOrdenados(){
		return vuelos.stream()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toCollection(TreeSet::new));
	}
	public Set<Vuelo>vuelosOrdenadosLetra(Character l) {
		return vuelos.stream()
				.filter(x->x.destino().toLowerCase().startsWith(String.valueOf(l)))
			    .sorted()
			    .collect(Collectors.toCollection(TreeSet::new));
	}
	public SortedSet<String>vuelosOrdenadosLongitud() {
		return vuelos.stream()
				.map(Vuelo::destino)
				.collect(Collectors.toCollection(()-> new TreeSet<>(Comparator.comparing((String v)->v.length()))));

	}
	public Map<LocalDate,List<Vuelo>>vuelosPorFecha(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha));
	}
	public Map<LocalDate,Set<Vuelo>>vuelosPorFecha2(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha, Collectors.toSet()));
	}
	public Map<LocalDate, Long>nVuelosFecha(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha, Collectors.counting()));
	}
	public Map<String, Integer>nPlazasDestinos(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino, 
						Collectors.summingInt(Vuelo::getNumPlazas)));
	}
	public Map<String, Double>precioMedioDestino(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino, 
						Collectors.averagingDouble(Vuelo::getPrecio)));
				
	}
	public Map<String, Set<LocalDate>>fechaVuelos(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino, 
						Collectors.mapping(Vuelo::getFecha, Collectors.toSet())));
	}
//	Bloque 6
	public  Map<String, Optional<Vuelo>>vueloMasBaratoPorDestino(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino, 
						Collectors.minBy(Comparator.comparingDouble(Vuelo::getPrecio))));
	}
	public Map<String, Vuelo> vueloMasBaratoPorDestino2(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino,
						Collectors.collectingAndThen(
								Collectors.minBy(Comparator.comparingDouble(Vuelo::getPrecio)), Optional::get)));
								
	}
	public Map<String, String> codigoVueloMasBarato(){
		return vuelos.stream()
                .collect(Collectors.groupingBy(
                        Vuelo::destino,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingDouble(Vuelo::getPrecio)),
                                optional->optional.orElseThrow(
                                		()->new IllegalArgumentException()
                                		).getCodigo())));
	}
	public String destinoMasVuelos() {
		Map<String, Long>mpaux= getNumVuelosPorDestino();
		return mpaux.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
	}
	private Map<String, Long> getNumVuelosPorDestino() {
		
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino,  //agrupa por destino y cuenta numero de vuelos
						Collectors.counting()));
	}
	public String segundoDestinoMasVuelos() {
		Map<String, Long>mpaux=getNumVuelosPorDestino();
		return mpaux.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.skip(1)
				.findFirst()
				.map(Map.Entry::getKey)
				.get();
	}
	public Map<String, Integer> nPlazasDestino(){
		return vuelos.stream()
				.collect(Collectors.toMap(Vuelo::destino, Vuelo::getNumPasajeros));
	}
	public Map<String, Double>porcentajePlazas(){
		int totalplazas=vuelos.stream().mapToInt(Vuelo::getNumPlazas).sum();
		Map <String, Double>plazasPorDestino=vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino, 
						Collectors.summingDouble(Vuelo::getNumPlazas)));
		return plazasPorDestino.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue()*100/totalplazas));
		
	}
	public Map<String, Vuelo>vuelosMasBarato(){//utilazando collectors tomap, utilazando groupingBy se utiliza minBy
		return vuelos.stream()
				.collect(Collectors.toMap(Vuelo::destino, vuelo->vuelo,(v1,v2)->v1.getPrecio()<v2.getPrecio()?v1:v2));
		
	}
	public SortedMap<String, Long>pasajerosPorDestinoEnFecha(Integer fecha){
		return vuelos.stream()
				.filter(v->v.getFecha().getYear()==fecha)
				.collect(Collectors.groupingBy(
						Vuelo::destino,
						TreeMap::new,Collectors.summingLong(Vuelo::getNumPasajeros)));
	}
	public Map<LocalDate, Object>destinosMasDuracion(Integer n){
		Comparator <Vuelo>cmp=Comparator.comparingInt(v->v.getDuracion().toMinutesPart());
		return vuelos.stream()
				.collect(Collectors.groupingBy(
						Vuelo::getFecha, Collectors.collectingAndThen(
								Collectors.toList(), 
								v->v.stream()
								.sorted(cmp.reversed())
								.distinct()
								.limit(n)
								.toList())));
	}
	public Map<LocalDate, List<Vuelo>>vuelosOrdenadosPrecio(){
		Comparator <Vuelo>cmp=Comparator.comparingDouble(v->v.getPrecio());
		Comparator<Vuelo>cmp1=cmp.reversed();
		return vuelos.stream()
				.collect(Collectors.groupingBy(
						Vuelo :: getFecha,
						Collectors.collectingAndThen(
								Collectors.toList(),
								v->v.stream()
								.sorted(cmp1)
								.toList())));
	
	}
	public Map<LocalDate, List<Vuelo>>vuelosOrdenadosPrecio2(){
		Comparator<Vuelo> cmp = Comparator.comparingDouble(v->v.getPrecio());
		Comparator<Vuelo> cmp1 = cmp.reversed();
		Map<LocalDate, List<Vuelo>> aux = vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo :: getFecha));
		return aux.entrySet().stream()
		.collect(Collectors.toMap(
				Map.Entry::getKey, 
				entry->entry.getValue().stream()
				.sorted(cmp1)
				.toList()));
	}
	public Set<String>destinosConMasVuelos(Integer n){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::destino,
						Collectors.counting()))
						.entrySet().stream()
						.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
						.limit(n)
						.map(Map.Entry::getKey)
						.collect(Collectors.toSet());
		
	}
//	BLOQUE 7
    
}







