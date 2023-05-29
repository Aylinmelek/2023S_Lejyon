package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Board;
import domain.Die;
import domain.controller.ConKUerorHandler;

public class PlayingMode extends JLayeredPane {
	
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
    JButton btnRoll = new JButton("ROLL DIE");
    JButton btnSkip = new JButton("SKIP/END TURN");
    JButton btnPickChance = new JButton("Pick a Chance Card");
    JButton btnTACard = new JButton("Pick a Territory/Army Card");
    JTextArea txtCard = new JTextArea();

    
    JLabel dieLabel = new JLabel();
    public boolean playMode = false;
    
    Die die = new Die();
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
                    default:
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
            ///
            		//die.generateNum();
            switch (finalDieDisplayed) {
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
                default:
                    dieLabel.setIcon(die6);
                    break;
            }
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
	     btnArmy.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ArmyCardFrame armyCard = new ArmyCardFrame();
	     		armyCard.setVisible(true);
	
	     	}
	     });
	     
	     btnArmy.setBounds(27, 467, 118, 29);
	     add(btnArmy);
	     
	     
	     btnChance.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ChanceCardFrame armyCard = new ChanceCardFrame();
	     		armyCard.chanceCardF.setVisible(true);
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
	                
	            }
	        });
	        
	        
	        btnSkip.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //turn bitiren bisey çağrılmalı
	            	
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
	     

	     btnPickChance.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                txtCard.setText(".... card picked");
	                
	            	
	            }
	        });

	     btnTACard.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	txtCard.setText("a/t.. card picked");
	            	
	            }
	        });
	     
	     
	     //if die diger playerdan büyükse conquer ettin/kaybettin JText
	     
	}
}
