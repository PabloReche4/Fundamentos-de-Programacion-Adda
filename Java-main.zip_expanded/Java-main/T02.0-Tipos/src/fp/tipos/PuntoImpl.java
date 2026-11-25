package fp.tipos;

import utiles.Checkers;

public class PuntoImpl implements Punto {
	
	//Atributos
	private Double x;
	private Double y;

	//Constructores
	public PuntoImpl() {
		x=0.0;
		y=0.0;
	}

	public PuntoImpl(Double x, Double y) {
		this.x=x;
		this.y=y;
	}
    //Constructor a partir de String
	public PuntoImpl(String s) {
		Checkers.checkNoNull(s);
		//Limpieza de la cadena
		String s1=s.replace(",(","").replace(")", "");
		//Troceo de la cadena
		String[]trozos=s1.split(",");
		//Comprobacion del formato
		Checkers.check("Formato no válido", trozos.length ==2);
		this.x = Double.valueOf(trozos[0].trim());
		this.y=  Double.valueOf(trozos[1].trim());
	}
	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	@Override
	public void setX(Double x) {
		this.x=x;
		
	}

	@Override
	public void setY(Double y) {
		this.y=y;
		
	}

	@Override
	public Double getDistancia(Punto p) {
		Double difX =p.getX() - this.getX();
		Double difY= p.getY() - getY();
		return Math.sqrt(difX*difX + difY*difY);
	}

	public String toString() {
		return "(" + this.getX() +","+ this.getY()+")";
	}
	
	//Criterio de igualdad 
	public boolean equals(Object obj) {
		boolean res =false;
		if (obj instanceof Punto) {
			Punto p = (Punto) obj;
			res = getX().equals(p.getX()) &&
					getY().equals(p.getY());
			
		}
	return res;	
	}
	
	
	//Representación como número
	public int hashCode() {
		return this.getX().hashCode() + 
				31* this.getY().hashCode();
	}

	public int compareTo(Punto o) {
		/// Primer objeto: this
		// Segundo objeto:o
		int res = this.getX().compareTo(o.getX()); 
		if (res == 0) {
			res = this.getY().compareTo(o.getY());
		}
		return res;
	}
}
