package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class BuildingMode extends JLayeredPane {
	JTextArea txtrGameOptions = new JTextArea();
    static JComboBox<Integer> numPlayers = new JComboBox<Integer> ();
    static JComboBox<Integer> numComp = new JComboBox<Integer>();
    JTextArea txtnumPlayers = new JTextArea();
    JTextArea txtnumComp = new JTextArea();
    JButton btnNext = new JButton("Next");
    PlayingMode playingMode = new PlayingMode();
    LoginScreen loginScreen = new LoginScreen();
    InitSharing initSharing = new InitSharing();
    static String players,comp;
    static int numOfInfantry, totalPlayers=0;

	public void initialize()  {
		setBounds(0, 54, 873, 451);
	    setBackground(Color.DARK_GRAY);
	    
	    setLayout(null);
	}
	
	
	public void addElements() {
		
        txtrGameOptions.setBounds(212, 6, 453, 43);
        txtrGameOptions.setText("Game Options & Map Settings");
        txtrGameOptions.setForeground(Color.LIGHT_GRAY);
        txtrGameOptions.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtrGameOptions.setEditable(false);
        txtrGameOptions.setBackground(Color.DARK_GRAY);
        add(txtrGameOptions);
        
        txtnumPlayers.setBounds(220, 358, 217, 32);
        txtnumPlayers.setText("Number of players (2-6):");
        txtnumPlayers.setForeground(Color.LIGHT_GRAY);
        txtnumPlayers.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumPlayers.setEditable(false);
        txtnumPlayers.setBackground(Color.DARK_GRAY);
        add(txtnumPlayers);
        
        txtnumComp.setBounds(143, 388, 294, 32);
        txtnumComp.setText("Number of computer players (1-6):");
        txtnumComp.setForeground(Color.LIGHT_GRAY);
        txtnumComp.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumComp.setEditable(false);
        txtnumComp.setBackground(Color.DARK_GRAY);
        add(txtnumComp);
        
        numPlayers.setBounds(432, 361, 64, 27);
        numPlayers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 2, 3, 4, 5, 6}));
    
        numPlayers.setMaximumRowCount(6);
   
        numPlayers.setBackground(Color.LIGHT_GRAY);
        add(numPlayers);
       

        numComp.setBounds(432, 391, 64, 27);
        numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        numComp.setMaximumRowCount(6);
        numComp.setBackground(Color.LIGHT_GRAY);
        add(numComp);

        btnNext.setBounds(724, 404, 117, 29);
        add(btnNext);
        
	}
	
	public static int armyNum() {  
		
	
	    players = String.valueOf(numPlayers.getSelectedItem().toString());
		System.out.println(players); 
		
		comp = String.valueOf(numComp.getSelectedItem().toString());
		System.out.println(comp); 
		
		totalPlayers = Integer.parseInt(players) + Integer.parseInt(comp);
	
		System.out.println(totalPlayers);
		if (totalPlayers == 2) {
			numOfInfantry = 40;
		}
	    if (totalPlayers == 3) {
			numOfInfantry = 35;
		}
		if (totalPlayers == 4) {
			numOfInfantry = 30;
		}
		if (totalPlayers == 5) {
			numOfInfantry = 25;
		}
		if (totalPlayers == 6) {{
			numOfInfantry = 20;
		}
	
	}
		return numOfInfantry;

	}

}
