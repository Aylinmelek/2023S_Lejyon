package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TerrCardFrame extends JFrame {
    private static final int NUM_LABELS = 43;
    private JLabel[] labels = new JLabel[NUM_LABELS];
	

    public TerrCardFrame() {
        initializeFrame();
        initializeLabels();
    }
    
    
    private void initializeLabels() {
    	
        for (int i = 0; i < NUM_LABELS; i++) {
            labels[i] = new JLabel();     
            add(labels[i]);
            labels[i].setVisible(true);
        }     
    }
    
    private void initializeFrame() {
    	
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(new FlowLayout());
        JTextArea txtrTerritoryCards = new JTextArea();
        txtrTerritoryCards.setBounds(192, 20, 419, 71);
        txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
        txtrTerritoryCards.setBackground(Color.DARK_GRAY);
        txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
        txtrTerritoryCards.setEditable(false);
        txtrTerritoryCards.setText("Territory Cards");
        getContentPane().add(txtrTerritoryCards);
        setBounds(100, 100, 657, 481);	//ekledim
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void setTerritoryCard(String territoryColor, String territoryName, int index, int x, int y) {
	
        labels[index].setBounds(x, y, 96,165);
        String imageStr = "/territoryCards/" + territoryColor.toLowerCase() + territoryName + ".png";
        ImageIcon img = new ImageIcon(getClass().getResource(imageStr));
        labels[index].setIcon(img);
        labels[index].setVisible(true);
        getContentPane().add(labels[index]);
        getContentPane().revalidate();
        getContentPane().repaint();
        
        
    }
   
  
}

//You can then call setTerritoryCard() method from outside this class to set individual cards.
//Remember to ensure that the index and x and y values are correct for each territory card.


