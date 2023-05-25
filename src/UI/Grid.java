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
    int index=0;  
    territoryCardFrame terCard = new territoryCardFrame();
    static Map gameMap;
    private int column, row;
    
    public Grid() {
        this.gridColors = new Color[ROWS][COLUMNS];
        this.gridText = new String[ROWS][COLUMNS];
        this.gameMap = new Map();

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
                this.gridColors[row][col] = Color.DARK_GRAY;
                this.gridText[row][col] = "";
                TerritoryUI territory = TerritoryUI.isTerritory(row, col);
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
        int row = e.getY() / CELL_SIZE;
        int col = e.getX() / CELL_SIZE;

        gridColors[row][col] = Color.DARK_GRAY;
        repaint();

        //if (!runningMode.isBuilding()) {
        TerritoryUI territory2 = TerritoryUI.isTerritory(row, col);
            index=territory2.getIndex();
            
            if (territory2 != null) {
            		System.out.println(getColorName(territory2.getColor()));   
            		System.out.println(index);
                    terCard.setTerritoryCard(getColorName(territory2.getColor()), territory2.getText(),index,20,100);                  
                    System.out.println(index);
            }
       // }
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
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}