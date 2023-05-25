package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

public class GameFrame extends JFrame {

	static boolean start;
	private static final long serialVersionUID = 1L;
	static boolean init, build, playMode = false;
	ArrayList<Boolean> playerTurn = new ArrayList<Boolean>();
	

	public static void main(String[] args) {

		GameFrame frame = new GameFrame();
		//InitSharing sharing = new InitSharing();
		PlayingMode play = new PlayingMode();
		HelpScreen help = new HelpScreen();
		BuildingMode bmode = new BuildingMode();
		//InitSharing sharing = new InitSharing();
		LoginScreen login = new LoginScreen();
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBackground(Color.WHITE);
        btnStartGame.setBounds(733, 495, 117, 29);
        frame.add(btnStartGame);
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
					start = true;
				}

			}
		});
		
		bmode.btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitSharing sharing = new InitSharing();
				init = true;
				build = false;
				
				frame.setLayeredPane(sharing);
				frame.revalidate();
				bmode.getPlayerNum();
				//bmode.addPlayers();
				sharing.add(grid);
				sharing.addElements();
				JTextArea txtInfNum = new JTextArea();
				txtInfNum.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
				txtInfNum.setForeground(Color.LIGHT_GRAY);
				txtInfNum.setBackground(Color.DARK_GRAY);
				txtInfNum.setText("You have " + bmode.infNum() + " Infantry.");
				txtInfNum.setEditable(false);
				txtInfNum.setBounds(350, 450, 822, 263);
				sharing.add(txtInfNum);
				

			}
		});

		help.btnBack = new JButton("Back to Game");
		help.btnBack.setBounds(729, 517, 128, 29);

		help.btnBack.setBackground(Color.DARK_GRAY);
		help.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (start == true) {
					System.out.println("geldi mi");
					help.setVisible(false);
					frame.setLayeredPane(login);
					frame.revalidate();
					help.btnBack.setVisible(false);
					start = false;
				}
				
				else {
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

		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Toggle the visibility of the panels
				String action = e.getActionCommand();

				frame.setLayeredPane(play);
				frame.revalidate();
				// grid.setVisible(true);
				grid.setBounds(19, 69, 850, 350);
				play.add(grid);
				init = false;
				playMode = true;

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