package domain.controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.LoginScreen;
import domain.Board;
import domain.Continent;
import domain.Deck;
import domain.Die;
import domain.GameActions;
import domain.Infantry;
import domain.InfantryCreator;
import domain.MainDeckCreator;
import domain.Player;
import domain.PlayerCreator;
import domain.Territory;

public class ConKUerorHandler {

	

//private Board board;
private static ConKUerorHandler instance;

public static Board board;// = new Board(); //not initialize in here if it is null
private static Board mainBoard;
//public static Board board = new Board();
public ConKUerorHandler() {
	if (board == null) {
		this.board=new Board();
	}
	
	this.mainBoard=board;
}
	
	
	
	public void rollDice() {
	
		board.rollDice();
		
	}
	
	public Board getBoard() {
		return board;
	}
	
	public String getWinner() {
		return String.format("You rolled %d:  %s",
				             board.getDiceValue());//, (board.getDiceValue() > 7)?"You Win":"I Win");
	}
	
	public int getDieValue() {
		return board.getDiceValue();
	}

	//New Part
	
	public PlayerCreator playerCreator = new PlayerCreator();
	public MainDeckCreator mainDeckCreator = new MainDeckCreator();
	public GameActions gameActions = new GameActions();
	
	public void createInfantry(int number, Player player) {
		board.createInfantry(number,player);
	}
	
	public ArrayList<Player> createPlayer(int playerCount, int AICount) {
		return board.createPlayer(playerCount,AICount);
	}
	public ArrayList<String> createPlayerName(int playerCount) {
		return board.createPlayerName(playerCount);
	}
	
	public void createMainDeck(int count, int armyCard, Deck deck) {
		board.createMainDeck(count, armyCard, deck);
	}
	public void createTerCard(Continent continent1, Continent continent2, Continent continent3, Continent continent4, Continent continent5, Continent continent6, Deck deck)
	{
		board.createTerCard(continent1, continent2, continent3, continent4, continent5, continent6, deck);
	}

	public void giveArmyCard(Player player)
	{
		board.giveArmyCard(player);
	}
	public void giveTerCard(Player player)
	{
		board.giveTerCard(player);
	}
	public void giveChanceCard(Player player)
	{
		board.giveChanceCard(player);
	}
	public void placeArmy(Player player, Territory territory, String type)
	{
		board.placeArmy(player,territory,type);
	}
	public void reinforce(int face, Territory territory, Player player) 
	{
		board.reinforce(face, territory, player);
	}
	public void sabotage(int face, Territory territory, Player player) 
	{
		board.sabotage(face, territory, player);
	}
	public void spy(Territory territory, Player player)
	{
		board.spy(territory, player);
	}
	public void worldEvent(int face, Territory territorySource, ArrayList<Player> playerArray, Player player)
	{
		board.worldEvent(face, territorySource, playerArray, player);
	}
	public void disaster(Continent continent, Player player, int number)
	{
		board.disaster(continent, player, number);
	}
	public void immunize(Territory territory)
	{
		board.immunize(territory);
	}

	
	public void setPlayerName(String name) {
		board.setPlayerName(name);
	}

	/*public void setAdjacent(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
			for (int j = 0; j < map.getTerritories().size(); j++) {
				map.getTerritories().get(i).getAdjacentTerritories().add(map.getTerritories().get(j));
				
			}
		}
	}*/
	
	public void turnPass(int index) {
		board.turnPass(index);
	}

	public void createTerritory(int terCount) {
		board.createTerritory(terCount);
	}

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, int roll1, int roll2) {

		board.attack(player, territoryFrom, territoryTo, roll1, roll2);

	}

	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		board.fortify(player, territoryFrom, territoryTo, count);

	}
	public int addToPlayerList(ArrayList<Player> playerList, int totalPlayerNum) {
		return board.addToPlayerList(playerList,totalPlayerNum);
		  /*for (int i=0; i<loginScreen.getPlayerNum(); i++) {
		   Player player = new Player();
		   playerList.add(player);
		   System.out.println(player);

		  }
		  return playerList.size();*/
	}

	
	/*public void addToList(int num) {
		for (int j = 0; j < playerList.size(); j++) {
			Infantry inf = new Infantry();
		    for (int i = 0; i < num; i++) {
		    	playerList.get(j).getInfantryList().add(inf);
		   }
		}

	}*/
		
	



	
	public static ConKUerorHandler getInstance() {
		if (instance == null)
			instance = new ConKUerorHandler();
		return instance;
	}



	
	



}