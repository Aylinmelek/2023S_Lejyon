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
 
    /*JComboBox<Integer> cavalryNum = new JComboBox<Integer>();
    JComboBox<Integer> infantryNum = new JComboBox<Integer>();
    JComboBox<Integer> artilleryNum = new JComboBox<Integer>();*/
    
    JPanel tradePanel = new JPanel();
    ArrayList<JButton> txtArmies = new ArrayList<JButton>();
 
 JButton btnTrade = new JButton("TRADE");
  
 
 public ArmyCardFrame() {
  
  addCardstoArray();
  addCardNumstoArray();
  initialize();
  addElements();
  addTradePanel();
  addArmyButons();
  
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
    

   }