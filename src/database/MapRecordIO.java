package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Army;
import domain.Continent;
import domain.Infantry;
import domain.InfantryCard;
import domain.Map;
import domain.Player;
import domain.Recordable;
import domain.Territory;
import domain.TerritoryCard;

public class MapRecordIO implements Recordable{
	String fileName = "output_map.dat";
	public void saveTheMapIO(Map map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
            System.out.println("Map has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the map to " + fileName);
            e.printStackTrace();
        }
	}
	

	public Map loadTheMapIO() {
		 try {
		        FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        Map map = (Map)ois.readObject();
		        ois.close();
		        fis.close();
		        System.out.println("Map has been loaded from " + fileName);
		        return map;
		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("Error occurred while loading the map from " + fileName);
		        e.printStackTrace();
		    }
		 return null;
	}

	public static void main(String[] args)  {

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
		
		MapRecordIO mio = new MapRecordIO();
		
		mio.saveTheMapIO(map);
		Map mapLoaded= mio.loadTheMapIO();
		
		
		System.out.println("");
		
		}
	
}
