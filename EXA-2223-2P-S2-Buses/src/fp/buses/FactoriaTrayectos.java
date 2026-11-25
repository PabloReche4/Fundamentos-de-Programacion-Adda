package fp.buses;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import fp.utiles.Checkers;




public class FactoriaTrayectos {

	
	public static ControlTrayectos leeTrayectos(String ruta) {
		ControlTrayectos res = null;
		try {
			Stream<Trayecto> sv = Files.lines(Paths.get(ruta))
					.map(FactoriaTrayectos::parseaTrayecto);
			res = new ControlTrayectos(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + ruta);
			e.printStackTrace();
		}
		return res;
	}
    private static final String DELIMITADOR_PRINCIPAL=";";
    private static final String DELIMITADOR_SECUNDARIO=",";
    private static final String DELIMITADOR_RESULTADO="-";
    public Trayecto parseaTrayecto(String s) {
    	Checkers.checkNoNull(s);
    	String [] splits=s.split(DELIMITADOR_PRINCIPAL);
    	String msg= String.format("Formato no válido", s);
    	Checkers.check(msg, splits.length==6);
    	LocalDateTime fechaHora=parseaFechaHora(splits[0].trim());
    	String nombre=splits[1].trim(); //cuando es string se pone diractamente el split y el trim
    	Empresa empresa=parseaEmpresa(splits[2].trim());
    	Integer usuarios=Integer.valueOf(splits[3].trim()); //cuando es integer hay que usar integer.valueof
    	String paradaInicial=splits[4].trim();
    	List<Etapa> recorrido=parseaRecorrido(splits[5].trim());
    	return new Trayecto(fechaHora, nombre, empresa, usuarios, paradaInicial, recorrido);
    	
    }
	private List<Etapa> parseaRecorrido(String cad) {
				Checkers.checkNoNull(cad) ;
				String limpia=cad.replace("[", "").replace("]", "").trim();
				String [] splits=limpia.split(DELIMITADOR_SECUNDARIO);
				List <Etapa> lg=new ArrayList<>();
				for (String s:splits) {
					lg.add(parseaEtapa(s));
				}
			   return lg;
	}
	private Etapa parseaEtapa(String cad) {
		Checkers.checkNoNull(cad);
		String [] splits=cad.split(DELIMITADOR_RESULTADO);
		String msg= String.format("Formato no válido", cad);
		Checkers.check(msg, splits.length==2);
		String parada=splits[1].trim();
		Integer minutos=Integer.valueOf(splits[0].trim());
		return new Etapa(parada, minutos);
	}
	private Empresa parseaEmpresa(String cad) {
		return Empresa.valueOf(cad);
	}
	private LocalDateTime parseaFechaHora(String fechaHora) {
		return LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern("d/M/Y H:m"));
		
	}
    
	
}
