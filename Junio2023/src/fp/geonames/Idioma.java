package fp.geonames;

import java.util.Objects;

import fp.utiles.Checkers;

public record Idioma(String nombre, Double porcentaje) {
	
	public Idioma {
		Checkers.check("El valor del porcentaje debe estar comprendido en el intervalo [0.0, 1.0].", porcentaje>0. && porcentaje <1.);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Idioma other = (Idioma) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Idioma [nombre=" + nombre + ", porcentaje=" + porcentaje + "]";
	}
	
}
