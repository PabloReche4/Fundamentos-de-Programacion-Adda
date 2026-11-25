package fp.sevici;

import java.util.Objects;

public record Estacion(String id, String nombre, Integer numPuestos, Integer bicisDisponibles, Coordenadas ubicacion, 
		Integer puestosVacios, Boolean tieneBicisDisponibles, Double ocupacion) {
public Estacion{
	
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Estacion other = (Estacion) obj;
	return Objects.equals(id, other.id);
}
public int compareTo(Estacion e) {
	int res=this.id.compareTo(e.id);
	return res;
}
}

