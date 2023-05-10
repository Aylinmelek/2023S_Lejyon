package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class ArmyCardFrame {

	JFrame ArmyCardF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArmyCardFrame window = new ArmyCardFrame();
					window.ArmyCardF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArmyCardFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArmyCardF = new JFrame();
		ArmyCardF.getContentPane().setBackground(Color.DARK_GRAY);
		ArmyCardF.getContentPane().setLayout(null);
		
		JTextArea txtrTerritoryCards = new JTextArea();
		txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
		txtrTerritoryCards.setBackground(Color.DARK_GRAY);
		txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrTerritoryCards.setEditable(false);
		txtrTerritoryCards.setText("Army Cards");
		txtrTerritoryCards.setBounds(192, 20, 419, 71);
		ArmyCardF.getContentPane().add(txtrTerritoryCards);
		ArmyCardF.setBounds(100, 100, 657, 481);
		ArmyCardF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel label = new JLabel("");
		
		label.setBounds(121, 100, 92,86);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/artillery.png"));
		label.setIcon(img);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(200, 100, 92,86);
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/infantry.png"));
		label2.setIcon(img2);
		
		
		ArmyCardF.getContentPane().add(label);
		ArmyCardF.getContentPane().add(label2);
		
	}

}


