package fp.Persona;

import java.time.LocalDate;

import utiles.Checkers;

public record Personas(String nombre, String apellidos, String dni, LocalDate fechaNacimiento)
	implements Comparable <Personas> {
	
	public Personas {
		Checkers.check("el DNI debe estar compuesto por 9 caracteres, los ocho primeros deben ser números, y el último una letra", 
				dni.length()==9 &&
				Character.isDigit(dni.charAt(0)) &&
				Character.isDigit(dni.charAt(1)) &&
				Character.isDigit(dni.charAt(2)) &&
				Character.isDigit(dni.charAt(3)) &&
				Character.isDigit(dni.charAt(4)) &&
				Character.isDigit(dni.charAt(5)) &&
				Character.isDigit(dni.charAt(6)) &&
				Character.isDigit(dni.charAt(7)) &&
				Character.isAlphabetic(dni.charAt(8)));
		Checkers.check("La fecha debe ser anterior a la actual", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.checkNoNull(dni,fechaNacimiento,apellidos,nombre);
	}

	public String edad() {
		return "Tienes " + fechaNacimiento.until(LocalDate.now()).getYears() + " años";
		//Period.between(fechaNacimiento, LocalDate.now()).getYears() otra manera de hacerlo
	}
	//El enunciado pide TODAS las propiedades, hasta los metodos
	public String toString() {
		return "Personas [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", edad()=" + edad() + "]";
	}
	@Override
	public int compareTo(Personas o) {
		return this.dni().compareTo(o.dni());
	}
	
}
