package spacePong.classes;

import java.awt.*;

import javax.swing.ImageIcon;

public class Image {
	
	//Atributos
	private ImageIcon img;
	private int posX, posY, width, height;
	private SoundEffect sound;
	
	//Construtores
	public Image(String url, int posX, int posY) {
		this.img = new ImageIcon(this.getClass().getResource(url));
		this.posX = posX;
		this.posY = posY;
		this.width = img.getIconWidth();
		this.height = img.getIconHeight();
		this.sound = null;
	}
	public Image(String url, int posX, int posY, String sound, boolean loop) {
		this.img = new ImageIcon(this.getClass().getResource(url));
		this.posX = posX;
		this.posY = posY;
		this.width = img.getIconWidth();
		this.height = img.getIconHeight();
		this.sound = new SoundEffect(sound, loop);
	}
	
	
	//Métodos Específicos
	public void draw(Graphics g) {
		g.drawImage(img.getImage(), this.posX, this.posY, this.width, this.height, null);
	}
	public void scale(double scale) {
		this.width*=scale;
		this.height*=scale;
	}
	
	
	public void get_collision(int width, int height) {
		//Colisão com a borda lateral direita
		if(this.posX + this.width > width) {
			this.posX = width - this.width;
			this.sound.play();
		}
		//Colisão com a borda lateral esquerda
		if(this.posX < 0) {
			this.posX = 0;
			this.sound.play();

		}
		//Colisão com a borda  inferior
		if(this.posY + this.height > height) {
			this.posY = height - this.height;
			this.sound.play();

		}
		//Colisão com a borda  superior
		if(this.posY < 0) {
			this.posY = 0;
			this.sound.play();

		}
	}

	
	public void moveX ( int inc) {
		this.posX+= inc;
	}
	public void moveY ( int inc) {
		this.posY+= inc;
	}
	
	
	// Método de acesso
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
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
	
	
}
