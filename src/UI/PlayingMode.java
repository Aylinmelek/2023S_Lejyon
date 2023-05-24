package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PlayingMode extends JLayeredPane {
	
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
    JButton btnRoll = new JButton("ROLL DIE TO ATTACK");
    JButton btnSkip = new JButton("SKIP ATTACK");
    JLabel dieLabel = new JLabel();

    InitSharing init = new InitSharing();

	TerrCardFrame territoryCard = new TerrCardFrame();

    
	
	public PlayingMode() {
		super();
		initialize();
		addElements();
	}
	
	

	public void initialize() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 54, 873, 451);
		setLayout(null);
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
	     
	     dieLabel.setBounds(221, 450, 80, 80);
	     add(dieLabel);
	        btnRoll.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                init.displayDie();
	            }
	        });
	        
	        btnSkip.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            }
	        });
	        
     
	     btnRoll.setBounds(330, 430, 177, 56);
	     add(btnRoll);
	     btnSkip.setBounds(330, 490, 177, 56);
	     add(btnSkip);
	}

}
