package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import domain.Infantry;
import domain.Map;
import domain.Player;
import domain.Territory;
import domain.controller.ConKUerorHandler;

public class Grid extends JPanel implements MouseListener, MouseMotionListener {


	public static final int ROWS = 17;
	public static final int COLUMNS = 17;
	public static final int CELL_SIZE = 50;
	public static final int GRID_LINE_WIDTH = 2;
	public Color[][] gridColors;
	private String[][] gridText;
	int index = 0;
	private boolean indFlag = true;
	private boolean infFlag;

    JTextArea txtPlayerTurn = new JTextArea();
    //public PlayingMode playMode = new PlayingMode();
	public boolean isAttack = false;
	public Territory territoryTo, territorySource;
	public int firstChosenRow, firstChosenColumn, secondChosenRow, secondChosenColumn;
	public ConKUerorHandler handler = new ConKUerorHandler();
	
	private Point startPoint;
    private Point endPoint;
	
	
	public boolean isIndFlag() {
		return indFlag;
	}

	public void setIndFlag(boolean indFlag) {
		this.indFlag = indFlag;
	}

	int playerIndex=0;


	TerrCardFrame terCard = new TerrCardFrame();
	public Territory selectedTer;
	//Player player = new Player();
	
	
	
	Territory territoryFrom;
	ArrayList<Territory> terrsSelected = new ArrayList<Territory>();
	public int col, row;

	// Territory territoryIs = Territory.isTerritory(row, col);
	Color firstChosen = new Color(171,200,116);
	Color secondChosen = new Color(111,130,80);
	Color blue = new Color(0, 0, 155);
	ImageIcon deneme = new ImageIcon(this.getClass().getResource("/die1.png"));

