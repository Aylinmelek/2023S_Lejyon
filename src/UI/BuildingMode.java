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
	//JTextArea txtdisable = new JTextArea();
    /*JComboBox<Integer> numPlayers = new JComboBox<Integer> ();
    JComboBox<Integer> numComp = new JComboBox<Integer>();
    JTextArea txtnumPlayers = new JTextArea();
    JTextArea txtnumComp = new JTextArea();*/
    JButton btnNext = new JButton("Next");
    public boolean build = false;
    Grid grid = new Grid(); 
    int row = grid.row;
	int col = grid.col;
	JButton btnMenu = new JButton("Menu"); 
    
    //observer için ekledim
   // Board board = new Board();
    //ConKUerorHandler conKUerorHandler = new ConKUerorHandler(board);
    
    //InitSharing initSharing = new InitSharing(conKUerorHandler);
    ////////////
    
    //ConKUeror conku = new ConKUeror();

    /*int players,comp;
    int totalPlayers=0;
    int numOfInfant;
    
    ArrayList<Player> playerArray = new ArrayList<Player>(); 
    
    //ai player olucak class ı ? 
    ArrayList<Player> compPlayerArray = new ArrayList<Player>(); 

   */
    

	public BuildingMode() {
		super();
		initialize();
		addElements();
		//grid.addMouseListener(this);
	
		
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
        
        
  
        
       /* txtnumPlayers.setBounds(220, 450, 217, 32);
        txtnumPlayers.setText("Number of players (2-6):");
        txtnumPlayers.setForeground(Color.LIGHT_GRAY);
        txtnumPlayers.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumPlayers.setEditable(false);
        txtnumPlayers.setBackground(Color.DARK_GRAY);
        add(txtnumPlayers);
        
        
        txtnumComp.setBounds(143, 490, 294, 32);
        txtnumComp.setText("Number of computer players (1-6):");
        txtnumComp.setForeground(Color.LIGHT_GRAY);
        txtnumComp.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtnumComp.setEditable(false);
        txtnumComp.setBackground(Color.DARK_GRAY);
        add(txtnumComp);
        
        numPlayers.setBounds(432, 450, 64, 27);
        numPlayers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 2, 3, 4, 5, 6}));
        numPlayers.setMaximumRowCount(6);
        numPlayers.setBackground(Color.LIGHT_GRAY);
        add(numPlayers);
       

        numComp.setBounds(432, 490, 64, 27);
        numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        numComp.setMaximumRowCount(6);
        numComp.setBackground(Color.LIGHT_GRAY);
        add(numComp);*/
        
        

        btnNext.setBounds(724, 490, 117, 29);
        add(btnNext);
        

        btnMenu.setBounds(729, 13, 117, 29);
        btnMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));       
        add(btnMenu);
        
        
	}
	/*

	public int getPlayerNum() {  
	
	    players = (int) numPlayers.getSelectedItem(); 		
		comp = (int) numComp.getSelectedItem();
		totalPlayers = players + comp;
		
		
		return totalPlayers;
	}
	
	public int addPlayers(int total) {  
			for (int i=0; i<total; i++) {
				if (total == 2) {
					numOfInfant = 40;
				}
				else if (total == 3) {
					numOfInfant = 35;
				}
				else if (total == 4) {
					numOfInfant = 30;
				}
				else if (total == 5) {
					numOfInfant = 25;
				}
				else if (total == 6) {
					numOfInfant = 20;
				}
				else {
					numOfInfant = -1;
					System.out.println("choose again");
				}
		}
			return numOfInfant;
	
		}
	*/
	/*public void mouseClicked(MouseEvent e) {
		
		row = e.getY() / Grid.CELL_SIZE;
		col = e.getX() / Grid.CELL_SIZE;
		// if (GameFrame.build) {
		System.out.println(row + col);
		if (grid.gridColors[row][col] != grid.blue) {
			grid.gridColors[row][col] = Color.GRAY;
			repaint();
			//index = territoryIs.getIndex();
			//System.out.println("index" + index);
			/*if (terr != null) {
				terr.setEnabled(false);
			}*/
		//}
	//}
		
		



	
	
}
