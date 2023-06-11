package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TerrCardFrame extends JFrame {
    private static final int NUM_LABELS = 43;
	JPanel cardsPanel = new JPanel();

    private JLabel[] labels = new JLabel[NUM_LABELS];
    JButton btnFirst = new JButton("Continent 1");
	JButton btnSecond = new JButton("Continent  2");
	JButton btnThird = new JButton("Continent 3");
	JButton btnFourth = new JButton("Continent 4");
	JButton btnFifth = new JButton("Continent 5");
	JButton btnSixth = new JButton("Continent 6");


    public TerrCardFrame() {
        initializeFrame();
        initializeLabels();
        addButtons();
        addButtonActListener();
    }
    
    
    private void initializeLabels() {
    	int x = 100;
    	int y = 100;
        for (int i = 0; i < NUM_LABELS; i++) {
            labels[i] = new JLabel(); 
            labels[i].setBounds(x, y, 30,30);
            add(labels[i]);
            x += 34;
            if (x>600) {
            	x = 20;
            	y += 40;
            }
          
            //labels[i].setVisible(true);
        }     
    }
    
    private void initializeFrame() {
    	
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        JTextArea txtrTerritoryCards = new JTextArea();
        txtrTerritoryCards.setBounds(192, 20, 419, 51);
        txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
        txtrTerritoryCards.setBackground(Color.DARK_GRAY);
        txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
        txtrTerritoryCards.setEditable(false);
        txtrTerritoryCards.setText("Territory Cards");
        getContentPane().add(txtrTerritoryCards);
        setBounds(100, 100, 657, 481);	//ekledim
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void addButtons() {
		btnFirst.setBounds(120, 290, 137, 36);
		add(btnFirst);
		btnSecond.setBounds(260, 290, 137, 36);
		add(btnSecond);
		btnThird.setBounds(120, 340, 137, 36);
		add(btnThird);
		btnFourth.setBounds(260, 340, 137, 36);
		add(btnFourth);
		btnFifth.setBounds(120, 390, 137, 36);
		add(btnFifth);
		btnSixth.setBounds(260, 390, 137, 36);
		add(btnSixth);

	}
    public void addButtonActListener() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent1);
				System.out.println("Buraya Basıldı");

			}
		});
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent2);
				System.out.println("Buraya Basıldı");

			}
		});
		btnThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent3);
				System.out.println("Buraya Basıldı");

			}
		});
		btnFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent4);
				System.out.println("Buraya Basıldı");

			}
		});
		btnFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent5);
				System.out.println("Buraya Basıldı");

			}
		});
		btnSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).tradeTerritoryCards(GameFrame.play.handler.getBoard().continent6);
				System.out.println("Buraya Basıldı");

			}
		});

	}
    
    public void setTerritoryCard(String territoryColor, String territoryName, int index) {
    	
        
        String imageStr = "/territoryCards/" + territoryColor.toLowerCase() + territoryName + ".png";
        ImageIcon img = new ImageIcon(getClass().getResource(imageStr));
        labels[index].setIcon(img);
        labels[index].setVisible(true);
        //getContentPane().add(labels[index]);
        getContentPane().revalidate();
        getContentPane().repaint();
        //x += 30;
        
    }
   
	/*public void addPanel() {
		cardsPanel.setBounds(10, 100, 627, 341);
		cardsPanel.setBackground(Color.DARK_GRAY);
		//cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.X_AXIS));
		cardsPanel.setLayout(null);
		add(cardsPanel);
	}

	public JPanel getCardsPanel() {
		return cardsPanel;
	}

	public void setCardsPanel(JPanel cardsPanel) {
		this.cardsPanel = cardsPanel;
	}*/
}

//You can then call setTerritoryCard() method from outside this class to set individual cards.
//Remember to ensure that the index and x and y values are correct for each territory card.


