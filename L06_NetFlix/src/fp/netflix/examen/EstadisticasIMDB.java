package fp.netflix.examen;

import fp.utiles.Checkers;

public record EstadisticasIMDB(Double score, Long popularidad) {
	public EstadisticasIMDB{
		Checkers.checkNoNull(score, popularidad);
		Checkers.check("Puntuacion entre 0 y 10", score>=0 && score<=10);
		Checkers.check("Popularidad superior a 0", popularidad>=0);
		
	}

	/**
	 * @return the score
	 */
	public Double score() {
		return score;
	}

	/**
	 * @return the popularidad
	 */
	public Long popularidad() {
		return popularidad;
	}
	
	
}
