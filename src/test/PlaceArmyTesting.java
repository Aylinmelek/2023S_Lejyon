package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Infantry;
import domain.Player;
import domain.Territory;

public class PlaceArmyTesting {
	// Specification:
	// @Requires: Player should be in the initial sharing and army placement part of the game.
	// @Modifies: territoryList, InfantryList, ArmyList
	// @Effects: If a player has a territory the player can add infantries to that territory 
	//in the initial sharing and army placing part of the game
	

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
	public void armyNotPlaced() {
		player.getTerritoryList().add(territory); // territory added to player's territory list
		player.placeArmy(territory, "Infantry"); // player placed army to that territory
		assertTrue(territory.getArmyList().isEmpty()); // Check if the territory in the army list is empty
	}

	@Test
	public void territoryNotInTerList() {
		// territory is not in the players territory list
		player.placeArmy(territory, "Infantry"); // player placed infantry to that territory

		// Check if the territory is empty
		assertTrue(territory.getArmyList().isEmpty()); // if the territory is empty, it returns true
	}

	@Test
	public void invalidArmyType() {
		player.getTerritoryList().add(territory); // territory added to players territorylist
		player.placeArmy(territory, "Cavalry"); // player places army in that territory

		assertTrue(territory.getArmyList().isEmpty()); // returns true if the territory's army list is empty
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

}
