package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Die;

import domain.Player;

import domain.controller.ConKUerorHandler;

public class PlayingMode extends JLayeredPane {
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
	JButton btnRoll = new JButton("ROLL DIE");
	JButton btnSkip = new JButton("SKIP/END TURN");
	JButton btnInstr = new JButton("How to Play");
	JButton btnPickChance = new JButton("Pick a Chance Card");
	JButton btnTACard = new JButton("Pick a Territory/Army Card");
	JButton btnAttack = new JButton("Attack");
	JButton btnFortify = new JButton("Fortify");
	JButton btnPlace = new JButton("Place Army");
	JButton btnFinish = new JButton("Finish The Game");
	JButton btnMenu = new JButton("Menu");
	JTextArea txtCard = new JTextArea();
	public int roll3 = 0;
	public boolean chance = false;
	JComboBox<Integer> numFortify = new JComboBox<Integer>();
	public boolean isAttack;

	JTextArea txtPlayerTurn = new JTextArea();
	int indexOfPlayer = 0;

	private boolean indFlag = true;

	JLabel dieLabel = new JLabel();
	public boolean playMode = false;
	public ConKUerorHandler handler = new ConKUerorHandler();

	Die die = new Die();
	int roll1, roll2;
	ArrayList<Integer> playerArray = new ArrayList<Integer>();
	ArrayList<Integer> compPlayerArray = new ArrayList<Integer>();
	int dieDisplayed, finalDieDisplayed;
	int dieNumber;


	ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
	ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
	ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
	ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
	ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
	ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

