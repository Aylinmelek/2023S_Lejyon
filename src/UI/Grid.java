package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import domain.Map;
import domain.Territory;

public class Grid extends JPanel implements MouseListener {

    private static final int ROWS = 17;
    private static final int COLUMNS = 17;
    private static final int CELL_SIZE = 50;
    private static final int GRID_LINE_WIDTH = 2;

    private Color[][] gridColors;
    private String[][] gridText;
    territoryCardFrame terCard = new territoryCardFrame();

    static Map gameMap = new Map();
    //ArrayList enabledTerritories = new ArrayList[10][10];
    
    
    int column,row=0;
      
    public int getRow() {
 		// TODO Auto-generated method stub
 		return row;
 	}
    
    
    
    public int getCol() {
 		// TODO Auto-generated method stub
 		return column;
 	}
    

    public Grid() {
        gridColors = new Color[ROWS][COLUMNS];
        gridText = new String[ROWS][COLUMNS];
        
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                gridColors[row][col] = Color.DARK_GRAY;
                if (row==0 && col==0) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==0 && col==1) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==0 && col==2) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==1 && col==0) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==1 && col==1) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==1 && col==2) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==2 && col==0) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==2 && col==1) {
                	gridColors[row][col] = Color.yellow;
                }
                if (row==3 && col==0) {
                	gridColors[row][col] = Color.yellow;
                }
                
                if (row==4 && col==0) {
                	gridColors[row][col] = Color.pink;
                }
                if (row==4 && col==1) {
                	gridColors[row][col] = Color.pink;
                }
                if (row==5 && col==0) {
                	gridColors[row][col] = Color.pink;
                }
                if (row==5 && col==1) {
                	gridColors[row][col] = Color.pink;
                }
                
                if (row==1 && col==3) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==2 && col==3) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==1 && col==4) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==2 && col==4) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==3 && col==4) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==2 && col==5) {
                	gridColors[row][col] = Color.blue;
                }
                if (row==3 && col==5) {
                	gridColors[row][col] = Color.blue;
                }
                
                if (row==4 && col==4) {
                	gridColors[row][col] = Color.orange;
                }
                if (row==4 && col==5) {
                	gridColors[row][col] = Color.orange;
                }
                if (row==5 && col==4) {
                	gridColors[row][col] = Color.orange;
                }
                if (row==5 && col==5) {
                	gridColors[row][col] = Color.orange;
                }
                if (row==6 && col==4) {
                	gridColors[row][col] = Color.orange;
                }
                if (row==6 && col==5) {
                	gridColors[row][col] = Color.orange;
                }
                
                if (row==1 && col==6) {
                	gridColors[row][col] = Color.green;
                }
                if (row==1 && col==7) {
                	gridColors[row][col] = Color.green;
                }
                if (row==1 && col==8) {
                	gridColors[row][col] = Color.green;
                }
                if (row==1 && col==9) {
                	gridColors[row][col] = Color.green;
                }
                if (row==0 && col==8) {
                	gridColors[row][col] = Color.green;
                }
                if (row==2 && col==6) {
                	gridColors[row][col] = Color.green;
                }
                if (row==2 && col==7) {
                	gridColors[row][col] = Color.green;
                }
                if (row==2 && col==8) {
                	gridColors[row][col] = Color.green;
                }
                if (row==2 && col==9) {
                	gridColors[row][col] = Color.green;
                }
                if (row==3 && col==6) {
                	gridColors[row][col] = Color.green;
                }
                if (row==3 && col==7) {
                	gridColors[row][col] = Color.green;
                }
                if (row==3 && col==8) {
                	gridColors[row][col] = Color.green;
                }
                
                if (row==4 && col==8) {
                	gridColors[row][col] = Color.red;
                }
                if (row==4 && col==9) {
                	gridColors[row][col] = Color.red;
                }
                if (row==5 && col==8) {
                	gridColors[row][col] = Color.red;
                }
                if (row==5 && col==9) {
                	gridColors[row][col] = Color.red;
                }
                
            }
        }
        int width = COLUMNS * CELL_SIZE + GRID_LINE_WIDTH;
        int height = ROWS * CELL_SIZE + GRID_LINE_WIDTH;
        setSize(width, height);

        addMouseListener(this);
    }

    public void paint(Graphics g) {
        // Draw grid lines
        g.setColor(Color.BLACK);
        for (int row = 0; row <= ROWS; row++) {
            int y = row * CELL_SIZE;
            g.fillRect(0, y, COLUMNS * CELL_SIZE, GRID_LINE_WIDTH);
        }
        for (int col = 0; col <= COLUMNS; col++) {
            int x = col * CELL_SIZE;
            g.fillRect(x, 0, GRID_LINE_WIDTH, ROWS * CELL_SIZE);
        }
        // Draw cells
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                g.setColor(gridColors[row][col]);
                g.fillRect(col * CELL_SIZE + GRID_LINE_WIDTH, row * CELL_SIZE + GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH);
                g.setColor(Color.black);
                g.drawString("1", 20,25);
                g.drawString("6", 70,25);
                g.drawString("5", 120,25);
                g.drawString("12", 420,25);
                
                g.drawString("2", 20,75);
                g.drawString("7", 70,75);
                g.drawString("8", 120,75);
                g.drawString("2", 170,75);
                g.drawString("4", 220,75);
                g.drawString("11",320,75);
                g.drawString("10",370,75);
                g.drawString("4", 420,75);
                g.drawString("6", 470,75);
                
                g.drawString("9", 20,125);
                g.drawString("4", 70,125);
                g.drawString("1", 170,125);
                g.drawString("3", 220,125);
                g.drawString("6", 270,125);
                g.drawString("1", 320,125);
                g.drawString("2", 370,125);
                g.drawString("8", 420,125);
                g.drawString("5", 470,125);
                
                g.drawString("3", 20,175);
                g.drawString("7", 220,175);
                g.drawString("5", 270,175);
                g.drawString("7", 320,175);
                g.drawString("3", 370,175);
                g.drawString("9", 420,175);
                
                g.drawString("4", 20,225);
                g.drawString("2", 70,225);
                g.drawString("5", 220,225);
                g.drawString("3", 270,225);
                g.drawString("2", 420,225);
                g.drawString("3", 470,225);
                
                g.drawString("3", 20,275);
                g.drawString("1", 70,275);
                g.drawString("1", 220,275);
                g.drawString("2", 270,275);
                g.drawString("4", 420,275);
                g.drawString("1", 470,275);
               
                g.drawString("6", 220,325);
                g.drawString("4", 270,325);
                
                
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / CELL_SIZE;
        int col = e.getX() / CELL_SIZE;
        gridColors[row][col] = Color.DARK_GRAY;
        
        
        repaint();
        if (runningMode.building == false) {
            if (gameMap.getTerritories().contains(gameMap.getTerritory(row,column))) {
            	gameMap.getTerritories().remove(gameMap.getTerritory(row,column));
	    		gameMap.getTerritory(row,column).disable();
	    		row = getRow();
	    		column = getCol();
	    		//gridCells[row][column].setBackground(Color.red);
	    		
            }
            else {
            	gameMap.getTerritories().add(gameMap.getTerritory(row,column));
            	gameMap.setRowAndCol();
	    		gameMap.getTerritory(row,column).enable();
	    		
            }
        
	    
	for (Territory item1 : gameMap.getTerritories()) {
	    			if (row==0 && col==0) {
	    				terCard.setTerCards("Yellow 1");
	    			}
	    			 if (row==0 && col==1) {
	    				 terCard.setTerCards("Yellow 6");
	                 }
	                 if (row==0 && col==2) {
	                	 terCard.setTerCards("Yellow 5");
	                 }
	                 if (row==1 && col==0) {
	                	 terCard.setTerCards("Yellow 2");
	                 }
	                 if (row==1 && col==1) {
	                	 terCard.setTerCards("Yellow 7");
	                 }
	                 if (row==1 && col==2) {
	                	 terCard.setTerCards("Yellow 8");
	                 }
	                 if (row==2 && col==0) {
	                	 terCard.setTerCards("Yellow 9");
	                 }
	                 if (row==2 && col==1) {
	                	 terCard.setTerCards("Yellow 4");
	                 }
	                 if (row==3 && col==0) {
	                	 terCard.setTerCards("Yellow 3");
	                 }
	                 
	                 if (row==4 && col==0) {
	                	 terCard.setTerCards("Pink 4");
	                 }
	                 if (row==4 && col==1) {
	                	 terCard.setTerCards("Pink 2");
	                 }
	                 if (row==5 && col==0) {
	                	 terCard.setTerCards("Pink 3");
	                 }
	                 if (row==5 && col==1) {
	                	 terCard.setTerCards("Pink 1");
	                 }
	                 
	                 if (row==1 && col==3) {
	                	 terCard.setTerCards("Blue 2");
	                 }
	                 if (row==2 && col==3) {
	                	 terCard.setTerCards("Blue 1");
	                 }
	                 if (row==1 && col==4) {
	                	 terCard.setTerCards("Blue 4");
	                 }
	                 if (row==2 && col==4) {
	                	 terCard.setTerCards("Blue 3");
	                 }
	                 if (row==3 && col==4) {
	                	 terCard.setTerCards("Blue 7");
	                 }
	                 if (row==2 && col==5) {
	                	 terCard.setTerCards("Blue 6");
	                 }
	                 if (row==3 && col==5) {
	                	 terCard.setTerCards("Blue 5");
	                 }
	                 
	                 if (row==4 && col==4) {
	                	 terCard.setTerCards("Orange 5");
	                 }
	                 if (row==4 && col==5) {
	                	 terCard.setTerCards("Orange 3");
	                 }
	                 if (row==5 && col==4) {
	                	 terCard.setTerCards("Orange 1");
	                 }
	                 if (row==5 && col==5) {
	                	 terCard.setTerCards("Orange 2");
	                 }
	                 if (row==6 && col==4) {
	                	 terCard.setTerCards("Orange 6");
	                 }
	                 if (row==6 && col==5) {
	                	 terCard.setTerCards("Orange 4");
	                 }
	                 
	                 if (row==1 && col==6) {
	                	 terCard.setTerCards("Green 11");
	                 }
	                 if (row==1 && col==7) {
	                	 terCard.setTerCards("Green 10");
	                 }
	                 if (row==1 && col==8) {
	                	 terCard.setTerCards("Green 4");
	                 }
	                 if (row==1 && col==9) {
	                	 terCard.setTerCards("Green 6");
	                 }
	                 if (row==0 && col==8) {
	                	 terCard.setTerCards("Green 12");
	                 }
	                 if (row==2 && col==6) {
	                	 terCard.setTerCards("Green 1");
	                 }
	                 if (row==2 && col==7) {
	                	 terCard.setTerCards("Green 2");
	                 }
	                 if (row==2 && col==8) {
	                	 terCard.setTerCards("Green 8");
	                 }
	                 if (row==2 && col==9) {
	                	 terCard.setTerCards("Green 5");
	                 }
	                 if (row==3 && col==6) {
	                	 terCard.setTerCards("Green 7");
	                 }
	                 if (row==3 && col==7) {
	                	 terCard.setTerCards("Green 3");
	                 }
	                 if (row==3 && col==8) {
	                	 terCard.setTerCards("Green 9");
	                 }
	                 
	                 if (row==4 && col==8) {
	                	 terCard.setTerCards("Red 2");
	                 }
	                 if (row==4 && col==9) {
	                	 terCard.setTerCards("Red 3");
	                 }
	                 if (row==5 && col==8) {
	                	 terCard.setTerCards("Red 4");
	                 }
	                 if (row==5 && col==9) {
	                	 terCard.setTerCards("Red 1");
	                 }

	            } 
	    
    		//terCard.getContentPane().add(label);

	    		
}    
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}


  
}

