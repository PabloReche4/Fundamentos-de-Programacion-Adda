package fp.Beca;

import java.util.Comparator;
import java.util.Objects;

import utiles.Checkers;

public class Beca implements Comparable<Beca>{
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;
	
	public final static Double CUANTIA_MINIMA = 1500.00;

	public Double cuantiaMensual() {
		Double res = null;
		if (duracion != 0 && cuantiaTotal!=0) {
			res = cuantiaTotal/duracion;
		}
		return res;			
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public String getCodigo() {
		return codigo;
	}
	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}
	public TipoBeca getTipo() {
		return tipo;
	}

	public Beca(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		Checkers.check("el codigo esta formado por tres letras y cuatro digitos", 
				codigo.length()==7 &&
				//codigo.matches("[a-zA-Z]{3})") &&
				Character.isAlphabetic(codigo.charAt(0)) &&
				Character.isAlphabetic(codigo.charAt(1)) &&
				Character.isAlphabetic(codigo.charAt(2)) &&
				Character.isDigit(codigo.charAt(3)) &&
				Character.isDigit(codigo.charAt(4)) &&
				Character.isDigit(codigo.charAt(5)) &&
				Character.isDigit(codigo.charAt(6)));
		Checkers.check("el valor de la cuantía total debe ser mayor o igual que la cuantía mínima (1500 euros).", 
				cuantiaTotal>=CUANTIA_MINIMA);
		Checkers.check("el valor de la duración debe ser mayor o igual que la duración mínima (1 mes).",
				duracion>=1);
		this.codigo = codigo;
		this.cuantiaTotal = cuantiaTotal;
		this.duracion = duracion;
		this.tipo = tipo;
	}
	
	public Beca(String codigo, TipoBeca tipo) {
		this(codigo,CUANTIA_MINIMA,1,tipo);
//		this.codigo = codigo;
//		this.cuantiaTotal = 1500.0;
//		this.duracion = 1;
//		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Beca [codigo=" + codigo + ", cuantiaTotal=" + cuantiaTotal + ", duracion=" + duracion + ", tipo=" + tipo
				+ ", cuantiaMensual()=" + cuantiaMensual() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beca other = (Beca) obj;
		return Objects.equals(codigo, other.codigo);
	}
	@Override
	public int compareTo(Beca o) {
		int res = this.getCodigo().compareTo(o.getCodigo());
		return res;
	}

}
