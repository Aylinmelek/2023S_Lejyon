package UI;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.controller.ConKUerorHandler;

public class ChanceCardFrame extends JFrame {

	JPanel cardsPanel = new JPanel();

	int labelIndex;
	JButton btnFirst = new JButton("Reinforce!");
	JButton btnSecond = new JButton("Sabotage!");
	JButton btnThird = new JButton("World Event!");
	JButton btnFourth = new JButton("Spy!");
	JButton btnFifth = new JButton("Disaster!!!");
	JButton btnSixth = new JButton("Immunize!!!");
	JTextArea txtFirst = new JTextArea();
	JTextArea txtSecond = new JTextArea();
	JTextArea txtThird = new JTextArea();
	JTextArea txtFourth = new JTextArea();
	JTextArea txtFifth = new JTextArea();
	JTextArea txtSixth = new JTextArea();
	ConKUerorHandler handler = new ConKUerorHandler();

	public ChanceCardFrame() {
		addElements();
		addButtonActListener();
		initialize();
		addPanel();

	}

	public int getLabelIndex() {
		return labelIndex;
	}

	public void setLabelIndex(int labelIndex) {
		this.labelIndex = labelIndex;
	}

	public void addElements() {
		btnFirst.setBounds(100, 90, 137, 36);
		add(btnFirst);
		
		txtFirst.setBounds(240,97,20,36);
		txtFirst.setText(Integer.toString(ConKUerorHandler.board.player.deck.getReinforcementCardList().size()));
		txtFirst.setBackground(Color.DARK_GRAY);
		add(txtFirst);
		
		btnSecond.setBounds(280, 90, 137, 36);
		add(btnSecond);
		
		txtSecond.setBounds(420,97,20,36);
		txtSecond.setText(Integer.toString(ConKUerorHandler.board.player.deck.getsabotageCardList().size()));
		txtSecond.setBackground(Color.DARK_GRAY);
		add(txtSecond);

		btnThird.setBounds(100, 140, 137, 36);
		add(btnThird);
		
		txtThird.setBounds(240,147,20,36);
		txtThird.setText(Integer.toString(ConKUerorHandler.board.player.deck.getWorldEventCardList().size()));
		txtThird.setBackground(Color.DARK_GRAY);
		add(txtThird);

		btnFourth.setBounds(280, 140, 137, 36);
		add(btnFourth);
		
		txtFourth.setBounds(420,147,20,36);
		txtFourth.setText(Integer.toString(ConKUerorHandler.board.player.deck.getSpyCardList().size()));
		txtFourth.setBackground(Color.DARK_GRAY);
		add(txtFourth);

		btnFifth.setBounds(100, 190, 137, 36);
		add(btnFifth);
		
		txtFifth.setBounds(240,197,20,36);
		txtFifth.setText(Integer.toString(ConKUerorHandler.board.player.deck.getDisasterCardList().size()));
		txtFifth.setBackground(Color.DARK_GRAY);
		add(txtFifth);
		
		btnSixth.setBounds(280, 190, 137, 36); 
		add(btnSixth);
		txtSixth.setBounds(420,197,20,36);
		txtSixth.setText(Integer.toString(ConKUerorHandler.board.player.deck.getdipImmunityCardList().size()));
		txtSixth.setBackground(Color.DARK_GRAY);

		add(txtSixth);

	}



	public void addButtonActListener() {
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameFrame.bmode.grid.territorySource != null && GameFrame.play.roll3 != 0) {
					
					GameFrame.play.handler.reinforce(GameFrame.play.roll3,
							GameFrame.bmode.grid.territorySource,
							GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();
					
					GameFrame.play.roll3 = 0;
					GameFrame.play.btnRoll.setEnabled(false);
				}
			}
		});
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameFrame.bmode.grid.territorySource != null && GameFrame.play.roll3 != 0) {
					
					GameFrame.play.handler.sabotage(GameFrame.play.roll3,
							GameFrame.bmode.grid.territorySource,
							GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();
					
					GameFrame.play.roll3 = 0;
					GameFrame.play.btnRoll.setEnabled(false);
				}
			}
		});
		btnThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (GameFrame.bmode.grid.territorySource != null && GameFrame.play.roll3 != 0) {
					
					GameFrame.play.handler.worldEvent(GameFrame.play.roll3,
							GameFrame.bmode.grid.territorySource, GameFrame.playerArray,
							GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();
					
					GameFrame.play.roll3 = 0;
					GameFrame.play.btnRoll.setEnabled(false);
				}
			}
		});
		btnFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameFrame.bmode.grid.territorySource != null) {
					
					GameFrame.play.handler.spy(GameFrame.bmode.grid.territorySource,
							GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex));
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();
				}
			}
		});
		btnFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameFrame.bmode.grid.territorySource != null) {
					
					
					if (GameFrame.play.handler.getBoard().continent1.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent1,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent1);
					}
					if (GameFrame.play.handler.getBoard().continent2.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent2,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent2);
					}
					if (GameFrame.play.handler.getBoard().continent3.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent3,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent3);
					}
					if (GameFrame.play.handler.getBoard().continent4.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent4,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent4);
					}
					if (GameFrame.play.handler.getBoard().continent5.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent5,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent5);
					}
					if (GameFrame.play.handler.getBoard().continent6.getTerritoryList()
							.contains(GameFrame.bmode.grid.territorySource)) {
						GameFrame.play.handler.disaster(GameFrame.play.handler.getBoard().continent6,
								GameFrame.playerArray.get(GameFrame.bmode.grid.playerIndex), 2);
						System.out.println(GameFrame.play.handler.getBoard().continent6);
					}
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();

				}
			}
			
		});
		btnSixth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameFrame.bmode.grid.territorySource != null) {
					GameFrame.play.handler.immunize(GameFrame.bmode.grid.territorySource);
					GameFrame.bmode.grid.territorySource = null;
					GameFrame.bmode.grid.updateGridText();
				}
			}
		});
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