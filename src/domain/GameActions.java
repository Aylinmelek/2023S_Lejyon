package domain;

import java.util.ArrayList;

public class GameActions {
    public ArrayList<Player> playerList = new ArrayList<Player>();
	public ArrayList<Territory> terList = new ArrayList<Territory>();

    public void turnPass(int index) {
		playerList.get(index).turn = false;
		playerList.get((index + 1) % playerList.size()).turn = true;
	}
    public void createTerritory(int terCount) {
		for (int i = 0; i < terCount; i++) {
			Territory terr = new Territory();
			terList.add(terr);
		}
	}
    public void attack(Player player, Territory territoryFrom, Territory territoryTo, Die die) {
    	//Specification:
    	//@Requires: Attacker should owns territoryFrom and shouldn't owns territoryTo
    	//territoryFrom and territoryTo should be linked, and the territoryFrom should be equal or more powerful than territoryTo
    	//@Modifies: territoryFrom's armyList, territoryTo's armyList, and territoryTo's owner
    	//@Effects: If player won the attack, territoryTo's armyList would be decreased by 1.
    	//If player lose the attack, territoryFrom's armyList would be decreased by 2
    	//If territoryTo's armyList is equal to 0 after the attack, player conquer the territoryTo
    	
		if (player.getTerritoryList().contains(territoryFrom) && !player.getTerritoryList().contains(territoryTo)) {
			if (player.canAttackTerritory(territoryFrom, territoryTo)
					&& territoryTo.adjacentTerritories.contains(territoryFrom)) {
				System.out.println(player + " is attacking now.");

				// if (die.generateNum() > die.generateNum()) {
				// observer için değiştirdim
				die.roll();
				int firstRoll = die.getDiceValue();
				die.roll();
				int secondRoll = die.getDiceValue();
				if (firstRoll > secondRoll) {
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
				System.out.println("There is a power imbalance between Territories or they are notLinked");
			}

		} else {
			System.out.println("Player doesn't own TerritoryFrom or owns TerritoryTo.");
	
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
}
