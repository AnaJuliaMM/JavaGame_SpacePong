package spacePong.classes;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.JFrame;

import classes.ScreenProtector;
import classes.Shape;

import javax.swing.*;

public class SpacePong extends JFrame implements Runnable {
	
	//Atributos
	
		//Atributos: Tamanho da tela
	private int height = 920;
	private int width = 1800;
		//Atributos: Teclas setas
	private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    	//Atributos: Teclas A W S D
    private boolean a;
    private boolean w;
    private boolean s;
    private boolean d;
		//Atributo: tecla espaço
    private boolean space;
    
    
    
    //Construtor
    public SpacePong() {
        // Chama o metodo que realiza todas as configurações iniciais necessárias
		initComponents();
		// Mecanismo de execução paralela
		createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }
    

	//Métodos Específicos 
    
    /*
     * Método initComponents() realiza todas as configurações
     *  iniciais necessárias
     *  
     *  TODO FALTA COMENTÁRIOS DO CAINÃ
     */
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//início initComponents()
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Chama os métodos de Scaneamento de teclas (tecla pressionada / solta)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        
        // Configura o layout da tela
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        	// Largura
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, width, Short.MAX_VALUE)
        );
        	// Altura
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, height, Short.MAX_VALUE)
        );

        pack();
    }//fim initComponents()
    
    
    /*
     * Método formKeyPressed() verifica se as teclas foram pressionadas
     */
    
    private void formKeyPressed(KeyEvent evt) {//início formKeyPressed()
    	
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
    	// Verifica se a tecla a foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_A)
        {
        	// coloca o valor da variavel a em true enquanto a tecla estiver pressionada
        	a = true;
        }
    	// Verifica se a tecla w foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_W) 
        {
        	// coloca o valor da variavel w em true enquanto a tecla estiver pressionada
        	w = true;
        }
    	// Verifica se a tecla s foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_S) 
        {
        	// coloca o valor da variavel s em true enquanto a tecla estiver pressionada
        	s = true;
        }
    	// Verifica se a tecla d foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_D) 
        {
        	// coloca o valor da variavel d em true enquanto a tecla estiver pressionada
        	d = true;
        }
    	// Verifica se a tecla espaço foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_SPACE) 
        {
        	// coloca o valor da variavel space em true enquanto a tecla estiver pressionada
        	space = true;
        }
    	
    }//fim formKeyPressed()
    
    
    /*
     * Método formKeyReleased() 
     * verifica se as teclas foram soltas
     */
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//início formKeyReleased()
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
    	// Verifica se a tecla a foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_A)
        {
        	// coloca o valor da variavel a em false enquanto a tecla estiver pressionada
        	a = false;
        }
    	// Verifica se a tecla w foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_W) 
        {
        	// coloca o valor da variavel w em false enquanto a tecla estiver pressionada
        	w = false;
        }
    	// Verifica se a tecla s foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_S) 
        {
        	// coloca o valor da variavel s em false enquanto a tecla estiver pressionada
        	s = false;
        }
    	// Verifica se a tecla d foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_D) 
        {
        	// coloca o valor da variavel d em false enquanto a tecla estiver pressionada
        	d = false;
        }
    	// Verifica se a tecla espaço foi pressiona
        else if(evt.getKeyCode() == KeyEvent.VK_SPACE) 
        {
        	// coloca o valor da variavel space em false enquanto a tecla estiver pressionada
        	space = false;
        }
    }//início formKeyReleased()
    
    
    
    
    /*
     * Método main() 
     * Inicializa a janela 
     */
	public static void main(String[] args) {
	
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpacePong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SpacePong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SpacePong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SpacePong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	//Instancia a classe 
                new SpacePong().setVisible(true);
            }
        });
	}

	@Override
	public void run() {
		// A variável g recebe o objeto do tipo Graphics que permite gerar imagens na tela
		Graphics g = getBufferStrategy().getDrawGraphics();
		
		//Instancia e toca o efeito sonoro em loop infinito

		
		// Instancie suas formas aqui
		
		
		// Como num desenho animado, as animações são criadas a partir da sobreposição de frames
		while(true) {
			
			//Atualiza o g
			g = getBufferStrategy().getDrawGraphics();
			
			//limpa tela
			g.clearRect( 0 , 0, getWidth(), getHeight());
			
			
			
			//Exibe a tela
			getBufferStrategy().show();
            
	      // Unidade de tempo da animação
	      try {
	        Thread.sleep(1);
	      }catch  (InterruptedException ex) {}
		}
	}// Fim do Run

}
