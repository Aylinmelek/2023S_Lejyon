package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GameFrame extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	//GameFrame frame = new GameFrame();
	
	/*public void initialize() {
		setSize(873, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}*/

	public static void main(String[] args) {
	    	GameFrame frame = new GameFrame();
	    	InitSharing sharing = new InitSharing();
	    	PlayingMode play = new PlayingMode();
	    	HelpScreen help = new HelpScreen();
	    	BuildingMode bmode = new BuildingMode();
	    	LoginScreen login = new LoginScreen();
	        frame.setSize(873, 600);
	        System.out.println("main");
	        frame.setBounds(0, 54, 873, 600);
			frame.setBackground(Color.DARK_GRAY);
			Grid grid = new Grid();
		  
			
			
			
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        frame.setLayeredPane(login);
	        login.initialize();
	        login.addElements();
	        frame.setVisible(true);
	        
	        login.btnLogin.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        		bmode.initialize();
	        		bmode.addElements();
					frame.setLayeredPane(bmode);
					frame.revalidate();
					frame.add(grid);
        		
	        	}	
	        });
	        
	              
	        login.btnHelp.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		help.initialize();
	        		help.addElements();
					frame.setLayeredPane(help);
					frame.revalidate();
	        		
	        	}	
	        });
	        
	        bmode.btnNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String action=e.getActionCommand();
	        		/*loginScreen.setVisible(!loginScreen.isVisible());
	            	if ("Next".equals(action)) {
	            		
	            		initSharing.setVisible(true);
	            		buildingMode.setVisible(false);
	            		
	            		btnNext.setVisible(false);
	            		building=true;
	            		
	            		
	            		gridPanel_1.setVisible(true);
	            		initSharing.add(gridPanel_1);
	                 
	                   // dieLabel.setIcon(die1);
	            		
	            		
	            	}*/
	        		
	        		
	        		sharing.initialize();
	        		sharing.addElements();
					frame.setLayeredPane(sharing);
					frame.revalidate();
					
					grid.setVisible(true);
					grid.setBounds(19, 69 , 850, 350);
				    sharing.add(grid);
				   // bmode.armyNum();
				    
				    JTextArea txtrYour = new JTextArea();
					txtrYour.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
					txtrYour.setForeground(Color.LIGHT_GRAY);
					txtrYour.setBackground(Color.DARK_GRAY);
					txtrYour.setText("You have " + bmode.armyNum() +  " Infantry.");
					txtrYour.setBounds(350, 450, 822, 263);
					sharing.add(txtrYour);
					
			
					
		
	        	}
	        });
	        
	        sharing.btnStartGame.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		  // Toggle the visibility of the panels
	            	String action=e.getActionCommand();
	            	
	            	/*if ("Start Game".equals(action)) {
	            		layeredPane.add(playingMode, Integer.valueOf(4));
	            		playingMode.setVisible(true);
	            		//startScreen.removeAll();
	            		//btnStart.setVisible(false);
	            		btnBack.setVisible(false);
	            		init=true;
	            		//playingMode.add(gridPanel);
	            		//gridPanel.setVisible(true);
	            		playingMode.add(gridPanel_1);
	            		gridPanel_1.setVisible(true);
	            		
	         
	            	
	            	}
	        	playingMode.setVisible(true);
	        	initSharing.setVisible(false);
	        	}*/
	            	
	            	play.initialize();
	            	play.addElements();
					frame.setLayeredPane(play);
					frame.revalidate();
					grid.setVisible(true);
					grid.setBounds(19, 69 , 850, 350);
				    play.add(grid);
				        
	        	}
	        });

}
	
	
}
