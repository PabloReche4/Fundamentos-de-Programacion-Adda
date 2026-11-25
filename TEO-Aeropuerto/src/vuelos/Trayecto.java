package vuelos;

import fp.utiles.Checkers;

public record Trayecto(String origen, String destino) {

	public  Trayecto{
		Checkers.check("El origen del trayecto no puede ser el mismo que el destino",	origen != destino);
	}
}
