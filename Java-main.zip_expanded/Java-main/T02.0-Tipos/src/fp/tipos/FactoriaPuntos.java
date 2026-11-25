package fp.tipos;

import java.util.ArrayList;
import java.util.List;

import utiles.Checkers;
import utiles.Ficheros;

public class FactoriaPuntos {
        //Patron factoria estatica
	    //Metodo de factoria para constructor sin parametros
	public static Punto create() {
		return new PuntoImpl();
		
		
	}

	    //Metodo de factoria para constructor con parametros
	public static Punto create(Double x, Double y) {
		return new PuntoImpl(x, y);
		
	}
    
    //Metodo de factoria para constructor a partir de String
	public static Punto create(String cad) {
		return new PuntoImpl(cad);
	}

    //Metodo de factoria sin constructor correspondiente
	public static Punto create(Double x) {
		return create (x, 0.0);
	}
    //Patron factoria estatica
    //Metodo de factoria que hace una copia
	public static Punto create(Punto p) {
		return create(p.getX(), p.getY());
		
	}
	public static List <Punto> createPuntos(String nombreFichero){
		Checkers.checkNoNull(nombreFichero);
		List<Punto> res= new ArrayList<>();
		List<String> lineas =Ficheros.leeFichero("Factoria.createPuntos: : Error leyendo ficheros", nombreFichero);
		for (String linea: lineas) {
			Punto p= create(linea);
			res.add(p);
		}
		return res;
	}
}
