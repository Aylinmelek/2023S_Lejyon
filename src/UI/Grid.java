package UI;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Map;
import domain.Territory;


public class Grid extends JPanel {
	
    static final int GRID_SIZE = 10;

    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final Color SELECTED_COLOR = Color.gray;
    private static final Color SELECTED = Color.red;
    public Color[][] gridColors;
    public JPanel[][] gridCells;
    
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
    
    public void addGrid() {
        gridColors = new Color[GRID_SIZE][GRID_SIZE];
        gridCells = new JPanel[GRID_SIZE][GRID_SIZE];
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
       // setLayout(new GridLayout(822, 263));
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
          /*  JPanel cell = new JPanel();
            cell.setBackground(DEFAULT_COLOR);
            add(cell);*/
        	JPanel cell = new JPanel();
            cell.setBackground(DEFAULT_COLOR);
            add(cell);
            int column = i % GRID_SIZE;
            int row = i / GRID_SIZE;
            gridCells[column][row] = cell;
            
       
        }
        
        // Paint the region with SELECTED_COLOR initially
        gridColors[0][0] = SELECTED_COLOR;
        JPanel cell = gridCells[0][0];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
       
        cell = gridCells[0][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[0][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("9"));
        
        cell = gridCells[0][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[1][0];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("6"));
        
        cell = gridCells[1][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("7"));
        
        cell = gridCells[1][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[2][0];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("5"));
        
        cell = gridCells[2][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("8"));
        
        cell = gridCells[0][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[0][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[1][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[1][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
        cell = gridCells[3][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[4][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[3][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
        cell = gridCells[4][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[4][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("7"));
        
        cell = gridCells[5][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("6"));
        
        cell = gridCells[5][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("5"));
        
        cell = gridCells[4][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("5"));
        
        cell = gridCells[5][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[4][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
        cell = gridCells[5][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[4][6];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("6"));
        
        cell = gridCells[5][6];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[6][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("11"));
        
        cell = gridCells[6][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
        cell = gridCells[6][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("7"));

        
        cell = gridCells[7][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("10"));
        
        cell = gridCells[7][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[7][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[8][0];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("12"));
        
        cell = gridCells[8][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[8][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("8"));
        
        cell = gridCells[8][3];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("9"));
        
        cell = gridCells[9][1];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("6"));
        
        cell = gridCells[9][2];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("5"));
        
        cell = gridCells[8][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("2"));
        
        cell = gridCells[8][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("4"));
        
        cell = gridCells[9][4];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("3"));
        
        cell = gridCells[9][5];
        cell.setBackground(SELECTED_COLOR);
        cell.setLayout(new GridLayout());
        cell.add(new NumberPanel("1"));
        
       
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	
            	    int cellWidth = getWidth() / GRID_SIZE;
            	    int cellHeight = getHeight() / GRID_SIZE;

            	    column = e.getX() / cellWidth;
            	    row = e.getY() / cellHeight;
            	    
            	   /* System.out.print("row: ");
            	    System.out.println(row);
            	    System.out.print("col: ");
            	    System.out.println(column);*/
            	    
            	    if (runningMode.building == false) {
    	                if (gameMap.getTerritories().contains(gameMap.getTerritory(row,column))) {
    	                	gameMap.getTerritories().remove(gameMap.getTerritory(row,column));
            	    		gameMap.getTerritory(row,column).disable();
            	    		
    	                }
    	                else {
    	                	gameMap.getTerritories().add(gameMap.getTerritory(row,column));
            	    		gameMap.getTerritory(row,column).enable();
            	    		
    	                }
    	            
            	    
            	    		for (Territory item1 : gameMap.getTerritories()) {
            	                System.out.println(item1);
            	            } 
            	    
            	    	

            	    if (column >= 0 && column < GRID_SIZE && row >= 0 && row < GRID_SIZE) {
            	    	
            	    	
            	       // Color newColor = gridColors[column][row] == SELECTED_COLOR ? DEFAULT_COLOR : SELECTED_COLOR;
            	    	Color newColor = gridColors[column][row] == SELECTED_COLOR ? DEFAULT_COLOR : DEFAULT_COLOR;
            	        if (gridColors[column][row] == DEFAULT_COLOR) {
            	    		
            	    		

            	    	}
            	    	else if (gridColors[column][row] == SELECTED_COLOR) {
            	    		
            	    	}
            	        gridColors[column][row] = newColor;
            	        JPanel cell = (JPanel) getComponent(column + row * GRID_SIZE);
            	        cell.setBackground(newColor);
            	        repaint(); // repaint the panel to update the colors
            	    }
     
            }
            }    
        });

		
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int cellWidth = getWidth() / GRID_SIZE;
        int cellHeight = getHeight() / GRID_SIZE;
        
     // Draw grid lines
        g.setColor(Color.BLACK);
        for (int i = 0; i <= GRID_SIZE; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }
        for (int i = 0; i <= GRID_SIZE; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }
       
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (gridColors[i][j] == SELECTED_COLOR) {
                    g.setColor(SELECTED_COLOR);
                    g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);           
                }
            }
        }
        
        
    }
    
    private static class NumberPanel extends JPanel {
        private final String number;
        
        public NumberPanel(String number) {
            this.number = number;
            setBackground(SELECTED_COLOR);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(DEFAULT_COLOR);
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            int x = getWidth() / 2 - g.getFontMetrics().stringWidth(number) / 2;
            int y = getHeight() / 2 + g.getFontMetrics().getAscent() / 2;
            g.drawString(number, x, y);
        }
    }

}

