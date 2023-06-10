package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    JButton btnPickChance = new JButton("Pick a Chance Card");
    JButton btnTACard = new JButton("Pick a Territory/Army Card");
    JButton btnAttack = new JButton("Attack");
    JButton btnFortify = new JButton("Fortify");
    JButton btnMenu = new JButton("Menu");
    JTextArea txtCard = new JTextArea();
    
    JComboBox<Integer> numFortify = new JComboBox<Integer> ();
    public boolean isAttack;
    
    JTextArea txtPlayerTurn = new JTextArea();
    int indexOfPlayer=0;

    private boolean indFlag = true;
    
    
    JLabel dieLabel = new JLabel();
    public boolean playMode = false;
    public ConKUerorHandler handler = new ConKUerorHandler();

    
    Die die = new Die();
    int roll1, roll2;
    ArrayList<Integer> playerArray = new ArrayList<Integer>(); 
    ArrayList<Integer> compPlayerArray = new ArrayList<Integer>(); 
    int dieDisplayed,finalDieDisplayed;
    int dieNumber;
 
    //observer için ekledim
    //Board board_play = new Board();
    //ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
    
    //InitSharing initSharing = new InitSharing(conKUerorHandler);
    ////////////
    
    

	//TerrCardFrame territoryCard = 
	
	 ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
	 ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
	 ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
	 ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
	 ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
	 ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));
    

	public PlayingMode() {
		super();
		initialize();
		//addElements();
	}
	
	

	public void initialize() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 54, 873, 451);
		handler.createMainDeck(10,10,handler.getBoard().deck);
		btnRoll.setEnabled(false);
		//handler.createTerCard(null, null, null, null, null, null, null);
		setLayout(null);
		
	}
	public void displayDie() {
        Thread rollThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
            	//observer için ekledim
            	die.roll();
                dieDisplayed = die.getDiceValue();
                
                //////
                		//die.generateNum();
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
                    Thread.sleep(100); // Adjust the delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //observer için ekledim
            finalDieDisplayed = dieNumber;
            if(roll1 == 0)
            {
            	roll1 = die.getDiceValue();
            	System.out.println("Rolllllll1 : " + roll1);
            }
            else
            {
            	roll2 = die.getDiceValue();
            	System.out.println("Rolllllll2 : " + roll2);
            }
            ///
            		//die.generateNum();
            /*switch (finalDieDisplayed) {
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
            }*/
        });
        rollThread.start();
    }
    
	public void addElements() {
		/*
	     btnTer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		territoryCard.setVisible(true);
	
	     	}
	     	
	     }
	     );*/
	     
	     //btnTer.setBounds(27, 437, 118, 30); added to gameframe for cards to be visible
	     //add(btnTer);
		numFortify.setBounds(800, 467, 64, 27);
		numFortify.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
		numFortify.setMaximumRowCount(6);
		numFortify.setBackground(Color.LIGHT_GRAY);
		
        add(numFortify);
	     btnArmy.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
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

	     
	    
	     GameFrame.play.btnAttack.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		btnTer.setEnabled(false);
	            	btnArmy.setEnabled(false);
	            	btnChance.setEnabled(false);
	            	btnRoll.setEnabled(true);
	                
	                btnPickChance.setEnabled(false);
	                btnTACard.setEnabled(false);
	                btnSkip.setEnabled(false);
	                btnFortify.setEnabled(false);
		     		if(roll1 != 0 && roll2 !=0 && GameFrame.bmode.grid.territorySource != null && GameFrame.bmode.grid.territoryTo != null)
				     {
						
						System.out.println("roll1 : "+ roll1 + "roll2 : " + roll2);
						handler.getBoard().attack(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo, roll1, roll2);
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.firstChosenRow][GameFrame.bmode.grid.firstChosenColumn] = Color.CYAN;
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.secondChosenRow][GameFrame.bmode.grid.secondChosenColumn] = Color.CYAN;
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
		     		GameFrame.bmode.grid.updateGridText();
					
		     	}
		     });
	     GameFrame.play.btnFortify.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
					if(GameFrame.bmode.grid.territorySource != null && GameFrame.bmode.grid.territoryTo != null)
				     {
						handler.getBoard().fortify(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo,(int) numFortify.getSelectedItem());
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.firstChosenRow][GameFrame.bmode.grid.firstChosenColumn] = Color.CYAN;
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.secondChosenRow][GameFrame.bmode.grid.secondChosenColumn] = Color.CYAN;
						repaint();
						GameFrame.bmode.grid.territorySource = null;
						GameFrame.bmode.grid.territoryTo = null;
						numFortify.setEnabled(false);
				     }
					GameFrame.bmode.grid.updateGridText();
		     	}
		     });
	     


	     
	     btnChance.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ChanceCardFrame chanceCard = new ChanceCardFrame();
	     		chanceCard.setVisible(true);
	     		
	     		
	     		
	     	}
	     });
	     
	     btnChance.setBounds(27, 497, 118, 29);
	     add(btnChance);
	     
	     dieLabel.setBounds(471, 450, 80, 80);
	     add(dieLabel);
	        btnRoll.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//kimin turnü oldugu yazsın atarken
	                displayDie();
	                if(roll1 != 0 && roll2 !=0 && GameFrame.bmode.grid.territorySource != null && GameFrame.bmode.grid.territoryTo != null)
				     {
						
						System.out.println("roll1 : "+ roll1 + "roll2 : " + roll2);
						handler.getBoard().attack(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), GameFrame.bmode.grid.territorySource, GameFrame.bmode.grid.territoryTo, roll1, roll2);
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.firstChosenRow][GameFrame.bmode.grid.firstChosenColumn] = Color.CYAN;
						GameFrame.bmode.grid.gridColors[GameFrame.bmode.grid.secondChosenRow][GameFrame.bmode.grid.secondChosenColumn] = Color.CYAN;
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
	                GameFrame.bmode.grid.updateGridText();
					
	                
	            }
	        });
	        
	        btnSkip.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //turn bitiren bisey çağrılmalı
	            	
	            			
	            	ArrayList<Player> players = GameFrame.playerArray;
	            	//indexOfPlayer=GameFrame.playerIndex;
					GameFrame.bmode.grid.setIndFlag(false);
	            	
					
					System.out.println("turn bunda: "+ GameFrame.nameSorted.get(indexOfPlayer));
	            	GameFrame.play.txtPlayerTurn.setText("It is " + GameFrame.nameSorted.get(indexOfPlayer)+ "'s turn!!");
	            	
	            	
	            	System.out.println("players size: "+ players.size());
	            	if (indexOfPlayer==(players.size()-1)) {
                		//GameFrame.sharing.getTemp()) {
	                	System.out.println("playersList finished");
	                	indexOfPlayer=0;
	            	}
	            	else {
	            		indexOfPlayer++;
	                	System.out.println("playerIndex: "+ indexOfPlayer);
	                	
                	
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

	     txtCard.setBounds(170, 510, 137, 36);
	     txtCard.setBackground(Color.DARK_GRAY);
	     txtCard.setForeground(Color.WHITE);
	     txtCard.setEditable(false);
	     add(txtCard);
	     
	     txtPlayerTurn.setBounds(600, 490, 200, 36);
	     txtPlayerTurn.setBackground(Color.DARK_GRAY);
	     txtPlayerTurn.setForeground(Color.WHITE);
	     txtPlayerTurn.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 20));
	     txtPlayerTurn.setEditable(false);
	     txtPlayerTurn.setText("It is "+GameFrame.nameSorted+ "turn!!");
	     add(txtPlayerTurn);
	     

	     btnPickChance.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	handler.giveChanceCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
	                txtCard.setText(".... card picked");
	                
	            	
	            }
	        });

	     btnTACard.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	handler.giveArmyCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
	            	System.out.println(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
	            	handler.giveTerCard(GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
	            	
	            }
	        });
	     
	     
	     //if die diger playerdan büyükse conquer ettin/kaybettin JText
	     
	     btnMenu.setBounds(27, 527, 118, 29);
	     btnMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));       
	     add(btnMenu);
	     
	}

	
	 public static void sort(ArrayList<Player> list) {

	        list.sort((o1, o2) -> o2.getfirstRoll().compareTo(
	                o1.getfirstRoll()));
	    }


}


