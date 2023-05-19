package domain;

import UI.*;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class MapRecordDB implements AdapterRecord{
	
	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017"); //will change, ask TA
	MongoClient mongoClient = new MongoClient(uri);

	// Access the game database
	MongoDatabase database = mongoClient.getDatabase("game_database");

	// Access the game collection
	MongoCollection<Document> collection = database.getCollection("game_collection");
	
	// Create a sample game document
    Document gameDocument = new Document();
	    
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
	
	public void loadTheMapDB(Map map) {
		 map.setTerritories((ArrayList<Territory>) gameDocument.get("current_map"));
	}
	
	public void loadTheContinentsDB(Map map) {
		 map.setTerritories((ArrayList<Territory>) gameDocument.get("current_contients"));
	}
	
	public void loadTheOwnersOfTerritoriesDB(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        String key = "owner_of_a_territory" + i;
	        map.getTerritories().get(i).setOwner((Player) gameDocument.get(key));
	    }
	}
	
	public void loadTheArmyListOfTerritoriesDB(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        String key = "armyList_of_a_territory" + i;
	        map.getTerritories().get(i).setArmyList((ArrayList<Army>) gameDocument.get(key));
	    }
	
	// Insert the game document into the collection
    collection.insertOne(gameDocument);
    
    // Close the MongoDB connection
    mongoClient.close();

}
