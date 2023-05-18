package classes;

import java.awt.Color;

public class Circle extends Ellipse {

	public Circle(Color color, int posX, int posY, int size) {
		super(color, posX, posY, size, size);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setWidth(int size) {
		super.setWidth(size);
		super.setHeight(size);
	}
	
	@Override
	public void setHeight(int size) {
		super.setWidth(size);
		super.setHeight(size);
	}
	
	
	
	

}
