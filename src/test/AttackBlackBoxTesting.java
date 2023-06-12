package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class AttackBlackBoxTesting {
	//Specification:
	//@Requires: Attacker should owns territoryFrom and shouldn't owns territoryTo
	//territoryFrom and territoryTo should be linked, and the territoryFrom should be equal or more powerful than territoryTo
	//@Modifies: territoryFrom's armyList, territoryTo's armyList, and territoryTo's owner
	//@Effects: If player won the attack, territoryTo's armyList would be decreased by 1.
	//If player lose the attack, territoryFrom's armyList would be decreased by 2
	//If territoryTo's armyList is equal to 0 after the attack, player conquer the territoryTo
	Die die = new Die();
    GameActions conkueror = new GameActions();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();

    Territory territory1 = new Territory();
    Territory territory2 = new Territory();
    Territory territory5 = new Territory();
    Territory territory6 = new Territory();

    Infantry infantry = new Infantry();

    @Test
    void cannotAttack() {
    	//If player can not attack, then it shouldn't change armyCount of these territories
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player2, territory2, territory1, 3 , 2);

        int range2 = territory1.getArmyList().size() + territory2.getArmyList().size();
        assertEquals(5, range2);
    }

    @Test
    void ownerDoesntChange() {
    	//If player can not attack, then territoryTo's owner shouldn't be changed.
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player2, territory2, territory1, 3 , 2);

        int range2 = territory1.getArmyList().size() + territory2.getArmyList().size();

        assertEquals(player1, territory1.getOwner());
    }

    @Test
    void winOrLose() {
    	//If player won the attack then the territoryTo's owner would be changed, and if attacker couldn't win the attack then 
    	//territoryTo's owner wouldn't change. TerritoryTo's owner can not be both player. It checks it.
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        

        conkueror.attack(player1, territory1, territory2, 3 , 2);

        boolean and_output = territory2.getOwner().equals(player1) && territory2.getOwner().equals(player2);
        assertEquals(false, and_output);

    }

    @Test
    void changeOrNot() {
    	//territoryTo's owner can be owner before attack or attacker but not other players it checks it. 
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player2, territory2, territory1, 3 , 2);

        int range2 = territory1.getArmyList().size() + territory2.getArmyList().size();

        conkueror.attack(player1, territory1, territory2, 3 , 2);

        boolean and_output = territory2.getOwner().equals(player1) && territory2.getOwner().equals(player2);

        boolean or_output = territory2.getOwner().equals(player1) || territory2.getOwner().equals(player2);
        assertEquals(true, or_output);

    }

    @Test
    void deadInfantries() {
    	//If the player can attack, there should be dead in army, This test checks it
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player2, territory2, territory1, 3 , 2);

        int range2 = territory1.getArmyList().size() + territory2.getArmyList().size();

        conkueror.attack(player1, territory1, territory2,  3 , 2);

        boolean and_output = territory2.getOwner().equals(player1) && territory2.getOwner().equals(player2);

        boolean or_output = territory2.getOwner().equals(player1) || territory2.getOwner().equals(player2);

        boolean range = territory1.getArmyList().size() + territory2.getArmyList().size() >= 3
                && territory1.getArmyList().size() + territory2.getArmyList().size() <= 4;
        assertEquals(true, range);
    }
    @Test
    void doubleAttack() {
    	//In this test, attacker attacked 2 times
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory2,  3 , 2);
        conkueror.attack(player1, territory1, territory2,  3 , 2);

       
        
        boolean range = territory1.getArmyList().size() + territory2.getArmyList().size() >= 4
                && territory1.getArmyList().size() + territory2.getArmyList().size() <= 6;
        System.out.println(territory1.getArmyList().size() + territory2.getArmyList().size());
        System.out.println("range:" + range);
        assertEquals(true, range);
    }
    @Test
    void defaultAttack() {
    	//In this test, attacker attacked.
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory5.getAdjacentTerritories().add(territory6);
        territory6.getAdjacentTerritories().add(territory5);

        territory1.setOwner(player1);
        territory2.setOwner(player2);
        territory5.setOwner(player3);
        territory6.setOwner(player3);

        player1.getTerritoryList().add(territory1);
        player2.getTerritoryList().add(territory2);
        player3.getTerritoryList().add(territory5);
        player3.getTerritoryList().add(territory6);

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory2,  3 , 2);

       

        boolean range = territory1.getArmyList().size() + territory2.getArmyList().size() >= 6
                && territory1.getArmyList().size() + territory2.getArmyList().size() <= 7;
        assertEquals(true, range);
    }
    
    

}
