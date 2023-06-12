package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.TimerTask;

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
	public boolean isAttack = false;
	public Territory territoryTo, territorySource, territoryTo2, territorySource2;
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

	int playerIndex = 0;

	TerrCardFrame terCard = new TerrCardFrame();
	public Territory selectedTer;

	Territory territoryFrom;
	ArrayList<Territory> terrsSelected = new ArrayList<Territory>();
	public int col, row;

	Color firstChosen = new Color(171, 200, 116);
	Color secondChosen = new Color(111, 130, 80);
	Color blue = new Color(0, 0, 155);

	public Grid() {

		this.gridColors = new Color[ROWS][COLUMNS];
		this.gridText = new String[ROWS][COLUMNS];
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
	}
	public void updatePlayerColorToGrid()
	{
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				Territory territory = Territory.isTerritory(row, col);
				if (territory != null) {
					if (territory.isEnabled()) {
						
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Red"))
						{
							this.gridColors[row][col] = Color.RED;
						}
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Blue"))
						{
							this.gridColors[row][col] = Color.BLUE;
						}
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Yellow"))
						{
							this.gridColors[row][col] = Color.YELLOW;
						}
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Pink"))
						{
							this.gridColors[row][col] = Color.PINK;
						}
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Orange"))
						{
							this.gridColors[row][col] = Color.ORANGE;
						}
						if(territory.getOwner() != null && territory.getOwner().getColor().equals("Green"))
						{
							this.gridColors[row][col] = Color.GREEN;
						}
						
					}

				}
			}
		}
	}

	public void updateGridText() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				Territory territory = Territory.isTerritory(row, col);
				if (territory != null) {
					if (territory.isEnabled()) {
						
						String armyNumStr = Integer.toString(territory.getArmyList().size());
						this.gridText[row][col] = armyNumStr;
					}

				}
			}
		}
	}

	private void initializeGridAndText() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				this.gridColors[row][col] = blue;
				this.gridText[row][col] = "";
				Territory territory = Territory.isTerritory(row, col);
				if (territory != null) {
					this.gridColors[row][col] = territory.getColor();
					String armyNumStr = Integer.toString(territory.getArmyList().size());
					this.gridText[row][col] = armyNumStr;
					territory.matchContinent(GameFrame.play.handler.getBoard());
					territory.matchMap(GameFrame.play.handler.getBoard());
				}

				// Set Link Implementation to Map
				if (row > 1 && Territory.isTerritory(row - 1, col) != null && Territory.isTerritory(row, col) != null) {
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row - 1, col));
				}
				if (col > 1 && Territory.isTerritory(row, col - 1) != null && Territory.isTerritory(row, col) != null) {
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row, col - 1));
				}

				if (Territory.isTerritory(row + 1, col) != null && Territory.isTerritory(row, col) != null) {
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row + 1, col));
				}
				if (Territory.isTerritory(row, col + 1) != null && Territory.isTerritory(row, col) != null) {
					Territory.isTerritory(row, col).setLink(Territory.isTerritory(row, col + 1));
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

			}
		}
	}

	int timer_count = 0;
	Timer timer;

	public void startColorChangeTimer() {
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer_count < 30) { // Change colors for 3 seconds (30 * 0.1 seconds)
					if (timer_count % 2 == 0) {
						changeGridColors(Color.BLACK);
					} else {
						changeGridColors(Color.WHITE);
					}
					timer_count++;

					repaint();
				} else {
					timer.stop(); // Stop the timer after 3 seconds
				}
			}
		});

		timer.start();
	}

	public void changeGridColors(Color color) {
		gridColors[row][col] = color;
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
		// System.out.println(row + col);
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
				if (selectedTer != null && !GameFrame.bmode.setLink) {
					selectedTer.setEnabled(false);
				}
				if (GameFrame.bmode.setLink) {
					if (territorySource2 == null) {
						gridColors[row][col] = firstChosen;
						firstChosenRow = row;
						firstChosenColumn = col;
						repaint();
						territorySource2 = Territory.isTerritory(row, col);
						System.out.println("territorySource :" + territorySource);
					} else {
						gridColors[row][col] = secondChosen;
						secondChosenRow = row;
						secondChosenColumn = col;
						repaint();
						territoryTo2 = Territory.isTerritory(row, col);
						System.out.println("territoryTo :" + territoryTo);
						// territorySource.setLink(territoryTo);
						if (!territoryTo2.getAdjacentTerritories().contains(territorySource2)) {
							territoryTo2.setLink(territorySource2);
							System.out.println(territoryTo2.getAdjacentTerritories().size());
							System.out.println("Linklendiiii");
							territoryTo2 = null;
							territorySource2 = null;
							GameFrame.bmode.setLink = false;
						}

					}
				}

			}
		}

		if (GameFrame.sharing.init) {
			if (gridColors[row][col] != Color.DARK_GRAY && gridColors[row][col] != blue
					&& gridColors[row][col] != Color.WHITE && gridColors[row][col] != Color.CYAN
					&& gridColors[row][col] != Color.MAGENTA && gridColors[row][col] != Color.LIGHT_GRAY
					&& gridColors[row][col] != Color.BLACK) {

				index = selectedTer.getIndex();
				if (!GameFrame.sharing.getButton().isEnabled()) {
					if (isIndFlag()) {
						playerIndex = 0;
						setIndFlag(false);
					}

					ArrayList<Player> players = GameFrame.playerArray;
					gridColors[row][col] = GameFrame.sharing.addColors().get(playerIndex);
					repaint();

					if (selectedTer.isEnabled()) {
						players.get(playerIndex).chooseATerritory(selectedTer);
						players.get(playerIndex).placeArmy(selectedTer, "Infantry");
						// updateGridText();
						String armyNumStr = Integer.toString(selectedTer.getArmyList().size());
						this.gridText[row][col] = armyNumStr;
					}

					if (selectedTer.isEnabled()) {
						if (selectedTer.getOwner().equals(players.get(playerIndex))) {
							if (playerIndex == (players.size() - 1)) {

								playerIndex = 0;
							} else {
								playerIndex++;

							}
							
							for (int i = 0; i < players.size(); i++) {
								if (players.get(i).getInfantryList().size() != 0) {
									infFlag = false;
								}
							}
							if (infFlag) {
								// burada shuffle Ã§aÄrÄ±lacak

							}
						}
					}

				}

			}

			else if (GameFrame.sharing.addColors().contains(gridColors[row][col])) {
				if (gridColors[row][col] == GameFrame.sharing.addColors().get(playerIndex)) {
					index = selectedTer.getIndex();
					if (!GameFrame.sharing.getButton().isEnabled()) {
						if (isIndFlag()) {
							playerIndex = 0;
							setIndFlag(false);
						}

						ArrayList<Player> players = GameFrame.playerArray;
						gridColors[row][col] = GameFrame.sharing.addColors().get(playerIndex);
						System.out.println("player index" + playerIndex);
						repaint();

						if (selectedTer.isEnabled()) {
							System.out.println("Territory enable mý?" + selectedTer.isEnabled());
							players.get(playerIndex).chooseATerritory(selectedTer);
							players.get(playerIndex).placeArmy(selectedTer, "Infantry");
							// updateGridText();
							String armyNumStr = Integer.toString(selectedTer.getArmyList().size());
							this.gridText[row][col] = armyNumStr;
						}
						if (selectedTer.isEnabled()) {
							if (selectedTer.getOwner().equals(players.get(playerIndex))) {
								if (playerIndex == (players.size() - 1)) {

									playerIndex = 0;
								} else {

									System.out.println("playerIndex: " + playerIndex);
									playerIndex++;

								}
								System.out.println("-------");
								for (int i = 0; i < players.size(); i++) {
									if (players.get(i).getInfantryList().size() != 0) {
										infFlag = false;
									}
								}

							}
						}

					} else {
						System.out.println("choose again.");
					}
				}

			} else {
				System.out.println("choose again.");

			}
		}

		else if (GameFrame.play.playMode) {
			System.out.println("PLAYMODE");
			if (territorySource == null || territoryTo != null) {
				if (Territory.isTerritory(row, col).isEnabled()) {
					territorySource = Territory.isTerritory(row, col);
					gridColors[row][col] = firstChosen;
					firstChosenRow = row;
					firstChosenColumn = col;
					repaint();

				}
				territoryTo = null;
			} else {
				if (Territory.isTerritory(row, col).isEnabled()) {
					gridColors[row][col] = secondChosen;
					secondChosenRow = row;
					secondChosenColumn = col;
					repaint();
					territoryTo = Territory.isTerritory(row, col);
					
					GameFrame.play.numFortify.setEnabled(true);
					GameFrame.play.btnRoll.setEnabled(true);
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