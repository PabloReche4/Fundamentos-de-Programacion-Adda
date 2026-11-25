package fp.compras.test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DayOfWeek;


import fp.compras.MomentoDia;

public class TestTiposReferencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer n=20;
        MomentoDia md= MomentoDia.EVENING;
        		System.out.println(md);
        String s= "Ejercicio de FP";
                // System.out.println(s(size()));
              System.out.println(s.charAt(1));
              //System.out.println(s.get(1));
              System.out.println(s.concat(", de prueba"));
              System.out.println(s);
              System.out.println(s.startsWith("e"));
              
              
              LocalTime horaInicioPeli, horaFinPeli;
              DayOfWeek diaMasBarato;
              LocalDateTime ultimaPeli;
              Duration duracionPeli;
              LocalDate fechaEstreno;
              
              horaInicioPeli= LocalTime.of(18, 30);
              horaFinPeli= LocalTime.of(20, 0);
              diaMasBarato= DayOfWeek.WEDNESDAY;
              ultimaPeli= LocalDateTime.of(2016, 9, 14, 18, 30);
              duracionPeli= Duration.ofMinutes(80);
              fechaEstreno= LocalDate.of(2017, 2, 1);
              
              
              
              
              
              
              
              
        
	}

}
