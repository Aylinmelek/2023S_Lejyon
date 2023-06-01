package domain.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.LoginScreen;
import domain.Board;
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
		board.createInfantry(number,player);
	}
	
	public void createPlayer(int playerCount, int AICount) {
		board.createPlayer(playerCount,AICount);
	}
	
	public void createMainDeck(int count, int armyCard, Deck deck) {
		board.createMainDeck(count, armyCard, deck);
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

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {

		board.attack(player, territoryFrom, territoryTo, die);

	}

	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		board.fortify(player, territoryFrom, territoryTo, count);

	}
	public int addToPlayerList(LoginScreen loginScreen) {
		board.addToPlayerList(loginScreen);
		  /*for (int i=0; i<loginScreen.getPlayerNum(); i++) {
		   Player player = new Player();
		   playerList.add(player);
		   System.out.println(player);

		  }
		  return playerList.size();*/
		 }

		 public void addToList(int num) {
		  for (int j = 0; j < playerList.size(); j++) {
		   Infantry inf = new Infantry();
		   for (int i = 0; i < num; i++) {
		    playerList.get(j).getInfantryList().add(inf);
		   }
		  }

		 }
		}
	



	



}
