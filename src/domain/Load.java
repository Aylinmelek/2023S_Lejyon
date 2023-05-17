package domain;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import UI.*;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Load {
	String fileName = "output.dat";
    // Connect to MongoDB server
    MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017"); //will change, ask TA
    MongoClient mongoClient = new MongoClient(uri);

    // Access the game database
    MongoDatabase database = mongoClient.getDatabase("game_database");

    // Access the game collection
    MongoCollection<Document> collection = database.getCollection("game_collection");

    // Find the game document
    Document gameDocument = collection.find().first();
    
	public void loadThePlayersIO(ArrayList <Player> playerList){
		try {
	        FileInputStream fis = new FileInputStream(fileName);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        playerList = (ArrayList<Player>) ois.readObject();
	        ois.close();
	        fis.close();
	        System.out.println("Players have been loaded from " + fileName);
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error occurred while loading the players from " + fileName);
	        e.printStackTrace();
	    }
	}
	
	public void loadTheMapIO(Map map) {
		 try {
		        FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        map.setTerritories((ArrayList<Territory>) ois.readObject());
		        ois.close();
		        fis.close();
		        System.out.println("Map has been loaded from " + fileName);
		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("Error occurred while loading the map from " + fileName);
		        e.printStackTrace();
		    }
	}
	
	public void loadTheArmyListOfTerritoriesIO(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            map.getTerritories().get(i).setArmyList((ArrayList<Army>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("ArmyList of territory " + i + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the ArmyList of territory " + i + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheInfantryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).getDeck().setInfantryCardList((ArrayList<InfantryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Infantry cardList of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the infantry cardList of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheDeckOfPlayersIO(ArrayList <Player> playerList) {
		   
	    for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).setDeck((Deck) ois.readObject()); 
	            ois.close();
	            fis.close();
	            System.out.println("Deck of cards of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the deck of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadThePlayersDB(ArrayList <Player> playerList){
		for(int i = 0; i < playerList.size(); i++) {
			 String key = "Players" + i;
    		playerList.add(gameDocument.get(key));
    	}
	}
	
	public void loadTheMapDB(Map map) {
		 map.setTerritories((ArrayList<Territory>) gameDocument.get("current_map"));
	}
	
	public void loadTheArmyListOfTerritoriesDB(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        String key = "armyList_of_a_territory" + i;
	        map.getTerritories().get(i).setArmyList((ArrayList<Army>) gameDocument.get(key));
	    }
	}
	
	public void loadTheInfantryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_infantry_cardList" + i;
	        playerList.get(i).getDeck().setInfantryCardList((ArrayList<InfantryCard>) gameDocument.get(key));
	    }
	}
	
	public void loadTheDeckOfPlayersDB(ArrayList <Player> playerList) {
		 for (int i = 0; i < playerList.size(); i++) {
		        String key = "deck_of_players" + i;
		        playerList.get(i).setDeck((Deck)gameDocument.get(key)); 
		        playerDecks.add(deck); //Ask TA
		    }
	}

	
	
    
   
    
    
    
    
    
    
    

}
