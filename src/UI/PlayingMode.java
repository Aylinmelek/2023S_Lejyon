package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class PlayingMode extends JLayeredPane {
	Grid map = new Grid();
	JButton btnTer = new JButton("Territory Cards");
	JButton btnArmy = new JButton("Army Cards");
	JButton btnChance = new JButton("Chance Cards");
	
	public void initialize() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 54, 873, 451);
		
		setLayout(null);
	}
	
	public void addElements() {
		map.addGrid();
		add(map);
		
	     btnTer.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		territoryCardFrame territoryCard = new territoryCardFrame();
	     		territoryCard.territoryCardF.setVisible(true);
	
	     	}
	     });
	     btnTer.setBounds(27, 337, 118, 29);
	     add(btnTer);
	     
	     
	     btnArmy.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ArmyCardFrame armyCard = new ArmyCardFrame();
	     		armyCard.ArmyCardF.setVisible(true);
	
	     	}
	     });
	     btnArmy.setBounds(27, 367, 118, 29);
	     add(btnArmy);
	     
	     
	     btnChance.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ChanceCardFrame armyCard = new ChanceCardFrame();
	     		armyCard.chanceCardF.setVisible(true);
	     	}
	     });
	     btnChance.setBounds(27, 397, 118, 29);
	     add(btnChance);
	     
	}

}
