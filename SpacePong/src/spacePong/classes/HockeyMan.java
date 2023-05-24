package spacePong.classes;

import javax.swing.ImageIcon;

public class HockeyMan extends Image{
	//Atributos 
	private int life;
	private ImageIcon imageCounter;
	private ImageIcon imageDamage;
	
	
	//Construtores
	public HockeyMan(String url_imagemStandard, String url_imageCounter, String url_imageDamage,  int posY, int posX){
		//Para criar o HockeyMan precisamos: Imagem dele, posição em X e Y
		super(url_imagemStandard, posY, posX);
		
		this.life = 3; 
		this.imageCounter = new ImageIcon(this.getClass().getResource(url_imageCounter)); //Imagem 2 (de contra ataque)
		this.imageDamage = new ImageIcon(this.getClass().getResource(url_imageDamage));
		//TODO: Colocar as url da imagem direto no construtor sem ser como parâmetro
	}
	
	
	
	
	//Métodos específicos
	

	// Método counter(): Realiza o contra ataque do ator
	public void counter() {
		//TODO: Realizar o movimento de contra-aque
		
		//TODO: Trocar a imagem do ator
			//Trocar imagem
		super.setImg(imageCounter);
			//TODO: lógica para Voltar imagem 
		
	}
	
	
	//Método damage(): Executa a perda da vida do ator
	public void damage() {
		//1°: Verificar se o personagem tem vida acima de 1, ou seja, ainda tem vida para perder antes de morrer
		if(this.life>1) {
			//Caso ele ainda tenha vida para perder antes de morrer, subtrair uma vida do ator
			this.life--;
			System.out.println(this.getLife());
		}else{
			//Caso a vida do ator seja 1, ele perde, fica com 0
			this.life--;
			//Ele morre
			this.die();
			System.out.println(this.getLife());
		}
			
	}
	
	
	
	
	//Método die(): Executa a morte ator
	public void die() {
		//TODO: O ator some gradualmente
		//TODO: Aparece a frase game-over na tela do jogador
		
			//Teste da entrada no método
		System.out.println("Game Over!");
		
	}

	
	//Métodos de acesso
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public ImageIcon getImageCounter() {
		return imageCounter;
	}
	public void setImageCounter(ImageIcon imageCounter) {
		this.imageCounter = imageCounter;
	}
	public ImageIcon getImageDamage() {
		return imageDamage;
	}
	public void setImageDamage(ImageIcon imageDamage) {
		this.imageDamage = imageDamage;
	}
	
	
	

}
