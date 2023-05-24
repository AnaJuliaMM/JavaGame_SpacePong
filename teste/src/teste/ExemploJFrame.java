package teste;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploJFrame {

	public static void main(String[] args) {
		// Cria uma nova instância do JFrame
        JFrame frame = new JFrame("Exemplo JFrame");
        
        // Define o tamanho do JFrame
        frame.setSize(400, 300);
        
        // Cria um novo JLabel com o texto desejado
        JLabel label = new JLabel("Olá, mundo!");
        
        // Adiciona o JLabel ao JFrame
        frame.add(label);
        
        // Define o comportamento do JFrame ao ser fechado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Torna o JFrame visível
        frame.setVisible(true);
    }

	}
