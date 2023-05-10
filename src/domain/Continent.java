package domain;

import java.util.ArrayList;

public class Continent {
	int territoryCount;
	Territory[] territorylist;
	ArrayList <TerritoryCard> territoryCardList = new ArrayList<TerritoryCard>();
	ArrayList <Territory> territoryList = new ArrayList<Territory>();
	public ArrayList<TerritoryCard> getTerritoryCardList() {
		return territoryCardList;
	}
	public void setTerritoryCardList(ArrayList<TerritoryCard> territoryCardList) {
		this.territoryCardList = territoryCardList;
	}
	public ArrayList<Territory> getTerritoryList() {
		return territoryList;
	}
	public void setTerritoryList(ArrayList<Territory> territoryList) {
		this.territoryList = territoryList;
	}
	
}
