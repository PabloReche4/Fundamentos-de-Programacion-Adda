package fp.vinos;
import fp.útiles.*;
import java.util.ArrayList;
import java.util.List;



public class FactoríaVinos {
	
	public static Vinos leerVinos(String ruta) {
		List<Vino> vinos=new ArrayList<Vino>();
		try {
			List<String> líneas=Ficheros.leeFichero("Error apertura "+ruta, ruta);
			for (String línea:líneas.subList(1,líneas.size()-1)) {
				vinos.add(parsearVino(línea));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Vinos(vinos.stream());
	}
	
	private static Vino parsearVino(String s) {
		Checkers.checkNoNull(s);
		String [] trozos= s.split(",");
		fp.útiles.Checkers.check("No tienen todos los argumentos", trozos.length==5);
		String pais=trozos[0].trim();
		String region=trozos[1].trim();
		Integer puntos= Integer.valueOf(trozos[2].trim());
		Double precio= Double.valueOf(trozos[3].trim());
		String uva=trozos[4].trim();
		return new Vino(pais, region, puntos, precio, uva);
		
		
	}
}
