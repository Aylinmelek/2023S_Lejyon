package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.Army;
import domain.Board;
import domain.Continent;
import domain.Die;
import domain.Infantry;
import domain.InfantryCard;
import domain.Map;
import domain.Player;
import domain.Territory;
import domain.TerritoryCard;
import domain.controller.ConKUerorHandler;
import java.util.Hashtable;


public class GameFrame extends JFrame {
	
	//static boolean start;
	private static final long serialVersionUID = 1L;
	//public static Board board = new Board();
	//public static ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
	//static boolean init, build, playMode, loginMode = false;
	public static ConKUerorHandler conKUerorHandler = new ConKUerorHandler();

	public static InitSharing sharing = new InitSharing();
	//////////
	static boolean taken, takenHelper;
	public static PlayingMode play = new PlayingMode();
	public static BuildingMode bmode = new BuildingMode();
	public static LoginScreen login = new LoginScreen();
	public static MenuScreen menu = new MenuScreen();
	public static ArrayList<String> tempPlayer = new ArrayList<String>();
	public static ArrayList<String> nameSorted = new ArrayList<String>();
	public static ArrayList<Player> playerArray = new ArrayList<Player>();
	public static ArrayList<String> playerName = new ArrayList<String>();
	
	static int counter=0;
	static int counter2=0;
	public static void main(String[] args) {
		
		GameFrame frame = new GameFrame();
	
		JButton btnMenu = new JButton();
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
				System.out.println("real: "+ login.getRealPlayer()+"comp: " +login.getCompPlayer());
				frame.add(login.btnMenu);
				playerArray = conKUerorHandler.createPlayer(login.getRealPlayer(), login.getCompPlayer());
				
				playerName = conKUerorHandler.createPlayerName(login.getPlayerNum());
				
				play.handler.createTerCard(play.handler.getBoard().continent1, play.handler.getBoard().continent2, play.handler.getBoard().continent3, play.handler.getBoard().continent4, play.handler.getBoard().continent5, play.handler.getBoard().continent6, play.handler.getBoard().deck);

				
				System.out.println("playerArraysize: "+playerArray.size());
				int totalPeople = login.getPlayerNum();
				tempPlayer = login.addNamesToArrayList();
				System.out.println("total people" + totalPeople);
				//JPanel playerNames = new JPanel();
				//JTextArea txtPlayerNames = new JTextArea();
				//txtPlayerNames.setBounds(212, 6, 453, 43);
				//StringBuilder playerNamesBuilder = new StringBuilder();
				for(int i =0;i<totalPeople; i++) {
					System.out.println(playerName.get(i));
				}
				
				for (int i =0;i<totalPeople;i++) {
					playerName.set(i, tempPlayer.get(i));
					//playerNamesBuilder.append(tempPlayer.get(i)).append("      ");
					
				}
				for (Player i:playerArray) {
					i.setPlayerName(playerName.get(counter));
					System.out.println("counter: "+playerName.get(counter));
					counter++;
					
				}
				
				
				/*txtPlayerNames.setText(playerNamesBuilder.toString());
				txtPlayerNames.setForeground(Color.LIGHT_GRAY);
				txtPlayerNames.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
				txtPlayerNames.setEditable(false);
				txtPlayerNames.setBackground(Color.DARK_GRAY);
				txtPlayerNames.setBounds(70, 6, 780, 43);
				play.add(txtPlayerNames);*/

				for(int i =0;i<totalPeople; i++) {
					System.out.println(playerArray.get(i));
					conKUerorHandler.getBoard().createInfantry(login.addPlayers(totalPeople),playerArray.get(i));
				}
				play.handler.createMainDeck(10, 10, play.handler.getBoard().deck);
				for (int i =0;i<totalPeople;i++) {				
					playerName.set(i, tempPlayer.get(i));
				}
				for(int i =0;i<totalPeople; i++) {			
					System.out.println("player names" + playerName.get(i));
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
			        
				
			     // Players turn number is sorted
			       
			}
		});
		
		

		login.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (login.loginMode == false) {

					menu.setVisible(true);
					login.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					login.loginMode = true;
					menu.menuMode=true;
					
				
				}
				
				else {
					menu.setVisible(true);
					login.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					//login.loginMode = false;
					
				}
				menu.setVisible(true);
				//login.setVisible(false);
				

			}
		});
		bmode.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (bmode.build == false) {
					menu.setVisible(true);
					bmode.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					bmode.build = true;
					menu.menuMode=true;
					
				
				}
				
				else {
					menu.setVisible(true);
					bmode.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					//login.loginMode = false;
					
				}
				menu.setVisible(true);
				//login.setVisible(false);
				

			}
		});
		sharing.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (sharing.init == false) {
					menu.setVisible(true);
					sharing.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					sharing.init = true;
					menu.menuMode=true;
					
				
				}
				
				else {
					menu.setVisible(true);
					sharing.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					//login.loginMode = false;
					
				}
				menu.setVisible(true);
				//login.setVisible(false);
				

			}
		});
		play.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (play.playMode == false) {
					menu.setVisible(true);
					play.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					play.playMode = true;
					menu.menuMode=true;
					
				
				}
				
				else {
					menu.setVisible(true);
					play.setVisible(false);
					frame.setLayeredPane(menu);
					frame.revalidate();
					//login.loginMode = false;
					
				}
				menu.setVisible(true);
				//login.setVisible(false);
				

			}
		});
		
		
		
	
		bmode.btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				frame.add(login.btnMenu);
				for(int k = 0; k< play.handler.getBoard().map.getTerritories().size(); k++)
				{	
					play.handler.getBoard().map.checkReachability(play.handler.getBoard().map.getTerritories().get(k));
					if(!play.handler.getBoard().map.getTerritories().get(k).isEnabled())
					{
						for(int a = 0; a < bmode.grid.ROWS; a++)
						{
							for(int b = 0; b < bmode.grid.COLUMNS; b++)
							{
								
								if(play.handler.getBoard().map.getTerritories().get(k).isTerritory(a,b) != null && play.handler.getBoard().map.getTerritories().get(k).isTerritory(a,b).equals(play.handler.getBoard().map.getTerritories().get(k)))
								{
									if (bmode.grid.gridColors[a][b] != bmode.grid.blue) {
										bmode.grid.gridColors[a][b] = Color.GRAY;
										bmode.grid.repaint();
								}
								}
								
						}
					}
				}}
				
				
					String action = e.getActionCommand();
					sharing.init = true;
					bmode.build = false;

					sharing.numPlay = login.getPlayerNum();
 					sharing.addElements();
 					frame.setLayeredPane(sharing);
 					frame.revalidate();
					
					

					sharing.add(bmode.grid);
				
				
		
				
				/*for (int i=0; i<sharing.conKUeror.playerList.size(); i++ ) {
					sharing.conKUeror.playerList.get(i).setNumOfInfantry(login.addPlayers(login.getPlayerNum()));
				}*/
				
				
				//sharing.conKUeror.addToList(login.addPlayers(login.getPlayerNum()));
				

			}
		});
		
		 menu.btnBack.setBackground(Color.DARK_GRAY);
		 menu.btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		if (login.loginMode==true) {
	        			menu.setVisible(false);
	 					frame.setLayeredPane(login);
	 					frame.revalidate();
	 					login.loginMode=false;
	         		    
	        		}
	        		else if (bmode.build==true) {
	        			menu.setVisible(false);
	 					frame.setLayeredPane(bmode);
	 					frame.revalidate();
	 					bmode.build=false;
	        		}
	        		else if (sharing.init==true) {
	        			menu.setVisible(false);
	 					frame.setLayeredPane(sharing);
	 					frame.revalidate();
	 					sharing.init=false;
	        		}
	        		else if (play.playMode==true) {
	        			menu.setVisible(false);
	 					frame.setLayeredPane(play);
	 					frame.revalidate();
	 					play.playMode=false;
	        		}
	        		else {


	         			login.setVisible(false);
	         		    bmode.setVisible(true);
	         		    sharing.setVisible(true);
	         		    play.setVisible(true);
	         		    login.btnLogin.setVisible(false);
	         		    menu.btnBack.setVisible(false);
	        		}
         	
	         		login.btnMenu.setVisible(true);
	         		login.setVisible(true);
	         		login.btnMenu.setVisible(true);
	         		
	         		bmode.btnMenu.setVisible(true);
	         		bmode.setVisible(true);
	         		
	         		sharing.btnMenu.setVisible(true);
	         		sharing.setVisible(true);
	         		
	         		play.btnMenu.setVisible(true);
	         		play.setVisible(true);
       	
	        	}	
	        });
		 
		 menu.btnHelp.setBackground(Color.DARK_GRAY);
		 menu.btnHelp.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		if (menu.menuMode==true) {
	        			menu.setVisible(false);
	 					frame.setLayeredPane(menu.help);
	 					frame.revalidate();
	 					menu.help.helpMode=true;
	         		    
	        		}
	        		else {
   
	         			login.setVisible(false);
	         		    bmode.setVisible(true);
	         		    login.btnLogin.setVisible(false);
	         		    menu.btnHelp.setVisible(false);
	        		}
         	
	         		login.btnMenu.setVisible(true);
	         		login.setVisible(true);
	         		login.btnMenu.setVisible(true);
       	
	        	}	
	        });
		 
		 menu.help.btnBack.setBackground(Color.DARK_GRAY);
		 menu.help.btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		if (menu.help.helpMode==true) {
	        			menu.help.setVisible(false);
	 					frame.setLayeredPane(menu);
	 					frame.revalidate();
	 					
	         		    
	        		}
	        		else if (login.loginMode==true || bmode.build==true){
   
	         			login.setVisible(false);
	         		    bmode.setVisible(true);
	         		    login.btnLogin.setVisible(false);
	         		    menu.help.btnBack.setVisible(false);
	        		}
         	
	         		//login.btnMenu.setVisible(true);
	        		menu.btnBack.setVisible(true);
	        		menu.btnHelp.setVisible(true);
	        		menu.btnSave.setVisible(true);
	         		menu.setVisible(true);
	         		//login.btnMenu.setVisible(true);
       	
	        	}	
	        });
	        
		/*menu.btnBack = new JButton("Back to Game");
		menu.btnBack.setBounds(729, 517, 128, 29);

		menu.btnBack.setBackground(Color.DARK_GRAY);
		menu.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (start == true) {
					menu.setVisible(false);
					frame.setLayeredPane(login);
					frame.revalidate();
					menu.btnBack.setVisible(false);
					start = false;

				} else {
					// layeredPane.add(buildingMode);
					login.setVisible(false);
					bmode.setVisible(true);
					login.btnLogin.setVisible(false);
					// btnResume.setVisible(false);
					menu.btnBack.setVisible(false);
				}

				menu.setVisible(false);
				menu.btnBack.setVisible(false);
				//login.btnMenu.setVisible(true);
				// btnResume.setVisible(true);
				start = true;
			}
		});*/


		sharing.btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Toggle the visibility of the panels

				
				for(int i = 0; i< play.handler.getBoard().map.getTerritories().size(); i++)
				{	
					/*play.handler.getBoard().map.checkReachability(play.handler.getBoard().map.getTerritories().get(i));
					if(!play.handler.getBoard().map.getTerritories().get(i).isEnabled())
					{
						play.handler.getBoard().map.getTerritories().get(i).setColor(Color.CYAN);
					}*/
					if(play.handler.getBoard().map.getTerritories().get(i).getOwner() == null && play.handler.getBoard().map.getTerritories().get(i).isEnabled())
					{
						taken = false;
						System.out.println("taken false");
						break;

						
					}
					else
 					{
 						taken = true;
 						System.out.println("taken true");
 					}

 				}
 				//if(taken)
 				//{
 					String action = e.getActionCommand();
 					play.numFortify.setEnabled(false);
 					play.btnTer.addActionListener(new ActionListener() {
 				     	public void actionPerformed(ActionEvent e) {
 				     		bmode.grid.terCard.setVisible(true);
 				     		//Burada update frame'i cagiracaksin

 				     	}

 				     });
 					play.btnTer.setBounds(27, 437, 118, 30);
 				    play.add(play.btnTer);
 					play.addElements();
 					frame.setLayeredPane(play);
 					frame.revalidate();
 					// grid.setVisible(true);
 					//grid.setBounds(19, 69, 850, 350);
 					play.add(bmode.grid);
 					sharing.init = false;

 					 //play.sort(playerArray);						
 					 play.playMode = true;

 					 System.out.println(play.playMode);
 					 play.sort(playerArray);

 					 for (Player i: playerArray) {
 						 System.out.println("i: "+i);
 						 nameSorted.add(i.getName());
 						 System.out.println("nameSorted: "+nameSorted.get(counter2));
 						 counter2++;

 					 }
 					 JTextArea txtPlayerNames = new JTextArea();
 					 StringBuilder playerNamesBuilder = new StringBuilder();
 					 for (int i =0;i<login.getPlayerNum();i++) {

 							playerNamesBuilder.append(nameSorted.get(i)).append("      ");

 						}

 					 txtPlayerNames.setText(playerNamesBuilder.toString());
 						txtPlayerNames.setForeground(Color.LIGHT_GRAY);
 						txtPlayerNames.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
 						txtPlayerNames.setEditable(false);
 						txtPlayerNames.setBackground(Color.DARK_GRAY);
 						txtPlayerNames.setBounds(70, 6, 780, 43);
 						play.add(txtPlayerNames);
				
					
				 

					play.playMode = true;
					System.out.println(play.playMode);
				//}
				
				


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