package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Infantry;
import domain.Player;
import domain.Territory;

public class PlaceArmyTesting {

	Player player = new Player();
	Player player2 = new Player();
	Territory territory = new Territory();
	Infantry infantry = new Infantry();

	@Test
	public void invalidTerritory() {
		player.placeArmy(territory, "Infantry"); // player places army in that territory
		assertTrue(territory.getArmyList().isEmpty()); // returns true if the territory's army list is empty
	}

	@Test
	public void invalidArmyType() {
		player.getTerritoryList().add(territory); // territory added to players territorylist
		player.placeArmy(territory, "Cavalry"); // player places army in that territory

		assertTrue(territory.getArmyList().isEmpty()); // returns true if the territory's army list is empty
	}

	@Test
	public void armyNotPlaced() {
		player.getTerritoryList().add(territory); // territory added to player's territory list
		player.placeArmy(territory, "Infantry"); // player placed army to that territory
		assertTrue(territory.getArmyList().isEmpty()); // Check if the territory in the army list is empty
	}

	@Test
	public void armyPlacing_multipleAvailableArmies() {
		player.getTerritoryList().add(territory); // territory added to player's territory list

		// adds multiple infantry armies to the player's infantryList
		player.getInfantryList().add(new Infantry());
		player.getInfantryList().add(new Infantry());
		player.getInfantryList().add(new Infantry());

		player.placeArmy(territory, "Infantry"); // player placed infantry to that territory

		assertEquals(2, player.getInfantryList().size()); // returns true if the players army list is equal to 2
	}

	@Test
	public void territoryNotInTerList() {
		// territory is not in the players territory list
		player.placeArmy(territory, "Infantry"); // player placed infantry to that territory

		// Check if the territory is empty
		assertTrue(territory.getArmyList().isEmpty()); // if the territory is empty, it returns true
	}

}
