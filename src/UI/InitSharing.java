package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.ConKUeror;
import domain.Die;
import domain.Player;


public class InitSharing extends JLayeredPane  {
    JTextArea txtInitSharing = new JTextArea();
    JLabel dieLabel = new JLabel();
    //JButton btnStartGame = new JButton("Start Game");
    JButton btnRoll = new JButton("ROLL");
    JButton btnSkip = new JButton("SKIP ATTACK");
    TerrCardFrame terCard = new TerrCardFrame();
    Player player = new Player();
    BuildingMode bmode = new BuildingMode();
    ConKUeror conku = new ConKUeror();
    int index=0;  
    Grid grid = new Grid();
    Die die = new Die();
    
    ArrayList<Integer> playerArray = new ArrayList<Integer>(); 
    ArrayList<Integer> compPlayerArray = new ArrayList<Integer>(); 

    
    ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
    ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
    ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
    ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
    ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
    ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

      
    public InitSharing() {
		super();
		initialize();
		//displayDie();
		//addElements();
		
	}

	public void initialize() {
        setBackground(Color.DARK_GRAY);
        setBounds(0, 54, 873, 451);
        setLayout(null);
    }
    
	
    public void displayDie(Player player) {
    	System.out.println("index " + index);
    	//if (conku.player_turn.size() != 0) {
    	//	System.out.println("size not 0");
	    	
	    	if(conku.player_turn.get(player)) {
	    		System.out.println("in second if");
		        Thread rollThread = new Thread(() -> {
		            for (int i = 0; i < 10; i++) {
		                int dieDisplayed = die.generateNum();
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
		            int finalDieDisplayed = die.generateNum();
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
    }
     
    public void addElements() {
    	
        txtInitSharing.setForeground(Color.LIGHT_GRAY);
        txtInitSharing.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtInitSharing.setBackground(Color.DARK_GRAY);
        txtInitSharing.setText("Initial Sharing and Army Placement");
        txtInitSharing.setBounds(175, 6, 489, 56);
        add(txtInitSharing);
        System.out.println("in add elements");
        dieLabel.setBounds(221, 450, 80, 80);
        
        System.out.println("size init  " + ""+ bmode.addPlayers());
        if (bmode.addPlayers() != 0) {
	        System.out.println("in size if " + conku.player_turn.size());
	        Player playerKey = (Player) conku.player_turn.keySet().toArray()[index];
	        conku.player_turn.put(playerKey, true);
	        System.out.println("alooo");
	        btnRoll.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println(conku.player_turn.get(playerKey));
	            	
	                displayDie(playerKey);
	                
	                conku.player_turn.put(playerKey, false);
	    	        index += 1;
	                
	            }
	        });
	        
        }
        
        //btnStartGame.setBackground(Color.WHITE);
        //btnStartGame.setBounds(733, 495, 117, 29);
        btnRoll.setBounds(30, 450, 117, 76);
        add(btnRoll);
        add(dieLabel);
        
        
    }

	
}
