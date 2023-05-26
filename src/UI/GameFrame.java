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
import domain.controller.conKUerorHandler;
import domain.ConKUeror;
import java.util.Hashtable;

public class GameFrame extends JFrame {

	static boolean start;
	private static final long serialVersionUID = 1L;
	static boolean init, build, playMode, loginMode = false;
	

	public static void main(String[] args) {

		//observer için ekledim
		ConKUeror conKUeror = new ConKUeror();
		Board board = new Board();
		conKUerorHandler conKUerorHandler = new conKUerorHandler(board);
		//////////
		
		GameFrame frame = new GameFrame();
		
		//observer için ekledim
		InitSharing sharing = new InitSharing(conKUerorHandler);
		//////////
	
		PlayingMode play = new PlayingMode();
		HelpScreen help = new HelpScreen();
		BuildingMode bmode = new BuildingMode();
		LoginScreen login = new LoginScreen();
		Grid grid = new Grid();
		frame.setSize(873, 600);
		frame.setBounds(0, 54, 873, 600);
		frame.setBackground(Color.DARK_GRAY);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayeredPane(login);
		frame.setVisible(true);

		login.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setLayeredPane(bmode);
				frame.revalidate();
				grid.setBounds(19, 69, 850, 350);
				bmode.add(grid);
				build = true;
				

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
					loginMode = false;
					start = true;
				}

			}
		});

		bmode.btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				init = true;
				build = false;

				int totalpeople = conKUeror.addToPlayerTurnHash(bmode);
				sharing.numPlay = totalpeople;
				sharing.addElements();
				System.out.println("buildmode da size" + totalpeople);

				frame.setLayeredPane(sharing);
				frame.revalidate();

				sharing.add(grid);

				JTextArea txtrYour = new JTextArea();
				txtrYour.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
				txtrYour.setForeground(Color.LIGHT_GRAY);
				txtrYour.setBackground(Color.DARK_GRAY);
				txtrYour.setText("You have " + bmode.addPlayers() + " Infantry.");
				txtrYour.setBounds(350, 450, 822, 263);
				sharing.add(txtrYour);
				

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

				frame.setLayeredPane(play);
				frame.revalidate();
				// grid.setVisible(true);
				grid.setBounds(19, 69, 850, 350);
				play.add(grid);
				playMode = true;
				init = false;
				

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
		conkueror.initialSharingOfTerritory(playerList, map);

	}

}