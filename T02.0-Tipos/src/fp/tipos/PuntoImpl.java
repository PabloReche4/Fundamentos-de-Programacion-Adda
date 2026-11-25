package fp.tipos;

public class PuntoImpl  implements Punto{
	
	//Atributos
	private Double x;
	private Double y;
	
     //Constructores
	public PuntoImpl() {
		x=0.0;
		y=0.0;
	}
	
	public PuntoImpl(Double x, Double y)  {
		this.x=x;
		this.y=y;
		
	}
		@Override
	public Double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public Double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(Double nuevaX) {
		x=nuevaX;
		
	}

	@Override
	public void setY(Double nuevaY) {
		y=nuevaY;
		
	}

	@Override
	public Double getDistancia(Punto p) {
		Punto pA= this;
		Double difX=p.getX() - getX();
		Double difY= p.getY() - getY();
		return Math.sqrt(difX*difX + difY*difY);
		
		//poner getX y poner this.getX es lo mismo
	
	}

	public String toString() {
		return "("+ this.getX() + "," +this.getY()+")";
		
				
	}

//Criterio de igualdad
public boolean equals (Object obj) {
	boolean res=false;
	if(obj instanceof Punto) {
		Punto p= (Punto) obj;
		res=this.getX().equals(p.getX()) && this.getY().equals(p.getY());
		
		
	}
         	return res;
		
	}
         	
         	//Representacion como numero
         	public int hashCode() {
         		return this.getX().hashCode()+ 31*this.getY().hashCode();{
         			
         		}
         		
         	}
	
