package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Board;
import domain.Player;
import domain.controller.ConKUerorHandler;

public class BuildingMode extends JLayeredPane{
	JTextArea txtrGameOptions = new JTextArea();
	
	MenuScreen menu = new MenuScreen();
  
    JButton btnNext = new JButton("Next");
    public boolean build = false;
    public boolean setLink = false;
    Grid grid = new Grid(); 
    int row = grid.row;
	int col = grid.col;


	JButton btnMenu = new JButton("Menu"); 


	JButton btnLink = new JButton("Set Link");

   
	public BuildingMode() {
		super();
		initialize();
		addElements();
		
		
	}


	public void initialize()  {
		
		setBounds(0, 54, 873, 451);
	    setBackground(Color.DARK_GRAY);
	    setLayout(null);
	    grid.setBounds(19, 69, 850, 350);
	    add(grid);
		grid.setVisible(true);
		
	}
	
	
	public void addElements() {
		
        txtrGameOptions.setBounds(212, 6, 453, 43);
        txtrGameOptions.setText("Game Options & Map Settings");
        txtrGameOptions.setForeground(Color.LIGHT_GRAY);
        txtrGameOptions.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtrGameOptions.setEditable(false);
        txtrGameOptions.setBackground(Color.DARK_GRAY);
        add(txtrGameOptions);
        
        
  
     
        btnNext.setBounds(724, 490, 130, 50);
        add(btnNext);
        


        btnMenu.setBounds(729, 13, 117, 29);
        btnMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));       
        add(btnMenu);

        btnLink.setBounds(724, 430, 130, 50);
        add(btnLink);
        

        
        
        btnLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	GameFrame.bmode.setLink = true;
            }
        });
                
            	
        
	}
	
}
