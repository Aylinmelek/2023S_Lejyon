package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable{
	ArrayList <Card> deskDeck = new ArrayList<Card>();
	ArrayList <Card> chanceCardList = new ArrayList<Card>();
	ArrayList <Card> territoryCardList = new ArrayList<Card>();
	ArrayList <Card> armyCardList = new ArrayList<Card>();
	ArrayList <InfantryCard> infantryCardList = new ArrayList<InfantryCard>();
	ArrayList <ArtilleryCard> artilleryCardList = new ArrayList<ArtilleryCard>();
	ArrayList <CavalryCard> cavalryCardList = new ArrayList<CavalryCard>();
	public void shuffle() {
		Collections.shuffle(deskDeck);
	}
	
	public void giveFirst(Player player) {
		player.deck.deskDeck.add(deskDeck.get(0));
		deskDeck.remove(0);
		}
	//public void takeCard() {

	public ArrayList<InfantryCard> getInfantryCardList() {
		return infantryCardList;
	}

	public ArrayList<Card> getTerritoryCardList() {
		return territoryCardList;
	}

	public void setTerritoryCardList(ArrayList<Card> territoryCardList) {
		this.territoryCardList = territoryCardList;
	}

	public ArrayList<ArtilleryCard> getArtilleryCardList() {
		return artilleryCardList;
	}

	public void setArtilleryCardList(ArrayList<ArtilleryCard> artilleryCardList) {
		this.artilleryCardList = artilleryCardList;
	}

	public ArrayList<CavalryCard> getCavalryCardList() {
		return cavalryCardList;
	}

	public void setCavalryCardList(ArrayList<CavalryCard> cavalryCardList) {
		this.cavalryCardList = cavalryCardList;
	}

	public void setInfantryCardList(ArrayList<InfantryCard> infantryCardList) {
		this.infantryCardList = infantryCardList;
	}
		
	//	}
	
}
