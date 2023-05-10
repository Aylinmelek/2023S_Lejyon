package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Die;

public class InitSharing extends JLayeredPane {
	JTextArea txtInitSharing = new JTextArea();
	JLabel dieLabel = new JLabel();
    JButton btnStartGame = new JButton("Start Game");
	JButton btnRoll = new JButton("ROLL");
	Grid grid = new Grid();
	Die die = new Die();
	
	ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
	ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
	ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
	ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
	ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
	ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

	
	public void initialize() {
		setBackground(Color.DARK_GRAY);
        setBounds(0, 54, 873, 451);
       
        setLayout(null);
	}
	
public void displayDie() {
		
		int dieDisplayed = die.generateNum();
		
		if (dieDisplayed == 1) {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die1);
			}
		
		else if (dieDisplayed == 2) {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die2);
		}
		else if (dieDisplayed == 3) {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die3);
		}
		
		else if (dieDisplayed == 4) {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die4);
		}
		
		else if (dieDisplayed == 5) {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die5);
		}
		
		else {
			System.out.println(dieDisplayed);
			dieLabel.setIcon(die6);
		}
		
		dieLabel.setVisible(true);
	}
	
	public void addElements() {
		//grid.addGrid();
		//add(grid);
		//grid.setVisible(true);
		txtInitSharing.setForeground(Color.LIGHT_GRAY);
		txtInitSharing.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
		txtInitSharing.setBackground(Color.DARK_GRAY);
		txtInitSharing.setText("Initial Sharing and Army Placement");
		txtInitSharing.setBounds(175, 6, 489, 56);
		add(txtInitSharing);
    
    
    dieLabel.setBounds(221, 359, 80, 80);
    
    btnRoll.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayDie();
    	
    		
    		
    	}
    });
    
   
    
    btnStartGame.setBackground(Color.WHITE);
    btnStartGame.setBounds(733, 395, 117, 29);
    btnRoll.setBounds(48, 360, 117, 56);
    
    add(btnRoll);
    add(dieLabel);
    add(btnStartGame);
    
    
	}
}
