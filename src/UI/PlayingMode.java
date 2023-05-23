package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class PlayingMode extends JLayeredPane {
	
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
	
    territoryCardFrame territoryCard = new territoryCardFrame();

	
	public void initialize() {
		setBackground(Color.DARK_GRAY);
		
		
		
		setBounds(0, 54, 873, 451);
		
		setLayout(null);
	}
	
	public void addElements(territoryCardFrame terCard) {
     btnTer.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		//territoryCardFrame territoryCard = new territoryCardFrame();
     		terCard.territoryCardF.setVisible(true);

     	}
     });
     btnTer.setBounds(27, 437, 118, 30);
     add(btnTer);
     
     
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
     
	}

}
