package fp.laboratorio.test;

import java.time.LocalDateTime;
import fp.laboratorio.*;

	    //1.

public class TestLaboratorio {
	public static void main(String[] args) {
		
		//2.	
		ClaseLaboratorio c0=new ClaseLaboratorioImpl(10);
		System.out.println(c0);		
		
		//3.
		
		Estudiante es1 = new EstudianteImpl(null, null, null);
		Estudiante es2 = new EstudianteImpl(null, null, null);
		Estudiante es3 = new EstudianteImpl(null, null, null);
		ClaseLaboratorio c1=new ClaseLaboratorioImpl(10);
		ClaseLaboratorio c2=new ClaseLaboratorioImpl(10);

		es1.setNombre("Ada");
		es1.setApellidos("Lovelace");
		es1.setUVUS("adalov");
		
		es2.setNombre("Grace");
		es2.setApellidos("Murray");
		es2.setUVUS("gramur");
		
		es3.setNombre("Frances");
		es3.setApellidos("Allen");
		es3.setUVUS("fraall");

		c1.inscribeEstudiante(es3);
		c1.inscribeEstudiante(es2);
		c1.inscribeEstudiante(es1);
		System.out.println(c1);
		
		//4.
		
		Estudiante es4 = new EstudianteImpl(null, null, null);
		Estudiante es5 = new EstudianteImpl(null, null, null);
		Estudiante es6 = new EstudianteImpl(null, null, null);
		
		es4.setNombre("Hedy");
		es4.setApellidos("Lamarr");
		es4.setUVUS("hedlam");
		es4.sumarPuntos(22.0);
		
		es5.setNombre("Ángela");
		es5.setApellidos("Ruiz");
		es5.setUVUS("angrui");
		es5.sumarPuntos(14.0);
	
		es6.setNombre("Margaret");
		es6.setApellidos("Hamilton");
		es6.setUVUS("marham");
		es6.sumarPuntos(23.0);
		
		c1.inscribeEstudiante(es4);
		c1.inscribeEstudiante(es5);
		c1.inscribeEstudiante(es6);
		
		c2.inscribeEstudiante(es4);
		c2.inscribeEstudiante(es5);
		c2.inscribeEstudiante(es6);
		
		//5.
		
		c1.setAula("Programación");
		c1.setProfesor("Adolfo Suárez");
		c1.setFechaHora(LocalDateTime.now());
		System.out.println(c1);
				
		//6.
		
		double media= (es4.getPuntos()+es5.getPuntos()+es6.getPuntos())/3;
		System.out.println("La media de los tres ultimos alumnos es: " + media);
	}

}