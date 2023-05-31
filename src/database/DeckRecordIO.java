package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Army;
import domain.Deck;
import domain.InfantryCard;
import domain.Recordable;


public class DeckRecordIO implements Recordable{
	String fileName = "output_deck.dat";
	public void saveTheDeckIO(Deck deck) { 
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(deck);
			oos.close();
			fos.close();
			System.out.println("Artillery cardList of" + deck + "have been saved to " + fileName);
		} 

		catch (IOException e) {
			System.out.println("Error occurred while saving the Artillery cardList of " + deck + "to " + fileName);
			e.printStackTrace();
		}

	}
	public Deck loadTheDeckIO(){

		
		try {
	        FileInputStream fis = new FileInputStream(fileName);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	         Deck deck = (Deck) ois.readObject();
	        	        ois.close();
	        fis.close();
	        System.out.println("Deck have been loaded from " + fileName);
	        return deck; 
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error occurred while loading the deck from " + fileName);
	        e.printStackTrace();
	    }
		
		return null;
	}
	
	public static void main(String[] args)  {
		Deck deck1 = new Deck();
		ArrayList<Army> armyList1 = new ArrayList<Army>();

		ArrayList <InfantryCard> infantryCardList = new ArrayList<InfantryCard>();
		infantryCardList .add(new InfantryCard());
		
		deck1.setInfantryCardList(infantryCardList);
		DeckRecordIO deckRecordIO = new DeckRecordIO();
		deckRecordIO.saveTheDeckIO(deck1);
		Deck deck2 = deckRecordIO.loadTheDeckIO();
		System.out.println();
	}
}
