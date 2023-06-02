package UI;

import java.awt.Color;
import UI.Grid;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import domain.Board;
import domain.BoardListener;
import domain.ConKUeror;
import domain.Die;
import domain.Infantry;
import domain.Player;
import domain.Territory;

import domain.controller.ConKUerorHandler;



public class InitSharing extends JLayeredPane  implements BoardListener{
    JTextArea txtInitSharing = new JTextArea();
    JTextArea txtFirstPlayer = new JTextArea();
    JLabel dieLabel = new JLabel();
    JButton btnStartGame = new JButton("Start Game");
    JButton btnRoll = new JButton("ROLL");
    JButton btnSkip = new JButton("SKIP ATTACK");
    //TerrCardFrame terCard = new TerrCardFrame();
    int index=0;  
    int temp;
    public boolean init = false;
    
    Die die = new Die();
    int dieDisplayed,finalDieDisplayed;
    static int dieNumber;
    int clickCount;
    public int numPlay;
    int max_die;
    int ind;
    public boolean isButton;
    ConKUeror conKUeror = new ConKUeror();
    public Player max_player;

    static Icon currentIcon;
    JButton btnHelp = new JButton("Help");
    
    public boolean dieRoll = true;
    
    ArrayList<Integer> playerArray = new ArrayList<Integer>(); 
    ArrayList<Integer> compPlayerArray = new ArrayList<Integer>(); 
   
    ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
    ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
    ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
    ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
    ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
    ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

    //observer için ekledim
    private ConKUerorHandler conKUerorHandler;
	public Board board;
	//////////
      
    public InitSharing(ConKUerorHandler conKUerorHandler) {
    	super();
		initialize();
		displayDie(0);
		
		//addElements();
		
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
        //add(grid);
        setLayout(null);
    }
    
	
    public Icon displayDie(int dieNumber) {
    	System.out.println("dieNumber: "+ dieNumber);
        Thread rollThread = new Thread(() -> {
            for (int i = 0; i < 13; i++) {
            	//observer için ekledim
            	dieDisplayed=dieNumber;
            	//die.getDiceValue();
                ///		
                		//die.generateNum();
                switch (dieDisplayed) {
                    case 1:
                    	currentIcon = die1; //DieTesting de hangi Icon print edildiğini görmek için ekledim
                        dieLabel.setIcon(die1);
                        break;
                    case 2:
                    	currentIcon = die2;
                        dieLabel.setIcon(die2);
                        break;
                    case 3:
                    	currentIcon = die3;
                        dieLabel.setIcon(die3);
                        break;
                    case 4:
                    	currentIcon = die4;
                        dieLabel.setIcon(die4);
                        break;
                    case 5:
                    	currentIcon = die5;
                        dieLabel.setIcon(die5);
                        break;
                    default:
                    	currentIcon = die6;
                        dieLabel.setIcon(die6);
                        break;
                }
                try {
                    Thread.sleep(100); // Adjust the delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            //burası yukarıda yapılanın aynısı değil mi? Burası silinince de çalışıyor.
            //observer için ekledim
           /* finalDieDisplayed = dieNumber;
            //
            switch (finalDieDisplayed) {
            
                case 1:
                	currentIcon = die1;
                    dieLabel.setIcon(die1);
                    break;
                case 2:
                	currentIcon = die2;
                    dieLabel.setIcon(die2);
                    break;
                case 3:
                	currentIcon = die3;
                    dieLabel.setIcon(die3);
                    break;
                case 4:
                	currentIcon = die4;
                    dieLabel.setIcon(die4);
                    break;
                case 5:
                	currentIcon = die5;
                    dieLabel.setIcon(die5);
                    break;
                default:
                	currentIcon = die6;
                    dieLabel.setIcon(die6);
                    break;
            }
            try { //üstteki try catch'in aynısı, buraya eklemeyince 2. switch lere gelmediğini fark ettim
            	//sorun olursa silinebilir.
                Thread.sleep(100); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            

        });
       
        rollThread.start();
        //DieTesting için ekledim
        String dieNum=Integer.toString(dieNumber);
        return currentIcon;
    }
    /*
    public int getInd(int max_die, int temp) {
    	
        max_player = conKUeror.playerList.get(ind);
        
        
        return ind;
    }*/
    
    public int getTemp() {
    	return temp;
    }
    
    public int getMaxDie() {
    	return max_die;
    }
    
    public Player getMaxPlayer() {
    	return max_player;
    }
    
    public void addElements() {
        txtInitSharing.setForeground(Color.LIGHT_GRAY);
        txtInitSharing.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtInitSharing.setBackground(Color.DARK_GRAY);
        txtInitSharing.setText("Initial Sharing and Army Placement");
        txtInitSharing.setBounds(175, 6, 489, 56);
        add(txtInitSharing);
        
        txtFirstPlayer.setText("Roll die! Highest roll starts the game!");
        txtFirstPlayer.setForeground(Color.LIGHT_GRAY);
        txtFirstPlayer.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 20));
        txtFirstPlayer.setBackground(Color.DARK_GRAY);
        txtFirstPlayer.setEditable(false);
        txtFirstPlayer.setBounds(320, 475, 389, 76);
        add(txtFirstPlayer);
        
        dieLabel.setBounds(221, 450, 80, 80);
        
        btnRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //observer için ekledim
                conKUerorHandler.rollDice();
                dieNumber = conKUerorHandler.getDieValue();
                System.out.println("(UI.InitSharing)You rolled1: "+getDie());
                displayDie(dieNumber);
                die.dice.add(dieNumber); //die values arraylist
                board.publishBoardEvent(dieNumber);
                //System.out.println("(UI.InitSharing)You rolled2: "+dieNumber);
                //roll die için yeni ekledim
                clickCount++;  // Increment the count
                if (clickCount >= numPlay) {
                    // Disable the button
                    max_die = die.calculateHighest(die.dice);
                    setInd(die.calcHighIndex(die.dice));
                    temp = ind;
                    
                    max_player = conKUeror.playerList.get(ind);
                    System.out.println("highest die val: " + max_die);
                    System.out.println("player_list high index: " + ind);
                    System.out.println("highest die rolling player: " + max_player);
                    
                    //max_player.setNumOfInfantry(max_player.getNumOfInfantry()-1);
                    
                    
                    txtFirstPlayer.setText("Highest die rolled by: "+max_player.getName()+"\n It's your turn!!");
                    
                    
                    
                    
                	
                    btnRoll.setEnabled(false);
                    
                   
                    
              
                    
                    
                }
                
                /////////////
               
            }
        });
        
        
        btnStartGame.setBackground(Color.WHITE);
        btnStartGame.setBounds(733, 495, 117, 29);
        btnRoll.setBounds(30, 450, 117, 76);
        add(btnRoll);
        add(dieLabel);
        add(btnStartGame); 
        
        btnHelp.setBounds(729, 13, 117, 29);
        btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 14));       
        add(btnHelp);
    }
    
    public JButton getButton() {
        return btnRoll;
    }

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	@Override
	public void onBoardEvent(String msg) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(InitSharing.this, msg);
		
	}
	
	public int getDie() {
		return dieNumber;
	}
	public Icon getCurrentIcon() {
	    return currentIcon;
	}
	
    
	

}
