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
	
	public void loadTheContinentsIO(Map map) {
		 try {
		        FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        map.setContinents((ArrayList<Continent>) ois.readObject());
		        ois.close();
		        fis.close();
		        System.out.println("Continents has been loaded from " + fileName);
		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("Error occurred while loading the continents from " + fileName);
		        e.printStackTrace();
		    }
	}
	
	public void loadTheOwnersOfTerritoriesIO(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            map.getTerritories().get(i).setOwner((Player) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Owner of territory " + i + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the owner of territory " + i + " from " + fileName);
	            e.printStackTrace();
	        }
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
	
	public void loadTheInfantryListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).setInfantryList((ArrayList<Infantry>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Infantry List of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the infantry List of " + playerList.get(i) + " from " + fileName);
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
	
	public void loadTheArtilleryListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).setArtilleryList((ArrayList<Artillery>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Artillery List of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the artillery List of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheArtilleryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).getDeck().setArtilleryCardList((ArrayList<ArtilleryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Artillery cardList of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the artillery cardList of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheCavalryListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).setCavalryList((ArrayList<Cavalry>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Cavalry List of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the cavalry List of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheCavalryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).getDeck().setCavalryCardList((ArrayList<CavalryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Cavalry cardList of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the cavalry cardList of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheTerritoryListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).setTerritoryList((ArrayList<Territory>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Territory List of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the territory List of " + playerList.get(i) + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	public void loadTheTerritoryCardListOfPlayersIO(ArrayList <Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            playerList.get(i).getDeck().setTerritoryCardList((ArrayList<Card>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Territory cardList of " + playerList.get(i) + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the territory cardList of " + playerList.get(i) + " from " + fileName);
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
	
	public void loadTheDeckIO(Deck deck) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            deck.setArtilleryCardList((ArrayList<ArtilleryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Artillery cardList of " + deck + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the artillery cardList of " + deck + " from " + fileName);
	            e.printStackTrace();
	        }
	        
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            deck.setInfantryCardList((ArrayList<InfantryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Infantry cardList of " + deck + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the infantry cardList of " + deck + " from " + fileName);
	            e.printStackTrace();
	        }
	        
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            deck.setCavalryCardList((ArrayList<CavalryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Cavalry cardList of " + deck + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the cavalry cardList of " + deck + " from " + fileName);
	            e.printStackTrace();
	        }
	        
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            deck.setTerritoryCardList((ArrayList<TerritoryCard>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Territory cardList of " + deck + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the territory cardList of " + deck + " from " + fileName);
	            e.printStackTrace();
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

	
	
    
   
    
    
    
    
    
    
    

}
