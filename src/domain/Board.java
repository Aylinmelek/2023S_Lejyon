package domain;

import java.util.ArrayList;
import java.util.List;

import UI.LoginScreen;


public class Board {
	
	private List<BoardListener> listeners = new ArrayList<>();
	
	private Die die;
	int dieValue;
	public Deck deck = new Deck();
	public Continent continent1 = new Continent();
	public Continent continent2 = new Continent();
	public Continent continent3 = new Continent();
	public Continent continent4 = new Continent();
	public Continent continent5 = new Continent();
	public Continent continent6 = new Continent();
	public InfantryCreator infCreator = new InfantryCreator();
	public PlayerCreator playerCreator = new PlayerCreator();
	public MainDeckCreator mainDeckCreator = new MainDeckCreator();
	public GameActions gameActions = new GameActions();
	public Player player = new Player();
	public ArrayList<Player> playerList = new ArrayList<Player>();
	
	public Board() {
		die = new Die();

		infCreator = new InfantryCreator();//yeni
		System.out.println("geliyo mu board'a");
		
		System.out.println("-----------------");
	}
	
	public void rollDice() {
		die.roll();
		//publishBoardEvent();
		
	}
	

	
	public int getDiceValue() {
		return die.getDiceValue();
	}
	
	public void addBoardListener(BoardListener lis) {
		listeners.add(lis);
	}
	
	
	public String publishBoardEvent(int dieNum) {
		 System.out.println("(domain.Board)You rolled: " + dieNum);
		 String num = Integer.toString(dieNum);
		 return num;
		/*for(BoardListener l: listeners)
			l.onBoardEvent(String.format("You rolled %d: ",
					dieNum));//, (dieNum > 7)?"You Win":"I Win"));*/
		
	}
	public void createInfantry(int number, Player player) {
		infCreator.createInfantry(number,player);
	}

	public ArrayList<Player> createPlayer(int playerCount, int AICount) {
		return playerCreator.createPlayer(playerCount,AICount);
	}
	public ArrayList<String> createPlayerName(int playerCount) {
		return playerCreator.createPlayerName(playerCount);
	}
	public void createMainDeck(int count, int armyCard, Deck deck) {
		mainDeckCreator.createMainDeck(count, armyCard, deck);
	}
	public void createTerCard(Continent continent1, Continent continent2, Continent continent3, Continent continent4, Continent continent5, Continent continent6, Deck deck)
	{
		mainDeckCreator.MainDeckTerCardCreator(continent1, continent2, continent3, continent4, continent5, continent6, deck);
	}
	public void turnPass(int index) {
		gameActions.turnPass(index);
	}
	public void createTerritory(int terCount) {
		gameActions.createTerritory(terCount);
	}

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {

		gameActions.attack(player, territoryFrom, territoryTo, die);

	}

	public void giveArmyCard(Player player)
	{

		deck.giveArmyCard(player);
	}
	public void giveTerCard(Player player)
	{
		deck.giveTerritoryCard(player);
	}

	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		gameActions.fortify(player, territoryFrom, territoryTo, count);

	}
	
	public void setPlayerName(String name) {
		player.setPlayerName(name);
	}
	
	public int addToPlayerList(ArrayList<Player> playerList, int totalPlayerNum) {
		
		return player.addToPlayerList(playerList,totalPlayerNum);
	}	
		  /*for (int i=0; i<loginScreen.getPlayerNum(); i++) {
		   Player player = new Player();
		   playerList.add(player);
		   System.out.println(player);

		  }
		  return playerList.size();*/
		 //}
	

}
