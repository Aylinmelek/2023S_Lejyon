package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import domain.Army;
import domain.Board;
import domain.ConKUeror;
import domain.Continent;
import domain.Die;
import domain.Infantry;
import domain.InfantryCard;
import domain.Map;
import domain.Player;
import domain.Territory;
import domain.TerritoryCard;
import domain.controller.ConKUerorHandler;
import domain.ConKUeror;
import java.util.Hashtable;

public class GameFrame extends JFrame {

	static boolean start;
	private static final long serialVersionUID = 1L;
	public static Board board = new Board();
	public static ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
	//static boolean init, build, playMode, loginMode = false;
	public static InitSharing sharing = new InitSharing(conKUerorHandler);
	//////////

	public static PlayingMode play = new PlayingMode();
	public static HelpScreen help = new HelpScreen();
	public static BuildingMode bmode = new BuildingMode();
	public static LoginScreen login = new LoginScreen();
	public static ArrayList<String> tempPlayer = new ArrayList<String>();

	public static void main(String[] args) {

		GameFrame frame = new GameFrame();
		
		frame.setSize(873, 600);
		frame.setBounds(0, 54, 873, 600);
		frame.setBackground(Color.DARK_GRAY);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayeredPane(login);
		frame.setVisible(true);
		
		
		
		login.btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setLayeredPane(bmode);
				frame.revalidate();
				int totalPeople = sharing.conKUeror.addToPlayerList(login);
				tempPlayer = login.addNamesToArrayList();
				System.out.println("total people" + totalPeople);
				
				for(int i =0;i<totalPeople; i++) {
					System.out.println(sharing.conKUeror.playerList.get(i));
				}
				
				for (int i =0;i<totalPeople;i++) {
					sharing.conKUeror.playerList.get(i).setName(tempPlayer.get(i));
				}
				for(int i =0;i<totalPeople; i++) {
					
					System.out.println("player names" + sharing.conKUeror.playerList.get(i).getName()); 
				}
		
				bmode.build = true;
				
				JTextArea dispInfant = new JTextArea();
				dispInfant.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
				dispInfant.setForeground(Color.LIGHT_GRAY);
				dispInfant.setBackground(Color.DARK_GRAY);
				dispInfant.setText("Every Player has " + login.addPlayers(login.getPlayerNum()) + " Infantry.");
				dispInfant.setEditable(false);
				
				dispInfant.setBounds(150, 430, 822, 50);
				bmode.add(dispInfant);
				
				 JTextArea txtdisable = new JTextArea();
				 txtdisable.setBounds(150, 490, 822, 50);
			     txtdisable.setText("Choose the territories you want to disable");
			     txtdisable.setForeground(Color.LIGHT_GRAY);
			     txtdisable.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
			     txtdisable.setEditable(false);
			     txtdisable.setBackground(Color.DARK_GRAY);
			     bmode.add(txtdisable);
			        
				

			}
		});

		login.btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (start == false) {
					help.initialize();
					help.addElements();
					frame.setLayeredPane(help);
					help.setVisible(true);
					frame.revalidate();
					login.loginMode = false;
					start = true;
					
				
				}
				
				

			}
		});
		/*bmode.btnNext.setEnabled(false);
		if (bmode.addPlayers(bmode.getPlayerNum()) >= 20 && bmode.addPlayers(bmode.getPlayerNum()) <= 40) {
			bmode.btnNext.setEnabled(true);
			bmode.addPlayers(bmode.getPlayerNum());
			
		}*/
		bmode.btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				sharing.init = true;
				bmode.build = false;

				
				
				sharing.numPlay = login.getPlayerNum();
				sharing.addElements();
				frame.setLayeredPane(sharing);
				frame.revalidate();

				sharing.add(bmode.grid);
		
				
				for (int i=0; i<sharing.conKUeror.playerList.size(); i++ ) {
					sharing.conKUeror.playerList.get(i).setNumOfInfantry(login.addPlayers(login.getPlayerNum()));
				}
				
				sharing.conKUeror.addToList(login.addPlayers(login.getPlayerNum()));
				

			}
		});

		help.btnBack = new JButton("Back to Game");
		help.btnBack.setBounds(729, 517, 128, 29);

		help.btnBack.setBackground(Color.DARK_GRAY);
		help.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (start == true) {
					help.setVisible(false);
					frame.setLayeredPane(login);
					frame.revalidate();
					help.btnBack.setVisible(false);
					start = false;

				} else {
					// layeredPane.add(buildingMode);
					login.setVisible(false);
					bmode.setVisible(true);
					login.btnLogin.setVisible(false);
					// btnResume.setVisible(false);
					help.btnBack.setVisible(false);
				}

				help.setVisible(false);
				help.btnBack.setVisible(false);
				login.btnHelp.setVisible(true);
				// btnResume.setVisible(true);
				start = true;
			}
		});

		sharing.btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Toggle the visibility of the panels
				String action = e.getActionCommand();
				play.btnTer.addActionListener(new ActionListener() {
			     	public void actionPerformed(ActionEvent e) {
			     		bmode.grid.terCard.setVisible(true);
			
			     	}
			     	
			     }
			
			     );
				play.btnTer.setBounds(27, 437, 118, 30);
			    play.add(play.btnTer);
				play.addElements();
				frame.setLayeredPane(play);
				frame.revalidate();
				// grid.setVisible(true);
				//grid.setBounds(19, 69, 850, 350);
				play.add(bmode.grid);
				
				

			}
		});
		/*
		Player player1 = new Player();
		Player player2 = new Player();
		Territory territory1 = new Territory();
		Territory territory2 = new Territory();
		territory1.getAdjacentTerritories().add(territory2);
		territory2.getAdjacentTerritories().add(territory1);
		territory1.setOwner(player1);
		territory2.setOwner(player2);
		ArrayList<Army> armyList1 = new ArrayList<Army>();
		Infantry infantry1 = new Infantry();
		armyList1.add(infantry1);
		armyList1.add(infantry1);
		armyList1.add(infantry1);
		player1.getTerritoryList().add(territory1);
		player2.getTerritoryList().add(territory2);
		ArrayList<Player> playerList = new ArrayList<Player>();
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
		ArrayList<Army> armyList2 = new ArrayList<Army>();
		armyList2.add(infantry1);

		Map map2 = new Map();
		map2.getTerritories().add(territory3);
		map2.getTerritories().add(territory4);
		map2.getTerritories().add(territory1);
		map2.getTerritories().add(territory2);
		territory1.enable();
		territory2.enable();
		// territory3.enable();
		// territory4.enable();
		map2.checkReachability(territory1);
		map2.checkReachability(territory2);
		map2.checkReachability(territory3);
		map2.checkReachability(territory4);
		territory1.setArmyList(armyList1);
		territory2.setArmyList(armyList2);
		ConKUeror conkueror = new ConKUeror();
		Die die = new Die();
		conkueror.attack(player1, territory1, territory2, die);
		conkueror.initialSharingOfTerritory(playerList, map);*/

	}

}