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
	HelpScreen help = new HelpScreen();
	JTextArea txtMenu = new JTextArea("Game Menu");

	
	
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
		txtMenu.setBounds(285,30,400,80);
		txtMenu.setBackground(Color.DARK_GRAY);
		txtMenu.setForeground(Color.LIGHT_GRAY);
		txtMenu.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 55));
		add(txtMenu);
		
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}

		});
	}
}
