package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class MenuScreen extends JLayeredPane {
	JButton btnHelp = new JButton("Help");
	JButton btnSave = new JButton("Save Game");
	JButton btnBack = new JButton("Back to Game");
	JButton btnExit = new JButton("Exit");
	HelpScreen help = new HelpScreen();
	JTextArea txtMenu = new JTextArea("Game Menu");
	JTextArea txtPause = new JTextArea("Game Paused");
	public boolean menuMode = false;
	
	
	public MenuScreen() {
		super();
		initialize();
		addElements();
	}

	public void initialize() {
		setBounds(0, 54, 873, 451);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);
	}

	public void addElements() {
		txtMenu.setBounds(285,120,400,80);
		txtMenu.setBackground(Color.DARK_GRAY);
		txtMenu.setForeground(Color.LIGHT_GRAY);
		txtMenu.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 55));
		add(txtMenu);
		
		txtPause.setBounds(280,30,400,80);
		txtPause.setBackground(Color.DARK_GRAY);
		txtPause.setForeground(Color.LIGHT_GRAY);
		txtPause.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 55));
		add(txtPause);
		
		btnHelp.setBounds(355,270,150,50);
		add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				help.setVisible(true);

			}

		});
		
		btnSave.setBounds(355,340,150,50);
		add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}

		});
		
		btnBack.setBounds(355,200,150,50);
		add(btnBack);
		/*btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        		if (GameFrame.login.loginMode==true) {
        			
        			setVisible(false);
        			
					//frame.setLayeredPane(login);
					//frame.revalidate();
					btnBack.setVisible(false);
					GameFrame.login.loginMode=false;
     		    
    
        		}
        		else {
			//layeredPane.add(buildingMode);
        			GameFrame.login.setVisible(false);
     		    GameFrame.bmode.setVisible(true);
     		   GameFrame.login.btnLogin.setVisible(false);
     		    //btnResume.setVisible(false);
     		   GameFrame.menu.btnBack.setVisible(false);
        		}
     	
     		
        		GameFrame.menu.setVisible(false);
        		GameFrame.menu.btnBack.setVisible(false);
        		GameFrame.login.btnMenu.setVisible(true);
     		//btnResume.setVisible(true);
        		GameFrame.login.loginMode=true;
     		

			}
		});*/
		
		btnExit.setBounds(355,410,150,50);
		add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit.setVisible(true);
			}

		});
	}
}
