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

	int tradeCvlry, tradeInfntry, tradeArtlry; 
	
	private JLabel[] labels = new JLabel[NUM_CARDS];
	private JTextArea[] numbers = new JTextArea[NUM_CARDS];
	
    JComboBox<Integer> cavalryNum = new JComboBox<Integer>();
    JComboBox<Integer> infantryNum = new JComboBox<Integer>();
    JComboBox<Integer> artilleryNum = new JComboBox<Integer>();
    
    JPanel tradePanel = new JPanel();
    ArrayList<JTextArea> txtArmies = new ArrayList<JTextArea>();
	
	JButton btnTrade = new JButton("TRADE");
	 
	
	public ArmyCardFrame() {
		initializeLabels();
		addCardstoArray();
		addCardNumstoArray();
		initialize();
		addElements();
		addTradePanel();
		
	}

	
    public ArrayList <String> addCardstoArray() {
    	armyCards.add("cavalry");
    	armyCards.add("infantry");
    	armyCards.add("artillery");
    	return armyCards;	
    }
    
    public ArrayList <Integer> addCardNumstoArray() {
    	armyCardsNum.add(player.getCavalryList().size());
    	armyCardsNum.add( player.getInfantryList().size());
    	armyCardsNum.add(player.getArtilleryList().size());
    	return armyCardsNum;	
    }
	
    public void initializeLabels() {
		 int y = 100;
		 for (int i = 0; i < NUM_CARDS; i++) {
			 labels[i] = new JLabel(""); 
	         labels[i].setBounds(72, y, 224, 67);
	         String imageStr = "/" + (addCardstoArray().get(i)) + ".png";   
			 ImageIcon img = new ImageIcon(this.getClass().getResource(imageStr));  
			 labels[i].setIcon(img);
	         add(labels[i]);
	         labels[i].setVisible(true);
	         y += 50;
		 }     
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
		setBounds(100, 100, 657, 481);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
	}
	
	public void addElements() {
		
		JTextArea txtCavalryCards = new JTextArea();
		JTextArea txtinfantryCards = new JTextArea();
		JTextArea txtArtilleryCards = new JTextArea();
		txtCavalryCards.setText("Cavalry Cards");
		txtinfantryCards.setText("Infantry Cards");
		txtArtilleryCards.setText("Artillery Cards");
		txtArmies.add(txtCavalryCards);
		txtArmies.add(txtinfantryCards);
		txtArmies.add(txtArtilleryCards);
		int y = 311;
		
		for (int i = 0; i < txtArmies.size(); i++) {
			txtArmies.get(i).setBackground(Color.DARK_GRAY);
			txtArmies.get(i).setForeground(Color.LIGHT_GRAY);
			txtArmies.get(i).setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 16));
			txtArmies.get(i).setBounds(120, y, 104, 27);
			add(txtArmies.get(i));
	        txtArmies.get(i).setVisible(true);
	         y += 30;
		 }     
		
		
		cavalryNum.setBounds(232, 311, 64, 27);
		cavalryNum.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
		cavalryNum.setMaximumRowCount(6);
		cavalryNum.setBackground(Color.LIGHT_GRAY);
	    tradeCvlry = Integer.parseInt(cavalryNum.getSelectedItem().toString());
	    add(cavalryNum);
        
        infantryNum.setBounds(232, 341, 64, 27);
        infantryNum.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        infantryNum.setMaximumRowCount(6);
        infantryNum.setBackground(Color.LIGHT_GRAY);
        tradeInfntry = Integer.parseInt(infantryNum.getSelectedItem().toString());
        //String tradeInfntry2 = String.valueOf(infantryNum.getSelectedItem().toString());
        add(infantryNum);
       
        
        artilleryNum.setBounds(232, 371, 64, 27);
        artilleryNum.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6}));
        artilleryNum.setMaximumRowCount(6);
        artilleryNum.setBackground(Color.LIGHT_GRAY);
        tradeArtlry = Integer.parseInt(artilleryNum.getSelectedItem().toString());
        //System.out.println("artlyr" + tradeArtlry);
        add(artilleryNum);
        
        
       
        y= 120;
        for (int i = 0; i < NUM_CARDS; i++) {
        	numbers[i] = new JTextArea();
        	numbers[i].setBounds(172, y, 24, 27);
	        numbers[i].setText(armyCardsNum.get(i).toString());
	        numbers[i].setEditable(false);
	        numbers[i].setBackground(Color.DARK_GRAY);
	        add(numbers[i]);
	        labels[i].setVisible(true);
	         y += 50;
		 }     
        
        
        btnTrade.setBackground(Color.WHITE);
	    btnTrade.setBounds(521, 350, 92, 50);
	    getContentPane().add(btnTrade);	
	    
	    btnTrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(tradeArtlry);
        		//System.out.println(tradeInfntry2); 

            }
        });
       	}
	
	public void addTradePanel() {
		
		tradePanel.setBackground(Color.LIGHT_GRAY);
		tradePanel.setBounds(342, 311, 164, 98);
	    tradePanel.setLayout(new FlowLayout());
		tradePanel.setVisible(true);
		add(tradePanel);	
	}
	
	
	
		/*3 Infantry cards => 1 Cavalry
		2 Infantry cards + 1 Cavalry card => 2 Cavalry
		2 Infantry cards + 1 Artillery card => 2 Artillery
		1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery
		1 Artillery + 2 Cavalry cards => 3 Artillery
		*/


}




