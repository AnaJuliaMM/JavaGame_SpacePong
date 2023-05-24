package classes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class ScreenProtector extends javax.swing.JFrame implements Runnable{

	// tamanho da tela
	private int height = 900;
	private int width = 1000;
	
	// teclas
	
	/*
	 * Funcionamento: quando a tecla é pressionada sua respectiva variável fica 
	 * com valor True. Quando solta a variável fica com valor False.
	 */
	
	private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
	
    // Construtor
	public ScreenProtector() {
        // Chama o metodo que realiza todas as configurações iniciais necessárias
		initComponents();
		
		// Mecanismo de execução paralela
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }
	

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Realiza todas as configurações iniciais necessárias
    
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Chama os métodos de Scaneamento de teclas (tecla pressionada / solta)
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        
        // Configura o layout da tela
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // Largura
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, width, Short.MAX_VALUE)
        );
        // Altura
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, height, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Método que verifica se as teclas foram pressionadas
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // Verifica se a tecla seta para a esquerda foi pressiona
    	if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            // coloca o valor da variavel left em true enquanto a tecla estiver pressionada
    		left = true;
        }
    	// Verifica se a tecla seta para a direita foi pressiona
    	else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
        	// coloca o valor da variavel right em true enquanto a tecla estiver pressionada
        	right = true;
        }
    	// Verifica se a tecla seta para cima foi pressiona
        else if (evt.getKeyCode() == KeyEvent.VK_UP) 
        {
        	// coloca o valor da variavel up em true enquanto a tecla estiver pressionada
            up = true;
        }
    	// Verifica se a tecla seta para baixo foi pressiona
        else if (evt.getKeyCode() == KeyEvent.VK_DOWN) 
        {
        	// coloca o valor da variavel down em true enquanto a tecla estiver pressionada
            down = true;
        }
    }//GEN-LAST:event_formKeyPressed

    // Método que verifica se as teclas foram soltas
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    	// Verifica se a tecla seta para a esquerda foi solta
    	if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
    		// volta o valor da variavel left em false depois que a tecla for solta
    		left = false;
        } 
    	// Verifica se a tecla seta para a direita foi solta
    	else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
    		// volta o valor da variavel right em false depois que a tecla for solta
    		right = false;
        }
    	// Verifica se a tecla seta para cima foi solta
    	else if (evt.getKeyCode() == KeyEvent.VK_UP) {
    		// volta o valor da variavel up em false depois que a tecla for solta
    		up = false;
        }
    	// Verifica se a tecla seta para baixo foi solta
        else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
        	// volta o valor da variavel down em false depois que a tecla for solta
        	down = false;
        }
    }//GEN-LAST:event_formKeyReleased
	
	// Inicializa a janela
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenProtector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenProtector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenProtector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenProtector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenProtector().setVisible(true);
            }
        });
	}
	
	
	// Implemente seu código aqui.
	public void run() {
		// A variável g recebe o objeto do tipo Graphics que permite gerar imagens na tela
		Graphics g = getBufferStrategy().getDrawGraphics();
		Random r = new Random();
		
		//Instancia e toca o efeito sonoro em loop infinito
		SoundEffect backgroundSound = new SoundEffect("/sounds/background.wav", true);
		backgroundSound.play();
		
		
		// Instancie suas formas geométricas aqui
		Circle main_c = new Circle(Color.BLACK, 
				r.nextInt(super.getWidth()- 100),
				r.nextInt(super.getHeight()- 500),
				r.nextInt(190) + 10 );
		
		//Array normal do Java
		Shape [] shapes = new Shape [20];
		for (int i = 0; i < shapes.length; i ++) {
			if(i<5) {
				shapes[i] = new Rectangle(this.colorGenerate(),r.nextInt(super.getWidth()- 100), r.nextInt(super.getHeight()- 500), r.nextInt(90) + 10, r.nextInt(90)+10);
			}else if(i<10) {
				shapes[i] = new Ellipse(this.colorGenerate(), r.nextInt(super.getWidth()- 100), r.nextInt(super.getHeight()- 500), r.nextInt(90) + 10, r.nextInt(90) + 10 );
			}else if(i<15) {
				shapes[i] = new Square (this.colorGenerate(), r.nextInt(super.getWidth()- 100), r.nextInt(super.getHeight()- 500), r.nextInt(90) + 10);
			}else {
				shapes[i] = new Circle (this.colorGenerate(), r.nextInt(super.getWidth()- 100), r.nextInt(super.getHeight()- 500), r.nextInt(90) + 10);
			}
		}
		
		//Criando uma ArrayList,que é um tipo de vetor sem quantidade fixa
		ArrayList<Shape> shapesAL = new ArrayList<Shape>();
		
		for(int i=0; i<20; i++) {
			shapesAL.add( new Rectangle(this.colorGenerate(),
							r.nextInt(super.getWidth()- 100), 
							r.nextInt(super.getHeight()- 500), 
							r.nextInt(90) + 10, r.nextInt(90)+10));
			shapesAL.add(new Ellipse(this.colorGenerate(), 
							r.nextInt(super.getWidth()- 100),
							r.nextInt(super.getHeight()- 500),
							r.nextInt(90) + 10, r.nextInt(90) + 10 ));
			shapesAL.add( new Square (this.colorGenerate(), 
										r.nextInt(super.getWidth()- 100), 
										r.nextInt(super.getHeight()- 500),
										r.nextInt(90) + 10));	
			shapesAL.add(new Circle (this.colorGenerate(), 
									r.nextInt(super.getWidth()- 100),
									r.nextInt(super.getHeight()- 500),
									r.nextInt(90) + 10));
			
		}
		
		
		for (Shape shape : shapesAL) {
			if(r.nextBoolean())
				shape.setSpeedX(-1);
				
			if(r.nextBoolean())
				shape.setSpeedY(-1);
		}
		
		Image senai_logo = new Image("/images/senai_logo.png", 100, 100);
		senai_logo.scale(0.1);
		Image balao_ar = new Image("/images/balao_ar.png", 200, 200, "/sounds/impact.wav", false);
		balao_ar.scale(0.6);
		
		// Como num desenho animado, as animações são criadas a partir da sobreposição de frames
		while(true) {
			
			//Atualiza o g
			g = getBufferStrategy().getDrawGraphics();
			
			//limpa tela
			g.clearRect( 0 , 0, getWidth(), getHeight());
			
			
			// Implemente sua animação aqui.
			if(right) {
				main_c.setPosX(main_c.getPosX()+ main_c.getSpeedX());
				balao_ar.moveX(1);
			}
			if(left) {
				main_c.setPosX(main_c.getPosX()- main_c.getSpeedX());
				balao_ar.moveX(-1);
			}
			if(up) {
				main_c.setPosY(main_c.getPosY() - main_c.getSpeedY());
				balao_ar.moveY(-1);

			}
			if(down) {
				main_c.setPosY(main_c.getPosY() + main_c.getSpeedY());
				balao_ar.moveY(1);


			}
			//For each para vetor classe
			for (Shape shape : shapesAL) {
				shape.draw(g);
				shape.move();
				shape.changeDirection(0, super.getWidth(), 0, super.getHeight());
			}
			
			//For each somente para vetores padrão
			for (Shape shape : shapes) {
				shape.draw(g);
				shape.move();
				shape.changeDirection(0, super.getWidth(), 0, super.getHeight());
			}
			
			main_c.draw(g);
			main_c.changeDirection(0, super.getWidth(), 0, super.getHeight());
			
			senai_logo.draw(g);
			balao_ar.draw(g);
			balao_ar.get_collision(this.getWidth(), this.getHeight());
			
			//Exibe a tela
			getBufferStrategy().show();
            
	      // Unidade de tempo da animação
	      try {
	        Thread.sleep(1);
	      }catch  (InterruptedException ex) {}
		}
		
	}// Fim do Run
	
	public Color colorGenerate() {
		Random rand = new Random();
		int r, g, b;
		
		r = rand.nextInt(255);
		g = rand.nextInt(255);
		b = rand.nextInt(255);
		
		return new Color(r,g,b);
	}
  
}
