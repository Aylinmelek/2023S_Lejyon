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

public class Grid extends JPanel implements MouseListener {


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
			}
		}
	}
	/*
	public void callTerr(Territory terr) {
		if (terr != null) {
			
			
			terCard.setTerritoryCard(getColorName(terr.getColor()), terr.getText(), index, 20, 100);
			//terCard.setVisible(true);
			
		}
		
	

		return terr;
	}*/
	
	public Territory getSelectedTer() {
		return selectedTer;
	}

	public void setSelectedTer(Territory selectedTer) {
		this.selectedTer = selectedTer;
	}

	public void mouseClicked(MouseEvent e) {
		infFlag = true;
		row = e.getY() / CELL_SIZE;
		col = e.getX() / CELL_SIZE;
		//System.out.println(row + col);
		selectedTer = Territory.isTerritory(row, col);
		
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
					
					
					terCard.setTerritoryCard(getColorName(selectedTer.getColor()), selectedTer.getText(), index, 20, 100);
					//terCard.setVisible(true);
					
				}
				index = selectedTer.getIndex();
				
				
                //max_player.setNumOfInfantry(max_player.getNumOfInfantry()-1);
				
				if(!GameFrame.sharing.getButton().isEnabled()) {
					if(isIndFlag()) {

						//playerIndex=GameFrame.sharing.getInd();

						playerIndex=0;
						setIndFlag(false);
					}

					ArrayList<Player> players = GameFrame.playerArray;

				//ArrayList<Player> players = GameFrame.sharing.conKUeror.playerList;
					/*System.out.println("playerArray size in grid: "+ GameFrame.playerArray.size());
					ArrayList<Player> players = GameFrame.playerArray;*/


					
				//ArrayList<Player> players = GameFrame.playerArray;
					
                

                	//players.get(i).setNumOfInfantry(players.get(i).getNumOfInfantry()-1);
                	//Infantry inf = new Infantry();
                	players.get(playerIndex).chooseATerritory(selectedTer);
                	players.get(playerIndex).placeArmy(selectedTer, "Infantry");
                	
                	//System.out.println(players.get(playerIndex).getTerritoryList().get(0));
                	//System.out.println(players.get(playerIndex).getName());
                	System.out.println(players.get(playerIndex));
           	        
           	     	//GameFrame.play.add(txtPlayerTurn);
           	     

                	System.out.println(players.get(playerIndex));
                	
                    System.out.println(selectedTer);
                	//players.get(i).chooseATerritory(null)
                    System.out.println(players.get(playerIndex).getInfantryList().size());
                    System.out.println(selectedTer.getArmyList().size());//aynı territory çağrıldığında size değişmiyor, ancak 4 player yani totalde 4 army eklendiğinde size 1 artıyor
                    
                    
                    if (playerIndex==(players.size()-1)) {
                    		//GameFrame.sharing.getTemp()) {
                    	System.out.println("playersList finished");
                    	playerIndex=0;
                    }
                    else {
                    	
                    	System.out.println("playerIndex: "+ playerIndex);
                    	playerIndex++;
                    	
                    }
                    System.out.println("-------");
                    //System.out.println("playerIndex: "+ playerIndex);
                    for(int i=0; i<players.size(); i++) {
                    	if(players.get(i).getInfantryList().size()!=0) {
                    		infFlag = false;
                    	}
                    }
                    if(infFlag) {
                    	//burada shuffle çağrılacak
                    }

                    
                    
                    //System.out.println("player: "+ players.get(playerIndex));
                    
                
                
                /*
                for (int i = 0; i<ind; i++) {
                	//players.get(i).setNumOfInfantry(players.get(i).getNumOfInfantry()-1);
                	Infantry inf2 = new Infantry();
                	players.get(i).chooseATerritory(GameFrame.bmode.grid.callTerr(GameFrame.bmode.grid.getSelectedTer()));
                	
                	players.get(i).placeArmy(GameFrame.bmode.grid.callTerr(GameFrame.bmode.grid.getSelectedTer()), inf2);
                    
                    System.out.println(players.get(i).getTerritoryList().get(0));
                    System.out.println("-------");
                    System.out.println(GameFrame.bmode.grid.getSelectedTer());
                }*/
                
                
				}
			
			
			
			
			
			}
				
				/*if (terr != null) {
					
					
					terCard.setTerritoryCard(getColorName(terr.getColor()), terr.getText(), index, 20, 100);
					//terCard.setVisible(true);
					
				}
				index = terr.getIndex();
			} */
		  
			else {
				System.out.println("choose again.");
			}
		}

		

		else if (GameFrame.play.playMode) {
			System.out.println("PLAYMODE");
			//playerları create edip turn turn ayırmak lazım
			//sectigin terr e değiştir isterritory
			//territorydeki asker sayısını goster
			
			/*
			Territory selectedTerr = Territory.territories[row][col];
			terrsSelected.add(Territory.territories[row][col]);
			System.out.println(player.canAttackTerritory(terrsSelected.get(0), selectedTerr));
			// once kendi territorymi secip untill baska kendi territorye basana kadar attack territorysi secebiliyorum. 
			if (player.getTerritoryList().contains(selectedTerr) && player.canAttackTerritory(terrsSelected.get(0), selectedTerr)) {
				gridColors[row][col] = Color.GRAY;
				//asker 
				repaint();
				System.out.println("size" + terrsSelected.get(0).getAdjacentTerritories().size());
					for (int i = 0; i<terrsSelected.get(0).getAdjacentTerritories().size(); i++) {
						if (selectedTerr == terrsSelected.get(0).getAdjacentTerritories().get(i)) {
							gridColors[row][col] = Color.BLACK;
							repaint();
							//asker koy kac asker koydugunu display et
							
							//if kazanırsan 
							//else terr rengi + asker sayısı vs vs 
								
						}
					}
				}		
			//rengini değiştirme*/
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