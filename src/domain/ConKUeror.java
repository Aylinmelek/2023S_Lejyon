package domain;

import java.util.ArrayList;

import UI.Grid;

public class ConKUeror {
	public ArrayList <Player> playerList = new ArrayList<Player>();
	Grid grid = new Grid();
	Die die = new Die();
	public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {
<<<<<<< Updated upstream
		if (player.canAttackTerritory(territoryFrom, territoryTo) && territoryTo.adjacentTerritories.contains(territoryFrom)) {
			System.out.println(player + " is attacking now.");
			if(die.generateNum() > die.generateNum()) {
				territoryTo.owner.loseTheDefend(territoryTo);
				System.out.println(player + " lose the defend.");
			}
			else {
				territoryFrom.owner.loseTheAttack(territoryFrom);
				System.out.println(player + " lose the attack.");
			}
			if(territoryTo.armyList.size() <= 0) {
				player.conquerTerritory(territoryTo);
				System.out.println(player + " conquer the territory.");
			}
			
=======

		if (player.getTerritoryList().contains(territoryFrom) && !player.getTerritoryList().contains(territoryTo)) {
			if (player.canAttackTerritory(territoryFrom, territoryTo)
					&& territoryTo.adjacentTerritories.contains(territoryFrom)) {
				System.out.println(player + " is attacking now.");
				if (die.generateNum() > die.generateNum()) {
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
				System.out.println("Can not attack");
			}

		} else {
			System.out.println("Can not attack");
>>>>>>> Stashed changes
		}
		
	}
	
	public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {
<<<<<<< Updated upstream
		
			if(territoryFrom.getArmyList().size() >= count) {
				for(int i = 0; i < count; i++) {
					int index = territoryFrom.getArmyList().size() - 1;
					System.out.println(territoryFrom.getArmyList().get(index) + "is fortified from" + territoryFrom + "to" + territoryTo);
=======

		if (player.getTerritoryList().contains(territoryTo) && player.getTerritoryList().contains(territoryFrom)
				&& territoryFrom.getAdjacentTerritories().contains(territoryTo)) {
			if (territoryFrom.getArmyList().size() >= count) {
				for (int i = 0; i < count; i++) {
					int index = territoryFrom.getArmyList().size() - 1;
					System.out.println(territoryFrom.getArmyList().get(index) + "is fortified from " + territoryFrom
							+ "to" + territoryTo);
>>>>>>> Stashed changes
					player.fortifying(territoryFrom, territoryTo, territoryFrom.getArmyList().get(index));
				}
			} else {
				System.out.println("Can not fortify");
			}
<<<<<<< Updated upstream
			
		}
	
=======

		} else {
			System.out.println("Can not fortify");
		}

	}

>>>>>>> Stashed changes
	public void initialSharingOfTerritory(ArrayList<Player> playerList, Map map) {
		boolean workUntil = true;
		boolean allTrue = false;
		while(workUntil) {
			if(!allTrue) {
				//System.out.println(playerList.size());
				for(int i = 0; i < playerList.size(); i++) {
				//	System.out.println(grid.getRow());
					//playerList.get(i).chooseATerritory();
<<<<<<< Updated upstream
							/*UI da seçtiği territoryi buraya parametre olarak yolluyoruz*/ 
=======
							/UI da seçtiği territoryi buraya parametre olarak yolluyoruz/ 
>>>>>>> Stashed changes
					System.out.println(playerList.get(i) + " will choose a territory.");
					map.getTerritories().get(i).isTaken = true;
					allTrue = true;
					for (Territory territory: map.territories) {
					    if (!territory.isTaken) {
					        allTrue = false;
					        break;
					    }
					}
				}
			}
			else {
				workUntil = false;
			}
		}
		
	}
}