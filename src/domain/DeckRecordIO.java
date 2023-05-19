package domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DeckRecordIO implements Recordable{
	String fileName = "output_deck.dat";
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

}
