package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class LoginScreen extends JLayeredPane{
	//BuildingMode bMode = new BuildingMode();
	JTextArea txtTitle = new JTextArea();
    JTextArea txtUsername = new JTextArea();
    JButton btnLogin = new JButton("Login");
    JTextArea txtPassword = new JTextArea();
    JButton btnHelp = new JButton("Help");
    JTextField username = new JTextField();
    JTextField password = new JTextField();

	
	//startScreen = new JPanel();
	public void initialize()  {
		setBounds(0, 54, 873, 451);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);
	    
	}
	
	public void addElements() {
        
		txtTitle.setEditable(false);
		txtTitle.setBounds(320, 21, 271, 83);
		txtTitle.setForeground(Color.LIGHT_GRAY);
		txtTitle.setBackground(Color.DARK_GRAY);
		txtTitle.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 49));
		txtTitle.setText("ConKUeror  ");
        add(txtTitle);
        
        txtUsername.setBounds(374, 219, 103, 23);
        txtUsername.setText("Enter Username");
        txtUsername.setForeground(Color.LIGHT_GRAY);
        txtUsername.setEditable(false);
        txtUsername.setBackground(Color.DARK_GRAY);
        add(txtUsername);
        
        
        username.setBounds(341, 244, 171, 30);
        username.setHorizontalAlignment(SwingConstants.LEFT);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 20));
        username.setColumns(10);
        username.setBackground(Color.WHITE);
        add(username);
        
        txtPassword.setBounds(374, 280, 103, 23);
        txtPassword.setText("Enter Password");
        txtPassword.setForeground(Color.LIGHT_GRAY);
        txtPassword.setEditable(false);
        txtPassword.setBackground(Color.DARK_GRAY);
        add(txtPassword);
        

        password.setBounds(341, 304, 171, 30);
        password.setHorizontalAlignment(SwingConstants.LEFT);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 20));
        password.setColumns(10);
        password.setBackground(Color.WHITE);
        add(password);
        
        btnLogin.setBounds(373, 518, 100, 30);
        btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        add(btnLogin);
        /*btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Toggle the visibility of the panels
            	String action=e.getActionCommand();
            	startScreen.setVisible(!startScreen.isVisible());
            	if ("Start".equals(action)) {
            		layeredPane.add(buildingMode, Integer.valueOf(1));
            		buildingMode.setVisible(true);
            		startScreen.setVisible(false);
            		//startScreen.removeAll();
            		//btnStart.setVisible(false);
            		btnBack.setVisible(false);
            		start=true;
            		btnLogin.setVisible(false);
            		//gridPanel.setVisible(true);
            		gridPanel_1.setVisible(true);
         
            	
            	} 
            }
        });*/
	
    
        add(btnHelp);
        
       /* btnHelp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 
        		String action=e.getActionCommand();
            	//startScreen.setVisible(false);
            	if ("Help".equals(action)) {
            		
            		//layeredPane.add(helpScreen);
            		helpScreen.setVisible(true);
            		btnHelp.setVisible(false);
            		btnStart.setVisible(false);
            		btnBack.setVisible(true);
            		System.out.println("hata");
            	}
            	
        	}
        });*/
        btnHelp.setBounds(729, 13, 117, 29);
        btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 14));         
    }
	
}
