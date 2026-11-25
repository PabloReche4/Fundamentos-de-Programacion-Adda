package fp.tipos;

import java.awt.Color;

public class PixelImpl extends PuntoImpl implements Pixel {
	//Atributos
	//OJO, heredo x e y;
	private Color color;
	
	//Constructores
	public PixelImpl() {
//		super();
//		this.color= Color.GREEN;
		this(0.0, 0.0, Color.GREEN);
	}
	public PixelImpl(Double x, Double y, Color c) {
		super(x, y);
		this.color=c;
	}
	
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color c) {
		color=c;
	}


	public String toString() {
//		String res =  super.toString();
//		res = res + " : " + getColor();
//		return res;
		return super.toString() + " : " + getColor();
	}
}
