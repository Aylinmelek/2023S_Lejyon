package domain;

import UI.*;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class PlayerRecordDB implements AdapterRecord{
	
	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017"); //will change, ask TA
	MongoClient mongoClient = new MongoClient(uri);

	// Access the game database
	MongoDatabase database = mongoClient.getDatabase("game_database");

	// Access the game collection
	MongoCollection<Document> collection = database.getCollection("game_collection");
	
	// Create a sample game document
    Document gameDocument = new Document();
	    
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
	
	public void loadThePlayersDB(ArrayList <Player> playerList){
		for(int i = 0; i < playerList.size(); i++) {
			 String key = "Players" + i;
    		playerList.add(gameDocument.get(key));
    	}
	}
	
	public void loadTheTerritoryListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_territory_List" + i;
	        playerList.get(i).setTerritoryList((ArrayList<Territory>) gameDocument.get(key));
	    }
	}
	
	public void loadTheTerritoryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_territory_cardList" + i;
	        playerList.get(i).getDeck().setTerritoryCardList((ArrayList<Card>) gameDocument.get(key));
	    }
	}
	
	
	public void loadTheInfantryListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_infantry_List" + i;
	        playerList.get(i).setInfantryList((ArrayList<Infantry>) gameDocument.get(key));
	    }
	}
	
	public void loadTheInfantryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_infantry_cardList" + i;
	        playerList.get(i).getDeck().setInfantryCardList((ArrayList<InfantryCard>) gameDocument.get(key));
	    }
	}
	
	public void loadTheCavalryListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_cavalry_List" + i;
	        playerList.get(i).setCavalryList((ArrayList<Cavalry>) gameDocument.get(key));
	    }
	}
	
	public void loadTheCavalryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_cavalry_cardList" + i;
	        playerList.get(i).getDeck().setCavalryCardList((ArrayList<CavalryCard>) gameDocument.get(key));
	    }
	}
	
	public void loadTheArtilleryListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_artillery_List" + i;
	        playerList.get(i).setArtilleryList((ArrayList<Artillery>) gameDocument.get(key));
	    }
	}
	
	public void loadTheArtilleryCardListOfPlayersDB(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        String key = "players'_artillery_cardList" + i;
	        playerList.get(i).getDeck().setArtilleryCardList((ArrayList<ArtilleryCard>) gameDocument.get(key));
	    }
	}
	
	public void loadTheDeckOfPlayersDB(ArrayList <Player> playerList) {
		 for (int i = 0; i < playerList.size(); i++) {
		        String key = "deck_of_players" + i;
		        playerList.get(i).setDeck((Deck)gameDocument.get(key)); 
		        playerDecks.add(deck); //Ask TA
		    }
	}
	
	
	// Insert the game document into the collection
    collection.insertOne(gameDocument);
    
    // Close the MongoDB connection
    mongoClient.close();

}
