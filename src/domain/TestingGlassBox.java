package domain;
import java.util.ArrayList;

public class TestingGlassBox {
	public static void main(String[] args) {
		
		Player player1 = new Player();
		assert player1 != null : "Player cannot be created";

		Player player2 = new Player();
		assert player2 != null : "Player cannot be created";

		Player player3 = new Player();
		assert player3 != null : "Player cannot be created";
		
		Territory territory1 = new Territory();
		assert territory1 != null : "Territory cannot be created";

		Territory territory2 = new Territory();
		assert territory2 != null : "Territory cannot be created";

		Territory territory5 = new Territory();
		assert territory5 != null : "Territory cannot be created";

		Territory territory6 = new Territory();
		assert territory6 != null : "Territory cannot be created";
    
		territory1.getAdjacentTerritories().add(territory2);
		assert territory1.getAdjacentTerritories().contains(territory2) : "Territories cannot be linked";

		territory2.getAdjacentTerritories().add(territory1);
		assert territory2.getAdjacentTerritories().contains(territory1) : "Territories cannot be linked";

		territory5.getAdjacentTerritories().add(territory6);
		assert territory5.getAdjacentTerritories().contains(territory6) : "Territories cannot be linked";
		
    	territory6.getAdjacentTerritories().add(territory5);
    	assert territory6.getAdjacentTerritories().contains(territory5) : "Territories cannot be linked";
    	
		territory1.setOwner(player1);
		assert territory1.getOwner() == player1 : "Owner of territory cannot be set";

		territory2.setOwner(player2);
		assert territory2.getOwner() == player2 : "Owner of territory cannot be set";
		
		territory5.setOwner(player3);
		assert territory5.getOwner() == player3 : "Owner of territory cannot be set";

		territory6.setOwner(player3);
		assert territory6.getOwner() == player3 : "Owner of territory cannot be set";
		
    	ArrayList <Army> armyList1 = new ArrayList<Army>();
    	Infantry infantry1 = new Infantry();
    	Infantry infantry2 = new Infantry();
    	territory5.getArmyList().add(infantry2);
    	territory5.getArmyList().add(infantry2);
    	territory5.getArmyList().add(infantry2);
    	
    	assert armyList1.add(infantry1) : "Infantry cannot be added to army";
    	assert armyList1.add(infantry1) : "Infantry cannot be added to army";
    	assert armyList1.add(infantry1) : "Infantry cannot be added to army";
    	

    	player1.getTerritoryList().add(territory1);
    	player2.getTerritoryList().add(territory2);
    	player3.getTerritoryList().add(territory5);
    	player3.getTerritoryList().add(territory6);
    	
    	ArrayList <Player> playerList = new ArrayList<Player>();
    	boolean isPlayer1Added = playerList.add(player1);
    	assert isPlayer1Added : "Player cannot join the game";

    	boolean isPlayer2Added = playerList.add(player2);
    	assert isPlayer2Added : "Player cannot join the game";

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
    		System.out.println(player1.getTerritoryList().get(i)); //Should print territory object name
    	}
    	for (int i = 0; i < player1.getTerritoryCardList().size(); i++) {
    		System.out.println("Player1 territoryCardList: ");
    		System.out.println(player1.getTerritoryCardList().get(i));  //Should print territory object name
    	}
    	
    	player1.placeArmy(territory4, infantry1);
    	System.out.println("Army that is placed on Territory4: ");
    	System.out.println(territory4.getArmyList().get(0));   //Should print armyPart object name
    	
    	System.out.println("Player 1's cavalries of army: ");
    	System.out.println(player1.getCavalryList().get(0));  //Should print cavallary object name  	
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
    	map2.checkReachability(territory1);       //Should print territory name + is reachable  
    	map2.checkReachability(territory2);	  //Should print territory name + is reachable  
    	map2.checkReachability(territory3);	  //Should print territory name + is not reachable  
    	map2.checkReachability(territory4);	  //Should print territory name + is not reachable  
    	
    	territory1.setArmyList(armyList1);   	   
    	territory2.setArmyList(armyList2);
    	ConKUeror conkueror = new ConKUeror();
    	Die die = new Die();
    	conkueror.attack(player1, territory1, territory2, die); //Should print player name + can attack/is attacking now/lose the attack 
    	conkueror.initialSharingOfTerritory(playerList, map);   //Should print player name + will choose a territory 2 times
    	conkueror.fortify(player3, territory5, territory6, 2); //Should print fortified from territoryName to TerritoryName 2 times
    	System.out.println(territory5.getArmyList().size()); //Should print 1
    	System.out.println(territory6.getArmyList().size()); //Should print 2
    }
}
