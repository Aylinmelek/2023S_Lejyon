package database;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import UI.*;
import domain.Deck;
import domain.Map;
import domain.Player;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Save {
	String fileName = "output.dat";
	
	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017"); //will change, ask TA
	MongoClient mongoClient = new MongoClient(uri);

	// Access the game database
	MongoDatabase database = mongoClient.getDatabase("game_database");

	// Access the game collection
	MongoCollection<Document> collection = database.getCollection("game_collection");
	
	// Create a sample game document
    Document gameDocument = new Document();
	    
    
	
	public void saveTheMapIO(Map map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map.getTerritories());
            oos.close();
            fos.close();
            System.out.println("Map has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the map to " + fileName);
            e.printStackTrace();
        }
	}
	
	public void saveTheOwnersOfTerritoriesIO(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(map.getTerritories().get(i).getOwner());
	            oos.close();
	            fos.close();
	            System.out.println("Owners of territories has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the Owners of territories to " + fileName);
	            e.printStackTrace();
	        
	        }
		}
	}
	
	public void saveTheContinentsIO(Map map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map.getContinents());
            oos.close();
            fos.close();
            System.out.println("Continents has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the continents to " + fileName);
            e.printStackTrace();
        }
	}
	
	public void saveTheArmyListOfTerritoriesIO(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(map.getTerritories().get(i).getArmyList());
	            oos.close();
	            fos.close();
	            System.out.println("ArmyList of a territory has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the ArmyList of a territory to " + fileName);
	            e.printStackTrace();
	        }
       }
	}
	
	public void saveThePlayersIO(ArrayList <Player> playerList) {
		try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerList);
            oos.close();
            fos.close();
            System.out.println("Players have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the players to " + fileName);
            e.printStackTrace();
        }
	}
	
	public void saveTheInfantryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getDeck().getInfantryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Infantry cardList of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the infantry cardList of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheInfantryListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getInfantryList());
	             oos.close();
	             fos.close();
	             System.out.println("Infantry List of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the infantry List of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheArtilleryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getDeck().getArtilleryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Artillery cardList of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Artillery cardList of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheArtilleryListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getArtilleryList());
	             oos.close();
	             fos.close();
	             System.out.println("Artillery List of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Artillery List of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheCavalryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getDeck().getCavalryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Cavalry cardList of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Cavalry cardList of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheCavalryListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getCavalryList());
	             oos.close();
	             fos.close();
	             System.out.println("Cavalry List of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Cavalry List of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	
	public void saveTheDeckOfPlayersIO(ArrayList <Player> playerList) {
		 for(int i = 0; i < playerList.size(); i++) {   
		        try {
		            FileOutputStream fos = new FileOutputStream(fileName);
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		            oos.writeObject(playerList.get(i).getDeck());
		            oos.close();
		            fos.close();
		            System.out.println("Deck of cards of " + playerList.get(i) + "have been saved to " + fileName);
		        } catch (IOException e) {
		            System.out.println("Error occurred while saving the deck of " + playerList.get(i) + "to " + fileName);
		            e.printStackTrace();
		        }
	     }
	}
	
	public void saveTheTerritoryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getDeck().getTerritoryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Territory cardList of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Territory cardList of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheTerritoryListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {   
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(playerList.get(i).getTerritoryList());
	             oos.close();
	             fos.close();
	             System.out.println("Territory List of" + playerList.get(i) + "have been saved to " + fileName);
	         } catch (IOException e) {
	             System.out.println("Error occurred while saving the Territory List of " + playerList.get(i) + "to " + fileName);
	             e.printStackTrace();
	         }
	 	}
	}
	
	public void saveTheDeckIO(Deck deck) { 
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(deck.getArtilleryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Artillery cardList of" + deck + "have been saved to " + fileName);
	         } 
	 		
	 		catch (IOException e) {
	             System.out.println("Error occurred while saving the Artillery cardList of " + deck + "to " + fileName);
	             e.printStackTrace();
	         }
	 		
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(deck.getInfantryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Infantry cardList of" + deck + "have been saved to " + fileName);
	         } 
	 		
	 		catch (IOException e) {
	             System.out.println("Error occurred while saving the Infantry cardList of " + deck + "to " + fileName);
	             e.printStackTrace();
	         }
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(deck.getCavalryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Cavalry cardList of" + deck + "have been saved to " + fileName);
	         } 
	 		
	 		catch (IOException e) {
	             System.out.println("Error occurred while saving the Cavalry cardList of " + deck + "to " + fileName);
	             e.printStackTrace();
	         }
	 		try {
	             FileOutputStream fos = new FileOutputStream(fileName);
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(deck.getTerritoryCardList());
	             oos.close();
	             fos.close();
	             System.out.println("Territory cardList of" + deck + "have been saved to " + fileName);
	         } 
	 		
	 		catch (IOException e) {
	             System.out.println("Error occurred while saving the Territory cardList of " + deck + "to " + fileName);
	             e.printStackTrace();
	         }
	 		
	 	
	}
	
	
	
	public void saveTheMapDB(Map map) {
		gameDocument.append("current_map", map.getTerritories());
	}
	
	public void saveTheContinentsDB(Map map) {
		gameDocument.append("current_contients", map.getContinents());
	}
	
	public void saveTheArmyListOfTerritoriesDB(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
    		gameDocument.append("armyList_of_a_territory" + i, map.getTerritories().get(i).getArmyList());   
    	}
	}
	
	public void saveTheOwnersTerritoriesDB(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
    		gameDocument.append("owner_of_a_territory" + i, map.getTerritories().get(i).getOwner());   
    	}
	}
	
	public void saveThePlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("Players" + i, playerList.get(i));   
    	}
	}
	
	public void saveTheInfantryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_infantry_cardList" + i, playerList.get(i).getDeck().getInfantryCardList());   
    	}
	}
	
	public void saveTheInfantryListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_infantry_List" + i, playerList.get(i).getInfantryList());   
    	}
	}
	
	public void saveTheCavalryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_cavalry_cardList" + i, playerList.get(i).getDeck().getCavalryCardList());   
    	}
	}
	
	public void saveTheCavalryListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_cavalry_List" + i, playerList.get(i).getCavalryList());   
    	}
	}
	
	public void saveTheArtilleryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_artillery_cardList" + i, playerList.get(i).getDeck().getArtilleryCardList());   
    	}
	}
	
	public void saveTheArtilleryListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_artillery_List" + i, playerList.get(i).getArtilleryList());   
    	}
	}
	
	public void saveTheTerritoryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_territory_cardList" + i, playerList.get(i).getDeck().getTerritoryCardList());   
    	}
	}
	
	public void saveTheTerritoryListOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_territory_List" + i, playerList.get(i).getTerritoryList());   
    	}
	}
	
	public void saveTheDeckOfPlayersDB(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("deck_of_players" + i, playerList.get(i).getDeck());   
    	}
	}
	
	public void saveTheDeckDB(Deck deck) { 
    		gameDocument.append("main_infantry_cardList", deck.getInfantryCardList())
    					.append("main_artillery_cardList", deck.getArtilleryCardList())
    					.append("main_cavalry_cardList", deck.getCavalryCardList())
    					.append("main_territory_cardList", deck.getTerritoryCardList());
	}
	
	
	
	// Insert the game document into the collection
    collection.insertOne(gameDocument);
    
    // Close the MongoDB connection
    mongoClient.close();

	
}
