package domain;

import java.util.ArrayList;

public class Player {
	String name;
	public Deck deck = new Deck();
	public Die die;

	public int numOfInfantry;
	
	public int getNumOfInfantry() {
		return numOfInfantry;
	}

	public void setNumOfInfantry(int numOfInfantry) {
		this.numOfInfantry = numOfInfantry;
	}

	ArrayList <Infantry> infantryList = new ArrayList<Infantry>();
	ArrayList <Artillery> artilleryList = new ArrayList<Artillery>();
	ArrayList <Cavalry> cavalryList = new ArrayList<Cavalry>();
	ArrayList <TerritoryCard> territoryCardList = new ArrayList<TerritoryCard>();
	public ArrayList <Territory> territoryList = new ArrayList<Territory>();
	public boolean turn;
	
	

	public String getName() {
		return name;
	}

	public void playTheGame() {
		Map map;
		// it will start the game.
	}

 
	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}


	public void winTheGame() {
		System.out.println("Congratulations! You won the game!");
	}

	public void loseTheGame() {
		System.out.println("Unfortunately! You lose the game!");
	}

	public void tradeArmyCards(int i) {
		if (i == 0 && deck.infantryCardList.size() == 3) {
			for (int j = 0; j <= 2; j++) {
				int index = deck.infantryCardList.size() - 1;
				deck.infantryCardList.remove(index);
				System.out.println("Infantry Card is removed.");
			}
			cavalryList.add(new Cavalry());
			System.out.println("Cavalry is added.");
		}
		if (i == 1 && deck.infantryCardList.size() == 2 && deck.cavalryCardList.size() == 1) {
			for (int j = 0; j <= 1; j++) {
				int index = deck.infantryCardList.size() - 1;
				deck.infantryCardList.remove(index);
			}
			int index = deck.cavalryCardList.size() - 1;
			deck.cavalryCardList.remove(index);
			cavalryList.add(new Cavalry());
			cavalryList.add(new Cavalry());
		}
		if (i == 2 && deck.infantryCardList.size() == 2 && deck.artilleryCardList.size() == 1) {
			for (int j = 0; j <= 1; j++) {
				int index = deck.infantryCardList.size() - 1;
				deck.infantryCardList.remove(index);
			}
			int index = deck.artilleryCardList.size() - 1;
			deck.artilleryCardList.remove(index);
			artilleryList.add(new Artillery());
			artilleryList.add(new Artillery());
		}
		if (i == 3 && deck.infantryCardList.size() == 1 && deck.cavalryCardList.size() == 2) {
			int index = deck.infantryCardList.size() - 1;
			deck.infantryCardList.remove(index);
			for (int j = 0; j <= 1; j++) {
				int index2 = deck.cavalryCardList.size() - 1;
				deck.cavalryCardList.remove(index2);
			}
			cavalryList.add(new Cavalry());
			artilleryList.add(new Artillery());
		}
		if (i == 4 && deck.artilleryCardList.size() == 1 && deck.cavalryCardList.size() == 2) {
			int index = deck.artilleryCardList.size() - 1;
			deck.artilleryCardList.remove(index);
			for (int j = 0; j <= 1; j++) {
				int index3 = deck.cavalryCardList.size() - 1;
				deck.cavalryCardList.remove(index3);
			}
			artilleryList.add(new Artillery());
			artilleryList.add(new Artillery());
			artilleryList.add(new Artillery());
		}
	}

	public ArrayList<Cavalry> getCavalryList() {
		return cavalryList;
	}

	public ArrayList<Artillery> getArtilleryList() {
		return artilleryList;
	}

	public void setArtilleryList(ArrayList<Artillery> artilleryList) {
		this.artilleryList = artilleryList;
	}

	public void setCavalryList(ArrayList<Cavalry> cavalryList) {
		this.cavalryList = cavalryList;
	}

	public ArrayList<TerritoryCard> getTerritoryCardList() {
		return territoryCardList;
	}

	public void setTerritoryCardList(ArrayList<TerritoryCard> territoryCardList) {
		this.territoryCardList = territoryCardList;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Infantry> getInfantryList() {
		return infantryList;
	}

	public void setInfantryList(ArrayList<Infantry> infantryList) {
		this.infantryList = infantryList;
	}

	public void tradeTerritoryCards(Continent continent) {
		if (territoryCardList.containsAll(continent.territoryCardList)) {
			for (int i = 0; i < territoryCardList.size(); i++) {
				for (int j = 0; j < continent.territoryCardList.size(); j++) {
					if (territoryCardList.get(i).equals(continent.territoryCardList.get(j))) {
						territoryCardList.remove(i);
					}
				}
			}
			for (int j = 0; j < continent.territoryList.size(); j++) {
				for (int k = 0; k < territoryList.size(); k++) {
					if (territoryList.get(k).equals(continent.territoryList.get(j))) {
						break;
					}
				}
				territoryList.add(continent.territoryList.get(j));
			}
		}
	}

	public void chooseATerritory(Territory territory) {
		if (!territoryList.contains(territory) && !territory.isTaken) {
			territoryList.add(territory);
			territory.isTaken = true;
			territory.setOwner(this);
		}
	}

	public void placeArmy(Territory territory, Army army) {
		if (territoryList.contains(territory)) {
			territory.armyList.add(army);

			if (army.type == "Cavalry" && cavalryList.size() >= 1) {
				int index = cavalryList.size() - 1;
				cavalryList.remove(index);
			}
			if (army.type == "Artillery" && artilleryList.size() >= 1) {
				int index = artilleryList.size() - 1;
				artilleryList.remove(index);
			}
			if (army.type == "Infantry" && infantryList.size() >= 1) {
				int index = infantryList.size() - 1;
				infantryList.remove(index);
			}
		}
	}

	public void fortifying(Territory territoryFrom, Territory territoryTo, Army army) {

		if (territoryList.contains(territoryTo) && territoryList.contains(territoryFrom)
				&& territoryFrom.getAdjacentTerritories().contains(territoryTo)) {
			territoryFrom.getArmyList().remove(army);
			territoryTo.getArmyList().add(army);
		}
	}

	public void loseTheAttack(Territory territory) {
		int index = territory.armyList.size() - 1;
		territory.armyList.remove(index);
		territory.armyList.remove(index - 1);
		/*
		 * if(infantryList.size() >= 2 ) {
		 * infantryList.remove(-1);
		 * infantryList.remove(-2);
		 * }
		 * 
		 * else if(cavalryList.size() >= 2 ) {
		 * cavalryList.remove(-1);
		 * cavalryList.remove(-2);
		 * }
		 * 
		 * else if(artilleryList.size() >= 2 ) {
		 * artilleryList.remove(-1);
		 * artilleryList.remove(-2);
		 * }
		 */
	}

	public void loseTheDefend(Territory territory) {
		int index = territory.armyList.size() - 1;
		territory.armyList.remove(index);


		/* if(infantryList.size() >= 1 ) {
			infantryList.remove(-1);
		}
		
		else if(cavalryList.size() >= 1 ) {
			cavalryList.remove(-1);
		}
		
		else if(artilleryList.size() >= 1 ) {
			artilleryList.remove(-1);
		} */
		

	}

	public ArrayList<Territory> getTerritoryList() {
		return territoryList;
	}

	public void setTerritoryList(ArrayList<Territory> territoryList) {
		this.territoryList = territoryList;
	}

	public boolean canAttackTerritory(Territory territoryFrom, Territory territoryTo) {
		int territoryPower = territoryTo.armyList.size();
		int playerPower = territoryFrom.armyList.size();
		/*
		 * for (int i = 0; i < territoryTo.armyList.size(); i++) {
		 * territoryPower += territoryTo.armyList.get(i).power;
		 * System.out.println(territoryPower);
		 * 
		 * }
		 * for (int i = 0; i < territoryFrom.armyList.size(); i++) {
		 * playerPower += territoryFrom.armyList.get(i).power;
		 * System.out.println(playerPower);
		 * }
		 */
		// playerPower += infantryList.size() * 1;
		// playerPower += artilleryList.size() * 2;
		// playerPower += cavalryList.size() * 3;

		if (playerPower >= territoryPower) {
			System.out.println(this + " can attack.");
			return true;
		} else {
			System.out.println(this + " cannot attack.");
			return false;
		}
	}

	public void conquerTerritory(Territory territory) {
		territoryList.add(territory);
		territory.owner.territoryList.remove(territory.owner.territoryList.indexOf(territory));
		territory.owner = this;
	}

}
