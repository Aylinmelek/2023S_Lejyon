package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import domain.Die;
import domain.Territory;


public class InitSharing extends JLayeredPane implements MouseListener {
    JTextArea txtInitSharing = new JTextArea();
    JLabel dieLabel = new JLabel();
    JButton btnStartGame = new JButton("Start Game");
    JButton btnRoll = new JButton("ROLL");
    private static final int CELL_SIZE = 50;
    territoryCardFrame terCard = new territoryCardFrame();
    int index=0;  
    Grid grid = new Grid();
    Die die = new Die();
    
    ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
    ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
    ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
    ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
    ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
    ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

    
    
    
    public InitSharing() {
		super();
		initialize();
		displayDie();
		addElements();
		addMouseListener(this);
	}

	public void initialize() {
        setBackground(Color.DARK_GRAY);
        setBounds(0, 54, 873, 451);
        setLayout(null);
    }
    
    public void displayDie() {
        Thread rollThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int dieDisplayed = die.generateNum();
                switch (dieDisplayed) {
                    case 1:
                        dieLabel.setIcon(die1);
                        break;
                    case 2:
                        dieLabel.setIcon(die2);
                        break;
                    case 3:
                        dieLabel.setIcon(die3);
                        break;
                    case 4:
                        dieLabel.setIcon(die4);
                        break;
                    case 5:
                        dieLabel.setIcon(die5);
                        break;
                    default:
                        dieLabel.setIcon(die6);
                        break;
                }
                try {
                    Thread.sleep(100); // Adjust the delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int finalDieDisplayed = die.generateNum();
            switch (finalDieDisplayed) {
                case 1:
                    dieLabel.setIcon(die1);
                    break;
                case 2:
                    dieLabel.setIcon(die2);
                    break;
                case 3:
                    dieLabel.setIcon(die3);
                    break;
                case 4:
                    dieLabel.setIcon(die4);
                    break;
                case 5:
                    dieLabel.setIcon(die5);
                    break;
                default:
                    dieLabel.setIcon(die6);
                    break;
            }
        });
        rollThread.start();
    }
    
    public void addElements() {
        txtInitSharing.setForeground(Color.LIGHT_GRAY);
        txtInitSharing.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtInitSharing.setBackground(Color.DARK_GRAY);
        txtInitSharing.setText("Initial Sharing and Army Placement");
        txtInitSharing.setBounds(175, 6, 489, 56);
        add(txtInitSharing);
        
        dieLabel.setBounds(221, 450, 80, 80);
        
        btnRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayDie();
            }
        });
        
        btnStartGame.setBackground(Color.WHITE);
        btnStartGame.setBounds(733, 495, 117, 29);
        btnRoll.setBounds(30, 450, 117, 56);
        
        add(btnRoll);
        add(dieLabel);
        add(btnStartGame);
    }
    
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / CELL_SIZE;
        int col = e.getX() / CELL_SIZE;

        grid.gridColors[row][col] = Color.black;
        repaint();

        Territory territory2 = Territory.isTerritory(row, col);
        index=territory2.getIndex();
            
        if (territory2 != null) {
            		System.out.println(grid.getColorName(territory2.getColor()));   
            		System.out.println(index);
                    terCard.setTerritoryCard(grid.getColorName(territory2.getColor()), territory2.getText(),index,20,100);                  
                    System.out.println(index);
            }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
