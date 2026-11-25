package fp.ciclismo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class EstadisticasCarreraImpl implements EstadisticasCarrera {

	private String nombreCarrera;
	private List<Ganador> ganadores;

	/**
	 * @param nombre Nombre de la carrera
	 */
	public EstadisticasCarreraImpl(String nombre) {
		this.nombreCarrera = nombre;
		this.ganadores = new ArrayList<Ganador>();
	}
	
	public EstadisticasCarreraImpl(String nombre, Collection<Ganador> ganadores) {
		this (nombre);
		this.ganadores = new ArrayList<Ganador>(ganadores);
	}
	
	@Override
	public String getNombreCarrera() {
		return this.nombreCarrera;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadores()
	 */
	public List<Ganador> getGanadores() {
		return new ArrayList<Ganador>(ganadores);
	}


	public boolean equals(Object obj) {
	boolean res = false;
		if (obj!= null && obj instanceof EstadisticasCarrera){
			EstadisticasCarrera est= (EstadisticasCarrera) obj;
			res = getNombreCarrera().equals(est.getNombreCarrera())
					&& this.ganadores.equals(est.getGanadores());
		}
	return res;
	}

	public int hashCode() {
		return getNombreCarrera().hashCode() + 31* this.ganadores.hashCode();
	}
	
	public String toString() {
		return getNombreCarrera()+" - " + this.ganadores;
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadoresConRecorridoInferiorA(java.lang.Integer)
	 */
	public List<String> getGanadoresConRecorridoInferiorA(Integer km) {
		//TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getNumeroGanadores()
	 */
	
	public Long getNumeroGanadores() {
		
		return ganadores.stream()   //stream <ganador>
				    .map(Ganador::nombre)               //stream <string>: map+ Function <Ganador, String>
		            .distinct()
		            .count();
		            
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#hanGanadoTodosAlgunaEtapa()
	 */
	public Boolean hanGanadoTodosAlgunaEtapa(){
		
		return ganadores.stream()
				.allMatch(g->g.numEtapasGanadas()>0); 	
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#hayAlgunGanadorNacionalidad(java.lang.String)
	 */
	public Boolean hayAlgunGanadorNacionalidad(String nacionalidad) {
		return ganadores.stream()
				.anyMatch(g->g.nacionalidad().equals(nacionalidad)); //boolean : anyMath + Predicate <Ganadores>
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getEquiposGanadores()
	 */
	public Set<String> getEquiposGanadores() {
			return ganadores.stream()
					.map(Ganador::equipo)
	                .collect(Collectors.toSet());
			//.collect(Collectors.toCollection(TreeSet:new);
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#buscarGanador(java.lang.String)
	 */
	public Ganador buscaGanador(String nombre) {
		Optional<Ganador> opt=
				ganadores.stream()
				.filter(g->g.nombre().equals(nombre))
				.findFirst();
		return null;
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#buscaGanador(java.lang.Integer)
	 */
	public Ganador buscaGanador(Integer anyo) {
		
		Optional<Ganador> res= ganadores.stream()     //stream <ganador>
		       .filter (g-> g.anyo().equals(anyo))       //filter+predicate<ganadoe>
		       .findAny();
		
		return res.orElse(null);
	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#calcularDistanciaTotal()
	 */
	@Override
	public Integer calculaDistanciaTotal() {
				return ganadores.stream()
				.map(g->g.kmRecorridos())  // o .map(Ganador::kmRecorridos)
				.reduce(0, (a,b)->a+b);
				
	}

	public Integer calculaDistanciaTotal2() {
		return ganadores.stream().mapToInt(Ganador::kmRecorridos).sum();
	}

	@Override
	public Double getMediaEtapasGanadas(String equipo) {
			return ganadores.stream()
					.filter(g->g.equipo().equals(equipo))
					.mapToInt(Ganador::numEtapasGanadas)
					.average()
					.orElse(0);
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getDistanciaMenor()
	 */
	public Integer getKmMenorRecorrido() {
		return null;
		//TODO
        
        
	 } 

	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasTour#getGanadorMasRapido()
	 */
	public String getGanadorMasRapido() {
		Comparator <Ganador> c=
				Comparator.comparing((Ganador g)->g.getVelocidadMedia());
		return ganadores.stream()
				.max(c)
				.map(Ganador::nombre)
				.orElse(null);
	}

	public Map<String, List<Ganador>> getGanadoresPorNacionalidad() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(
						Ganador::nacionalidad)) ; //Funcion para las claves Funtion<Ganador, String>
	}

	public Map<String, Set<Ganador>> getGanadoresPorNacionalidad_ejemplo2() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(
						Ganador::nacionalidad,
						Collectors.toSet())) ;
	}
	
	public Map<String, SortedSet<Ganador>> getGanadoresPorNacionalidad_ejemplo3() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(
						Ganador::nacionalidad,
						Collectors.toCollection(TreeSet::new))) ;
	}
	
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#cuentaGanadoresPorNacionalidad()
	 */
	public Map<String, Long> cuentaGanadoresPorNacionalidad() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(
						Ganador::nacionalidad,
						Collectors.counting())) ;

	}

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#getTotalEtapasGanadasPorEquipo()
	 */
	public Map<String, Integer> getTotalEtapasGanadasPorEquipo(){
				return ganadores.stream()
						.collect(Collectors.groupingBy(Ganador::equipo,
								Collectors.summingInt(Ganador::numEtapasGanadas)));
	}

	public Map<String, Double> getMediaEtapasGanadasPorEquipo(){
		return ganadores.stream()
				.collect(Collectors.groupingBy(Ganador::equipo,
						Collectors.averagingInt(Ganador::numEtapasGanadas)));  
	}
	
	@Override
	public Map<String, Integer> cuentaCarrerasGanadasPorCiclista() {
		return ganadores.stream()
				.collect(Collectors.groupingBy(
						Ganador :: nombre,
						Collectors.collectingAndThen(
								Collectors.counting(),
								Long :: intValue)));
	}
	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#guardaGanadoresNacionalidadConAnyos(java.lang.String, java.lang.String)
	 */
	public void guardaGanadoresNacionalidadConAnyos(String nombreFichero, String nacionalidad) {
		Map<String, List<Integer>> m = 
				ganadores.stream() // stream de ganadores
				.filter(v->v.nacionalidad().equals(nacionalidad)) // Stream <Ganador> nacionalidad dada por parametro
				.collect(Collectors.groupingBy(
						Ganador:: nombre, //funcion para las claves
						Collectors.mapping(
								Ganador :: anyo,//Function<Ganador, Integer>  funcion que transforma el elem antes de recolectarlo
								Collectors.toList())));//como recolecto los valores							//recolector para los valores
	
	Ficheros.escribeFichero(
			"No se puede escribir el fichero", // mensaje de error
			m, // map que voy a escribir en el fichero
			nombreFichero); // nombre del fichero de texto a generar
	}

	public Map<String, Ganador> ganadorMasDiasMaillotPorNacionalidad() {
		//TODO
		return null;
	}
	
	

	
	

	/* (non-Javadoc)
	 * @see fp.ciclismo.EstadisticasCarrera#guardaGanadoresDeAnyosOrdenados(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public void guardaGanadoresDeAnyosOrdenados(String nombreFichero, Integer anyoInicial, Integer anyoFinal) {
		//TODO
	}

	@Override
	public String getNacionalidadMasGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Ganador>> getMasDiasMaillotPorNacionalidad(Integer n) {
		// Paso 1: obtener un map en el que ñas claves sean las nacionalidades
		//y los valores la lista de ganadores de esa nacionalidad
		Map <String, List<Ganador>> m=
				ganadores.stream()
				.collect(Collectors.groupingBy(Ganador::nacionalidad));
		//Paso 2: a partir del map amterior generar uno nuevo con las mismas claves
		//y como valores las listas ordenadas y recortadas
		return m.entrySet().stream()  //Stream<Entry<String, List<Ganador>>>
				.collect(Collectors.toMap(//No hay claves duplicadas
						e->e.getKey(), //Map.Entry::getKey
						e->ganadoresMasDias(e.getValue(), n)));
	}
	private List<Ganador> ganadoresMasDias(List<Ganador>listaGan, Integer n){
		Comparator<Ganador> c = Comparator.comparing(Ganador :: numDiasMaillot).reversed();
		return listaGan.stream()  //stream<Ganador>
				.sorted(c)  //stream <Ganador> ordenador por numero de dias de mayor a menor
				.limit(n)  //Stream <Ganador> (recortado)
				.toList();
	} 

	@Override
	public Map<String, Ganador> ganadorMasDiasMaillotPorEquipo() {
	Comparator<Ganador> c=
			Comparator.comparing(Ganador::numDiasMaillot);
		return ganadores.stream()
				.collect(Collectors.toMap(
						Ganador::equipo, //Funcion para las claves
						ganador->ganador,//Funcion para las valores
						BinaryOperator.maxBy(c)));//Operador binario para ver con que ganador me quedo
	}
	public Map<String, Ganador> ganadorMasDiasMaillotPorEquipo2() {
		Comparator<Ganador> c=
				Comparator.comparing(Ganador::numDiasMaillot);
		return ganadores.stream()
				.collect(Collectors.groupingBy( //Funcion claves
						Ganador::equipo,
						Collectors.collectingAndThen(
						Collectors.maxBy(c),  //como recolectar los valores
						opt->opt.get())));//o Optional::get //Transformar
				
	}
	
	@Override
	public List<String> getNacionalidadesGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCiclistasTop(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
