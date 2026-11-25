package fp.vinos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.útiles.Checkers;

public class Vinos{
	private Set<Vino> vinos;
	
	public Vinos() {
		this.vinos =  new HashSet<Vino>();
	}
	
	public Vinos(Stream<Vino> svinos) {
		this.vinos=svinos.collect(Collectors.toSet());
	}

	public  void agregarVino(Vino v) {
		if(v!=null) {
		 this.vinos.add(v);
		}
	}
	
	public void eliminarVino(Vino v) {
//		Checkers.check("no existe el vino", this.vinos.contains(v));  OTRA MANERA DE HACERLO
//		this.vinos.remove(v);
		if(vinos.contains(v)) {
			this.vinos.remove(v);
		}else {
			throw new IllegalArgumentException("No existe");
		}
	}
	
	public int obtenerNumeroVinos() {
		return this.vinos.size();
	}

	public boolean contieneVino(Vino v) {
		return this.vinos.contains(v);
	}
	
	public void agregarVinos(Collection<Vino>cv) {
		for(Vino v:cv) {
			agregarVino(v);
		}
	}
	
	public boolean contieneVinos(Set<Vino>v) {
		return this.vinos.containsAll(v);
	}
	
//	public int calcularNumeroVinosDePais(String pais) {
//		int res = 0;
//		for(Vino v:this.vinos) {
//			if(v.pais().toUpperCase().equals(pais.toUpperCase())) {
//				res++;
//			}
//		}
//		return res;
//	}
//	
//	public Collection<Vino> obtenerVinosRangoPuntos(double inf, double sup){
//		List<Vino> res = new ArrayList<Vino>();
//		for(Vino v: this.vinos) {
//			if (inf<=v.puntos() && v.puntos()<=sup) {
//				res.add(v);
//			}
//		}
//		return res;
//	}
//	
//	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer puntuacion) {
//		int res = 0;
//		for(Vino v:this.vinos) {
//			if(v.pais().toUpperCase().equals(pais.toUpperCase()) && v.puntos()>puntuacion) {
//					res++;
//				}
//		}
//		return res;
//	}
//	
//	public boolean existeVinoDeUvaEnRegion(String uva, String region) {
//		boolean res = false;
//		for(Vino v:this.vinos) {
//			if(v.region().toUpperCase().equals(region.toUpperCase()) && v.uva().toUpperCase().equals(uva.toUpperCase()) ) {
//				res = true;
//				break;
//			}
//		}
//		return res;
//	}
//	
//	public Set<String> calcularUvasDeRegion(String region){
//		Set<String> res = new HashSet<>();
//		for(Vino v:this.vinos) {
//			if(v.region().toUpperCase().equals(region.toUpperCase())) {
//				res.add(v.uva());
//			}
//		}
//		return res;
//	}
//	
//	public int calcularTotalPuntosVinosDeRegion(String region) {
//		int res = 0;
//		for(Vino v:this.vinos) {
//			if(v.region().toUpperCase().equals(region.toUpperCase())) {
//				res+=v.puntos();
//			}
//		}
//		return res;
//	}
//	
//	public Double calcularMediaPuntosVinosDeUva(String uva) {
//		double res = 0;
//		int contador = 0;
//		for(Vino v:this.vinos) {
//			if(v.uva().toUpperCase().equals(uva.toUpperCase())) {
//				res+=v.puntos();
//				contador++;
//				}
//			}
//		if(contador>0) {
//			res = res/contador;
//		}
//		return res;
//	}
//	
//	public Vino obtenerVinoMejorPuntuado() {
//		return this.vinos.stream().max(Comparator.comparing(Vino :: puntos)).orElseThrow();
////		Vino res = new Vino(null, null, 0, null, null);
////		if (this.vinos.isEmpty()) {
////            throw new IllegalArgumentException("No hay vinos en la lista");
////		}
////		for (Vino v : vinos) {
////			
////			if(v.puntos()>res.puntos() ) {
////				res = v;
////			}
////			else {
////				
////			}
////		}
////		return res;
//	}
//	
//	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
//		return this.vinos.stream().filter(v->v.pais().equals(pais)).max(Comparator.comparing(Vino :: puntos)).orElseThrow();
//	}
//	
//	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer N){
//		List<Vino> res = new ArrayList<>();
//		int cont = 0;
//		for(Vino v : vinos) {
//			if(cont>N && v.region().toUpperCase().equals(region)){
//				res.add(v);
//				cont ++;
//			}else {
//				break;
//			}
//		}
//		return res;
//		return this.vinos.stream().filter(v->v.region().equals(region)).max(Comparator.comparing(Vino :: precio)).orElseThrow();
//	}
	
	public Integer calcularNumeroVinosDePais(String pais) {
		Long res = vinos.stream()
				.filter(vino->vino.pais().equals(pais))
				.count();
		return res.intValue();
	}
	
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer puntuacion) {
		Long res = vinos.stream()
				.filter(v->v.pais().equals(pais) && v.puntos()>puntuacion)
				.count();
		return res.intValue();
	}
	
	public Set<Vino>obtenerVinosBaratos(Double pr) {
		return vinos.stream()
				.filter(v->v.precio()<pr)
				.collect(Collectors.toSet());
	}
	
	public Boolean existeVinoDeUvaEnRegion(String uva, String region) {
		return vinos.stream()
				.anyMatch(v->v.region().equals(region) && v.uva().equals(uva));
	}
	
	public Set<String> calcularUvasDeRegion(String region){
		return vinos.stream()
				.filter(v->v.region().equals(region))
				.map(Vino :: uva)
				.collect(Collectors.toSet());
	}
	
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		return vinos.stream()
				.filter(v->v.region().equals(region))
				.mapToInt(Vino :: puntos)
				.sum();
	}
	
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		return vinos.stream()
				.filter(v->v.uva().equals(uva))
				.mapToDouble(Vino :: puntos)
				.average()
				.orElse(0);
	}
	
	public Vino obtenerVinoMejorPuntuado() {
		return vinos.stream()
				.max(Comparator.comparingDouble(v->v.puntos()))
				.get();
	}
	
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		return vinos.stream()
				.filter(v->v.pais().equals(pais))
				.max(Comparator.comparingDouble(Vino :: puntos))
				.orElseThrow(NoSuchElementException :: new);
		
	}
	
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer n) {
		return vinos.stream()
				.filter(v->v.region().equals(region))
				.sorted(Comparator.comparingDouble(Vino::precio).reversed())
				.limit(n)
				.collect(Collectors.toList());
		
	}
	public Map<String,List<Vino>> agruparVinosPorPais(){
		 return vinos.stream()
				 .collect(Collectors.groupingBy(Vino::pais)) ;
		 
	}
	public Map<String,List<String>> agruparUvasPorPais(){
		 return vinos.stream()
				 .collect(Collectors.groupingBy(Vino::pais, Collectors.mapping(Vino::uva, Collectors.toList())));
	}
	public Map <String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double valor){
		return vinos.stream()
				.filter(v->v.calidadPrecio()>valor)
				.collect(Collectors.groupingBy(Vino::region, Collectors.collectingAndThen(Collectors.counting(), c->c.intValue())));	
	}
	public Map <String, Long> calcularCalidadPrecioPorRegionMayorDe2(Double valor){
		return vinos.stream()
				.filter(v->v.calidadPrecio()>valor)
				.collect(Collectors.groupingBy(Vino::region, Collectors.counting()));
		
	}
	
	@Override
	public String toString() {
		return "Vinos [vinos=" + vinos.size() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(vinos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinos other = (Vinos) obj;
		return Objects.equals(vinos, other.vinos);
	}

	
}
