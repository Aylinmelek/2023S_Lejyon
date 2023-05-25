package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import domain.Die;
import domain.Player;
import domain.Territory;

public class PlayingMode extends JLayeredPane {
	
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
    JButton btnRoll = new JButton("ROLL DIE");
    JButton btnSkip = new JButton("SKIP/END TURN");
    
    JLabel dieLabel = new JLabel();
    Die die = new Die();
    ArrayList<Integer> playerArray = new ArrayList<Integer>(); 
    ArrayList<Integer> compPlayerArray = new ArrayList<Integer>(); 
 
	Player player = new Player();
    Grid grid = new Grid();

	TerrCardFrame territoryCard = new TerrCardFrame();
	
	 ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
	    ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
	    ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
	    ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
	    ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
	    ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));
    
	
	public PlayingMode() {
		super();
		initialize();
		addElements();
		//attack();
	}
	
	

	public void initialize() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 54, 873, 451);
		setLayout(null);
	}
	
	public void displayDie() {
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
    
	public void addElements() {
		System.out.println("add elements");
	     btnTer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		territoryCard.setVisible(true);
	
	     		}
	     	}
	     );
	     
	     btnTer.setBounds(27, 437, 118, 30);
	     add(btnTer);
	     System.out.println("added button territory");
     
     
	     btnArmy.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ArmyCardFrame armyCard = new ArmyCardFrame();
	     		armyCard.setVisible(true);
	     	}
	     });
	     
	     btnArmy.setBounds(27, 467, 118, 29);
	     add(btnArmy);
	     System.out.println("added army territory");
	     
	     btnChance.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ChanceCardFrame armyCard = new ChanceCardFrame();
	     		armyCard.chanceCardF.setVisible(true);
	     	}
	     });
	     
	     btnChance.setBounds(27, 497, 118, 29);
	     add(btnChance);
	     
	     dieLabel.setBounds(321, 450, 80, 80);
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
	        
     
	     btnRoll.setBounds(170, 430, 137, 56);
	     add(btnRoll);
	     btnSkip.setBounds(170, 490, 137, 56);
	     add(btnSkip);
	     
	     //if die diger playerdan büyükse conquer ettin/kaybettin JText
	     
	}
	
	/*public void attack() {
		Territory territoryIs = Territory.isTerritory(grid.row, grid.col);
		Territory selectedTerr = Territory.territories[grid.row][grid.col];
		grid.terrsSelected.add(Territory.territories[grid.row][grid.col]);
		System.out.println(player.canAttackTerritory(grid.terrsSelected.get(0), selectedTerr));
		// once kendi territorymi secip untill baska kendi territorye basana kadar attack territorysi secebiliyorum. 
		if (player.getTerritoryList().contains(selectedTerr) && player.canAttackTerritory(grid.terrsSelected.get(0), selectedTerr)) {
			grid.gridColors[grid.row][grid.col] = Color.GRAY;
			//asker 
			repaint();
			System.out.println("size" + grid.terrsSelected.get(0).getAdjacentTerritories().size());
				for (int i = 0; i<grid.terrsSelected.get(0).getAdjacentTerritories().size(); i++) {
					if (selectedTerr == grid.terrsSelected.get(0).getAdjacentTerritories().get(i)) {
						grid.gridColors[grid.row][grid.col] = Color.BLACK;
						repaint();
						//asker koy kac asker koydugunu display et
						
						//if kazanırsan 
						//else terr rengi + asker sayısı vs vs 
							
					}
				}
			}
		//rengini değiştirme 
		
	}*/		

}
