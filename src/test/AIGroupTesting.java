package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;


import org.junit.jupiter.api.Test;

class AIGroupTesting {

	AI playerAI = new AI();
	Map map = new Map();
	boolean turn = true;
	Board board = new Board();
	Die die = new Die();
	
	Territory territory = new Territory();
	Territory territory2 = new Territory();
	Infantry inf = new Infantry();
	Player player = new Player();

	// OVERVIEW: AI is an plus player. The player of AI also plays the game like
	// other users' players.

	// test cases
	
	public boolean repOK() {
		return playerAI != null && map != null && board != null && die != null && turn == true;
	}
	public boolean repnotOK() {
		return playerAI != null && map == null && board != null && die != null && turn == true;
	}
	@Test
	public void repNotOKTest() {
		assertEquals(false, repnotOK());
	}
	
	@Test
	public void repOKTest() {
		assertEquals(true, repOK());
	}

	@Test
	public void initSharingTest() {
		map.getTerritories().add(territory);
		playerAI.setMap(map);
		playerAI.setInitialShare(true);
		playerAI.setTurn(true);
		playerAI.chooseTer();
		assertEquals(1, playerAI.getPlayerAI().getTerritoryList().size());
	}

	@Test
	public void notInitSharingTest() {
		map.getTerritories().add(territory);
		playerAI.setMap(map);
		playerAI.setInitialShare(false);
		playerAI.setTurn(true);
		playerAI.chooseTer();
		assertEquals(0, playerAI.getPlayerAI().getTerritoryList().size());
	}

	@Test
	public void attackTest() {
		playerAI.setInitialShare(false);
		map.getTerritories().add(territory);
		map.getTerritories().add(territory2);
		playerAI.setMap(map);
		playerAI.setTurn(true);

		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		player.getInfantryList().add(inf);
		player.getInfantryList().add(inf);

		playerAI.getPlayerAI().chooseATerritory(territory);
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		player.chooseATerritory(territory2);
		player.placeArmy(territory2, "Infantry");
		System.out.println(territory2.getOwner());
		System.out.println(player);
		player.placeArmy(territory2, "Infantry");
		// territory2.getArmyList().add(inf);
		territory.setLink(territory2);
		territory2.setLink(territory);
		playerAI.attackAI();
		boolean armyRange = (territory.getArmyList().size() + territory2.getArmyList().size() < 5);
		assertEquals(true, armyRange);
	}

	@Test
	public void fortifyTest() {
		playerAI.setInitialShare(false);
		map.getTerritories().add(territory);
		map.getTerritories().add(territory2);
		playerAI.setMap(map);
		playerAI.setTurn(true);

		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		playerAI.getPlayerAI().getInfantryList().add(inf);
		player.getInfantryList().add(inf);
		player.getInfantryList().add(inf);

		playerAI.getPlayerAI().chooseATerritory(territory);
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		playerAI.getPlayerAI().placeArmy(territory, "Infantry");
		playerAI.getPlayerAI().chooseATerritory(territory2);
		playerAI.getPlayerAI().placeArmy(territory2, "Infantry");

		territory.setLink(territory2);
		territory2.setLink(territory);

		playerAI.fortifyAI(true, 1);
		boolean isFortified = (territory2.getArmyList().size() != 1);
		assertEquals(true, isFortified);
	}

	@Test
	public void turnTest() {
		map.getTerritories().add(territory);
		playerAI.setMap(map);
		playerAI.setInitialShare(true);
		playerAI.setTurn(false);
		playerAI.chooseTer();
		assertEquals(0, playerAI.getPlayerAI().getTerritoryList().size());
	}

	// abstraction for chooseTer()
	// if (gameMode == initialSharing) || AIturn == true;
	// then
	// find territory==notTaken
	// placeInfantry(territory)

	// abstraction for attackAI()
	// if (gameMode != initialSharing) || AIturn == true;
	// then
	// find territoryFrom==random
	// find territoryTo==attackable
	// then attack(territoryFrom,territoryTo)

	// abstraction for fortifyAI()
	// if ((gameMode != initialSharing) || AIturn == true) && possibility==1/2;
	// then
	// find territory==(territory.adjacent().owner==this.playerAI)
	// find territory.adjacent()
	// fortifyAI(territoryFrom,territoryTo,range[territoryFrom,armyList.size()])

	// Representation invariants:
	// The playerAI owns territories.
	// The playerAI owns armies.
	// The playerAI != null.
	// The map object != null.
	// The conkueror object != null.
	// The die object != null.

	// repOK method

}
