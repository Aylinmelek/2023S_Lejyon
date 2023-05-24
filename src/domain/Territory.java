package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import UI.Grid;

public class Territory {
 int army; 
 Continent continent;
 boolean isImmune = false;
 private static final int ROWS = 17;
 private static final int COLUMNS = 17;
 
 
 static Color[][] gridColors= new Color[ROWS][COLUMNS];
 static String[][] gridText = new String[ROWS][COLUMNS];
 
 static Territory[][] territories = {
	        { new Territory("Yellow 1", "1", Color.yellow,0), new Territory("Yellow 6", "6", Color.yellow,5), new Territory("Yellow 5", "5", Color.yellow,4), null, null, null, null, null, new Territory("Green 12", "12", Color.green,27), null },
	        { new Territory("Yellow 2", "2", Color.yellow,1), new Territory("Yellow 7", "7", Color.yellow,6), new Territory("Yellow 8", "8", Color.yellow,7), new Territory("Blue 2", "2", Color.blue,10), new Territory("Blue 4", "4", Color.blue,12), null, new Territory("Green 11","11", Color.green,26), new Territory("Green 10", "10", Color.green,25), new Territory("Green 4", "4", Color.green,19), new Territory("Green 6", "6", Color.green,21) },
	        { new Territory("Yellow 9", "9", Color.yellow,8), new Territory("Yellow 4", "4", Color.yellow,3), null, new Territory("Blue 1", "1", Color.blue,9), new Territory("Blue 3", "3", Color.blue,11), new Territory("Blue 6", "6", Color.blue,14), new Territory("Green 1", "1", Color.green,16), new Territory("Green 2", "2", Color.green,17), new Territory("Green 8", "8", Color.green,23), new Territory("Green 5", "5", Color.green,20) },
	        
	        { new Territory("Yellow 3", "3", Color.yellow,2), null, null, null, new Territory("Blue 7", "7", Color.blue,15), new Territory("Blue 5", "5", Color.blue,13), new Territory("Green 7", "7", Color.green,22), new Territory("Green 3", "3", Color.green,18), new Territory("Green 9", "9", Color.green,24), null },
	        { new Territory("Pink 4", "4", Color.pink,31), new Territory("Pink 2", "2", Color.pink,29), null, null, new Territory("Orange 5", "5", Color.orange,37), new Territory("Orange 3", "3", Color.orange,34), null, null, new Territory("Red 2", "2", Color.red,40), new Territory("Red 3", "3", Color.red,41) },
	        { new Territory("Pink 3", "3", Color.pink,30), new Territory("Pink 1", "1", Color.pink,28),null, null, new Territory("Orange 1", "1", Color.orange,32), new Territory("Orange 2", "2", Color.orange,32), null, null, new Territory("Red 4", "4", Color.red,42), new Territory("Red 1", "1", Color.red,39) },
	        { null, null, null, null, new Territory("Orange 6", "6", Color.orange,38), new Territory("Orange 4", "4", Color.orange,36), null, null, null, null },
	    };
 
	private String name;
	private String text;
	private Color color;
	private int index;

 
 public Territory(String name, String text, Color color, int index) {
	    this.name = name;
	    this.text = text;
	    this.color = color;
	    this.index = index;

}
 
 public Territory() {

 }




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

public static Territory isTerritory(int row2, int col2) {
	    
	    // Check if the specified position is within the bounds of the territories array
	    if (row2 >= 0 && row2 < territories.length && col2 >= 0 && col2 < territories[row2].length) {
	        return territories[row2][col2];
	    }
	    return null; // Return null if no territory exists at the specified position
}

public boolean isEnabled() {
	return isEnabled;
}

public void setEnabled(boolean isEnabled) {
	this.isEnabled = isEnabled;
}

public Color getColor() {
	return color;
}

public String getText() {
	// TODO Auto-generated method stub
	return text;
}
 
public int getIndex() {
	// TODO Auto-generated method stub
	return index;
}

 
}