package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class ChanceCardFrame {

	JFrame chanceCardF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChanceCardFrame window = new ChanceCardFrame();
					window.chanceCardF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChanceCardFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chanceCardF = new JFrame();
		chanceCardF.getContentPane().setBackground(Color.DARK_GRAY);
		chanceCardF.getContentPane().setLayout(null);
		
		JTextArea txtrTerritoryCards = new JTextArea();
		txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
		txtrTerritoryCards.setBackground(Color.DARK_GRAY);
		txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrTerritoryCards.setEditable(false);
		txtrTerritoryCards.setText("Chance Cards");
		txtrTerritoryCards.setBounds(192, 20, 419, 71);
		chanceCardF.getContentPane().add(txtrTerritoryCards);
		chanceCardF.setBounds(100, 100, 657, 481);
		chanceCardF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

}


