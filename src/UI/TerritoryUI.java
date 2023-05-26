package UI;

import java.awt.Color;

import domain.Territory;

public class TerritoryUI {


private static final int ROWS = 17;
private static final int COLUMNS = 17;


static Color[][] gridColors= new Color[ROWS][COLUMNS];
static String[][] gridText = new String[ROWS][COLUMNS];

static TerritoryUI[][] territories = {
	        { new TerritoryUI("Yellow 1", "1", Color.yellow,0), new TerritoryUI("Yellow 6", "6", Color.yellow,5), new TerritoryUI("Yellow 5", "5", Color.yellow,4), null, null, null, null, null, new TerritoryUI("Green 12", "12", Color.green,27), null },
	        { new TerritoryUI("Yellow 2", "2", Color.yellow,1), new TerritoryUI("Yellow 7", "7", Color.yellow,6), new TerritoryUI("Yellow 8", "8", Color.yellow,7), new TerritoryUI("Blue 2", "2", Color.blue,10), new TerritoryUI("Blue 4", "4", Color.blue,12), null, new TerritoryUI("Green 11","11", Color.green,26), new TerritoryUI("Green 10", "10", Color.green,25), new TerritoryUI("Green 4", "4", Color.green,19), new TerritoryUI("Green 6", "6", Color.green,21) },
	        { new TerritoryUI("Yellow 9", "9", Color.yellow,8), new TerritoryUI("Yellow 4", "4", Color.yellow,3), null, new TerritoryUI("Blue 1", "1", Color.blue,9), new TerritoryUI("Blue 3", "3", Color.blue,11), new TerritoryUI("Blue 6", "6", Color.blue,14), new TerritoryUI("Green 1", "1", Color.green,16), new TerritoryUI("Green 2", "2", Color.green,17), new TerritoryUI("Green 8", "8", Color.green,23), new TerritoryUI("Green 5", "5", Color.green,20) },
	        
	        { new TerritoryUI("Yellow 3", "3", Color.yellow,2), null, null, null, new TerritoryUI("Blue 7", "7", Color.blue,15), new TerritoryUI("Blue 5", "5", Color.blue,13), new TerritoryUI("Green 7", "7", Color.green,22), new TerritoryUI("Green 3", "3", Color.green,18), new TerritoryUI("Green 9", "9", Color.green,24), null },
	        { new TerritoryUI("Pink 4", "4", Color.pink,31), new TerritoryUI("Pink 2", "2", Color.pink,29), null, null, new TerritoryUI("Orange 5", "5", Color.orange,37), new TerritoryUI("Orange 3", "3", Color.orange,34), null, null, new TerritoryUI("Red 2", "2", Color.red,40), new TerritoryUI("Red 3", "3", Color.red,41) },
	        { new TerritoryUI("Pink 3", "3", Color.pink,30), new TerritoryUI("Pink 1", "1", Color.pink,28),null, null, new TerritoryUI("Orange 1", "1", Color.orange,32), new TerritoryUI("Orange 2", "2", Color.orange,32), null, null, new TerritoryUI("Red 4", "4", Color.red,42), new TerritoryUI("Red 1", "1", Color.red,39) },
	        { null, null, null, null, new TerritoryUI("Orange 6", "6", Color.orange,38), new TerritoryUI("Orange 4", "4", Color.orange,36), null, null, null, null },
	    };

	private String name;
	private String text;
	private Color color;
	private int index;
	


public TerritoryUI(String name, String text, Color color, int index) {
    this.name = name;
    this.text = text;
    this.color = color;
    this.index = index;

}


public static TerritoryUI isTerritory(int row2, int col2) {
    
    // Check if the specified position is within the bounds of the territories array
    if (row2 >= 0 && row2 < territories.length && col2 >= 0 && col2 < territories[row2].length) {
        return territories[row2][col2];
    }
    return null; // Return null if no territory exists at the specified position
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