	public Grid() {
		
		this.gridColors = new Color[ROWS][COLUMNS];
		this.gridText = new String[ROWS][COLUMNS];
		
		/*JLabel label = new JLabel("Your Label Text");
        label.setBounds(100, 100, 40, 40);
        setComponentZOrder(label, 0);
        add(label);*/

		initializeGridAndText();
		setupUI();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void setupUI() {
		int width = COLUMNS * CELL_SIZE + GRID_LINE_WIDTH;
		int height = ROWS * CELL_SIZE + GRID_LINE_WIDTH;
		setLayout(null);
		setSize(width, height);
		/*ImageIcon deneme = new ImageIcon(this.getClass().getResource("/die1.png"));
		JLabel labeldeneme = new JLabel(deneme);
		//labeldeneme.setBounds(100,100,40,40);
		setComponentZOrder(labeldeneme, 0);
		add(labeldeneme);
		
		JLabel labeldeneme2 = new JLabel("Label");
	    labeldeneme2.setBounds(100, 100, 40, 40);
	    setComponentZOrder(labeldeneme2, 0);
	    // Add the label to the panel
	    add(labeldeneme2);*/
	    
		repaint();
		
		
         
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
					territory.matchContinent(GameFrame.play.handler.getBoard());
				}
				
				//Set Link Implementation to Map
				if(row > 1 && Territory.isTerritory(row-1, col) != null  && Territory.isTerritory(row, col) != null)
				{
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row-1, col));
					Territory.isTerritory(row-1, col).setLink(Territory.isTerritory(row, col));
				}
				if(col > 1 && Territory.isTerritory(row, col-1) != null  && Territory.isTerritory(row, col) != null)
				{
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row, col-1));
					Territory.isTerritory(row, col-1).setLink(Territory.isTerritory(row, col));
				}
				
				if(Territory.isTerritory(row+1, col) != null && Territory.isTerritory(row, col) != null)
				{
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row+1, col));
					Territory.isTerritory(row+1, col).setLink(Territory.isTerritory(row, col));
				}
				if(Territory.isTerritory(row, col+1) != null  && Territory.isTerritory(row, col) != null)
				{
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row, col+1));
					Territory.isTerritory(row, col+1).setLink(Territory.isTerritory(row, col));
				}
				
			}
		}
	}

	public void paint(Graphics g) {
		drawGridLines(g);
		drawCells(g);
		if (startPoint != null && endPoint != null) {
			if (GameFrame.play.playMode == true) {
				
				Graphics2D g2d = (Graphics2D) g;
	            g2d.setStroke(new BasicStroke(3));

	            int arrowHeadSize = 12;

	            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

	            Polygon arrowHead = new Polygon();
	            arrowHead.addPoint(endPoint.x, endPoint.y);
	            arrowHead.addPoint(endPoint.x - arrowHeadSize, endPoint.y - arrowHeadSize);
	            arrowHead.addPoint(endPoint.x - arrowHeadSize, endPoint.y + arrowHeadSize);
	            g2d.fillPolygon(arrowHead);
			}
        }
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
				g.fillRect(col * CELL_SIZE + GRID_LINE_WIDTH, row * CELL_SIZE + GRID_LINE_WIDTH,
						CELL_SIZE - GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH);
				g.setColor(Color.black);
				g.drawString(gridText[row][col], col * CELL_SIZE + GRID_LINE_WIDTH + 20,
						row * CELL_SIZE + GRID_LINE_WIDTH + 25);
				
				if (row == 2 && col == 3) { // Customize the row and column as needed
	                JLabel label = new JLabel(deneme);
	                label.setBounds(col * CELL_SIZE + GRID_LINE_WIDTH, row * CELL_SIZE + GRID_LINE_WIDTH,
	                        CELL_SIZE - GRID_LINE_WIDTH, CELL_SIZE - GRID_LINE_WIDTH);
	                add(label);
	            }
			}
		}
	}
	
	public Territory getSelectedTer() {
		return selectedTer;
	}

	public void setSelectedTer(Territory selectedTer) {
		this.selectedTer = selectedTer;
	}



  
    public void mouseMoved(MouseEvent e) {
        if (startPoint != null) {
            endPoint = e.getPoint();
            repaint();
        }
    }
	
	public void mouseClicked(MouseEvent e) {
		infFlag = true;
		row = e.getY() / CELL_SIZE;
		col = e.getX() / CELL_SIZE;
		//System.out.println(row + col);
		selectedTer = Territory.isTerritory(row, col);
		
		 if (startPoint == null) {
	            startPoint = e.getPoint();
	        } else {
	            endPoint = e.getPoint();
	            repaint();
	            startPoint = null;
	            endPoint = null;
	        }
		
		 if (GameFrame.bmode.build) {
			if (gridColors[row][col] != blue) {
				gridColors[row][col] = Color.GRAY;
				repaint();
				//index = territoryIs.getIndex();
				//System.out.println("index" + index);
				if (selectedTer != null) {
					selectedTer.setEnabled(false);
				}
			}
		}

		  if (GameFrame.sharing.init) {
			 
			 
			 
			if (gridColors[row][col] != Color.GRAY && gridColors[row][col] != blue) {
				gridColors[row][col] = Color.CYAN;
				
				repaint();
				//callTerr(selectedTer);
				if (selectedTer != null) {
					
					
					//terCard.setTerritoryCard(getColorName(selectedTer.getColor()), selectedTer.getText(), index, 20, 100);
					terCard.setTerritoryCard(getColorName(selectedTer.getColor()), selectedTer.getText(), index);
					//terCard.setVisible(true);
					
				}
				index = selectedTer.getIndex();
				if(!GameFrame.sharing.getButton().isEnabled()) {
					if(isIndFlag()) {
						playerIndex=0;
						setIndFlag(false);
					}

					ArrayList<Player> players = GameFrame.playerArray;

		          	players.get(playerIndex).chooseATerritory(selectedTer);
                	players.get(playerIndex).placeArmy(selectedTer, "Infantry");
                  	System.out.println(players.get(playerIndex));
           	      	System.out.println(players.get(playerIndex));
                	
                    System.out.println(selectedTer);
                    System.out.println(players.get(playerIndex).getInfantryList().size());
                    System.out.println(selectedTer.getArmyList().size());//aynı territory çağrıldığında size değişmiyor, ancak 4 player yani totalde 4 army eklendiğinde size 1 artıyor
                    
                    
                    if (playerIndex==(players.size()-1)) {
                    	System.out.println("playersList finished");
                    	playerIndex=0;
                    }
                    else {
                    	
                    	System.out.println("playerIndex: "+ playerIndex);
                    	playerIndex++;
                    	
                    }
                    System.out.println("-------");
                    for(int i=0; i<players.size(); i++) {
                    	if(players.get(i).getInfantryList().size()!=0) {
                    		infFlag = false;
                    	}
                    }
                    if(infFlag) {
                    	//burada shuffle çağrılacak
                    }                    
      			}
			
			}
				else {
				System.out.println("choose again.");
			}
		}

		

		else if (GameFrame.play.playMode) {
			System.out.println("PLAYMODE");
				if(territorySource == null)
			{
				gridColors[row][col] = firstChosen;
				firstChosenRow = row;
				firstChosenColumn = col;
				repaint();
				territorySource = Territory.isTerritory(row, col);
				System.out.println("territorySource :"+territorySource);
			}
			else {
				gridColors[row][col] = secondChosen;
				secondChosenRow = row;
				secondChosenColumn = col;
				repaint();
				territoryTo = Territory.isTerritory(row, col);
				System.out.println("territoryTo :"+territoryTo);
				//territorySource.setLink(territoryTo);
				GameFrame.play.numFortify.setEnabled(true);
				
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			}

	@Override 
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

}