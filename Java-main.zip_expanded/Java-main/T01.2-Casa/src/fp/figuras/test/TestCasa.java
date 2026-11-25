package fp.figuras.test;

import fp.figuras.*;

public class TestCasa {

	public static void main(String[] args) throws InterruptedException {
		Casa c = new CasaImpl();
		c.dibujar();
		Thread.sleep(500);
		c.setBlancoYNegro();
		
		
	}

}
