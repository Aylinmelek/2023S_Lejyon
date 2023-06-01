package domain;

import java.util.ArrayList;
import java.util.Hashtable;

import UI.BuildingMode;
import UI.Grid;
import UI.LoginScreen;

public class ConKUeror {

	public ArrayList<Player> playerList = new ArrayList<Player>();
	public ArrayList<Territory> terList = new ArrayList<Territory>();
	public InfantryCreator infCreator = new InfantryCreator();
	public PlayerCreator playerCreator = new PlayerCreator();
	public MainDeckCreator mainDeckCreator = new MainDeckCreator();
	public GameActions gameActions = new GameActions();
	
	Grid grid = new Grid();
	public Die die = new Die();

	public Hashtable<Player, Boolean> player_turn = new Hashtable<Player, Boolean>();

	
	public void createInfantry(int number, Player player) {
		infCreator.createInfantry(number,Player);
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

	public void initialSharingOfTerritory(ArrayList<Player> playerList, Map map) {
		boolean workUntil = true;
		boolean allTrue = false;
		while (workUntil) {
			if (!allTrue) {
				// System.out.println(playerList.size());
				for (int i = 0; i < playerList.size(); i++) {
					// System.out.println(grid.getRow());
					// playerList.get(i).chooseATerritory();
					// UI da seçtiği territoryi buraya parametre olarak yolluyoruz/
					System.out.println(playerList.get(i) + " will choose a territory.");
					map.getTerritories().get(i).isTaken = true;
					allTrue = true;
					for (Territory territory : map.territories) {
						if (!territory.isTaken) {
							allTrue = false;
							break;
						}
					}
				}
			} else {
				workUntil = false;
			}
		}

	}

	public int addToPlayerTurnHash(LoginScreen loginScreen) {
		for (int i = 0; i < loginScreen.getPlayerNum(); i++) {
			Player player = new Player();
			playerList.add(player);
			System.out.println(player);
			// player.setNumOfInfantry();
			player_turn.put(player, player.turn);

		}
		return player_turn.size();
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