package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ChanceCardFrame extends JFrame{

 private static final int MAX_CHANCE_CARDS = 15; //????
 
 JPanel cardsPanel = new JPanel();
 
 JLabel[] cardLabels = new JLabel[MAX_CHANCE_CARDS];
  int labelIndex;
  JButton btnFirst = new JButton("Reinforce!");
  JButton btnSecond = new JButton("Sabotage!");
  JButton btnThird = new JButton("World Event!");
  JButton btnFourth = new JButton("Spy!");
  JButton btnFifth = new JButton("Disaster!!!");
 
 public ChanceCardFrame() {
	 addButtons();
	 addButtonActListener();
  initialize();
  addPanel();
  initializeCardLabels();
 }

 
 public int getLabelIndex() {
  return labelIndex;
 }



 public void setLabelIndex(int labelIndex) {
  this.labelIndex = labelIndex;
 }
 public void addButtons() {
		btnFirst.setBounds(100, 90, 137, 36);
		add(btnFirst);
		btnSecond.setBounds(280, 90, 137, 36);
		add(btnSecond);
		
		btnThird.setBounds(100, 140, 137, 36);
		add(btnThird);
		
		btnFourth.setBounds(280, 140, 137, 36);
		add(btnFourth);
		
		btnFifth.setBounds(100, 190, 137, 36);
		add(btnFifth);
		/*
		btnSixth.setBounds(260, 390, 137, 36);
		add(btnSixth);*/

	}
 public void addButtonActListener() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameFrame.bmode.grid.territorySource != null)
				{
				GameFrame.play.handler.reinforce(GameFrame.play.handler.getBoard().getDie(), GameFrame.bmode.grid.territorySource,GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				GameFrame.bmode.grid.territorySource = null;
				}
			}
		});
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameFrame.bmode.grid.territorySource != null)
				{
				GameFrame.play.handler.sabotage(GameFrame.play.handler.getBoard().getDie(), GameFrame.bmode.grid.territorySource,GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				GameFrame.bmode.grid.territorySource = null;
				}
			}
		});
		btnThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameFrame.bmode.grid.territorySource != null)
				{
				GameFrame.play.handler.worldEvent(GameFrame.play.handler.getBoard().getDie(), GameFrame.bmode.grid.territorySource, GameFrame.playerArray, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				GameFrame.bmode.grid.territorySource = null;
				}
			}
		});
		btnFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameFrame.bmode.grid.territorySource != null)
				{
				GameFrame.play.handler.spy( GameFrame.bmode.grid.territorySource, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
				GameFrame.bmode.grid.territorySource = null;
				}
			}
		});
		btnFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameFrame.bmode.grid.territorySource != null)
				{
					
				
				if(GameFrame.play.handler.getBoard().continent1.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent1, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent1);
				}
				if(GameFrame.play.handler.getBoard().continent2.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent2, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent2);
				}
				if(GameFrame.play.handler.getBoard().continent3.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent3, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent3);
				}
				if(GameFrame.play.handler.getBoard().continent4.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent4, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent4);
				}
				if(GameFrame.play.handler.getBoard().continent5.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent5, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent5);
				}
				if(GameFrame.play.handler.getBoard().continent6.getTerritoryList().contains(GameFrame.bmode.grid.territorySource))
				{
					GameFrame.play.handler.disaster( GameFrame.play.handler.getBoard().continent6, GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex),2);
					System.out.println( GameFrame.play.handler.getBoard().continent6);
				}
				GameFrame.bmode.grid.territorySource = null;
				
				}
			}
		});}

 public JLabel[] initializeCardLabels() {
     
        for (int i = 0; i< MAX_CHANCE_CARDS; i++) {
         cardLabels[i] = new JLabel();     
            add(cardLabels[i]);
            
        }
        
        return cardLabels;
        
       
    }
 
 
        
        
 
 public void initialize() {
  
  getContentPane().setBackground(Color.DARK_GRAY);
  getContentPane().setLayout(null);
  
  JTextArea txtrChanceCards = new JTextArea();
  txtrChanceCards.setForeground(Color.LIGHT_GRAY);
  txtrChanceCards.setBackground(Color.DARK_GRAY);
  txtrChanceCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
  txtrChanceCards.setEditable(false);
  txtrChanceCards.setText("Chance Cards");
  txtrChanceCards.setBounds(192, 20, 419, 41);
  getContentPane().add(txtrChanceCards);
  setBounds(100, 100, 657, 481);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 }

 
 public void addPanel() {
  cardsPanel.setBounds(10, 100, 627, 341);
  cardsPanel.setBackground(Color.DARK_GRAY);
  cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));
  add(cardsPanel);
 }

 
 public JPanel getCardsPanel() {
  return cardsPanel;
 }


 public void setCardsPanel(JPanel cardsPanel) {
  this.cardsPanel = cardsPanel;
 }


 
 
}