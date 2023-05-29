package domain;

import java.util.ArrayList;
import java.util.Hashtable;

import UI.BuildingMode;
import UI.Grid;
import UI.LoginScreen;

public class ConKUeror {


	public ArrayList<Player> playerList = new ArrayList<Player>(); 
	
	

	Grid grid = new Grid();
	public Die die = new Die();
	
	
	public Hashtable <Player, Boolean> player_turn = new Hashtable<Player, Boolean>();

	public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {

		if (player.getTerritoryList().contains(territoryFrom) && !player.getTerritoryList().contains(territoryTo)) {
			if (player.canAttackTerritory(territoryFrom, territoryTo)
					&& territoryTo.adjacentTerritories.contains(territoryFrom)) {
				System.out.println(player + " is attacking now.");

				//if (die.generateNum() > die.generateNum()) {
				//observer için değiştirdim
				die.roll();
				if (die.getDiceValue() > die.getDiceValue()) {
				/////////
				

					territoryTo.owner.loseTheDefend(territoryTo);
					System.out.println(player + " lose the defend.");
				} else {
					territoryFrom.owner.loseTheAttack(territoryFrom);
					System.out.println(player + " lose the attack.");
				}
				if (territoryTo.armyList.size() <= 0) {
					player.conquerTerritory(territoryTo);
					System.out.println(player + " conquer the territory.");
				}

			} else {
				System.out.println("Player doesn't own TerritoryFrom or it is not adjacent to TerritoryTo");
			}

		} else {
			System.out.println("There is a power imbalance between Territories");
		}

	}


	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {

		if (player.getTerritoryList().contains(territoryTo) && player.getTerritoryList().contains(territoryFrom)
				&& territoryFrom.getAdjacentTerritories().contains(territoryTo)) {
			if (territoryFrom.getArmyList().size() >= count) {
				for (int i = 0; i < count; i++) {
					int index = territoryFrom.getArmyList().size() - 1;
					System.out.println(territoryFrom.getArmyList().get(index) + "is fortified from " + territoryFrom
							+ "to" + territoryTo);
					player.fortifying(territoryFrom, territoryTo, territoryFrom.getArmyList().get(index));
				}
			} else {

				System.out.println(
						"Player doesn't own TerritoryTo or TerritoryFrom or it is not adjacent to TerritoryTo");
			}

		} else {
			System.out.println("The territory has not this much army");
		}

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
		for (int i=0; i<loginScreen.getPlayerNum(); i++) {
			Player player = new Player();
			playerList.add(player);
			System.out.println(player);
			//player.setNumOfInfantry();
			player_turn.put(player, player.turn);
				
		}
		return player_turn.size();
	}
	
	public void addToList(int num) {
		for (int j=0; j<playerList.size(); j++) {
			Infantry inf = new Infantry();
			for (int i=0; i<num; i++) {
				playerList.get(j).getInfantryList().add(inf);
			}
		}
		
	}
}