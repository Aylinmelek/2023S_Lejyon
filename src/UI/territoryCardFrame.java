package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class territoryCardFrame {

	//JFrame territoryCardF;

	private JPasswordField txtPassword;
	private JLabel loginLabel;
	static JFrame territoryCardF = territoryCardF = new JFrame();
	static JLabel label = new JLabel("");
	static JLabel label2 = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					territoryCardFrame window = new territoryCardFrame();
					window.territoryCardF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public territoryCardFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		territoryCardF.getContentPane().setBackground(Color.DARK_GRAY);
		territoryCardF.getContentPane().setLayout(null);
		//territoryCardF.getContentPane().setLayout(null);
		
		JTextArea txtrTerritoryCards = new JTextArea();
		txtrTerritoryCards.setBounds(192, 20, 419, 71);
		txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
		txtrTerritoryCards.setBackground(Color.DARK_GRAY);
		txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrTerritoryCards.setEditable(false);
		txtrTerritoryCards.setText("Territory Cards");
		territoryCardF.getContentPane().add(txtrTerritoryCards);
		territoryCardF.setBounds(100, 100, 657, 481);
		
		//JLabel label = new JLabel("");
		label.setBounds(239, 163, 96,165);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/blue7.png"));
		label.setIcon(img);
		
		//JLabel label2 = new JLabel("");
		label2.setBounds(339, 163, 96,165);
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/red2.png"));
		label2.setIcon(img2);
		
		//territoryCardF.getContentPane().add(label2);
		
		
		
		territoryCardF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	public static void setTerCards(String territory) {
		
		/*if (territory=="Blue 1") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Blue 2") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Blue 3") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Blue 4") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Blue 5") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Blue 6") {
			territoryCardF.getContentPane().add(label);
		}*/
		if (territory=="Blue 7") {
			territoryCardF.getContentPane().add(label);
		}
	/*	if (territory=="Yellow 1") {
			territoryCardF.getContentPane().add(label);
		}
		if (territory=="Yellow 2") {
			territoryCardF.getContentPane().add(label);
		}*/
		if (territory=="Red 2") {
			territoryCardF.getContentPane().add(label2);
		}
		
		
		
	}

}


