package fp.lexico;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lexico {
	
	//Atributos
	private SortedSet<String> palabras;
	//C1
	public Lexico() {
		this.palabras= new TreeSet<>();
	}
	//C2
	public Lexico (Collection<String> palabras) {
		//TODO Debo convertir a minusculas
//		this.palabras=new TreeSet<>();
		this();
		agregarPalabras(palabras);
	}
	
	public SortedSet<String> getPalabras() {
		return new TreeSet<>(palabras);
	}
	
	public Integer getTotalPalabras() {
		return palabras.size();
	}
	@Override
	public int hashCode() {
		return Objects.hash(palabras);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lexico other = (Lexico) obj;
		return Objects.equals(palabras, other.palabras);
	}

	public String toString() {
		return "Lexico [palabras=" + palabras + "]";
	}
	
	public void agregarPalabra(String palabra) {
		palabras.add(palabra.toLowerCase());
	}
	
	public void agregarPalabras(Collection<String> palabras) {
		for(String palabra :palabras) {
			agregarPalabra(palabra);
		}
	}
	
	public Set<String> getPalabrasComunes(Lexico c){
		Set<String> inter = new HashSet<>(palabras);
		inter.retainAll(c.getPalabras());
		return inter;
	}

	
}
