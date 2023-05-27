package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import domain.Map;
import domain.Player;
import domain.Territory;

public class Grid extends JPanel implements MouseListener {


	private static final int ROWS = 17;
	private static final int COLUMNS = 17;
	private static final int CELL_SIZE = 50;
	private static final int GRID_LINE_WIDTH = 2;
	Color[][] gridColors;
	private String[][] gridText;
	int index = 0;
	TerrCardFrame terCard = new TerrCardFrame();
	Player player = new Player();
	static Map gameMap;
	Territory territoryFrom;
	ArrayList<Territory> terrsSelected = new ArrayList<Territory>();
	public int col, row;

	// Territory territoryIs = Territory.isTerritory(row, col);
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
	
	public void mouseClicked(MouseEvent e) {
		row = e.getY() / CELL_SIZE;
		col = e.getX() / CELL_SIZE;

		if (GameFrame.init) {
			if (gridColors[row][col] != Color.GRAY && gridColors[row][col] != blue) {
				gridColors[row][col] = Color.CYAN;
				repaint();

			 Territory territoryIs = Territory.isTerritory(row, col);
				// index=territory2.getIndex();

				if (territoryIs != null) {
					player.territoryList.add(territoryIs);
					terCard.setTerritoryCard(getColorName(territoryIs.getColor()), territoryIs.getText(), index, 20, 100);
					
//String name, String text, Color color, int index
				}
				index = territoryIs.getIndex();
			}

			else {
				System.out.println("choose again.");
			}
		}

		else if (GameFrame.build) {
			if (gridColors[row][col] != blue) {
				gridColors[row][col] = Color.GRAY;

				repaint();

			 Territory territoryIs = Territory.isTerritory(row, col);
//				index = territoryIs.getIndex();
				//System.out.println("index" + index);
				if (territoryIs != null) {
					territoryIs.setEnabled(false);
				}
			}
		}

		else if (GameFrame.playMode) {
			//playerları create edip turn turn ayırmak lazım
			//sectigin terr e değiştir isterritory
			//territorydeki asker sayısını goster
			
			Territory territoryIs = Territory.isTerritory(row, col);
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
			//rengini değiştirme 
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