package fp.buses;

import fp.utiles.Checkers;

public record Etapa(String parada, Integer minutos) {
	public Etapa{
		Checkers.check("Minuto mayor que 0", minutos>=0);
	}

}
