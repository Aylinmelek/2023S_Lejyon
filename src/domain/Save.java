package domain;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import UI.*;

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
	
	public void saveTheMapDB(Map map) {
		gameDocument.append("current_map", map.getTerritories());
	}
	
	public void saveTheArmyListOfTerritoriesDB(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
    		gameDocument.append("armyList_of_a_territory" + i, map.getTerritories().get(i).getArmyList());   
    	}
	}
	
	public void saveThePlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("Players" + i, playerList.get(i));   
    	}
	}
	
	public void saveTheInfantryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("players'_infantry_cardList" + i, playerList.get(i).getDeck().getInfantryCardList());   
    	}
	}
	
	public void saveTheDeckOfPlayersIO(ArrayList <Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
    		gameDocument.append("deck_of_players" + i, playerList.get(i).getDeck());   
    	}
	}
	
	// Insert the game document into the collection
    collection.insertOne(gameDocument);
    
    // Close the MongoDB connection
    mongoClient.close();

	
}
