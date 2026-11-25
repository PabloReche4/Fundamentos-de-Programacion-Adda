package fp.tipos;

public interface Punto extends Comparable<Punto>{
	
	Double getX();
	Double getY();
	void setX(Double nuevaX);
	void setY(Double nuevaY);
	Double getDistancia(Punto p);
}