	public PlayingMode() {
		super();
		initialize();
		
	}

	
	public void initialize() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 54, 873, 451);
		handler.createMainDeck(10, 10, handler.getBoard().deck);
		btnRoll.setEnabled(false);
		setLayout(null);

	}

	public void displayDie() {
		Thread rollThread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				die.roll();
				dieDisplayed = die.getDiceValue();

				switch (dieDisplayed) {
				case 1:
					dieLabel.setIcon(die1);
					break;
				case 2:
					dieLabel.setIcon(die2);
					break;
				case 3:
					dieLabel.setIcon(die3);
					break;
				case 4:
					dieLabel.setIcon(die4);
					break;
				case 5:
					dieLabel.setIcon(die5);
					break;
				case 6:
					dieLabel.setIcon(die6);
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			finalDieDisplayed = dieNumber;
			if(roll3 == 0)
			{
				roll3 = die.getDiceValue();
				System.out.println(roll3);
			}
			if (roll1 == 0) {
				roll1 = die.getDiceValue();
			} else {
				roll2 = die.getDiceValue();
			}
			if (roll1 != 0 && roll2 != 0 && GameFrame.bmode.grid.territorySource != null
					&& GameFrame.bmode.grid.territoryTo != null) {

				int armyCountBefore = GameFrame.bmode.grid.territoryTo.getArmyList().size();
				handler.getBoard().attack(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),
						GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo, roll1, roll2);
				int armyCountAfter = GameFrame.bmode.grid.territoryTo.getArmyList().size();
				GameFrame.bmode.grid.startColorChangeTimer();
				repaint();
				if (armyCountBefore > armyCountAfter) {
					GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.secondChosenRow][GameFrame.bmode.grid.secondChosenColumn]= Color.BLACK;
					repaint();
				}
				GameFrame.bmode.grid.territorySource = null;
				GameFrame.bmode.grid.territoryTo = null;
				numFortify.setEnabled(false);
				btnTer.setEnabled(true);
				btnArmy.setEnabled(true);
				btnChance.setEnabled(true);

				btnPickChance.setEnabled(true);
				btnTACard.setEnabled(true);
				btnSkip.setEnabled(true);
				btnFortify.setEnabled(true);
				btnRoll.setEnabled(false);

				roll1 = 0;
				roll2 = 0;
				
				
			}
			
			
			
			GameFrame.bmode.grid.updateGridText();
			
		});
		rollThread.start();
	}

	public void addElements() {
		
		numFortify.setBounds(800, 467, 64, 27);
		numFortify.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 0, 1, 2, 3, 4, 5, 6 }));
		numFortify.setMaximumRowCount(6);
		numFortify.setBackground(Color.LIGHT_GRAY);

		add(numFortify);
		btnArmy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");
				ArmyCardFrame armyCard = new ArmyCardFrame();
				armyCard.setVisible(true);

			}
		});

		btnArmy.setBounds(27, 467, 118, 29);
		add(btnArmy);
		btnAttack.setBounds(460, 430, 137, 36);
		add(btnAttack);
		btnFortify.setBounds(600, 430, 137, 36);
		add(btnFortify);
		btnPlace.setBounds(737, 430, 137, 36);
		add(btnPlace);
		btnFinish.setBounds(737, 497, 137, 46);
		add(btnFinish);

		
		btnInstr.setBounds(587, 497, 137, 46);
		add(btnInstr);
		btnInstr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");
				PlayingInstructions instr = new PlayingInstructions();
				instr.setVisible(true);

			}
		});

		
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");
				btnTer.setEnabled(false);
				btnArmy.setEnabled(false);
				btnChance.setEnabled(false);
				btnRoll.setEnabled(true);

				btnPickChance.setEnabled(false);
				btnTACard.setEnabled(false);
				btnSkip.setEnabled(false);
				btnFortify.setEnabled(false);
				if (roll1 != 0 && roll2 != 0 && GameFrame.bmode.grid.territorySource != null
						&& GameFrame.bmode.grid.territoryTo != null) {
					handler.getBoard().attack(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),
							GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo, roll1, roll2);
					numFortify.setEnabled(false);
					btnTer.setEnabled(true);
					btnArmy.setEnabled(true);
					btnChance.setEnabled(true);

					btnPickChance.setEnabled(true);
					btnTACard.setEnabled(true);
					btnSkip.setEnabled(true);
					btnFortify.setEnabled(true);
					btnRoll.setEnabled(false);

					//roll1 = 0;
					//roll2 = 0;
				}
				
			}
		});
		btnFortify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");

				if (GameFrame.bmode.grid.territorySource != null && GameFrame.bmode.grid.territoryTo != null) {

					handler.getBoard().fortify(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),
							GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo,
							(int) numFortify.getSelectedItem());
					GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.firstChosenRow][GameFrame.bmode.grid.firstChosenColumn] = Color.BLACK;
					GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.secondChosenRow][GameFrame.bmode.grid.secondChosenColumn] = Color.CYAN;
					repaint();
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.territoryTo = null;
					numFortify.setEnabled(false);
				}
				GameFrame.bmode.grid.updateGridText();
			}
		});
		btnPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");

				if (GameFrame.bmode.grid.territorySource != null) {
					handler.placeArmy(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),
							GameFrame.bmode.grid.territorySource, "Infantry");
					GameFrame.bmode.grid.updateGridText();
					GameFrame.bmode.grid.territorySource = null;
				}
				GameFrame.bmode.grid.updateGridText();
			}
		});
		

		btnChance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChanceCardFrame chanceCard = new ChanceCardFrame();
				chanceCard.setVisible(true);
				btnRoll.setEnabled(true);

			}
		});

		btnChance.setBounds(27, 497, 118, 29);
		add(btnChance);

	
		
		dieLabel.setBounds(471, 470, 80, 80);
		add(dieLabel);
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");
				displayDie();
				
				if (roll1 != 0 && roll2 != 0 && GameFrame.bmode.grid.territorySource != null
						&& GameFrame.bmode.grid.territoryTo != null) {
					handler.getBoard().attack(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),
					GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo, roll1, roll2);
						
					repaint();
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.territoryTo = null;
					numFortify.setEnabled(false);
					btnTer.setEnabled(true);
					btnArmy.setEnabled(true);
					btnChance.setEnabled(true);

					btnPickChance.setEnabled(true);
					btnTACard.setEnabled(true);
					btnSkip.setEnabled(true);
					btnFortify.setEnabled(true);
					btnRoll.setEnabled(false);

					roll1 = 0;
					roll2 = 0;
					
					
				}
				
			}
		});

		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCard.setText("");
				// turn bitiren bisey çağrılmalı
				ArrayList<Player> players = GameFrame.playerArray;
				GameFrame.bmode.grid.setIndFlag(false);
				GameFrame.play.txtPlayerTurn.setText("It is " + GameFrame.nameSorted.get(getIndexOfPlayer()) + "'s turn!!");
				
				if (indexOfPlayer == (players.size() - 1)) {
					indexOfPlayer = 0;
				} else {
					indexOfPlayer++;
					
				}

			}
			
		});
		
		
		
		btnRoll.setBounds(170, 430, 137, 36);
		add(btnRoll);
		btnSkip.setBounds(170, 470, 137, 36);
		add(btnSkip);

		btnPickChance.setBounds(320, 430, 137, 36);
		btnTACard.setBounds(320, 470, 137, 36);
		add(btnPickChance);
		add(btnTACard);

		txtCard.setBounds(170, 510, 167, 36);
		txtCard.setBackground(Color.DARK_GRAY);
		txtCard.setForeground(Color.WHITE);
		txtCard.setEditable(false);
		add(txtCard);

		txtPlayerTurn.setBounds(600, 465, 200, 36);
		txtPlayerTurn.setBackground(Color.DARK_GRAY);
		txtPlayerTurn.setForeground(Color.WHITE);
		txtPlayerTurn.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 20));
		txtPlayerTurn.setEditable(false);
		txtPlayerTurn.setText("It is " + GameFrame.playerArray.get(indexOfPlayer).getName() + "'s turn!!");
		add(txtPlayerTurn);

		btnPickChance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.giveChanceCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				txtCard.setText("CARD PICKED");
				

			}
		});

		btnTACard.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				handler.giveTerCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				Random rand = new Random();
				int randomValue = rand.nextInt() % 2;
				if (randomValue == 0) {
				handler.giveArmyCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				System.out.println(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				}
				
				else {
				//handler.giveTerCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				}
				txtCard.setText("CARD PICKED");
			}
		});


		btnMenu.setBounds(27, 527, 118, 29);
		btnMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(btnMenu);

	}

	
	public int getIndexOfPlayer() {
		return indexOfPlayer;
	}

	public static void sort(ArrayList<Player> list) {

		list.sort((o1, o2) -> o2.getfirstRoll().compareTo(o1.getfirstRoll()));
	}

}
