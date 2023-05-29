package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import domain.Player;

public class LoginScreen extends JLayeredPane{
	//BuildingMode bMode = new BuildingMode();
	JTextArea txtTitle = new JTextArea();
    JTextArea txtUsername = new JTextArea();
    JButton btnLogin = new JButton("Login");
    JTextArea txtPassword = new JTextArea();
    JButton btnHelp = new JButton("Help");
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JComboBox<Integer> numPlayers = new JComboBox<Integer> ();
    JComboBox<Integer> numComp = new JComboBox<Integer>();
    JTextArea txtnumPlayers = new JTextArea();
    JTextArea txtnumComp = new JTextArea();
    JPanel playersPanel = new JPanel();

    int players,comp;
    int totalPlayers=0;
    int numOfInfant;
    
    ArrayList<Player> playerArray = new ArrayList<Player>(); 
    
    //ai player olucak class ı ? 
    ArrayList<Player> compPlayerArray = new ArrayList<Player>(); 

   
    
    
	
	public LoginScreen() {
		super();
		initialize();
		addElements();
	}

	//startScreen = new JPanel();
	public void initialize()  {
		setBounds(0, 54, 873, 451);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);
	    
	}
	
	public void addElements() {
        
		txtTitle.setEditable(false);
		txtTitle.setBounds(240, 21, 371, 83);
		txtTitle.setForeground(Color.LIGHT_GRAY);
		txtTitle.setBackground(Color.DARK_GRAY);
		txtTitle.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 65));
		txtTitle.setText("ConKUeror  ");
        add(txtTitle);
        
        
        txtnumPlayers.setBounds(220, 190, 217, 32);
        txtnumPlayers.setText("Number of players (2-6):");
        txtnumPlayers.setForeground(Color.LIGHT_GRAY);
        txtnumPlayers.setFont(new Font("Kokonor", Font.ITALIC, 19));
        txtnumPlayers.setEditable(false);
        txtnumPlayers.setBackground(Color.DARK_GRAY);
        add(txtnumPlayers);
        
        
        txtnumComp.setBounds(143, 230, 294, 32);
        txtnumComp.setText("Number of computer players (1-6):");
        txtnumComp.setForeground(Color.LIGHT_GRAY);
        txtnumComp.setFont(new Font("Kokonor", Font.ITALIC, 19));
        txtnumComp.setEditable(false);
        txtnumComp.setBackground(Color.DARK_GRAY);
        add(txtnumComp);
        
        numPlayers.setBounds(432, 190, 64, 27);
        numPlayers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 2, 3, 4, 5, 6}));
        numPlayers.setMaximumRowCount(6);
        numPlayers.setBackground(Color.LIGHT_GRAY);
        add(numPlayers);
       

        numComp.setBounds(432, 230, 64, 27);
        numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        numComp.setMaximumRowCount(6);
        numComp.setBackground(Color.LIGHT_GRAY);
        add(numComp);
        
        txtUsername.setBounds(660, 350, 163, 23);
        txtUsername.setText("Enter Username");
        txtUsername.setForeground(Color.LIGHT_GRAY);
        txtUsername.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
        txtUsername.setEditable(false);
        txtUsername.setBackground(Color.DARK_GRAY);
        add(txtUsername);
        
        
        username.setBounds(641, 374, 171, 30);
        username.setHorizontalAlignment(SwingConstants.LEFT);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
        username.setColumns(10);
        username.setBackground(Color.WHITE);
        add(username);
        
        txtPassword.setBounds(660, 430, 163, 23);
        txtPassword.setText("Enter Password");
        txtPassword.setForeground(Color.LIGHT_GRAY);
        txtPassword.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
        txtPassword.setEditable(false);
        txtPassword.setBackground(Color.DARK_GRAY);
        add(txtPassword);
        

        password.setBounds(641, 454, 171, 30);
        password.setHorizontalAlignment(SwingConstants.LEFT);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 20));
        password.setColumns(10);
        password.setBackground(Color.WHITE);
        add(password);
        
        btnLogin.setBounds(673, 518, 100, 30);
        btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        add(btnLogin);
        
        btnHelp.setBounds(729, 13, 117, 29);
        btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 14));       
        add(btnHelp);
        
        playersPanel.setBounds(623, 118, 200, 200);
		playersPanel.setBackground(Color.WHITE);
		//add(playersPanel);
		
		txtnumPlayers.getText();
		
		
        
    }
	
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
	
	
}
