package classes;

import java.awt.*; // Importa as classes Color e Graphics e outras

public class Rectangle extends Shape {
	
	/*Atributos:
		atributos podem ser herdados, e podemos acrescentar mais */
	
	private int width;
	private int height; 
	
	
	//Construtor
	public Rectangle(Color color, int posX, int posY, int width, int height) {
		super(color, posX, posY); //Herda a inicialização
		this.height = height;
		this.width = width;
	}
	
	
	
	//Método Funcional
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.fillRect(super.getPosX(), super.getPosY(), this.width, this.height);
	}
	
	public void changeDirection(int limXmin, int limXmax, int limYmin, int limYmax) {
		//Método para bater nas bordas e voltar
		
		if(super.getPosX()+ this.width >= limXmax  || super.getPosX() <= limXmin) {
			super.setSpeedX(super.getSpeedX() * -1);
			super.setColor(super.colorGenerate() );
		}
		if(super.getPosY() + this.height >= limYmax  || super.getPosY() <= limYmin) {
			super.setSpeedY(super.getSpeedY() * -1);
			super.setColor(super.colorGenerate() );
		}
	}
	
	
	//Métodos de acesso
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
