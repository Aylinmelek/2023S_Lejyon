package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TerrCardFrame extends JFrame {
	private static final int NUM_LABELS = 43;
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
			labels[i].setBounds(x, y, 30, 30);
			add(labels[i]);
			x += 34;
			if (x > 600) {
				x = 20;
				y += 40;
			}

			
		}
	}

	private void initializeFrame() {

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		JTextArea txtrTerritoryCards = new JTextArea();
		txtrTerritoryCards.setBounds(192, 20, 419, 71);
		txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
		txtrTerritoryCards.setBackground(Color.DARK_GRAY);
		txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrTerritoryCards.setEditable(false);
		txtrTerritoryCards.setText("Territory Cards");
		getContentPane().add(txtrTerritoryCards);
		setBounds(100, 100, 657, 481); // ekledim
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
	public void updateFrame()
	{
		for(int i = 0; i < GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).getTerritoryCardList().size(); i++)
		{
			//Burada territoryCardList'in her eleman�na bagli olan png'i'yi territoryCardFrame'e ekliceksin Commenti ac.
			//GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex).getTerritoryCardList().get(i);
		}
		
	}

	public void addButtonActListener() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent1);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();

			}
		});
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent2);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();

			}
		});
		btnThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent3);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();
			}
		});
		btnFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent4);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();
			}
		});
		btnFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent5);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();
			}
		});
		btnSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex)
						.tradeTerritoryCards(GameFrame.play.handler.getBoard().continent6);
				System.out.println("Buraya Basıldı");
				GameFrame.bmode.grid.updatePlayerColorToGrid();
			}
		});

	}

	public void setTerritoryCard(String territoryColor, String territoryName, int index) {

		String imageStr = "/territoryCards/" + territoryColor.toLowerCase() + territoryName + ".png";
		ImageIcon img = new ImageIcon(getClass().getResource(imageStr));
		labels[index].setIcon(img);
		labels[index].setVisible(true);

		getContentPane().revalidate();
		getContentPane().repaint();

	}
}
