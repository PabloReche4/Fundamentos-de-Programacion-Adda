package jugadores;

import fp.utiles.Checkers;

public record Equipo(String nombre, Integer clasificacion, String estadio) {
	
	public Equipo{
		Checkers.check("R1: La posición en la clasificación debe estar comprendida entre 1 y 20.", 
				clasificacion<=20 && clasificacion>=1);
		Checkers.check("R2: La propiedad estadio debe comenzar por la cadena “Estadio”.", 
				estadio.startsWith("Estadio"));
	}

}
