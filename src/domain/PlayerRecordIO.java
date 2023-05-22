package domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PlayerRecordIO implements Recordable{
	String fileName = "output_player.dat";
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
	
}
