package UI;

import javax.swing.*;

import domain.Army;
import domain.ConKUeror;
import domain.Continent;
import domain.Die;
import domain.Infantry;
import domain.InfantryCard;
import domain.Map;
import domain.Player;
import domain.Territory;
import domain.TerritoryCard;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;



public class runningMode extends JFrame{
    private JLayeredPane layeredPane;
    JFrame run = new JFrame();
    
   Die die = new Die();
	
	//JLabel dielabel = new JLabel();
	
	
	

	ImageIcon die1 = new ImageIcon(this.getClass().getResource("/die1.png"));
	ImageIcon die2 = new ImageIcon(this.getClass().getResource("/die2.png"));
	ImageIcon die3 = new ImageIcon(this.getClass().getResource("/die3.png"));
	ImageIcon die4 = new ImageIcon(this.getClass().getResource("/die4.png"));
	ImageIcon die5 = new ImageIcon(this.getClass().getResource("/die5.png"));
	ImageIcon die6 = new ImageIcon(this.getClass().getResource("/die6.png"));

	

	
	static Grid gridPanel_1 = new Grid();
	
	

    //RollDieUI rolldieUI = new RollDieUI(); 
    private JPanel startScreen;
	//private static JPanel buildingMode;
    private JTextPane txtpnKjkjkjk;
    private JButton btnHelp, btnResume, btnPause;
    private JTextArea txtrEnterUsername;
    private JTextField textField_1;
    private JPanel helpScreen, pauseScreen;
    private JPanel playingMode;
    private JPanel initSharing;
    private JTextArea txtrGameObject;
    private JTextArea txtrGameFeatures;
    private JTextArea txtrHowToPlay;
    private JButton btnBack;
    static boolean start, building, help, init, playGame;
    private JTextArea txtrGameOptions;
    //InitialSharingPlacement gridLabel = new InitialSharingPlacement(10, 10, Color.black);
    //GridPanel gridPanel = new GridPanel(14, 14, Color.black);
    
    
     JPanel buildingMode = new JPanel();
     
     private int x,y;
     private boolean flag;
     private JTextArea txtrInitialSharingAnd;
     private JButton btnRoll;
     private JLabel dieLabel;
     private JButton btnArmy;
     private JButton btnChance;
     private JTextArea txtrGamePaused;
     private JButton btnNewButton;
     private JButton btnNewButton_1;
     

 	public JPanel getbuildingMode() {
 		// TODO Auto-generated method stub
 		return buildingMode;
 	}
    
 	public void displayDie() {
		
		//System.out.println(die.generateNum());
		int dieDisplayed = die.generateNum();
		//System.out.println(dieDisplayed);
		
		if (dieDisplayed == 1) {
			
		
			dieLabel.setIcon(die1);
			
			//initSharing.setVisible(true);
		}
		
		else if (dieDisplayed == 2) {
			
			
			dieLabel.setIcon(die2);
			
			
		}
		else if (dieDisplayed == 3) {
			
			
			dieLabel.setIcon(die3);
			
		}
		else if (dieDisplayed == 4) {
			
			
			dieLabel.setIcon(die4);
	
		}
		else if (dieDisplayed == 5) {
			
			
			dieLabel.setIcon(die5);
	
		}
		else {
			
			
			dieLabel.setIcon(die6);
	
		}
		
		dieLabel.setVisible(true);
		//return dielabel;
	}
    
    public runningMode() {
        getContentPane().setLayout(null);
        // Create the layered pane and add it to the frame
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 873, 565);
        getContentPane().add(layeredPane);
        getContentPane().setLayout(null);
        
      

        // Create the two panels to switch between
        startScreen = new JPanel();
        startScreen.setBounds(0, 54, 873, 451);
        startScreen.setBackground(Color.DARK_GRAY);
        startScreen.setVisible(true);
        //layeredPane.setLayout(null);
        startScreen.setLayout(null);
       
        
        helpScreen = new JPanel();
        helpScreen.setBackground(Color.DARK_GRAY);
        helpScreen.setBounds(0, 54, 873, 451);
        helpScreen.setVisible(false);
        //layeredPane.setLayout(null);
        helpScreen.setLayout(null);
        
