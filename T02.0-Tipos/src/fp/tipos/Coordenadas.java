package fp.tipos;

public record Coordenadas(Double latitud, Double longitud) {

		// TODO Auto-generated constructor stub
	
	
		// TODO Auto-generated constructor stub
	
	//No añado un constructor(a no ser que haga falta)
	//No añado getters(ya los tiene hecho el record)
	//No añado toString(a no ser que sea necesario)
	//otras operaciones
	public Double getDistancia(Coordenadas c) {
		
	
	//Objeto 1: this
	//Objeto 2: c
Double diflat=c.latitud()- latitud();
Double diflon = c.longitud()- longitud;
return Math.sqrt(Math.pow(diflat, 2)+ Math.pow(diflon, 2));


}
	public Double getDistanciaHaversvine();
}