package fp.trayecto;
import fp.utiles.*;
public record Etapa(String parada, Integer minutos) {
	public Etapa{
		Checkers.check("minuto incorrecto", minutos>=0);
	}
	
	

}
