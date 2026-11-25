package jugadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Jugador implements Comparable<Jugador>{
	
	String nombre;
	LocalDate fechaNacimiento;
	
	public Integer getEdad() {
		return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
	}
	
	Posicion posicion;
	Integer goles;
	Integer asistencias;
	Equipo equipo;
	List<String> lesiones;
	
	public Boolean esCampeon() {
		return this.equipo.clasificacion()==1;
	}
	
	public Boolean mismaLesionConsecutiva(){
		boolean res = false;
		for (int i = 0; i<this.lesiones.size() ;i++) {
				if(lesiones.get(i).equals(this.lesiones.get(i+1))) {
					res = true;
					break;
				}
		}
		return res;
	}

	public Jugador(String nombre, LocalDate fechaNacimiento, Posicion posicion, Integer goles,
			Integer asistencias, List<String> lesiones, Equipo equipo) {
		
		Checkers.check("R1: La fecha de nacimiento no puede ser anterior al 1970-01-01", fechaNacimiento.isAfter(LocalDate.of(1970, 1, 1)));
		Checkers.check("R2: Los goles y asistencias deben ser números mayores o iguales a 0", goles>=0 && asistencias>=0);
		
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.posicion = posicion;
		this.goles = goles;
		this.asistencias = asistencias;
		this.equipo = equipo;
		this.lesiones = new ArrayList<>(lesiones);
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public Integer getGoles() {
		return goles;
	}

	public Integer getAsistencias() {
		return asistencias;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public List<String> getLesiones() {
		return lesiones;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", posicion="
				+ posicion + ", goles=" + goles + ", asistencias=" + asistencias + ", equipo=" + equipo + ", lesiones="
				+ lesiones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Jugador o) {
		int res = getFechaNacimiento().compareTo(o.getFechaNacimiento());
		if (res == 0) {
			res = getNombre().compareTo(o.getNombre());
		}
		return res;
	}
	
	
	
	

}
