package fp.examen;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Encuesta implements Comparable<Encuesta>{
private String nombre;
private LocalDate fechaComienzo;
private LocalDate fechaFin;
private Integer numEncuestados;
private String pais;
private TipoEncuesta tipo;
private Double porcentajeIndecisos;
private List<Resultado>resultados;
public Encuesta(String nombre, LocalDate fechaComienzo, LocalDate fechaFin, Integer numEncuestados, String pais,
		TipoEncuesta tipo, Double porcentajeIndecisos, List<Resultado> resultados) {
	Checkers.check("Fecha fin no puede ser anterior a la fecha de comienzo", fechaComienzo.isBefore(fechaFin));
	Checkers.check("la lista de resultados no puede estar vacia", !resultados.isEmpty());
	Checkers.check("El numero de encuestados debe ser mayor que 0", numEncuestados>0);
	
	
	this.nombre = nombre;
	this.fechaComienzo = fechaComienzo;
	this.fechaFin = fechaFin;
	this.numEncuestados = numEncuestados;
	this.pais = pais;
	this.tipo = tipo;
	this.porcentajeIndecisos = porcentajeIndecisos;
	this.resultados = resultados;
}

 
public String getNombre() {
	return nombre;
}

public LocalDate getFechaComienzo() {
	return fechaComienzo;
}

 
public LocalDate getFechaFin() {
	return fechaFin;
} 

public void setNumEncuestados(Integer numEncuestados) {
	Checkers.check("El numero de encuestados debe ser mayor que 0", numEncuestados>=0);
	this.numEncuestados = numEncuestados;
}

 
public Integer getNumEncuestados() {
	return numEncuestados;
}

public String getPais() {
	return pais;
}

public TipoEncuesta getTipo() {
	return tipo;
}

public Double getPorcentajeIndecisos() {
	return porcentajeIndecisos;
}

public List<Resultado> getResultados() {
	return new ArrayList <Resultado>(resultados);
}
public Double getRatioEncuestadosDia() {
	return numEncuestados*1.0/(Period.between(fechaFin, fechaComienzo).getDays());
	// También se puede usar en lugar de Period.betweem 
	// fechaComienzo.until(fechaFin).getDays(
}


@Override
public String toString() {
	return "Encuesta [nombre=" + nombre + ", fechaComienzo=" + fechaComienzo + ", fechaFin=" + fechaFin
			+ ", numEncuestados=" + numEncuestados + ", pais=" + pais + ", tipo=" + tipo + ", porcentajeIndecisos="
			+ porcentajeIndecisos + ", resultados=" + resultados + "]";
}


@Override
public int hashCode() {
	return Objects.hash(fechaComienzo, fechaFin, nombre, numEncuestados);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof Encuesta))
		return false;
	Encuesta other = (Encuesta) obj;
	return Objects.equals(fechaComienzo, other.fechaComienzo) && Objects.equals(fechaFin, other.fechaFin)
			&& Objects.equals(nombre, other.nombre) && Objects.equals(numEncuestados, other.numEncuestados);
}
public int compareTo(Encuesta e) {
	int res=getFechaComienzo().compareTo(e.getFechaComienzo());
		if(res==0) {
			 res=getFechaFin().compareTo(e.getFechaFin());
			 	if(res==0) {
			 		res=getNombre().compareTo(e.getNombre());
			 			if (res==0) {
			 				res=getNumEncuestados().compareTo(e.getNumEncuestados());
			 			}
			 	}
		}
		return res;
}


}
