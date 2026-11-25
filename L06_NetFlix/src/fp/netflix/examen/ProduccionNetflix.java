package fp.netflix.examen;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class ProduccionNetflix implements Comparable<ProduccionNetflix>  {
	private String titulo;
	private Tipo tipo;
	private Integer añoProduccion;
	private Duration duracion;
	private Set<String> generos;
	private Integer numTemporadas;
	private EstadisticasIMDB imdb;
	public ProduccionNetflix(String titulo, Tipo tipo, Integer añoProduccion, Duration duracion, Set<String> generos,
			Integer numTemporadas, Double score, Long popularidad) {
		Checkers.check("Año produccion posterior a 1900", añoProduccion>1900);
		Checkers.check("Si el tipo es movie numero de temporadas es 0"+
		"Si el tipo es show numero de temporadas mayoor o igual a 1", 
		tipo==Tipo.MOVIE && numTemporadas==0||tipo==Tipo.SHOW&&numTemporadas>=1);
		this.titulo = titulo;
		this.tipo = tipo;
		this.añoProduccion = añoProduccion;
		this.duracion = duracion;
		this.generos = generos;
		this.numTemporadas = numTemporadas;
		this.imdb = new EstadisticasIMDB(score, popularidad);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Integer getAñoProduccion() {
		return añoProduccion;
	}
	public void setAñoProduccion(Integer añoProduccion) {
		this.añoProduccion = añoProduccion;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	public Set<String> getGeneros() {
		return generos;
	}
	public void setGeneros(Set<String> generos) {
		this.generos = generos;
	}
	public Integer getNumTemporadas() {
		return numTemporadas;
	}
	public void setNumTemporadas(Integer numTemporadas) {
		this.numTemporadas = numTemporadas;
	}
	public Double getScore() {
		return this.imdb.score();
	}
	public Long getPopularidad() {
		return this.imdb.popularidad();
	}
	@Override
	public int hashCode() {
		return Objects.hash(añoProduccion, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduccionNetflix other = (ProduccionNetflix) obj;
		return Objects.equals(añoProduccion, other.añoProduccion) && Objects.equals(titulo, other.titulo);
	}
	public int compareTo (ProduccionNetflix p) {
		int res=this.titulo.compareTo(p.titulo);
				if (res==0) {
					res=this.añoProduccion.compareTo(p.añoProduccion);
				}
				return res;
	}
	@Override
	public String toString() {
		return "ProduccionNetflix [titulo=" + titulo + ", tipo=" + tipo + ", añoProduccion=" + añoProduccion
				+ ", duracion=" + duracion + ", generos=" + generos + ", numTemporadas=" + numTemporadas + ", imdb="
				+ imdb + "]";
	}

	
}
