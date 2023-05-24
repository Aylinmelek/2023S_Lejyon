package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Player;

public class BuildingMode extends JLayeredPane {
	JTextArea txtrGameOptions = new JTextArea();
    JComboBox<Integer> numPlayers = new JComboBox<Integer> ();
    JComboBox<Integer> numComp = new JComboBox<Integer>();
    JTextArea txtnumPlayers = new JTextArea();
    JTextArea txtnumComp = new JTextArea();
    JButton btnNext = new JButton("Next");
    PlayingMode playingMode = new PlayingMode();
    LoginScreen loginScreen = new LoginScreen();
    InitSharing initSharing = new InitSharing();
    String players,comp;
    int numOfInfantry, totalPlayers=0;
    
    
    ArrayList<Player> playerArray = new ArrayList<Player>(); 
    
    //ai player olucak class ı ? 
    ArrayList<Player> compPlayerArray = new ArrayList<Player>(); 

   

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
        
        txtnumPlayers.setBounds(220, 450, 217, 32);
        txtnumPlayers.setText("Number of players (2-6):");
        txtnumPlayers.setForeground(Color.LIGHT_GRAY);
        txtnumPlayers.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumPlayers.setEditable(false);
        txtnumPlayers.setBackground(Color.DARK_GRAY);
        add(txtnumPlayers);
        
        
        txtnumComp.setBounds(143, 490, 294, 32);
        txtnumComp.setText("Number of computer players (1-6):");
        txtnumComp.setForeground(Color.LIGHT_GRAY);
        txtnumComp.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumComp.setEditable(false);
        txtnumComp.setBackground(Color.DARK_GRAY);
        add(txtnumComp);
        
        numPlayers.setBounds(432, 450, 64, 27);
        numPlayers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 2, 3, 4, 5, 6}));
        //aldığım player sayısı kadar for loopta player oluşturma
        numPlayers.setMaximumRowCount(6);
        
        
        
       
        numPlayers.setBackground(Color.LIGHT_GRAY);
        add(numPlayers);
       

        numComp.setBounds(432, 490, 64, 27);
        numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        //aldığım comp sayısı kadar for loopta comp oluşturma
        numComp.setMaximumRowCount(6);
        numComp.setBackground(Color.LIGHT_GRAY);
        add(numComp);
        
        

        btnNext.setBounds(724, 490, 117, 29);
        add(btnNext);
        
	}
	
	public void addPlayers() {
		int playerNum = (int) numPlayers.getSelectedItem();
		int compPlayerNum = (int) numComp.getSelectedItem();
		
		for (int i=0; i<playerNum; i++) {
			playerArray.add(new Player());
			
		}
	
	for (int i=0; i<compPlayerNum; i++) {
		//ai player olucak ama class ı bulamadım 
		compPlayerArray.add(new Player());
		
		}
	}
	
	public int armyNum() {  
		
	
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
		if (totalPlayers == 6) {
			numOfInfantry = 20;
		
	}
		return numOfInfantry;

	}

}
