package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EndGame extends JLayeredPane {
	JTextArea txtEnd = new JTextArea("GAME ENDED");
	
	public boolean helpMode=false;
	
	
	public EndGame() {
		super();
		initialize();
		addElements();
	}


	public void initialize()  {
	    setBackground(Color.DARK_GRAY);
	    setBounds(0, 54, 873, 451);
	    
	    setLayout(null);
	}
	
	
	public void addElements() {
		txtEnd.setForeground(Color.LIGHT_GRAY);
		txtEnd.setFont(new Font("Kokonor", Font.PLAIN, 40));
		txtEnd.setEditable(false);
		txtEnd.setBackground(Color.DARK_GRAY);
		txtEnd.setBounds(19, 79 , 822, 400);
	    add(txtEnd);
	    
	    
        
	}
	
	
    
}
