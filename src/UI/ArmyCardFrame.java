 
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.Artillery;
import domain.Cavalry;
import domain.Infantry;
import domain.Player;

public class ArmyCardFrame extends JFrame {

	private static final int NUM_CARDS = 3;

	Player player = new Player();
	ArrayList<Cavalry> cavalryCards = player.getCavalryList();
	ArrayList<Infantry> infantryCards = player.getInfantryList();
	ArrayList<Artillery> artilleryCards = player.getArtilleryList();

	ArrayList<String> armyCards = new ArrayList<String>();
	ArrayList<Integer> armyCardsNum = new ArrayList<Integer>();

	JButton btnFirst = new JButton("Trade 1");
	JButton btnSecond = new JButton("Trade  2");
	JButton btnThird = new JButton("Trade 3");
	JButton btnFourth = new JButton("Trade 4");
	JButton btnFifth = new JButton("Trade 5");
	JButton btnSixth = new JButton("Trade 6");
	
	JTextArea txtInfantry = new JTextArea();
	JTextArea txtArtillery = new JTextArea();
	JTextArea txtCavalry = new JTextArea();

	int tradeCvlry, tradeInfntry, tradeArtlry;

	private JLabel[] labels = new JLabel[NUM_CARDS];
	private JTextArea[] numbers = new JTextArea[NUM_CARDS];

	JPanel tradePanel = new JPanel();
	ArrayList<JButton> txtArmies = new ArrayList<JButton>();

	JButton btnTrade = new JButton("TRADE");

	public ArmyCardFrame() {
		addButtons();
		addArmyCards();
		initialize();
		addButtonActListener();
		addTradeOps();
		//addCardCounts();

	}
	private void initialize() {

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JTextArea txtArmyCards = new JTextArea();
		txtArmyCards.setForeground(Color.LIGHT_GRAY);
		txtArmyCards.setBackground(Color.DARK_GRAY);
		txtArmyCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtArmyCards.setEditable(false);
		txtArmyCards.setText("Army Cards");
		txtArmyCards.setBounds(192, 20, 419, 71);
		getContentPane().add(txtArmyCards);
		setBounds(0, 100, 837, 481);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	public void addButtons() {
		btnFirst.setBounds(120, 290, 137, 36);
		add(btnFirst);
		btnSecond.setBounds(300, 290, 137, 36);
		add(btnSecond);
		btnThird.setBounds(120, 340, 137, 36);
		add(btnThird);
		btnFourth.setBounds(300, 340, 137, 36);
		add(btnFourth);
		btnFifth.setBounds(120, 390, 137, 36);
		add(btnFifth);
		btnSixth.setBounds(300, 390, 137, 36);
		add(btnSixth);

	}
	
	public void addTradeOps() {
		
		JTextArea cavalry1 = new JTextArea("Trade option 1: Infantry cards => 1 Cavalry");
		JTextArea cavalry2 = new JTextArea("Trade option 2: 2 Infantry cards + 1 Artillery card => 2 Artillery");
		JTextArea artlry2 = new JTextArea("Trade option 3: 2 Infantry cards + 1 Artillery card => 2 Artillery");
		JTextArea inf1cav2 = new JTextArea("Trade option 4: 1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery");
		JTextArea art1cav2 = new JTextArea("Trade option 5: 1 Artillery + 2 Cavalry cards => 3 Artillery");
		
		cavalry1.setBounds(250, 100, 400, 25);
		cavalry1.setForeground(Color.LIGHT_GRAY);
        cavalry1.setFont(new Font("Kokonor", Font.ITALIC, 17));
        cavalry1.setEditable(false);
        cavalry1.setBackground(Color.DARK_GRAY);
        add(cavalry1);
        
        cavalry2.setBounds(250, 130, 500, 25);
		cavalry2.setForeground(Color.LIGHT_GRAY);
        cavalry2.setFont(new Font("Kokonor", Font.ITALIC, 17));
        cavalry2.setEditable(false);
        cavalry2.setBackground(Color.DARK_GRAY);
        add(cavalry2);
        
        artlry2.setBounds(250, 160, 500, 25);
        artlry2.setForeground(Color.LIGHT_GRAY);
        artlry2.setFont(new Font("Kokonor", Font.ITALIC, 17));
        artlry2.setEditable(false);
        artlry2.setBackground(Color.DARK_GRAY);
        add(artlry2);
        
        inf1cav2.setBounds(250, 190, 570, 25);
        inf1cav2.setForeground(Color.LIGHT_GRAY);
        inf1cav2.setFont(new Font("Kokonor", Font.ITALIC, 17));
        inf1cav2.setEditable(false);
        inf1cav2.setBackground(Color.DARK_GRAY);
        add(inf1cav2);
        
        art1cav2.setBounds(250, 220, 500, 25);
        art1cav2.setForeground(Color.LIGHT_GRAY);
        art1cav2.setFont(new Font("Kokonor", Font.ITALIC, 17));
        art1cav2.setEditable(false);
        art1cav2.setBackground(Color.DARK_GRAY);
        add(art1cav2);
	}

	public void addButtonActListener() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(0);
				txtInfantry.setText(Integer.toString(player.infantryList.size()));
				txtCavalry.setText(Integer.toString(player.cavalryList.size()));

			}
		});
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(1);
				
				txtInfantry.setText(Integer.toString(player.infantryList.size()));
				txtCavalry.setText(Integer.toString(player.cavalryList.size()));

			}
		});
		btnThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(2);
				
				txtInfantry.setText(Integer.toString(player.infantryList.size()));
				txtArtillery.setText(Integer.toString(player.artilleryList.size()));
			}
		});
		btnFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(3);
				
				txtInfantry.setText(Integer.toString(player.infantryList.size()));
				txtCavalry.setText(Integer.toString(player.cavalryList.size()));
				txtArtillery.setText(Integer.toString(player.artilleryList.size()));

			}
		});
		btnFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(4);
				
				txtCavalry.setText(Integer.toString(player.cavalryList.size()));
				txtArtillery.setText(Integer.toString(player.artilleryList.size()));


			}
		});
		btnSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(5);
				

			}
		});

	}

	
	public void addArmyCards() {
		ImageIcon infantry = new ImageIcon(this.getClass().getResource("/infantry.png"));
		ImageIcon artillery = new ImageIcon(this.getClass().getResource("/artillery.png"));
		ImageIcon cavalry = new ImageIcon(this.getClass().getResource("/cavalry.png"));
		
		JLabel labelInfantry = new JLabel(infantry);
		JLabel labelArtillery = new JLabel(artillery);
		JLabel labelCavalry = new JLabel(cavalry);

		labelInfantry.setBounds(52, 100, 114, 37);
		labelArtillery.setBounds(52, 150, 114, 37);
		labelCavalry.setBounds(52, 200, 114, 37);
		
		txtInfantry.setBounds(172, 107, 20, 37);
		txtInfantry.setBackground(Color.DARK_GRAY);
		txtInfantry.setText(Integer.toString(infantryCards.size()));
		txtArtillery.setBounds(172, 157, 20, 37);
		txtArtillery.setBackground(Color.DARK_GRAY);
		txtArtillery.setText(Integer.toString(artilleryCards.size()));
		txtCavalry.setBounds(172, 207, 20, 37);
		txtCavalry.setBackground(Color.DARK_GRAY);
		txtCavalry.setText(Integer.toString(cavalryCards.size()));


		add(labelInfantry);
		add(labelArtillery);
		add(labelCavalry);
		add(txtInfantry);
		add(txtArtillery);
		add(txtCavalry);
		
		
		
	}
}


