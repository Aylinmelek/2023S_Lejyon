package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class territoryCardFrame {

	//JFrame territoryCardF;

	private JPasswordField txtPassword;
	private JLabel loginLabel;
	static JFrame territoryCardF = territoryCardF = new JFrame();

	JLabel[] l2;

	public territoryCardFrame() {
		initialize();
		CLabels();
		showLabels();
		
		
	}
	 public JLabel[] CLabels()
     {
         JLabel[] l = new JLabel[43];
         for(int x = 0; x < 43; x++)
         {
           l[x] = new JLabel("");
         }
         return l;
     }
     
     public void showLabels()
     {
         l2 = CLabels();
       for(int y = 0; y < l2.length; y++)
       {
           territoryCardF.add(l2[3]);
       }
     }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		territoryCardF.getContentPane().setBackground(Color.DARK_GRAY);
		territoryCardF.getContentPane().setLayout(null);
		//territoryCardF.getContentPane().setLayout(null);
		
		JTextArea txtrTerritoryCards = new JTextArea();
		txtrTerritoryCards.setBounds(192, 20, 419, 71);
		txtrTerritoryCards.setForeground(Color.LIGHT_GRAY);
		txtrTerritoryCards.setBackground(Color.DARK_GRAY);
		txtrTerritoryCards.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 34));
		txtrTerritoryCards.setEditable(false);
		txtrTerritoryCards.setText("Territory Cards");
		territoryCardF.getContentPane().add(txtrTerritoryCards);
		territoryCardF.setBounds(100, 100, 657, 481);	
		territoryCardF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	public void setTerCards(String territory) {
		
		if (territory=="Yellow 1") {
			l2[0].setBounds(40, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow1.png"));
			l2[0].setIcon(img);
			territoryCardF.getContentPane().add(l2[0]);
		}
		if (territory=="Yellow 2") {
			l2[1].setBounds(80, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow2.png"));
			l2[1].setIcon(img);
			territoryCardF.getContentPane().add(l2[1]);
		}
		if (territory=="Yellow 3") {
			l2[2].setBounds(120, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow3.png"));
			l2[2].setIcon(img);
			territoryCardF.getContentPane().add(l2[2]);
		}
		if (territory=="Yellow 4") {
			l2[3].setBounds(160, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow4.png"));
			l2[3].setIcon(img);
			territoryCardF.getContentPane().add(l2[3]);
		}
		if (territory=="Yellow 5") {
			l2[4].setBounds(200, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow5.png"));
			l2[4].setIcon(img);
			territoryCardF.getContentPane().add(l2[4]);
		}
		if (territory=="Yellow 6") {
			l2[5].setBounds(240, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow6.png"));
			l2[5].setIcon(img);
			territoryCardF.getContentPane().add(l2[5]);
		}
		if (territory=="Yellow 7") {
			l2[6].setBounds(280, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow7.png"));
			l2[6].setIcon(img);
			territoryCardF.getContentPane().add(l2[6]);
		}
		if (territory=="Yellow 8") {
			l2[7].setBounds(320, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow8.png"));
			l2[7].setIcon(img);
			territoryCardF.getContentPane().add(l2[7]);
		}
		if (territory=="Yellow 9") {
			l2[8].setBounds(360, 63, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/yellow9.png"));
			l2[8].setIcon(img);
			territoryCardF.getContentPane().add(l2[8]);
		}
		
		if (territory=="Blue 1") {
			l2[9].setBounds(40, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue1.png"));
			l2[9].setIcon(img);
			territoryCardF.getContentPane().add(l2[9]);
		}
		if (territory=="Blue 2") {
			l2[10].setBounds(80, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue2.png"));
			l2[10].setIcon(img);
			territoryCardF.getContentPane().add(l2[10]);
		}
		if (territory=="Blue 3") {
			l2[11].setBounds(120, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue3.png"));
			l2[11].setIcon(img);
			territoryCardF.getContentPane().add(l2[11]);
		}
		if (territory=="Blue 4") {
			l2[12].setBounds(160, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue4.png"));
			l2[12].setIcon(img);
			territoryCardF.getContentPane().add(l2[12]);
		}
		if (territory=="Blue 5") {
			l2[13].setBounds(200, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue5.png"));
			l2[13].setIcon(img);
			territoryCardF.getContentPane().add(l2[13]);
		}
		if (territory=="Blue 6") {
			l2[14].setBounds(240, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue6.png"));
			l2[14].setIcon(img);
			territoryCardF.getContentPane().add(l2[14]);
		}
		if (territory=="Blue 7") {
			l2[15].setBounds(280, 120, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/blue7.png"));
			l2[15].setIcon(img);
			territoryCardF.getContentPane().add(l2[15]);
		}
		
		if (territory=="Green 1") {
			l2[16].setBounds(40, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green1.png"));
			l2[16].setIcon(img);
			territoryCardF.getContentPane().add(l2[16]);
		}
		if (territory=="Green 2") {
			l2[17].setBounds(80, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green2.png"));
			l2[17].setIcon(img);
			territoryCardF.getContentPane().add(l2[17]);
		}
		if (territory=="Green 3") {
			l2[18].setBounds(120, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green3.png"));
			l2[18].setIcon(img);
			territoryCardF.getContentPane().add(l2[18]);
		}
		if (territory=="Green 4") {
			l2[19].setBounds(160, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green4.png"));
			l2[19].setIcon(img);
			territoryCardF.getContentPane().add(l2[19]);
		}
		if (territory=="Green 5") {
			l2[20].setBounds(200, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green5.png"));
			l2[20].setIcon(img);
			territoryCardF.getContentPane().add(l2[20]);
		}
		if (territory=="Green 6") {
			l2[21].setBounds(240, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green6.png"));
			l2[21].setIcon(img);
			territoryCardF.getContentPane().add(l2[21]);
		}
		if (territory=="Green 7") {
			l2[22].setBounds(280, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green7.png"));
			l2[22].setIcon(img);
			territoryCardF.getContentPane().add(l2[22]);
		}
		if (territory=="Green 8") {
			l2[23].setBounds(320, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green8.png"));
			l2[23].setIcon(img);
			territoryCardF.getContentPane().add(l2[23]);
		}
		if (territory=="Green 9") {
			l2[24].setBounds(360, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green9.png"));
			l2[24].setIcon(img);
			territoryCardF.getContentPane().add(l2[24]);
		}
		if (territory=="Green 10") {
			l2[25].setBounds(400, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green10.png"));
			l2[25].setIcon(img);
			territoryCardF.getContentPane().add(l2[25]);
		}
		if (territory=="Green 11") {
			l2[26].setBounds(440, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green11.png"));
			l2[26].setIcon(img);
			territoryCardF.getContentPane().add(l2[26]);
		}
		if (territory=="Green 12") {
			l2[27].setBounds(480, 177, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/green12.png"));
			l2[27].setIcon(img);
			territoryCardF.getContentPane().add(l2[27]);
		}
		
		if (territory=="Pink 1") {
			l2[28].setBounds(40, 234, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/somon1.png"));
			l2[28].setIcon(img);
			territoryCardF.getContentPane().add(l2[28]);
		}
		if (territory=="Pink 2") {
			l2[29].setBounds(80, 234, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/somon2.png"));
			l2[29].setIcon(img);
			territoryCardF.getContentPane().add(l2[29]);
		}
		if (territory=="Pink 3") {
			l2[30].setBounds(120, 234, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/somon3.png"));
			l2[30].setIcon(img);
			territoryCardF.getContentPane().add(l2[30]);
		}
		if (territory=="Pink 4") {
			l2[31].setBounds(160, 234, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/somon4.png"));
			l2[31].setIcon(img);
			territoryCardF.getContentPane().add(l2[31]);
		}
		
		if (territory=="Orange 1") {
			l2[32].setBounds(40, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange1.png"));
			l2[32].setIcon(img);
			territoryCardF.getContentPane().add(l2[32]);
		}
		if (territory=="Orange 2") {
			l2[33].setBounds(80, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange2.png"));
			l2[33].setIcon(img);
			territoryCardF.getContentPane().add(l2[33]);
		}
		if (territory=="Orange 3") {
			l2[34].setBounds(120, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange3.png"));
			l2[34].setIcon(img);
			territoryCardF.getContentPane().add(l2[34]);
		}
		if (territory=="Orange 4") {
			l2[36].setBounds(160, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange4.png"));
			l2[36].setIcon(img);
			territoryCardF.getContentPane().add(l2[36]);
		}
		if (territory=="Orange 5") {
			l2[37].setBounds(200, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange5.png"));
			l2[37].setIcon(img);
			territoryCardF.getContentPane().add(l2[37]);
		}
		if (territory=="Orange 6") {
			l2[38].setBounds(240, 291, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/orange6.png"));
			l2[38].setIcon(img);
			territoryCardF.getContentPane().add(l2[38]);
		}
		
		
		if (territory=="Red 1") {
			l2[39].setBounds(40, 348, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/red1.png"));
			l2[39].setIcon(img);
			territoryCardF.getContentPane().add(l2[39]);
		}
		if (territory=="Red 2") {
			l2[40].setBounds(80, 348, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/red2.png"));
			l2[40].setIcon(img);
			territoryCardF.getContentPane().add(l2[40]);
		}
		if (territory=="Red 3") {
			l2[41].setBounds(120, 348, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/red3.png"));
			l2[41].setIcon(img);
			territoryCardF.getContentPane().add(l2[41]);
		}
		if (territory=="Red 4") {
			l2[42].setBounds(160, 348, 96,165);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/red4.png"));
			l2[42].setIcon(img);
			territoryCardF.getContentPane().add(l2[42]);
		}
		
		
		
	}

}


