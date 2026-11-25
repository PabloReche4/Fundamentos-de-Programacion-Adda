package fp.examen;

import fp.utiles.Checkers;

public record Resultado(String partido, Double porcentaje) {
	public Resultado{
		Checkers.check("El porcentaje no puede ser negativo", porcentaje>=0);
	}

	@Override
	public String toString() {
		return "Resultado [partido=" + partido + ", porcentaje=" + porcentaje + "]";
	}
	
}
