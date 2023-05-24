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
    Color[][] gridColors;
    private String[][] gridText;
    int index=0;  
    TerrCardFrame terCard = new TerrCardFrame();
    static Map gameMap;
    public int col, row;
    Territory territory = new Territory();
    Territory territoryIs = Territory.isTerritory(row, col);
    Color  blue   = new Color(0, 0, 155);
    
    public Grid() {
        this.gridColors = new Color[ROWS][COLUMNS];
        this.gridText = new String[ROWS][COLUMNS];
        

        initializeGridAndText();
        setupUI();
        addMouseListener(this);
    }

    
    private void setupUI() {
        int width = COLUMNS * CELL_SIZE + GRID_LINE_WIDTH;
        int height = ROWS * CELL_SIZE + GRID_LINE_WIDTH;
        setSize(width, height);
    }

    private void initializeGridAndText() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                this.gridColors[row][col] = blue;
                this.gridText[row][col] = "";
                Territory territory = Territory.isTerritory(row, col);
                if (territory != null) {
                    this.gridColors[row][col] = territory.getColor();
                    this.gridText[row][col] = territory.getText();
                }
            }
        }
    }

    public void paint(Graphics g) {
        drawGridLines(g);
        drawCells(g);
    }

    private void drawGridLines(Graphics g) {
        g.setColor(Color.BLACK);
        for (int row = 0; row <= ROWS; row++) {
            int y = row * CELL_SIZE;
            g.fillRect(0, y, COLUMNS * CELL_SIZE, GRID_LINE_WIDTH);
        }
        for (int col = 0; col <= COLUMNS; col++) {
            int x = col * CELL_SIZE;
            g.fillRect(x, 0, GRID_LINE_WIDTH, ROWS * CELL_SIZE);
        }
    }

    private void drawCells(Graphics g) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                g.setColor(gridColors[row][col]);
                g.fillRect(col * CELL_SIZE + GRID_LINE_WIDTH, row * CELL_SIZE + GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH);
                g.setColor(Color.black);
                g.drawString(gridText[row][col], col * CELL_SIZE + GRID_LINE_WIDTH + 20, row * CELL_SIZE + GRID_LINE_WIDTH + 25);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        row = e.getY() / CELL_SIZE;
        col = e.getX() / CELL_SIZE;
        
        if (GameFrame.init) {
        	if (gridColors[row][col] != Color.GRAY && gridColors[row][col] != blue) {
	        gridColors[row][col] = Color.CYAN;
	        repaint();
	
	        //Territory territory2 = Territory.isTerritory(row, col);
	            //index=territory2.getIndex();
	            
	            if (territoryIs != null) {
	            		System.out.println(getColorName(territoryIs.getColor()));   
	            		System.out.println(index);
	                    terCard.setTerritoryCard(getColorName(territoryIs.getColor()), territoryIs.getText(),index,20,100);  
	                    System.out.println("index" + index);
	                    
	            }
	            index=territoryIs.getIndex();
	        }
        	
        	else{
        		System.out.println("choose again.");
        	}
        }
        
        else if (GameFrame.build) {
        	if (gridColors[row][col] != blue) {
        		gridColors[row][col] = Color.GRAY;
        		
    	        repaint();
    	        
    	        //Territory ter = Territory.isTerritory(row, col);
	            index=territoryIs.getIndex();
	            System.out.println("index" + index);
	            if (territoryIs != null) {
	            	territoryIs.setEnabled(false);
	            }
	        }
        		
    	}
        
        else if (GameFrame.playMode) {
        	gridColors[row][col] = Color.BLACK;
        	repaint();
        	//if (territory.getAdjacentTerritories())
        	//secilen territory i bu arraylistte arasın eger varsa + asker sayısı uyumluysa saldır
        	for(int i = 0; i< territory.getAdjacentTerritories().size(); i++) {
        		if (territory.getAdjacentTerritories().contains(territoryIs)) { // && army sayısı tutuyosa
        			
        			
        		}
        	}
        }
        	
        
	        
        }
    
    
    
    public String getColorName(Color color) {
        if (color.equals(Color.BLACK)) {
            return "Black";
        } else if (color.equals(Color.BLUE)) {
            return "Blue";
   
        } else if (color.equals(Color.DARK_GRAY)) {
            return "Dark Gray";

        } else if (color.equals(Color.GREEN)) {
            return "Green";
        } else if (color.equals(Color.LIGHT_GRAY)) {
            return "Light Gray";
   
        } else if (color.equals(Color.ORANGE)) {
            return "Orange";
        } else if (color.equals(Color.PINK)) {
            return "Pink";
        } else if (color.equals(Color.RED)) {
            return "Red";
       
        } else if (color.equals(Color.YELLOW)) {
            return "Yellow";
        } else {
            return "Unknown";
        }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}