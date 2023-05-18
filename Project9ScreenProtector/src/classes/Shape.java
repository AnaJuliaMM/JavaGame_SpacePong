package classes;

import java.awt.*;
import java.util.Random;

public abstract class Shape {
	//Atributos
	private Color color;
	private int posX;
	private int posY;
	private int speedX; // incremento X
	private int speedY; // Incremento Y
	
	//Construtor
	public Shape( Color color , int posX, int posY) {
		this.color = color;
		this.posX = posX;
		this.posY = posY;
		this.speedX = 1;
		this.speedY = 1;
	}
	
	
	//Métodos funcionais,	
	public void move() {
		this.posX += this.speedX;
		this.posY += this.speedY;
	}
	
	public void moveX() {
		this.posX += this.speedX;
	}
	public void moveX(int speed) {
		this.setSpeedX(speed);
		this.moveX();
	}
	
	public void moveY() {
		this.posY += this.speedY;
	}
	public void moveY(int speed) {
		this.setSpeedY(speed);
		moveY();
	}
	
	
	public Color colorGenerate() {
		Random rand = new Random();
		int r, g, b;
		
		r = rand.nextInt(255);
		g = rand.nextInt(255);
		b = rand.nextInt(255);
		
		return new Color(r,g,b);
	}
	
	
	//Métodos abstratos
	public abstract void draw(Graphics g);
	public abstract void changeDirection(int limXmin, int limXmax, int limYmin, int limYmax);
	
	
	
	//Métodos de acesso
	
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
