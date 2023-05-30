package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ChanceCardFrame extends JFrame{

	private static final int MAX_CHANCE_CARDS = 15; //????
	
	JPanel cardsPanel = new JPanel();
	
	JLabel[] cardLabels = new JLabel[MAX_CHANCE_CARDS];
	 int labelIndex;
	
	
	
	public ChanceCardFrame() {
		initialize();
		addPanel();
		initializeCardLabels();
	}

	
	public int getLabelIndex() {
		return labelIndex;
	}



	public void setLabelIndex(int labelIndex) {
		this.labelIndex = labelIndex;
	}


	public JLabel[] initializeCardLabels() {
    	
        for (int i = 0; i< MAX_CHANCE_CARDS; i++) {
        	cardLabels[i] = new JLabel();     
            add(cardLabels[i]);
            
        }
        
        return cardLabels;
        
       
    }
	
	public void addLabels() {
		cardLabels[labelIndex].setBackground(Color.DARK_GRAY);
		cardLabels[labelIndex].setForeground(Color.WHITE);
		cardLabels[labelIndex].setText("Chance Card      ");
		cardLabels[labelIndex].setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 25));
 		getCardsPanel().add(cardLabels[labelIndex]);
 		labelIndex++; //artsın
	}
        
        
	
	public void initialize() {
		
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JTextArea txtrChanceCards = new JTextArea();
		txtrChanceCards.setForeground(Color.LIGHT_GRAY);
		txtrChanceCards.setBackground(Color.DARK_GRAY);
		txtrChanceCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrChanceCards.setEditable(false);
		txtrChanceCards.setText("Chance Cards");
		txtrChanceCards.setBounds(192, 20, 419, 41);
		getContentPane().add(txtrChanceCards);
		setBounds(100, 100, 657, 481);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	public void addPanel() {
		cardsPanel.setBounds(10, 100, 627, 341);
		cardsPanel.setBackground(Color.DARK_GRAY);
		cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));
		add(cardsPanel);
	}

	
	public JPanel getCardsPanel() {
		return cardsPanel;
	}


	public void setCardsPanel(JPanel cardsPanel) {
		this.cardsPanel = cardsPanel;
	}


	
	
}


