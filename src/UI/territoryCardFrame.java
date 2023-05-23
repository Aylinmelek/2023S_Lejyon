package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class territoryCardFrame {
    private static final int NUM_LABELS = 43;

    JFrame territoryCardF  = new JFrame();
    private JLabel[] labels = new JLabel[NUM_LABELS];

    public territoryCardFrame() {
        initializeFrame();
        initializeLabels();
    }
    
    private void initializeLabels() {
        for (int i = 0; i < NUM_LABELS; i++) {
            labels[i] = new JLabel("");     
            territoryCardF.add(labels[i]);
            labels[i].setVisible(true);
        }     
    }
    
    private void initializeFrame() {
        territoryCardF.getContentPane().setBackground(Color.DARK_GRAY);
        territoryCardF.getContentPane().setLayout(new FlowLayout());

        JTextArea txtrTerritoryCards = new JTextArea();
        txtrTerritoryCards.setBounds(192, 20, 419, 71);
        txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
        txtrTerritoryCards.setBackground(Color.DARK_GRAY);
        txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
        txtrTerritoryCards.setEditable(false);
        txtrTerritoryCards.setText("Territory Cards");
        territoryCardF.getContentPane().add(txtrTerritoryCards);
        territoryCardF.setBounds(100, 100, 657, 481);	//ekledim
        territoryCardF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void setTerritoryCard(String territoryColor, String territoryName, int index, int x, int y) {
	
        labels[index].setBounds(x, y, 96,165);
        String imageStr = "/territoryCards/" + territoryColor.toLowerCase() + territoryName + ".png";   
        ImageIcon img = new ImageIcon(this.getClass().getResource(imageStr));  
        labels[index].setIcon(img);
        territoryCardF.getContentPane().add(labels[index]);
        labels[index].setVisible(true);

    }
  
}

//You can then call setTerritoryCard() method from outside this class to set individual cards.
//Remember to ensure that the index and x and y values are correct for each territory card.


