package utiles;

public class Validators {
	public static Boolean sonDigitos(String cad) {
		Boolean res = true;
		for (int i = 0; i<cad.length();i++) {
			if (! Character.isDigit(cad.charAt(i))) {
			res = false;
			break;				
			}
		}
		return res;
	}

public static Boolean sonLetras(String cad) {
		//Esquema paratodo
		//Devuelve cierto si todos los caracteres de la cadena son letras
		Boolean res =true;
		//inicializacion; condicion; actualizacion
		//cad.length()  ==> 3
		// i = 0
		// ¿i<cad.length()? ==>  true
		// i = 1
		// ¿i<cad.length()? ==>  true
		// i= 2
		// ¿i<cad.length()? ==>  true
		for (int i = 0;i<cad.length();i++) {
			if (! Character.isLetter(cad.charAt(i))) {
				res =false;
				break;
			}
			
		}
		
		return res;
	}
}