        pauseScreen = new JPanel();
        pauseScreen.setBackground(Color.DARK_GRAY);
        pauseScreen.setBounds(0, 54, 873, 451);
        pauseScreen.setVisible(false);
        //layeredPane.setLayout(null);
        pauseScreen.setLayout(null);
        
        


        //buildingMode = new JPanel();
        buildingMode.setBounds(0, 54, 873, 451);
        buildingMode.setBackground(Color.DARK_GRAY);
        buildingMode.setVisible(false);
        buildingMode.setLayout(null);
        
       /* gridPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println("dd");
        	}
        });    */
        
     /*   gridPanel.setBounds(19, 69, 822, 263);
        gridPanel.setVisible(false);
        gridPanel.setLayout(null);*/
       // buildingMode.add(gridPanel.createPixels(layeredPane));
        //buildingMode.add(gridPanel.createP)
  //      buildingMode.add(btnBack);
       
       // gridPanel.add(gridLabel);
   
        initSharing = new JPanel();
        initSharing.setBackground(Color.DARK_GRAY);
        initSharing.setBounds(0, 54, 873, 451);
        initSharing.setVisible(false);
        //layeredPane.setLayout(null);
        initSharing.setLayout(null);

        
       playingMode = new JPanel();
        playingMode.setBackground(Color.DARK_GRAY);
        playingMode.setBounds(0, 54, 873, 451);
        playingMode.setVisible(false);
        //layeredPane.setLayout(null);
        playingMode.setLayout(null);

        
        
       
    
   

        
        layeredPane.add(startScreen, Integer.valueOf(0));
        layeredPane.add(helpScreen, Integer.valueOf(1));
        layeredPane.add(buildingMode, Integer.valueOf(2));
        layeredPane.add(initSharing, Integer.valueOf(3));
        layeredPane.add(playingMode, Integer.valueOf(4));
        layeredPane.add(pauseScreen, Integer.valueOf(5));
        
