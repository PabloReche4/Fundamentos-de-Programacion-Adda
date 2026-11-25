package fp.Canciones;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import utiles.Checkers;

public class ListaReproduccion {
	private String nombre;
	private List<Cancion> canciones;
	
	public Integer numCanciones() {
		return canciones.size();
	}

	public ListaReproduccion(String nombre, List<Cancion> canciones) {
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>();
	}

	public String toString() {
		return "ListaReproduccion [nombre=" + nombre + ", canciones=" + canciones + "]";
	}

	public int hashCode() {
		return Objects.hash(canciones, nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaReproduccion other = (ListaReproduccion) obj;
		return Objects.equals(canciones, other.canciones) && Objects.equals(nombre, other.nombre);
	}
	
	public void aleatoriza() {
		Collections.shuffle(canciones);
	}
	
	public void incorpora(Cancion c) {
		canciones.add(c);
	}
	
	public void incorpora (Album a) {
		canciones.addAll(a.getCanciones());
	}
	
	public void incorpora(List<Cancion> canciones) {
		this.canciones.addAll(canciones);
	}
	
	public void eliminaPrimera(Cancion c) {
		Checkers.check("La cancion no pertenece a la lista", canciones.contains(c));
		for (Cancion can : canciones) {
			if (can.equals(c))
				canciones.remove(can);
			break;
			}	
		}
	
	public void eliminaUltima(Cancion c) {
		Checkers.check("La cancion no pertenece a la lista", canciones.contains(c));
		List<Cancion> cancionesInv = new ArrayList<>(canciones);
		Collections.reverse(cancionesInv);
		for (Cancion can : cancionesInv) {
			if (can.equals(c))
				canciones.remove(can);
			break;
		}
	}
	
	public void eliminaTrozo(int primeraPosicion, int ultimaPosicion) {
		Checkers.check("Primera Posicion sea mayor o igual que cero", primeraPosicion>=0);
		Checkers.check("Ultima Posicion sea menor que el número de canciones en la lista", ultimaPosicion<canciones.size());
		Checkers.check("primeraPosicion sea menor o igual que ultimaPosicion", ultimaPosicion>=primeraPosicion);
		for (Cancion c : canciones) {
			if(canciones.indexOf(primeraPosicion)<=canciones.indexOf(c) && canciones.indexOf(ultimaPosicion)>= canciones.indexOf(c)) {
				canciones.remove(c);
			}
		}
	}
	
	public Integer getNumeroCancionesComienzanPorCadena(String cadena) {
		int res = 0;
		for(Cancion c : canciones) {
			if(c.getTitulo().substring(0, cadena.length()).equals(cadena)) {
				res +=1;
			}
		}
		return res;
	}
	
	public Duration getDuracionTotal() {
		Duration res = Duration.ZERO;
		for(Cancion c : canciones) {
			res.plus(c.getDuracion());
		}
		return res;
	}
	
	public Duration getDuracionMedia() {
		return Duration.ofSeconds(canciones.size()/getDuracionTotal().toSeconds());
	}
	
	public List<Cancion> getCancionesGenero(Genero genero){
		return canciones.stream()
				.filter(c->c.getGenero().equals(genero))
				.toList();
	}
	
	public Boolean existeCancionConPalabraEnTitulo(String palabra) {
		return canciones.stream()
				.anyMatch(c->c.getTitulo().contains(palabra));	
	}
	
	public Boolean todasSuperioresA(Integer minutos) {
		return canciones.stream()
				.allMatch(c->c.getDuracion().toMinutes()>minutos);
	}
	
	public Cancion getCancionMayorDuracion() {
		return canciones.stream()
				.max(Comparator.comparing(Cancion :: getDuracion))
				.get();
	}
	
	public Map<Integer, List<Cancion>> agrupaCancionesPorAño(){
		return canciones.stream()
				.collect(Collectors.groupingBy(
						c->c.getFechaLanzamiento().getYear()));
	}
	
	public Map<Integer, List<Cancion>> agrupaCancionesArtistaPorPalabras(String artista){
		Map<Integer,List<Cancion>> res = new HashMap<Integer, List<Cancion>>();
		for(Cancion c : canciones) {
			if(c.getArtista().equals(artista)) {
				Integer key = contarPalabras(c.getTitulo());
				if(res.containsKey(key)) {
					res.get(key).add(c);
				}
				else {
				List<Cancion> aux = new ArrayList<Cancion>();
				aux.add(c);
				res.put(key, aux);
				}
			}
		}
		return res;
	}

	private Integer contarPalabras(String titulo) {
		String[] palabras = titulo.split("\\s+");
		return palabras.length;
	}
	
	public Map<String, Long> getNumeroCancionesPorArtista(){
		Map<String, Long> res = new HashMap<String, Long>();
		for(Cancion c : canciones) {
			String key = c.getArtista();
			res.put(key, res.getOrDefault(key, 0L) +1);	
		}
		return res;
	}
	
	public Map<Genero, Duration> getDuracionCancionesPorGenero(){
		Map<Genero, Duration> res = new HashMap<Genero, Duration>();
		for(Cancion c : canciones) {
			Genero key = c.getGenero();
			Duration duracion = c.getDuracion();
            res.put(key, res.getOrDefault(key, Duration.ZERO).plus(duracion));
		}
		return res;
	}

}
