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
	public Map map = new Map();
	
	public Board() {
		die = new Die();

		infCreator = new InfantryCreator();//yeni
		
	}
	
	public void rollDice() {
		die.roll();
		//publishBoardEvent();
		
	}
	public Die getDie()
	{
		return die;
	}
	
	public void addMap(Territory territory)
	{
		this.map.getTerritories().add(territory);
	}
	
	public int getDiceValue() {
		return die.getDiceValue();
	}
	
	public void addBoardListener(BoardListener lis) {
		listeners.add(lis);
	}
	
	
	public String publishBoardEvent(int dieNum) {
		 String num = Integer.toString(dieNum);
		 return num;
		/*for(BoardListener l: listeners)
			l.onBoardEvent(String.format("You rolled %d: ",
					dieNum));//, (dieNum > 7)?"You Win":"I Win"));*/
		
	}
	public void createInfantry(int number, Player player) {
		infCreator.createInfantry(number,player);
	}
	public void placeArmy(Player player, Territory territory, String type)
	{
		player.placeArmy(territory, type);
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

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, int roll1, int roll2) {

		gameActions.attack(player, territoryFrom, territoryTo, roll1, roll2);

	}
	public void giveChanceCard(Player player)
	{
		deck.giveChanceCard(player);
	}
	public void giveArmyCard(Player player)
	{

		deck.giveArmyCard(player);
	}
	public void giveTerCard(Player player)
	{
		deck.giveTerritoryCard(player);
	}
	public void reinforce(int face, Territory territory, Player player)
	{
		gameActions.reinforce(face, territory, player);
	}
	public void sabotage(int face, Territory territory, Player player)
	{
		gameActions.sabotage(face, territory, player);
	}
	public void spy(Territory territory, Player player)
	{
		gameActions.spy(territory, player);
	}
	public void worldEvent(int face,Territory territory, ArrayList<Player> playerList, Player player)
	{
		gameActions.worldEvent(face, territory, playerList, player);
	}
	public void disaster(Continent continent, Player player, int number)
	{
		gameActions.disaster(continent, player, number);
	}
	public void immunize(Territory territory)
    {
    	gameActions.immunize(territory);
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
		 

}
