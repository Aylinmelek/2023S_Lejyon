package domain;

import java.util.ArrayList;

import UI.Grid;

public class Territory {
 int army; 
 Continent continent;
 boolean isImmune = false;
 public ArrayList<Army> getArmyList() {
	return armyList;
}

public void setArmyList(ArrayList<Army> armyList) {
	this.armyList = armyList;
}
boolean reachability;
 int count;
 Player owner;
 String territoryName; 
 boolean isEnabled;
 boolean isTaken = false;
 ArrayList <Territory> adjacentTerritories = new ArrayList<Territory>();
 ArrayList <Army> armyList = new ArrayList<Army>();
 
 
public ArrayList<Territory> getAdjacentTerritories() {
	return adjacentTerritories;
}

public void setAdjacentTerritories(ArrayList<Territory> adjacentTerritories) {
	this.adjacentTerritories = adjacentTerritories;
}
int row,col=0;

 public Player getOwner() {
	return owner;
}

public void setOwner(Player owner) {
	this.owner = owner;
}

public void enable() {
	 isEnabled = true;
 }
 
 public void disable() {
	 isEnabled = false;
 }
 
 public void immunize() {
	 isImmune = true;
 }
 public void deImmunize() {
	 isImmune = false;
 }
 

 
}