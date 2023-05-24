package domain;

import java.util.ArrayList;

public class TestingBlackBox {
	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		// Should print "Player is created" 3 times
		Territory territory1 = new Territory();
		Territory territory2 = new Territory();
		Territory territory5 = new Territory();
		Territory territory6 = new Territory(); // Should print "Territory is created" 4 times
		territory1.getAdjacentTerritories().add(territory2);
		territory2.getAdjacentTerritories().add(territory1);
		territory5.getAdjacentTerritories().add(territory6);
		territory6.getAdjacentTerritories().add(territory5);// Should print "Territories are linked" 4 times
		territory1.setOwner(player1);
		territory2.setOwner(player2);
		territory5.setOwner(player3);
		territory6.setOwner(player3); // Should print "Owner of territory is seted" 4 times
		ArrayList<Army> armyList1 = new ArrayList<Army>();
		Infantry infantry1 = new Infantry();
		Infantry infantry2 = new Infantry();
		player3.getTerritoryList().add(territory5); // Should print "Player took a territory"
		player3.getTerritoryList().add(territory6); // Should print "Player took a territory"
		armyList1.add(infantry1); // Should print "Infantry is added to army"
		armyList1.add(infantry1); // Should print "Infantry is added to army"
		armyList1.add(infantry1); // Should print "Infantry is added to army"
		player1.getTerritoryList().add(territory1); // Should print "Player took a territory"
		player2.getTerritoryList().add(territory2); // Should print "Player took a territory"
		territory5.getArmyList().add(infantry2); // Should print "Infantry is placed to territory"
		territory5.getArmyList().add(infantry2); // Should print "Infantry is placed to territory"
		territory5.getArmyList().add(infantry2); // Should print "Infantry is placed to territory"
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(player1); // Should print "Player join the game"
		playerList.add(player2); // Should print "Player join the game"
		Map map = new Map();
		map.getTerritories().add(territory1); // Should print "Player join the game"
		map.getTerritories().add(territory2); // Should print "Player join the game"
		InfantryCard infantryCard = new InfantryCard();
		player1.getDeck().getInfantryCardList().add(infantryCard); // Should print "InfantryCard is placed to Deck"
		player1.getDeck().getInfantryCardList().add(infantryCard); // Should print "InfantryCard is placed to Deck"
		player1.getDeck().getInfantryCardList().add(infantryCard); // Should print "InfantryCard is placed to Deck"
		player1.tradeArmyCards(0); // Should print "Infantry Card is removed." 3 times and "Cavalry is added." once
		Continent continent = new Continent();
		Territory territory3 = new Territory();
		Territory territory4 = new Territory();
		TerritoryCard territoryCard1 = new TerritoryCard();
		TerritoryCard territoryCard2 = new TerritoryCard();
		player1.getTerritoryCardList().add(territoryCard1); // Should print "Player took a territory"
		player1.getTerritoryCardList().add(territoryCard2); // Should print "Player took a territory"
		continent.getTerritoryCardList().add(territoryCard1);
		continent.getTerritoryCardList().add(territoryCard2);
		continent.getTerritoryList().add(territory3);
		continent.getTerritoryList().add(territory4);
		player1.tradeTerritoryCards(continent);
		for (int i = 0; i < player1.getTerritoryList().size(); i++) {
			System.out.println("Player1 territoryList: ");
			System.out.println(player1.getTerritoryList().get(i)); // Should print territory object name
		}
		for (int i = 0; i < player1.getTerritoryCardList().size(); i++) {
			System.out.println("Player1 territoryCardList: ");
			System.out.println(player1.getTerritoryCardList().get(i)); // Should print territory object name
		}
		player1.placeArmy(territory4, infantry1); // Should print "Infantry is placed to territory"
		System.out.println("Army that is placed on Territory4: ");
		System.out.println(territory4.getArmyList().get(0)); // Should print armyPart object name
		System.out.println("Player 1's cavalries of army: ");
		System.out.println(player1.getCavalryList().get(0)); // Should print cavallary object name
		ArrayList<Army> armyList2 = new ArrayList<Army>();
		armyList2.add(infantry1);
		Map map2 = new Map();
		map2.getTerritories().add(territory3); // Should print territory is added
		map2.getTerritories().add(territory4);// Should print territory is added
		map2.getTerritories().add(territory1);// Should print territory is added
		map2.getTerritories().add(territory2);// Should print territory is added
		territory1.enable();
		territory2.enable();
		// territory3.enable();
		// territory4.enable();
		map2.checkReachability(territory1); // Should print territory name + is reachable
		map2.checkReachability(territory2); // Should print territory name + is reachable
		map2.checkReachability(territory3); // Should print territory name + is not reachable
		map2.checkReachability(territory4); // Should print territory name + is not reachable
		territory1.setArmyList(armyList1); // Should print "ArmyList of territory is set"
		territory2.setArmyList(armyList2); // Should print "ArmyList of territory is set"
		ConKUeror conkueror = new ConKUeror();
		Die die = new Die();
		conkueror.attack(player1, territory1, territory2, die); // Should print player name + can attack/is attacking
																// now/lose the attack
		conkueror.initialSharingOfTerritory(playerList, map); // Should print player name + will choose a territory 2
																// times
		conkueror.fortify(player3, territory5, territory6, 2); // Should print fortified from territoryName to
																// TerritoryName 2 times
		System.out.println(territory5.getArmyList().size()); // Should print 1
		System.out.println(territory6.getArmyList().size()); // Should print 2
	}
}
