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

import domain.Board;
import domain.ConKUeror;
import domain.Player;
import domain.controller.ConKUerorHandler;

public class BuildingMode extends JLayeredPane {
	JTextArea txtrGameOptions = new JTextArea();
    JComboBox<Integer> numPlayers = new JComboBox<Integer> ();
    JComboBox<Integer> numComp = new JComboBox<Integer>();
    JTextArea txtnumPlayers = new JTextArea();
    JTextArea txtnumComp = new JTextArea();
    JButton btnNext = new JButton("Next");
    
    Grid grid = new Grid();
    
    
    //observer için ekledim
   // Board board = new Board();
    //ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
    
    //InitSharing initSharing = new InitSharing(conKUerorHandler);
    ////////////
    
    //ConKUeror conku = new ConKUeror();

    int players,comp;
    int totalPlayers=0;
    int numOfInfant;
    
    ArrayList<Player> playerArray = new ArrayList<Player>(); 
    
    //ai player olucak class ı ? 
    ArrayList<Player> compPlayerArray = new ArrayList<Player>(); 

   

	public BuildingMode() {
		super();
		initialize();
		addElements();
		//addPlayers();
		
	}


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
        numPlayers.setMaximumRowCount(6);
        numPlayers.setBackground(Color.LIGHT_GRAY);
        add(numPlayers);
       

        numComp.setBounds(432, 490, 64, 27);
        numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        numComp.setMaximumRowCount(6);
        numComp.setBackground(Color.LIGHT_GRAY);
        add(numComp);
        
        

        btnNext.setBounds(724, 490, 117, 29);
        add(btnNext);
        
	}
	
	
	public int addPlayers() {  
		
	
	    players = (int) numPlayers.getSelectedItem(); 
		//System.out.println(players); 
		
		comp = (int) numComp.getSelectedItem();
		//System.out.println(comp); 
		
		
	
		for (int i=0; i<players; i++) {

			//System.out.println("in loop");
			//GameFrame.player_turn.put(new Player(), false); 
		}
		
		for (int i= players; i<(totalPlayers); i++) {
			//conku.player_turn.put(new Player(), false);

		}
		//System.out.println("buildmode da size" + conku.player_turn.size());
		totalPlayers = players + comp;
		
		
		for (int i=0; i<totalPlayers; i++) {
			if (totalPlayers == 2) {
				numOfInfant = 40;
			}
		    if (totalPlayers == 3) {
				numOfInfant = 35;
			}
			if (totalPlayers == 4) {
				numOfInfant = 30;
			}
			if (totalPlayers == 5) {
				numOfInfant = 25;
			}
			if (totalPlayers == 6) {
				numOfInfant = 20;
		}
	
		
	}
		return numOfInfant;

	}
	
	public int getPlayerNum() {  
	
	    players = (int) numPlayers.getSelectedItem(); 		
		comp = (int) numComp.getSelectedItem();
		totalPlayers = players + comp;
		
		
		
		return totalPlayers;
	}

}
