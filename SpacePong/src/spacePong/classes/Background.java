package spacePong.classes;

import java.awt.Color;
import java.awt.Graphics;

public class Background {
	/*Atributos:
	atributos podem ser herdados, e podemos acrescentar mais */
	private Color color;
	private int posX;
	private int posY;
	private int speedX; // incremento X
	private int speedY; // Incremento Y
	private int width;
	private int height; 
	
	
	//Construtor
	public Background(Color color, int posX, int posY, int width, int height) {
		this.color = color;
		this.posX = posX;
		this.posY = posY;
		this.speedX = 1;
		this.speedY = 1;
		this.height = height;
		this.width = width;
	}
	
	
	
	//Método Funcional
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getPosX(), this.getPosY(), this.width, this.height);
	}
	
	//TODO: Tirar o changeDirection()
	public void changeDirection(int limXmin, int limXmax, int limYmin, int limYmax) {
		//Método para bater nas bordas e voltar
		
		if(this.getPosX()+ this.width >= limXmax  || this.getPosX() <= limXmin) {
			this.setSpeedX(this.getSpeedX() * -1);
		}
		if(this.getPosY() + this.height >= limYmax  || this.getPosY() <= limYmin) {
			this.setSpeedY(this.getSpeedY() * -1);
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	


}
