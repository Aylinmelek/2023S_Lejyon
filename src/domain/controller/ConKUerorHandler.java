package domain.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Board;
import domain.Deck;
import domain.Die;
import domain.GameActions;
import domain.InfantryCreator;
import domain.MainDeckCreator;
import domain.Player;
import domain.PlayerCreator;
import domain.Territory;

public class ConKUerorHandler {

	
	
private Board board;
	
	public ConKUerorHandler(Board board) {
		this.board = board;
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
		//infCreator.createInfantry(number,player);
		board.infCreator(number, player);//yeni
	}
	
	public void createPlayer(int playerCount, int AICount) {
		playerCreator.createPlayer(playerCount,AICount);
	}
	
	public void createMainDeck(int count, int armyCard, Deck deck) {
		mainDeckCreator.createMainDeck(count, armyCard, deck);
	}

	/*public void setAdjacent(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
			for (int j = 0; j < map.getTerritories().size(); j++) {
				map.getTerritories().get(i).getAdjacentTerritories().add(map.getTerritories().get(j));
				
			}
		}
	}*/
	
	public void turnPass(int index) {
		gameActions.turnPass(index);
	}

	public void createTerritory(int terCount) {
		gameActions.createTerritory(terCount);
	}

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {

		gameActions.attack(player, territoryFrom, territoryTo, die);

	}

	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		gameActions.fortify(player, territoryFrom, territoryTo, count);

	}
	



}
