package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	ArrayList<Card> deskDeck = new ArrayList<Card>();
	ArrayList<Card> chanceCardList = new ArrayList<Card>();
	ArrayList<DiplomaticImmunityCard> dipImmunityCardList = new ArrayList<DiplomaticImmunityCard>();
	ArrayList<ReinforcementCard> reinforceCardList = new ArrayList<ReinforcementCard>();
	ArrayList<sabotageCard> sabotageCardList = new ArrayList<sabotageCard>();
	ArrayList<SpyCard> spyCardList = new ArrayList<SpyCard>();
	ArrayList<WorldEventCard> worldEventCardList = new ArrayList<WorldEventCard>();
	ArrayList<DisasterCard> disasterCardList = new ArrayList<DisasterCard>();
	ArrayList<Card> territoryCardList = new ArrayList<Card>();
	ArrayList<Card> armyCardList = new ArrayList<Card>();
	ArrayList<InfantryCard> infantryCardList = new ArrayList<InfantryCard>();
	ArrayList<ArtilleryCard> artilleryCardList = new ArrayList<ArtilleryCard>();
	ArrayList<CavalryCard> cavalryCardList = new ArrayList<CavalryCard>();
	Random rand;

	public void shuffle() {
		Collections.shuffle(deskDeck);
	}

	// TerritoryCardList'lerin dağıtılması ve oluşturulması yapılacak

	public void giveFirst(Player player) {
		player.deck.deskDeck.add(deskDeck.get(0));
		deskDeck.remove(0);
	}

	// public void takeCard() {
	public void giveChanceCard(Player player) {
		int givenCard = rand.nextInt(5) + 1;
		if (givenCard == 0) {
			DiplomaticImmunityCard dipImCard = new DiplomaticImmunityCard();
			player.getDeck().getdipImmunityCardList().add(dipImCard);
		}
		if (givenCard == 1) {
			ReinforcementCard reinforceCard = new ReinforcementCard();
			player.getDeck().getReinforcementCardList().add(reinforceCard);
		}
		if (givenCard == 2) {
			sabotageCard sabotageCard = new sabotageCard();
			player.getDeck().getsabotageCardList().add(sabotageCard);
		}
		if (givenCard == 3) {
			SpyCard spyCard = new SpyCard();
			player.getDeck().getSpyCardList().add(spyCard);
		}
		if (givenCard == 4) {
			WorldEventCard worldEventCard = new WorldEventCard();
			player.getDeck().getWorldEventCardList().add(worldEventCard);
		}
		if (givenCard == 5) {
			DisasterCard disasterCard = new DisasterCard();
			player.getDeck().getDisasterCardList().add(disasterCard);
		}

	}

	public ArrayList<DiplomaticImmunityCard> getdipImmunityCardList() {
		return this.dipImmunityCardList;
	}

	public ArrayList<ReinforcementCard> getReinforcementCardList() {
		return this.reinforceCardList;
	}

	public ArrayList<sabotageCard> getsabotageCardList() {
		return this.sabotageCardList;
	}

	public ArrayList<SpyCard> getSpyCardList() {
		return this.spyCardList;
	}

	public ArrayList<WorldEventCard> getWorldEventCardList() {
		return this.worldEventCardList;
	}

	public ArrayList<DisasterCard> getDisasterCardList() {
		return this.disasterCardList;
	}

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

	// }

}
