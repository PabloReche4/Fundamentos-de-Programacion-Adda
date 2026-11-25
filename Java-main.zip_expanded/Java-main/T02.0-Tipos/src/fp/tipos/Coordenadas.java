package fp.tipos;

public record Coordenadas(Double latitud, Double longitud) {
	// NO añado un constructor (a no ser que haga falta)
	//NO añado getters(ya los tiene hecho el record
	// No añado toString (a no ser que sea necesario)
	
	//Otras operaciones
	public Double getDistancia(Coordenadas c) {
		//Objeto 1: this
		//Objeto 2 : c
		Double difLat = c.latitud() - latitud();
		Double difLon = c.longitud() - longitud();
		return Math.sqrt(Math.pow(difLat, 2) + 
						 Math.pow(difLon, 2));
		
	}
	
	public Double getDistanciaHaversine(Coordenadas c) {
		//TODO Implementar como tarea en casa
		return null;
	}
}
