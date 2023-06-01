package domain;

import java.util.ArrayList;
import java.util.List;


public class Board {
	
	private List<BoardListener> listeners = new ArrayList<>();
	
	private Die die;
	int dieValue;
	public InfantryCreator infCreator = new InfantryCreator();
	public PlayerCreator playerCreator = new PlayerCreator();
	public MainDeckCreator mainDeckCreator = new MainDeckCreator();
	public GameActions gameActions = new GameActions();
	
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
	
	
	public void publishBoardEvent(int dieNum) {
		 System.out.println("(domain.Board)You rolled: " + dieNum);
		/*for(BoardListener l: listeners)
			l.onBoardEvent(String.format("You rolled %d: ",
					dieNum));//, (dieNum > 7)?"You Win":"I Win"));*/
		
	}
	public void createInfantry(int number, Player player) {
		infCreator.createInfantry(number,Player);
	}

	public void createPlayer(int playerCount, int AICount) {
		playerCreator.createPlayer(playerCount,AICount);
	}
	public void createMainDeck(int count, int armyCard, Deck deck) {
		mainDeckCreator.createMainDeck(count, armyCard, deck);
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

	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		gameActions.fortify(player, territoryFrom, territoryTo, count);

	}
	
	
    
}
