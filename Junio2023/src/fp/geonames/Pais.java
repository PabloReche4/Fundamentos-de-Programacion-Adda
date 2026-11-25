package fp.geonames;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Pais {
	private String codigoISO;
	private String nombre;
	private Long poblacion;
	private Double area;
	private String capital;
	private Continente continente;
	private String moneda;
	private List<Idioma> idiomas;
	private Set<String> paisesVecinos;
	
	public Pais(String codigoISO, String nombre, Long poblacion,Double area,String capital, Continente continente, String moneda,List<Idioma> idiomas, Set<String> paisesVecinos) {
		Checkers.check("El valor de la población debe ser mayor o igual a 0.", poblacion>=0);
		Checkers.check("el área debe ser mayor o igual a 0.", area>=0);
		Checkers.check(("Si la población es mayor a 0, entonces el país debe tener una capital y una moneda."),( poblacion>0 && moneda!=null && capital!= null) || (poblacion == 0));
		
		this.area= area;
		this.capital= capital;
		this.codigoISO= codigoISO;
		this.continente= continente;
		this.idiomas= new ArrayList<Idioma>();
		this.moneda= moneda;
		this.nombre= nombre;
		this.poblacion= poblacion;
		this.paisesVecinos= new HashSet<>();
	}
	public Double getDensidadPoblacion() {
		return poblacion/ area;
	}
	public Boolean getAislado() {
		Boolean res = false;
		if (paisesVecinos.isEmpty()) {
			res = true;
		}
		return res;
	}
	public String getCodigoISO() {
		return codigoISO;
	}


	public String getNombre() {
		return nombre;
	}


	public Long getPoblacion() {
		return poblacion;
	}


	public Double getArea() {
		return area;
	}


	public String getCapital() {
		return capital;
	}


	public Continente getContinente() {
		return continente;
	}


	public String getMoneda() {
		return moneda;
	}


	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	


	public Set<String> getPaisesVecinos() {
		return paisesVecinos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoISO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codigoISO, other.codigoISO);
	}

	@Override
	public String toString() {
		return "Pais [codigoISO=" + codigoISO + ", nombre=" + nombre + ", poblacion=" + poblacion + ", area=" + area
				+ ", capital=" + capital + ", continente=" + continente + ", moneda=" + moneda + ", idiomas=" + idiomas
				+ "]";
	}
	public Boolean sonTodosPaises(Set<Pais> paises) {
		Boolean res = false;
		List<String> aux = new ArrayList<>();
		for(Pais p:paises) {
			aux.add(p.getCodigoISO());
		}
		if (paisesVecinos.containsAll(aux)) {
			res = true;
		}
		return res;
	}
	
}