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
 
 JButton btnFirst = new JButton("Trade");
 JButton btnSecond = new JButton("Trade");
 JButton btnThird = new JButton("Trade");
 JButton btnFourth = new JButton("Trade");
 JButton btnFifth = new JButton("Trade");
 JButton btnSixth = new JButton("Trade");

 int tradeCvlry, tradeInfntry, tradeArtlry; 
 
 private JLabel[] labels = new JLabel[NUM_CARDS];
 private JTextArea[] numbers = new JTextArea[NUM_CARDS];
 
    /*JComboBox<Integer> cavalryNum = new JComboBox<Integer>();
    JComboBox<Integer> infantryNum = new JComboBox<Integer>();
    JComboBox<Integer> artilleryNum = new JComboBox<Integer>();*/
    
    JPanel tradePanel = new JPanel();
    ArrayList<JButton> txtArmies = new ArrayList<JButton>();
 
 JButton btnTrade = new JButton("TRADE");
  
 
 public ArmyCardFrame() {
	 addButtons();
	 initialize();
	 addButtonActListener();
	 /*addCardstoArray();
	 * addButtonActListener()
	  addCardNumstoArray();		  
	  addCardNumstoArray();
	  initialize();		 
	  addElements();		  
	  addTradePanel();		  
	  addArmyButons();*/		  
  
 }
 public void addButtons() {
	 btnFirst.setBounds(120, 230, 137, 36);
	 add(btnFirst);
	 btnSecond.setBounds(260, 230, 137, 36);
	 add(btnSecond);
	 btnThird.setBounds(120, 270, 137, 36);
	 add(btnThird);
	 btnFourth.setBounds(260, 270, 137, 36);
	 add(btnFourth);
	 btnFifth.setBounds(120, 310, 137, 36);
	 add(btnFifth);
	 btnSixth.setBounds(260, 310, 137, 36);
	 add(btnSixth);
	 
 }
 
 public void addButtonActListener() {
	 btnFirst.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(0);
             System.out.println("Buraya Basýldý");
         	
         }
     });
	 btnSecond.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(1);
             System.out.println("Buraya Basýldý");
         	
         }
     });
	 btnThird.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(2);
             System.out.println("Buraya Basýldý");
         	
         }
     });
	 btnFourth.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(3);
             System.out.println("Buraya Basýldý");
         	
         }
     });
	 btnFifth.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(4);
             System.out.println("Buraya Basýldý");
             
         	
         }
     });
	 btnSixth.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeArmyCards(5);
             System.out.println("Buraya Basýldý");
         	
         }
     });
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
    
       public void addArmyButons() {
        JButton btnInfantry = new JButton("Infantry Cards");
        JButton btnArtillery = new JButton("Artillery Cards");
        JButton btnCavalry = new JButton("Cavalry Cards");
        
        btnInfantry.setBounds(52, 120, 114, 37);
        btnArtillery.setBounds(52, 170, 114, 37);
        btnCavalry.setBounds(52, 220, 114, 37);
        
        add(btnInfantry);
        add(btnArtillery);
        add(btnCavalry);
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
     
     int y= 131;
           for (int i = 0; i < NUM_CARDS; i++) {
            numbers[i] = new JTextArea();
            numbers[i].setBounds(172, y, 24, 27);
            numbers[i].setText(armyCardsNum.get(i).toString());
            numbers[i].setEditable(false);
            numbers[i].setBackground(Color.DARK_GRAY);
            add(numbers[i]);
            //labels[i].setVisible(true);
             y += 50;
      }     
           
           
           btnTrade.setBackground(Color.WHITE);
        btnTrade.setBounds(521, 350, 92, 50);
        getContentPane().add(btnTrade); 
        
        btnTrade.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
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
    

   }