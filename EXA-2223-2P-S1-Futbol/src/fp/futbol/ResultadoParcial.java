package fp.futbol;

import fp.utiles.Checkers;

public record ResultadoParcial(Integer minuto, Integer golesLocal, Integer golesVisitante) {
public ResultadoParcial {
		Checkers.check("Minutos mayor que 0", minuto>=0);
		Checkers.check("Goles locales", golesLocal>=0);
		Checkers.check("Goles visitantes", golesVisitante>=0);
	}

}
