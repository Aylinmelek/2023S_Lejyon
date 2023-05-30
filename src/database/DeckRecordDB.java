
package database;

import UI.*;
import domain.AdapterRecord;
import domain.ArtilleryCard;
import domain.Card;
import domain.CavalryCard;
import domain.Deck;
import domain.InfantryCard;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class DeckRecordDB implements AdapterRecord{
	
	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017"); //will change, ask TA
	MongoClient mongoClient = new MongoClient(uri);

	// Access the game database
	MongoDatabase database = mongoClient.getDatabase("game_database");

	// Access the game collection
	MongoCollection<Document> collection = database.getCollection("game_collection");
	
	// Create a sample game document
    Document gameDocument = new Document();
	    
    public void saveTheDeckDB(Deck deck) { 
		gameDocument.append("main_infantry_cardList", deck.getInfantryCardList())
					.append("main_artillery_cardList", deck.getArtilleryCardList())
					.append("main_cavalry_cardList", deck.getCavalryCardList())
					.append("main_territory_cardList", deck.getTerritoryCardList());

    }
    
    public void loadTheTDeckDB(Deck deck) {
        String key1 = "main_territory_cardList";
        deck.setTerritoryCardList((ArrayList<Card>) gameDocument.get(key1));
        String key2 = "main_infantry_cardList";
        deck.setInfantryCardList((ArrayList<InfantryCard>) gameDocument.get(key2));
        String key3 = "main_cavalry_cardList";
        deck.setCavalryCardList((ArrayList<CavalryCard>) gameDocument.get(key3));
        String key4 = "main_artillery_cardList";
        deck.setArtilleryCardList((ArrayList<ArtilleryCard>) gameDocument.get(key4));

    }

	
	
	// Insert the game document into the collection
    collection.insertOne(gameDocument);
    
    // Close the MongoDB connection
    mongoClient.close();

}
