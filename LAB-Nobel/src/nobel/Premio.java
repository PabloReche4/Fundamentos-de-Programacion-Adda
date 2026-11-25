package nobel;

import java.util.Objects;

import fp.utiles.Checkers;

public record Premio(Integer año, String categoria, String nombre, String apellidos, Genero genero,
		Integer añoNacimiento, Integer edadPremiado) {
	public Premio{
	Checkers.check("El año de nacimiento debe ser menor que el año del premio", año>añoNacimiento());
	}
	public Integer edadPremiado(){
		return año-añoNacimiento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, año, categoria, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(año, other.año)
				&& Objects.equals(categoria, other.categoria) && Objects.equals(nombre, other.nombre);
	}

}
