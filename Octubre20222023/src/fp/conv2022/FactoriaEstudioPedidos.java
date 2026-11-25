package fp.conv2022;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaEstudioPedidos {
public static  EstudioPedidos leerEstudioPedidos(String ruta) {
	List<Pedido>res=new ArrayList<>();
	List<String>lineas=Ficheros.leeFichero("Error en apertura", ruta);
	for(String linea:lineas.subList(1, lineas.size()-1)) {
		res.add(parseaPedidos(linea));
	}
	return new EstudioPedidos(res.stream());
}

public static Pedido parseaPedidos(String linea) {
	Checkers.checkNoNull(linea);
	String [] trozos=linea.split(";");
	Checkers.check("Formato no valido",trozos.length==9);
	LocalDate fecha=LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("d/M/yy"));
	String usuario=trozos[1].trim();
	String pais=trozos[2].trim();
	String ciudad=trozos[3].trim();
	Envio envio=Envio.valueOf(trozos[4].trim());
	Set<String>categorias=parseaCategorias(trozos[5].trim());
	String producto=trozos[6].trim();
	Double precioSinIVA=Double.valueOf(trozos[7].replace("$", "").replace(".", "").trim());
	Integer unidades=Integer.valueOf(trozos[8].trim());
	return new Pedido(fecha,usuario,pais,ciudad,envio,categorias,producto,precioSinIVA,unidades);
}

private static Set<String> parseaCategorias(String linea) {
	String []trozos=linea.split("and");
	Set<String>res=new HashSet<>();
	for (String elem:trozos) {
		res.add(elem.trim());
	}
	return res;
}
}
