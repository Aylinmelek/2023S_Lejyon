package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Map implements Serializable {
	
	/*public static void main(String[] args) {
		setRowAndCol();
	}*/
	Deck deskDeck;
	ArrayList <Territory> territories = new ArrayList<Territory>();
	ArrayList <Continent> continents = new ArrayList<Continent>();
	
	Territory[][] territoryArray=new Territory[10][10];
	
	
	
public Territory getTerritory(int row, int col) {
	return territoryArray[row][col];
}

public ArrayList<Territory> getTerritories() {
	return territories;
}

public void checkReachability(Territory territory) {
		//it will check reachability.
	
		for (int i = 0; i < territory.adjacentTerritories.size(); i++) {
			if (territory.adjacentTerritories.get(i).isEnabled) {
				territory.reachability = true;
			}
		}
		if (territory.reachability) {
			System.out.println(territory + " is reachable.");
			territory.isEnabled = true;
		}
		else {
			System.out.println(territory + " is not reachable.");
			territory.isEnabled = false;
		}
 }

public ArrayList<Continent> getContinents() {
	return continents;
}

public void setContinents(ArrayList<Continent> continents) {
	this.continents = continents;
}

public void setRowAndCol() {
	
	for(int i=0; i<10; i++) {
		
		for(int j=0; j<10; j++) {
			territoryArray[i][j]=new Territory();
			territoryArray[i][j].col=j;
			territoryArray[i][j].row=i;
		}
		
	}
	
	
}

public void setTerritories(ArrayList<Territory> new_territories) {
	// TODO Auto-generated method stub
	this.territories = new_territories;
	
}


}