        txtrGamePaused = new JTextArea();
        txtrGamePaused.setText("Game Paused");
        txtrGamePaused.setForeground(Color.LIGHT_GRAY);
        txtrGamePaused.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 45));
        txtrGamePaused.setBackground(Color.DARK_GRAY);
        txtrGamePaused.setBounds(259, 94, 302, 104);
        pauseScreen.add(txtrGamePaused);
        
        JButton btnTer = new JButton("Territory Cards");
        btnTer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		territoryCardFrame territoryCard = new territoryCardFrame();
        		territoryCard.territoryCardF.setVisible(true);

        	}
        });
        btnTer.setBounds(27, 337, 118, 29);
        playingMode.add(btnTer);
        
        btnArmy = new JButton("Army Cards");
        btnArmy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArmyCardFrame armyCard = new ArmyCardFrame();
        		armyCard.ArmyCardF.setVisible(true);

        	}
        });
        btnArmy.setBounds(27, 367, 118, 29);
        playingMode.add(btnArmy);
        
        btnChance = new JButton("Chance Cards");
        btnChance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ChanceCardFrame armyCard = new ChanceCardFrame();
        		armyCard.chanceCardF.setVisible(true);
        	}
        });
        btnChance.setBounds(27, 397, 118, 29);
        playingMode.add(btnChance);

        
        txtrInitialSharingAnd = new JTextArea();
        txtrInitialSharingAnd.setForeground(Color.LIGHT_GRAY);
        txtrInitialSharingAnd.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtrInitialSharingAnd.setBackground(Color.DARK_GRAY);
        txtrInitialSharingAnd.setText("Initial Sharing and Army Placement");
        txtrInitialSharingAnd.setBounds(175, 6, 489, 56);
        initSharing.add(txtrInitialSharingAnd);
        
        dieLabel = new JLabel();
        dieLabel.setBounds(221, 359, 80, 80);
        
        btnRoll = new JButton("ROLL");
        btnRoll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int dieDisplayed = die.generateNum();
        		
        		displayDie();
        	
        		
        		
        	}
        });
        btnRoll.setBounds(48, 360, 117, 56);
        initSharing.add(btnRoll);
       
        initSharing.add(dieLabel);
       
       
     
        
        //layeredPane.add(gridPanel, Integer.valueOf(3));
        
        buildingMode.setLayout(null);
        
        txtrGameOptions = new JTextArea();
        txtrGameOptions.setBounds(212, 6, 453, 43);
        txtrGameOptions.setText("Game Options & Map Settings");
        txtrGameOptions.setForeground(Color.LIGHT_GRAY);
        txtrGameOptions.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 31));
        txtrGameOptions.setEditable(false);
        txtrGameOptions.setBackground(Color.DARK_GRAY);
        buildingMode.add(txtrGameOptions);
        //buildingMode.add(gridPanel);
        
       //Grid gridPanel_1 = new Grid();
        gridPanel_1.setBounds(19, 69 , 822, 263);
       // gridPanel.add(gridPanel_1);
        
        buildingMode.add(gridPanel_1);
        
        JTextArea txtrNumberOfPlay = new JTextArea();
        txtrNumberOfPlay.setBounds(220, 358, 217, 32);
        txtrNumberOfPlay.setText("Number of players (2-6):");
        txtrNumberOfPlay.setForeground(Color.LIGHT_GRAY);
        txtrNumberOfPlay.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtrNumberOfPlay.setEditable(false);
        txtrNumberOfPlay.setBackground(Color.DARK_GRAY);
        buildingMode.add(txtrNumberOfPlay);
        
        JTextArea txtrNumberOfComputer = new JTextArea();
        txtrNumberOfComputer.setBounds(143, 388, 294, 32);
        txtrNumberOfComputer.setText("Number of computer players (1-6):");
        txtrNumberOfComputer.setForeground(Color.LIGHT_GRAY);
        txtrNumberOfComputer.setFont(new Font("Kokonor", Font.PLAIN, 19));
        txtrNumberOfComputer.setEditable(false);
        txtrNumberOfComputer.setBackground(Color.DARK_GRAY);
        buildingMode.add(txtrNumberOfComputer);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(432, 361, 64, 27);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2", "3", "4", "5", "6"}));
        comboBox.setToolTipText("");
        comboBox.setMaximumRowCount(6);
        comboBox.setBackground(Color.LIGHT_GRAY);
        buildingMode.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(432, 391, 64, 27);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6"}));
        comboBox_1.setMaximumRowCount(6);
        comboBox_1.setBackground(Color.LIGHT_GRAY);
        buildingMode.add(comboBox_1);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String action=e.getActionCommand();
            	startScreen.setVisible(!startScreen.isVisible());
            	if ("Next".equals(action)) {
            		layeredPane.add(initSharing, Integer.valueOf(2));
            		initSharing.setVisible(true);
            		buildingMode.setVisible(false);
            		//startScreen.removeAll();
            		//btnStart.setVisible(false);
            		btnNext.setVisible(false);
            		building=true;
            		/*gridPanel.setVisible(true);
            		initSharing.add(gridPanel);*/
            		gridPanel_1.setVisible(true);
            		initSharing.add(gridPanel_1);
            		//btnPause.setVisible(true);
                   // dieLabel.setIcon(die1);
            		
            		
            	}
        	}
        });
        btnNext.setBounds(724, 404, 117, 29);
        buildingMode.add(btnNext);
        
        
        

   
        
     
       
        
        JTextArea txtrGameObject_1 = new JTextArea();
        txtrGameObject_1.setText("The game is played on a political map of the world, divided into territories, which are grouped into continents. Turns rotate among players who control armies of playing pieces with which they attempt to capture \n"
        		+ "territories from other players, with results determined by dice rolls. Players may form and dissolve alliances during the course of the game. On a player’s turn, he/she tries to capture territories by defeating his/her \n"
        		+ "opponents’ armies. The goal of the game is to occupy every territory on the board and, in doing so, eliminate the other players. \n"
        		+ "The game ends when one of the players conquers the whole world defeating all his/her enemies. \n"
        		+ "\n"
        		+ "Armies:\n"
        		+ "There are 6 complete sets of armies, each containing 3 denominations of army pieces: Infantry (worth l), Cavalry (worth 5 Infantry), and Artillery (worth 10 Infantry, or 2 Cavalry). Start the game by \n"
        		+ "placing Infantry pieces; later in the game, you may trade in 5 Infantry for 1 Cavalry, or 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.\n"
        		+ "✪ Cards: At the beginning of any turn, you will pick a chance card, and at the end of any turn in which you have captured at least one territory, you will earn one territory or army card chosen randomly. \n"
        		+ "Territory Cards: the aim of collecting territory cards is to conquer a continent without attacking. When the player collects all territory cards of a continent, the player conquers all territories of that continent \n"
        		+ "without a need to attack these territories. \n"
        		+ "✪ Army Cards: A player can trade army cards to gain an additional army if she/he has a set of 3 cards. He/she can place new armies in any territories she/he has. The rules of gaining armies is as follows:\n"
        		+ "\n"
        		+ "Trade: \n"
        		+ "3 Infantry cards => 1 Cavalry\n"
        		+ "2 Infantry cards + 1 Cavalry card => 2 Cavalry\n"
        		+ "2 Infantry cards + 1 Artillery card => 2 Artillery\n"
        		+ "1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery\n"
        		+ "1 Artillery + 2 Cavalry cards => 3 Artillery\n"
        		+ "\n"
        		+ "Steps of a Player’s Turn:\n"
        		+ "Picking a chance card and doing whatever the card says\n"
        		+ "Getting and placing new armies\n"
        		+ "Attacking, if the player chooses to, by rolling the dice\n"
        		+ "Fortifying the position");
        txtrGameObject_1.setForeground(Color.LIGHT_GRAY);
        txtrGameObject_1.setFont(new Font("Kokonor", Font.PLAIN, 9));
        txtrGameObject_1.setEditable(false);
        txtrGameObject_1.setBackground(Color.DARK_GRAY);
        txtrGameObject_1.setBounds(19, 9 , 822, 400);
        helpScreen.add(txtrGameObject_1);
        
       
                
        
        // Add the panels to the layered pane
        //layeredPane.add(startScreen);
       
        
        txtpnKjkjkjk = new JTextPane();
        txtpnKjkjkjk.setEditable(false);
        txtpnKjkjkjk.setBounds(320, 21, 271, 83);
        txtpnKjkjkjk.setForeground(Color.LIGHT_GRAY);
        txtpnKjkjkjk.setBackground(Color.DARK_GRAY);
        txtpnKjkjkjk.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 49));
        txtpnKjkjkjk.setText("ConKUeror  ");
        startScreen.add(txtpnKjkjkjk);
        
        txtrEnterUsername = new JTextArea();
        txtrEnterUsername.setBounds(374, 219, 103, 23);
        txtrEnterUsername.setText("Enter Username");
        txtrEnterUsername.setForeground(Color.LIGHT_GRAY);
        txtrEnterUsername.setEditable(false);
        txtrEnterUsername.setBackground(Color.DARK_GRAY);
        startScreen.add(txtrEnterUsername);
        
        textField_1 = new JTextField();
        textField_1.setBounds(341, 244, 171, 30);
        textField_1.setHorizontalAlignment(SwingConstants.LEFT);
        textField_1.setForeground(Color.BLACK);
        textField_1.setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 20));
        textField_1.setColumns(10);
        textField_1.setBackground(Color.WHITE);
        startScreen.add(textField_1);
        

        
        
        

        // Create the button to switch between the panels
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(373, 518, 100, 30);
        btnStart.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        layeredPane.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Toggle the visibility of the panels
            	String action=e.getActionCommand();
            	startScreen.setVisible(!startScreen.isVisible());
            	if ("Start".equals(action)) {
            		layeredPane.add(buildingMode, Integer.valueOf(1));
            		buildingMode.setVisible(true);
            		startScreen.setVisible(false);
            		//startScreen.removeAll();
            		//btnStart.setVisible(false);
            		btnBack.setVisible(false);
            		start=true;
            		btnStart.setVisible(false);
            		//gridPanel.setVisible(true);
            		gridPanel_1.setVisible(true);
         
            	
            	}
                
            
          

                
            }
        });
        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  // Toggle the visibility of the panels
            	String action=e.getActionCommand();
            	
            	if ("Start Game".equals(action)) {
            		layeredPane.add(playingMode, Integer.valueOf(4));
            		playingMode.setVisible(true);
            		//startScreen.removeAll();
            		btnPause.setVisible(true);
            		btnBack.setVisible(false);
            		init=true;
            		/*playingMode.add(gridPanel);
            		gridPanel.setVisible(true);*/
            		playingMode.add(gridPanel_1);
            		gridPanel_1.setVisible(true);
            		
         
            	
            	}
        	playingMode.setVisible(true);
        	initSharing.setVisible(false);
        	}
        });
        btnStartGame.setBackground(Color.WHITE);
        btnStartGame.setBounds(733, 395, 117, 29);
        initSharing.add(btnStartGame);

        btnBack = new JButton("Back to Game");
        btnBack.setBounds(729, 517, 128, 29);
        
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  	String action=e.getActionCommand();
            	
            	if ("Back to Game".equals(action)) {
            		
            		if (start==false) {
            			//layeredPane.add(startScreen);
            		    startScreen.setVisible(true);
            		    btnStart.setVisible(true);
            		    //btnResume.setVisible(false);
            		    btnBack.setVisible(false);
            		    
           
            		}
            		else  {
            			
            			//layeredPane.add(buildingMode);
            			startScreen.setVisible(false);
            		    buildingMode.setVisible(true);
            		    btnStart.setVisible(false);
            		    //btnResume.setVisible(false);
            		    btnBack.setVisible(false);
            		}
            	
            		
            		helpScreen.setVisible(false);
            		btnBack.setVisible(false);
            		btnHelp.setVisible(true);
            		btnResume.setVisible(true);
            		
            	
            		
            	}
        	}
        });
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        
        btnBack.setVisible(false);
        btnHelp = new JButton("Help");
        layeredPane.add(btnHelp);
        layeredPane.add(btnBack);
        btnHelp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 
        		String action=e.getActionCommand();
            	//startScreen.setVisible(false);
            	if ("Help".equals(action)) {
            		
            		//layeredPane.add(helpScreen);
            		helpScreen.setVisible(true);
            		btnHelp.setVisible(false);
            		btnStart.setVisible(false);
            		btnBack.setVisible(true);
            	
            	}
            	
        	}
        });
        btnHelp.setBounds(729, 13, 117, 29);
        btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        
  
        
        
        btnPause = new JButton("Pause");
        btnPause.setVisible(false);
        btnPause.setBounds(508, 506, 117, 56);
        layeredPane.add(btnPause);
        
        
        btnResume = new JButton("Resume");
        btnResume.setVisible(false);
        btnResume.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		playingMode.setVisible(true);
        		pauseScreen.setVisible(false);
        		btnPause.setVisible(true);
        		btnResume.setVisible(false);
        	}
        });
        btnResume.setBounds(207, 517, 117, 29);
        layeredPane.add(btnResume);
        btnPause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int dieDisplayed = die.generateNum();
        		
        		pauseScreen.setVisible(true);
        		btnResume.setVisible(true);
        		btnPause.setVisible(false);
        		playingMode.setVisible(false);
        		
        		
        	}
        });

   
        
        
    }
    

    public static void main(String[] args) {
    	Player player1 = new Player(); 
    	Player player2 = new Player(); 
    	Territory territory1 = new Territory();
    	Territory territory2 = new Territory();
    	territory1.getAdjacentTerritories().add(territory2);
    	territory2.getAdjacentTerritories().add(territory1);
    	territory1.setOwner(player1);
    	territory2.setOwner(player2);
    	ArrayList <Army> armyList1 = new ArrayList<Army>();
    	Infantry infantry1 = new Infantry();
    	armyList1.add(infantry1);
    	armyList1.add(infantry1);
    	armyList1.add(infantry1);
    	player1.getTerritoryList().add(territory1);
    	player2.getTerritoryList().add(territory2);
    	ArrayList <Player> playerList = new ArrayList<Player>();
    	playerList.add(player1);
    	playerList.add(player2);
    	Map map = new Map();
    	map.getTerritories().add(territory1);
    	map.getTerritories().add(territory2);
    	InfantryCard infantryCard = new InfantryCard();
    	player1.getDeck().getInfantryCardList().add(infantryCard);
    	player1.getDeck().getInfantryCardList().add(infantryCard);
    	player1.getDeck().getInfantryCardList().add(infantryCard);
    	player1.tradeArmyCards(0);
    	
    	Continent continent = new Continent();
    	Territory territory3 = new Territory();
    	Territory territory4 = new Territory();
    	TerritoryCard territoryCard1 = new TerritoryCard();
    	TerritoryCard territoryCard2 = new TerritoryCard();
    	player1.getTerritoryCardList().add(territoryCard1);
    	player1.getTerritoryCardList().add(territoryCard2);
    	continent.getTerritoryCardList().add(territoryCard1);
    	continent.getTerritoryCardList().add(territoryCard2);
    	continent.getTerritoryList().add(territory3);
    	continent.getTerritoryList().add(territory4);
    	player1.tradeTerritoryCards(continent);
    	for (int i = 0; i < player1.getTerritoryList().size(); i++) {
    		System.out.println("Player1 territoryList: ");
    		System.out.println(player1.getTerritoryList().get(i));
    	}
    	for (int i = 0; i < player1.getTerritoryCardList().size(); i++) {
    		System.out.println("Player1 territoryCardList: ");
    		System.out.println(player1.getTerritoryCardList().get(i));
    	}
    	
    	player1.placeArmy(territory4, infantry1);
    	System.out.println("Army that is placed on Territory4: ");
    	System.out.println(territory4.getArmyList().get(0));
    	
    	System.out.println("Player 1's cavalries of army: ");
    	System.out.println(player1.getCavalryList().get(0));    	
    	ArrayList <Army> armyList2 = new ArrayList<Army>();
    	armyList2.add(infantry1);
    	
    	Map map2 = new Map();
    	map2.getTerritories().add(territory3);
    	map2.getTerritories().add(territory4);
    	map2.getTerritories().add(territory1);
    	map2.getTerritories().add(territory2);
    	territory1.enable();
    	territory2.enable();
    	//territory3.enable();
    	//territory4.enable();
    	map2.checkReachability(territory1);
    	map2.checkReachability(territory2);
    	map2.checkReachability(territory3);
    	map2.checkReachability(territory4);
    	
    	territory1.setArmyList(armyList1);
    	territory2.setArmyList(armyList2);
    	ConKUeror conkueror = new ConKUeror();
    	Die die = new Die();
    	conkueror.attack(player1, territory1, territory2, die);
    	conkueror.initialSharingOfTerritory(playerList, map);
    	
    	runningMode frame = new runningMode();
        frame.setSize(873, 600);
       // frame.setTitle("Switch LayeredPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gridPanel_1.gameMap.setRowAndCol();
       // label.setVisible(true);
      //  frame.setSize(400, 400);
      //  frame.setVisible(true);

        //SAVE THE MAP
        String fileName = "output.dat";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map.getTerritories());
            oos.close();
            fos.close();
            System.out.println("Map has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the map to " + fileName);
            e.printStackTrace();
        }
        
        for(int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(map.getTerritories().get(i).getArmyList());
	            oos.close();
	            fos.close();
	            System.out.println("ArmyList of a territory has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the ArmyList of a territory to " + fileName);
	            e.printStackTrace();
	        }
       }
        
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerList);
            oos.close();
            fos.close();
            System.out.println("Players have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the players to " + fileName);
            e.printStackTrace();
        }
        
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(player1.getDeck().getInfantryCardList());
            oos.close();
            fos.close();
            System.out.println("Infantry cardList of" + player1 + "have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the infantry cardList of " + player1 + "to " + fileName);
            e.printStackTrace();
        }
        
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(player1.getDeck());
            oos.close();
            fos.close();
            System.out.println("Deck of cards of " + player1 + "have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the deck of " + player1 + "to " + fileName);
            e.printStackTrace();
        }
    }
    
}


