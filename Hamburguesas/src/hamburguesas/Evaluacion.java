package hamburguesas;

import fp.utiles.Checkers;

public record Evaluacion(String  hamburgueseria, Integer presentacion, Integer puntoCarne,  Integer calidadPan, Integer calidadIngredientes) {
	public Evaluacion{
		Checkers.check("El valor de valoración de la presentación debe estar comprendido entre 0 y 10", presentacion>=0 && presentacion<=10);
		Checkers.check("El valor de valoración del punto de la carne debe estar comprendido entre 0 y 10.", puntoCarne>=0 && puntoCarne<=10);
		Checkers.check("El valor de valoración de la calidad de los ingredientes debe estar comprendido entre 0 y 10.", calidadIngredientes>=0&&calidadIngredientes<=10);
		Checkers.check("El valor de valoración de la calidad del pan debe estar comprendido entre 0 y 10.", calidadPan>=0&&calidadPan<=10);
		
	}
	public Double puntuacionFinal() {
		Double res=(presentacion()+puntoCarne()+calidadPan()+calidadIngredientes())/4.0;
		return res;
		
	}

}
