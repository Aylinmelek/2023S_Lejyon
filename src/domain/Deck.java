package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck implements Serializable{
	ArrayList<Card> deskDeck = new ArrayList<Card>();
	ArrayList<Card> chanceCardList = new ArrayList<Card>();
	ArrayList<DiplomaticImmunityCard> dipImmunityCardList = new ArrayList<DiplomaticImmunityCard>();
	ArrayList<ReinforcementCard> reinforceCardList = new ArrayList<ReinforcementCard>();
	ArrayList<sabotageCard> sabotageCardList = new ArrayList<sabotageCard>();
	ArrayList<SpyCard> spyCardList = new ArrayList<SpyCard>();
	ArrayList<WorldEventCard> worldEventCardList = new ArrayList<WorldEventCard>();
	ArrayList<DisasterCard> disasterCardList = new ArrayList<DisasterCard>();
	ArrayList<TerritoryCard> territoryCardList = new ArrayList<TerritoryCard>();
	ArrayList<Card> armyCardList = new ArrayList<Card>();
	ArrayList<InfantryCard> infantryCardList = new ArrayList<InfantryCard>();
	ArrayList<ArtilleryCard> artilleryCardList = new ArrayList<ArtilleryCard>();
	ArrayList<CavalryCard> cavalryCardList = new ArrayList<CavalryCard>();
	Random rand = new Random();


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
		int givenCard = rand.nextInt(5);
		if (givenCard == 0 && this.getdipImmunityCardList().size() > 0) {
			int index = this.getdipImmunityCardList().size() - 1;
			DiplomaticImmunityCard dipImCard = new DiplomaticImmunityCard();
			player.getDeck().getdipImmunityCardList().add(dipImCard);
			this.getdipImmunityCardList().remove(index);
		}
		if (givenCard == 1 && this.getReinforcementCardList().size() > 0) {
			int index = this.getReinforcementCardList().size() - 1;
			ReinforcementCard reinforceCard = new ReinforcementCard();
			player.getDeck().getReinforcementCardList().add(reinforceCard);
			this.getReinforcementCardList().remove(index);
		}
		if (givenCard == 2 && this.getsabotageCardList().size() > 0) {
			int index = this.getsabotageCardList().size() -1;
			sabotageCard sabotageCard = new sabotageCard();
			player.getDeck().getsabotageCardList().add(sabotageCard);
			this.getsabotageCardList().remove(index);
		}
		if (givenCard == 3 && this.getSpyCardList().size() > 0) {
			int index = this.getSpyCardList().size() -1;
			SpyCard spyCard = new SpyCard();
			player.getDeck().getSpyCardList().add(spyCard);
			this.getSpyCardList().remove(index);
			
		}
		if (givenCard == 4 && this.getWorldEventCardList().size() > 0) {
			int index = this.getWorldEventCardList().size() - 1;
			WorldEventCard worldEventCard = new WorldEventCard();
			player.getDeck().getWorldEventCardList().add(worldEventCard);
			this.getWorldEventCardList().remove(index);
		}
		if (givenCard == 5 && this.getDisasterCardList().size() > 0) {
			int index = this.getDisasterCardList().size() - 1;
			DisasterCard disasterCard = new DisasterCard();
			player.getDeck().getDisasterCardList().add(disasterCard);
			this.getDisasterCardList().remove(index);
		}

	}

	public void giveArmyCard(Player player) {
		int givenCard = rand.nextInt(2);
		if (givenCard == 0 && this.getInfantryCardList().size() > 0) {
			int index = this.getInfantryCardList().size() - 1;
			InfantryCard infantryCard = new InfantryCard();
			player.getDeck().getInfantryCardList().add(infantryCard);
			this.getInfantryCardList().remove(index);
		}
		if (givenCard == 1 && this.getCavalryCardList().size() > 0) {
			int index = this.getCavalryCardList().size() -1;
			CavalryCard cavalryCard = new CavalryCard();
			player.getDeck().getCavalryCardList().add(cavalryCard);
			this.getCavalryCardList().remove(index);
		}
		if (givenCard == 2 && this.getArtilleryCardList().size() > 0) {
			int index = this.getArtilleryCardList().size() - 1;
			ArtilleryCard artilleryCard = new ArtilleryCard();
			player.getDeck().getArtilleryCardList().add(artilleryCard);
			this.getArtilleryCardList().remove(index);
		}
		/*if (givenCard == 0) {
			//int index = this.getInfantryCardList().size() - 1;
			InfantryCard infantryCard = new InfantryCard();
			player.getDeck().getInfantryCardList().add(infantryCard);
			System.out.println("infanty verildi");
			//this.getInfantryCardList().remove(index);
		}
		if (givenCard == 1) {
			//int index = this.getCavalryCardList().size() -1;
			CavalryCard cavalryCard = new CavalryCard();
			player.getDeck().getCavalryCardList().add(cavalryCard);
			System.out.println("cavalry verildi");
			//this.getCavalryCardList().remove(index);
		}
		if (givenCard == 2) {
			//int index = this.getArtilleryCardList().size() - 1;
			ArtilleryCard artilleryCard = new ArtilleryCard();
			player.getDeck().getArtilleryCardList().add(artilleryCard);
			System.out.println("artilery verildi");
			
			//this.getArtilleryCardList().remove(index);
		}*/
	}

	public void giveTerritoryCard(Player player) {
		int givenCard = rand.nextInt(2);

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

	public ArrayList<TerritoryCard> getTerritoryCardList() {
		return territoryCardList;
	}

	public void setTerritoryCardList(ArrayList<TerritoryCard> territoryCardList) {
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