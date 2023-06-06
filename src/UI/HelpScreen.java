package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpScreen extends JLayeredPane {
	JTextArea txtHelp = new JTextArea();
	JButton btnBack = new JButton("Back to Menu");
	public boolean helpMode=false;
	
	
	
	
	
	public HelpScreen() {
		super();
		initialize();
		addElements();
	}


	public void initialize()  {
	    setBackground(Color.DARK_GRAY);
	    setBounds(0, 54, 873, 451);
	    
	    setLayout(null);
	}
	
	
	public void addElements() {
		System.out.println("add elements");
		txtHelp.setText("The game is played on a political map of the world, divided into territories, which are grouped into continents. Turns rotate among players who control armies of playing pieces with which they attempt to capture \n"
	        		+ "territories from other players, with results determined by dice rolls. Players may form and dissolve alliances during the course of the game. On a player’s turn, he/she tries to capture territories by defeating his/her \n"
	        		+ "opponents’ armies. The goal of the game is to occupy every territory on the board and, in doing so, eliminate the other players. \n"
	        		+ "The game ends when one of the players conquers the whole world defeating all his/her enemies. \n"
	        		+ "\n"
	        		+ "Armies:\n"
	        		+ "There are 6 complete sets of armies, each containing 3 denominations of army pieces: Infantry (worth l), Cavalry (worth 5 Infantry), and Artillery (worth 10 Infantry, or 2 Cavalry). Start the game by \n"
	        		+ "placing Infantry pieces; later in the game, you may trade in 5 Infantry for 1 Cavalry, or 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.\n"
	        		+ "✪ Cards: At the beginning of any turn, you will pick a chance card, and at the end of any turn in which you have captured at least one territory, you will earn one territory or army card chosen randomly. \n"
	        		+ "Territory Cards: the aim of collecting territory cards is to conquer a continent without attacking. When the player collects all territory cards of a continent, the player conquers all territories of that continent \n"
	        		+ "without a need to attack these territories. \n"
	        		+ "✪ Army Cards: A player can trade army cards to gain an additional army if she/he has a set of 3 cards. He/she can place new armies in any territories she/he has. The rules of gaining armies is as follows:\n"
	        		+ "\n"
	        		+ "Trade: \n"
	        		+ "3 Infantry cards => 1 Cavalry\n"
	        		+ "2 Infantry cards + 1 Cavalry card => 2 Cavalry\n"
	        		+ "2 Infantry cards + 1 Artillery card => 2 Artillery\n"
	        		+ "1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery\n"
	        		+ "1 Artillery + 2 Cavalry cards => 3 Artillery\n"
	        		+ "\n"
	        		+ "Steps of a Player’s Turn:\n"
	        		+ "Picking a chance card and doing whatever the card says\n"
	        		+ "Getting and placing new armies\n"
	        		+ "Attacking, if the player chooses to, by rolling the dice\n"
	        		+ "Fortifying the position");
		txtHelp.setForeground(Color.LIGHT_GRAY);
		txtHelp.setFont(new Font("Kokonor", Font.PLAIN, 9));
		txtHelp.setEditable(false);
		txtHelp.setBackground(Color.DARK_GRAY);
		txtHelp.setBounds(19, 9 , 822, 400);
	    add(txtHelp);
	    
	    
        btnBack.setBounds(729, 517, 128, 29); 
        btnBack.setBackground(Color.DARK_GRAY);
       /* btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  	String action=e.getActionCommand();
            	
            	if ("Back to Game".equals(action)) {
            		System.out.print("start: ");
            		if (start==false) {
            			//layeredPane.add(startScreen);
            		    startScreen.setVisible(true);
            		    btnStart.setVisible(true);
            		    btnBack.setVisible(false);
            		    
           
            		}
            		else  {
            			System.out.println("else de");
            			//layeredPane.add(buildingMode);
            			startScreen.setVisible(false);
            		    buildingMode.setVisible(true);
            		    btnStart.setVisible(false);
            		    btnBack.setVisible(false);
            		}
            	
            		
            		helpScreen.setVisible(false);
            		btnBack.setVisible(false);
            		btnHelp.setVisible(true);
            		
            	
            		
            	}
        	}
        });*/
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        add(btnBack);
        //btnBack.setVisible(false);
	}
	
	
    
}
