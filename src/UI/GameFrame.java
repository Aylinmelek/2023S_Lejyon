package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import domain.Army;
import domain.ConKUeror;
import domain.Continent;
import domain.Die;
import domain.Infantry;
import domain.InfantryCard;
import domain.Map;
import domain.Player;
import domain.Territory;
import domain.TerritoryCard;

public class GameFrame extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	//GameFrame frame = new GameFrame();
	
	/*public void initialize() {
		setSize(873, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}*/

	public static void main(String[] args) {
	    	GameFrame frame = new GameFrame();
	    	InitSharing sharing = new InitSharing();
	    	PlayingMode play = new PlayingMode();
	    	HelpScreen help = new HelpScreen();
	    	BuildingMode bmode = new BuildingMode();
	    	LoginScreen login = new LoginScreen();
	        frame.setSize(873, 600);
	        System.out.println("main");
	        frame.setBounds(0, 54, 873, 600);
			frame.setBackground(Color.DARK_GRAY);
			Grid grid = new Grid();
		  
			
			
			
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        frame.setLayeredPane(login);
	        login.initialize();
	        login.addElements();
	        frame.setVisible(true);
	        
	        login.btnLogin.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		bmode.initialize();
	        		bmode.addElements();
					frame.setLayeredPane(bmode);
					frame.revalidate();
					frame.add(grid);
					
					
				        
	        		
	        	}	
	        });
	        
	              
	        login.btnHelp.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		help.initialize();
	        		help.addElements();
					frame.setLayeredPane(help);
					frame.revalidate();
	        	}	
	        });
	        
	        bmode.btnNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String action=e.getActionCommand();
	        		/*loginScreen.setVisible(!loginScreen.isVisible());
	            	if ("Next".equals(action)) {
	            		
	            		initSharing.setVisible(true);
	            		buildingMode.setVisible(false);
	            		
	            		btnNext.setVisible(false);
	            		building=true;
	            		
	            		
	            		
	            		gridPanel_1.setVisible(true);
	            		initSharing.add(gridPanel_1);
	                 
	                   // dieLabel.setIcon(die1);
	            		
	            		
	            	}*/
	        		
	        		
	        		sharing.initialize();
	        		sharing.addElements();
					frame.setLayeredPane(sharing);
					frame.revalidate();
					
					grid.setVisible(true);
					grid.setBounds(19, 69 , 850, 350);
				    sharing.add(grid);
				   // bmode.armyNum();
				    
				    JTextArea txtrYour = new JTextArea();
					txtrYour.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
					txtrYour.setForeground(Color.LIGHT_GRAY);
					txtrYour.setBackground(Color.DARK_GRAY);
					txtrYour.setText("You have " + bmode.armyNum() +  " Infantry.");
					txtrYour.setBounds(350, 450, 822, 263);
					sharing.add(txtrYour);
					
			
					
		
	        	}
	        });
	        
	        sharing.btnStartGame.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		  // Toggle the visibility of the panels
	            	String action=e.getActionCommand();
	            	
	            	/*if ("Start Game".equals(action)) {
	            		layeredPane.add(playingMode, Integer.valueOf(4));
	            		playingMode.setVisible(true);
	            		//startScreen.removeAll();
	            		//btnStart.setVisible(false);
	            		btnBack.setVisible(false);
	            		init=true;
	            		//playingMode.add(gridPanel);
	            		//gridPanel.setVisible(true);
	            		playingMode.add(gridPanel_1);
	            		gridPanel_1.setVisible(true);
	            		
	         
	            	
	            	}
	        	playingMode.setVisible(true);
	        	initSharing.setVisible(false);
	        	}*/
	            	
	            	play.initialize();
	            	play.addElements(grid.terCard);
					frame.setLayeredPane(play);
					frame.revalidate();
					grid.setVisible(true);
					grid.setBounds(19, 69 , 850, 350);
				    play.add(grid);
				        
	        	}
	        });
	          
	        Player player1 = new Player(); 
	    	Player player2 = new Player(); 
	    	Territory territory1 = new Territory();
	    	Territory territory2 = new Territory();
	    	territory1.getAdjacentTerritories().add(territory2);
	    	territory2.getAdjacentTerritories().add(territory1);
	    	territory1.setOwner(player1);
	    	territory2.setOwner(player2);
	    	ArrayList <Army> armyList1 = new ArrayList<Army>();
	    	Infantry infantry1 = new Infantry();
	    	armyList1.add(infantry1);
	    	armyList1.add(infantry1);
	    	armyList1.add(infantry1);
	    	player1.getTerritoryList().add(territory1);
	    	player2.getTerritoryList().add(territory2);
	    	ArrayList <Player> playerList = new ArrayList<Player>();
	    	playerList.add(player1);
	    	playerList.add(player2);
	    	Map map = new Map();
	    	map.getTerritories().add(territory1);
	    	map.getTerritories().add(territory2);
	    	InfantryCard infantryCard = new InfantryCard();
	    	player1.getDeck().getInfantryCardList().add(infantryCard);
	    	player1.getDeck().getInfantryCardList().add(infantryCard);
	    	player1.getDeck().getInfantryCardList().add(infantryCard);
	    	player1.tradeArmyCards(0);
	    	
	    	Continent continent = new Continent();
	    	Territory territory3 = new Territory();
	    	Territory territory4 = new Territory();
	    	TerritoryCard territoryCard1 = new TerritoryCard();
	    	TerritoryCard territoryCard2 = new TerritoryCard();
	    	player1.getTerritoryCardList().add(territoryCard1);
	    	player1.getTerritoryCardList().add(territoryCard2);
	    	continent.getTerritoryCardList().add(territoryCard1);
	    	continent.getTerritoryCardList().add(territoryCard2);
	    	continent.getTerritoryList().add(territory3);
	    	continent.getTerritoryList().add(territory4);
	    	player1.tradeTerritoryCards(continent);
	    	for (int i = 0; i < player1.getTerritoryList().size(); i++) {
	    		System.out.println("Player1 territoryList: ");
	    		System.out.println(player1.getTerritoryList().get(i));
	    	}
	    	for (int i = 0; i < player1.getTerritoryCardList().size(); i++) {
	    		System.out.println("Player1 territoryCardList: ");
	    		System.out.println(player1.getTerritoryCardList().get(i));
	    	}
	    	
	    	player1.placeArmy(territory4, infantry1);
	    	System.out.println("Army that is placed on Territory4: ");
	    	System.out.println(territory4.getArmyList().get(0));
	    	
	    	System.out.println("Player 1's cavalries of army: ");
	    	System.out.println(player1.getCavalryList().get(0));    	
	    	ArrayList <Army> armyList2 = new ArrayList<Army>();
	    	armyList2.add(infantry1);
	    	
	    	Map map2 = new Map();
	    	map2.getTerritories().add(territory3);
	    	map2.getTerritories().add(territory4);
	    	map2.getTerritories().add(territory1);
	    	map2.getTerritories().add(territory2);
	    	territory1.enable();
	    	territory2.enable();
	    	//territory3.enable();
	    	//territory4.enable();
	    	map2.checkReachability(territory1);
	    	map2.checkReachability(territory2);
	    	map2.checkReachability(territory3);
	    	map2.checkReachability(territory4);
	    	
	    	territory1.setArmyList(armyList1);
	    	territory2.setArmyList(armyList2);
	    	ConKUeror conkueror = new ConKUeror();
	    	Die die = new Die();
	    	conkueror.attack(player1, territory1, territory2, die);
	    	conkueror.initialSharingOfTerritory(playerList, map);

}
	
	
}