package UI;

import java.awt.Color;
import UI.Grid;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import domain.Board;
import domain.BoardListener;
import domain.Die;
import domain.Territory;

import domain.controller.conKUerorHandler;



public class InitSharing extends JLayeredPane  implements BoardListener{
    JTextArea txtInitSharing = new JTextArea();
    JLabel dieLabel = new JLabel();
    JButton btnStartGame = new JButton("Start Game");
    JButton btnRoll = new JButton("ROLL");
    JButton btnSkip = new JButton("SKIP ATTACK");
    TerrCardFrame terCard = new TerrCardFrame();
    int index=0;  
    Grid grid = new Grid();
    Die die = new Die();
    int dieDisplayed,finalDieDisplayed;
    int dieNumber;
    
    ArrayList<Integer> playerArray = new ArrayList<Integer>(); 
    ArrayList<Integer> compPlayerArray = new ArrayList<Integer>(); 

    
    ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
    ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
    ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
    ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
    ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
    ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

    //observer için ekledim
    private conKUerorHandler conKUerorHandler;
	private Board board;
	//////////
      
    public InitSharing(conKUerorHandler conKUerorHandler) {
    	super();
		initialize();
		displayDie(0);
		addElements();
		
		//observer için ekledim
    	this.conKUerorHandler = conKUerorHandler;
	    board = conKUerorHandler.getBoard();
	    board.addBoardListener(this);
	    ShowDie showDie = new ShowDie(board);
	    //////////
		
		
		
		
	}

	public void initialize() {
        setBackground(Color.DARK_GRAY);
        setBounds(0, 54, 873, 451);
        setLayout(null);
    }
    
	
    public void displayDie(int dieNumber) {
        Thread rollThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
            	//observer için ekledim
            	 die.roll();
                 dieDisplayed = die.getDiceValue();
                ///		
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
            //die.roll();
            finalDieDisplayed = dieNumber;
            
            //
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
        txtInitSharing.setForeground(Color.LIGHT_GRAY);
        txtInitSharing.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtInitSharing.setBackground(Color.DARK_GRAY);
        txtInitSharing.setText("Initial Sharing and Army Placement");
        txtInitSharing.setBounds(175, 6, 489, 56);
        add(txtInitSharing);
        
        dieLabel.setBounds(221, 450, 80, 80);
        
        btnRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //displayDie();
                
                //observer için ekledim
            	//displayDie();
                conKUerorHandler.rollDice();
                dieNumber = conKUerorHandler.getDieValue();
                displayDie(dieNumber);
                board.publishBoardEvent(dieNumber);
                System.out.println("(UI.InitSharing)You rolled: "+dieNumber);
                /////////////
               
            }
        });
        
        
        btnStartGame.setBackground(Color.WHITE);
        btnStartGame.setBounds(733, 495, 117, 29);
        btnRoll.setBounds(30, 450, 117, 76);
        add(btnRoll);
        add(dieLabel);
        add(btnStartGame);
        
    }

	@Override
	public void onBoardEvent(String msg) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(InitSharing.this, msg);
		
	}
	
	
    
	

}
