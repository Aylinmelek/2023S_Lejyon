package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import domain.Board;
import domain.Player;

public class LoginScreen extends JLayeredPane {
	JTextArea txtTitle = new JTextArea();
	JTextArea txtUsername = new JTextArea();
	JButton btnLogin = new JButton("Login");
	JButton btnStart = new JButton("Start Game");
	JTextArea txtPassword = new JTextArea();
	JButton btnMenu = new JButton("Menu");
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	JLabel[] nameLabels = new JLabel[6];
	JComboBox<Integer> numPlayers = new JComboBox<Integer>();
	JComboBox<Integer> numComp = new JComboBox<Integer>();
	MenuScreen menu = new MenuScreen();

	JTextArea txtnumPlayers = new JTextArea();
	JTextArea txtnumComp = new JTextArea();
	JPanel playersPanel = new JPanel();
	public boolean loginMode = false;
	int players, comp;
	int totalPlayers = 0;
	int numOfInfant;
	int index = 0;
	int counter = 0;

	ArrayList<String> playerArray = new ArrayList<String>();
	public static ArrayList<String> tempPlayer = new ArrayList<String>();

	public LoginScreen() {
		super();
		initialize();

		addElements();
		initializeLabels();
		addLoginBtn();
		passwordAst();
	}

	public void initialize() {
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
		numPlayers.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 0, 2, 3, 4, 5, 6 }));
		numPlayers.setMaximumRowCount(6);
		numPlayers.setBackground(Color.LIGHT_GRAY);
		add(numPlayers);

		numComp.setBounds(432, 230, 64, 27);
		numComp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 0, 1, 2, 3, 4, 5, 6 }));
		numComp.setMaximumRowCount(6);
		numComp.setBackground(Color.LIGHT_GRAY);
		add(numComp);

		txtUsername.setBounds(660, 100, 163, 23);
		txtUsername.setText("Enter Username");
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
		txtUsername.setEditable(false);
		txtUsername.setBackground(Color.DARK_GRAY);
		add(txtUsername);

		username.setBounds(641, 124, 171, 30);
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
		username.setColumns(10);
		username.setBackground(Color.WHITE);
		add(username);

		txtPassword.setBounds(660, 180, 163, 23);
		txtPassword.setText("Enter Password");
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
		txtPassword.setEditable(false);
		txtPassword.setBackground(Color.DARK_GRAY);
		add(txtPassword);

		password.setBounds(641, 204, 171, 30);
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 20));
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		add(password);

	}

	public void addLoginBtn() {

		btnLogin.setBounds(673, 250, 100, 30);
		// btnLogin.setEnabled(false);
		btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 14));

		add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!username.getText().equals("") && !password.getText().equals("")) {
					if (counter < getPlayerNum()) {
						getNameLabels()[index].setText(username.getText());
						nameLabels[index].setBackground(Color.DARK_GRAY);
						nameLabels[index].setForeground(Color.WHITE);

						playersPanel.add(nameLabels[index]);
						index++;

						username.setText("");
						password.setText("");
						counter += 1;

					}

					if (counter == getPlayerNum()) {

						btnStart.setEnabled(true);
					}

				}
			}
		});

		btnStart.setBounds(724, 490, 130, 50);
		btnStart.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnStart.setEnabled(false);

		add(btnStart);

		btnMenu.setBounds(729, 13, 117, 29);
		btnMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(btnMenu);

		playersPanel.setBounds(653, 290, 200, 200);
		playersPanel.setBackground(Color.DARK_GRAY);
		playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
		add(playersPanel);

	}

	public void passwordAst() {

		((AbstractDocument) password.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				StringBuilder stringBuilder = new StringBuilder(string.length());
				for (int i = 0; i < string.length(); i++) {
					stringBuilder.append("*");
				}
				super.insertString(fb, offset, stringBuilder.toString(), attr);
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				StringBuilder stringBuilder = new StringBuilder(text.length());
				for (int i = 0; i < text.length(); i++) {
					stringBuilder.append("*");
				}
				super.replace(fb, offset, length, stringBuilder.toString(), attrs);
			}
		});
	}

	public int getPlayerNum() {

		players = (int) numPlayers.getSelectedItem();
		comp = (int) numComp.getSelectedItem();
		totalPlayers = players + comp;
		return totalPlayers;
	}

	public int getCompPlayer() {

		comp = (int) numComp.getSelectedItem();

		return comp;
	}

	public int getRealPlayer() {

		players = (int) numPlayers.getSelectedItem();

		return players;
	}

	public int addPlayers(int total) {

		if (total == 2) {
			numOfInfant = 40;
		} else if (total == 3) {
			numOfInfant = 35;
		} else if (total == 4) {
			numOfInfant = 30;
		} else if (total == 5) {
			numOfInfant = 25;
		} else if (total == 6) {
			numOfInfant = 20;
		} else {
			numOfInfant = -1;
			System.out.println("choose again");
		}

		return numOfInfant;

	}

	private void initializeLabels() {
		for (int i = 0; i < 6; i++) {
			nameLabels[i] = new JLabel();
			add(nameLabels[i]);

		}

	}

	private JLabel[] getNameLabels() {
		return nameLabels;
	}

	public ArrayList<String> addNamesToArrayList() {
		int playerNum = getPlayerNum();
		for (int i = 0; i < playerNum; i++) {
			playerArray.add(getNameLabels()[i].getText());

		}
		return playerArray;
	}

}
