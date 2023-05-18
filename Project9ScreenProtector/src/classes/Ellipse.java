package classes;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Rectangle {
	//Atributo
	
	public Ellipse (Color color, int posX, int posY, int width, int height) {
		super (color, posX, posY, width, height); //Herda a inicialização
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(super.getColor());
		g.fillOval(super.getPosX(), super.getPosY(), super.getWidth(), super.getHeight());
	}

}
