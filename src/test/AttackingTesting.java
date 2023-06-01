package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class AttackTesting {

    Die die = new Die();
    ConKUeror conkueror = new ConKUeror();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();

    Territory territory1 = new Territory();
    Territory territory2 = new Territory();
    Territory territory5 = new Territory();
    Territory territory6 = new Territory();

    Infantry infantry = new Infantry();

    @Test
    void sameTerritories() {
        // Test1 if TerritoryTo is equal to TerritoryFrom.

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

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory1, die);
        int output = territory1.getArmyList().size();
        // System.out.println(output);
        assertEquals(1, output);

    }

    @Test
    void attackThemselves() {
        // Test2 if TerritoryFrom's owner is not player and TerritoryTo's owner is
        // player.

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

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory1, die);
        int output = territory1.getArmyList().size();
        // System.out.println(output);

        conkueror.attack(player1, territory2, territory1, die);
        int output2 = territory2.getArmyList().size();
        // System.out.println(output2);
        assertEquals(2, output2);
    }

    @Test
    void notAdjacent() {
        // Test3 if TerritoryTo and TerritoryFrom are not adjacents.

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

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory1, die);
        int output = territory1.getArmyList().size();
        // System.out.println(output);

        conkueror.attack(player1, territory2, territory1, die);
        int output2 = territory2.getArmyList().size();
        // System.out.println(output2);

        conkueror.attack(player1, territory1, territory5, die);
        int output3 = territory5.getArmyList().size();
        // System.out.println(output3);
        assertEquals(3, output3);
    }

    @Test
    void insufficientPower() {
        // Test4 if TerritoryFrom's power is not greater than TerritoryTo.

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

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory1, die);
        int output = territory1.getArmyList().size();
        // System.out.println(output);

        conkueror.attack(player1, territory2, territory1, die);
        int output2 = territory2.getArmyList().size();
        // System.out.println(output2);

        conkueror.attack(player1, territory1, territory5, die);
        int output3 = territory5.getArmyList().size();
        // System.out.println(output3);

        conkueror.attack(player1, territory2, territory5, die);
        int output4 = territory2.getArmyList().size();
        // System.out.println(output4);
        assertEquals(2, output4);

    }

    @Test
    void workingTestCase() {
        // Test5 default.

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

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player1, territory1, territory1, die);
        int output = territory1.getArmyList().size();
        // System.out.println(output);

        conkueror.attack(player1, territory2, territory1, die);
        int output2 = territory2.getArmyList().size();
        // System.out.println(output2);

        conkueror.attack(player1, territory1, territory5, die);
        int output3 = territory5.getArmyList().size();
        // System.out.println(output3);

        conkueror.attack(player1, territory2, territory5, die);
        int output4 = territory2.getArmyList().size();
        // System.out.println(output4);

        conkueror.attack(player2, territory2, territory1, die);
        int output5 = territory1.getArmyList().size();
        System.out.println(output5);
        if (territory1.getOwner().equals(player2)) {
            assertNotEquals(1, output5);
        } else {
            assertEquals(1, output5);
        }

    }

}