package fp.vinos;

import fp.útiles.Checkers;

public record Vino(String pais, String region, Integer puntos, Double precio, String uva) {
    public Vino{
    	Checkers.check("El precio debe ser mayor que cero: " +precio, precio>0);
    	Checkers.check("Los puntos entre [0,100]: "+puntos, 0<=puntos && puntos<=100);
    }
	public Double calidadPrecio() {
	return this.puntos/this.precio;
	}
	
}
