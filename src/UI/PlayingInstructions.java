package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class PlayingInstructions extends JFrame {

	JPanel instrPanel = new JPanel();
	JTextArea txtInstructions = new JTextArea();

	
	public PlayingInstructions() {
		addInstructions();
		initialize();
		addPanel();

	}

	public void initialize() {

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JTextArea txtInstr = new JTextArea();
		txtInstr.setForeground(Color.LIGHT_GRAY);
		txtInstr.setBackground(Color.DARK_GRAY);
		txtInstr.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtInstr.setEditable(false);
		txtInstr.setText("How to Play");
		txtInstr.setBounds(140, 0, 419, 58);
		getContentPane().add(txtInstr);
		setBounds(900, 54, 657, 481);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	public void addInstructions() {
		txtInstructions.setForeground(Color.LIGHT_GRAY);
		txtInstructions.setBackground(Color.DARK_GRAY);
		txtInstructions.setBounds(20, 60, 607, 481);
		txtInstructions.setText("Click Pick Territory/Army button in the beggining of each turn.\n"
				+ "Select your own Territory and the territory you want to attack.\n"
				+ "Press the ATTACK button and roll the die twice: The first for.... and the second for ......\n"
				+ "Press ATTACK button again to start the action. \n"
				+ "Pick a chance card. \n"
				+ "Open the chance card frame \n"
				+ "Select a territory \n"
				+ "Roll a die \n"
				+  "Choose a card that you want to play \n"
				+  "Choose a territory that you want to fortify from \n"
				+  "Choose a territory that you want to fortify to \n"
				+  "The combobox will open and choose the count of army you want to fortify \n"
				+  "Push fortify button \n"
				+ "");
		add(txtInstructions);
	}



		
	public void addPanel() {
		instrPanel.setBounds(10, 100, 627, 341);
		instrPanel.setBackground(Color.DARK_GRAY);
		instrPanel.setLayout(null);
		add(instrPanel);
	}

	
}