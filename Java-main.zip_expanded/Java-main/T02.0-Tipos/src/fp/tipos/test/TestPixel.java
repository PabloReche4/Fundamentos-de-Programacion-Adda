package fp.tipos.test;
import java.awt.Color;
import fp.tipos.Pixel;
import fp.tipos.PixelImpl;
import fp.tipos.Color;

public class TestPixel {

	public static void main(String[] args) {
		Pixel px1=new PixelImpl();
		Pixel px2=new PixelImpl(1.0, 2.0, Color.BLUE);
		System.out.println(px1);
		System.out.println(px2);
	}

}
