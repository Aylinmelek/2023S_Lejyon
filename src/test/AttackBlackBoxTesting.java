package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.ConKUeror;
import domain.Die;
import domain.Infantry;
import domain.Player;
import domain.Territory;

class AttackBlackBoxTesting {

    @Test
    void test() {

        Die die = new Die();
        ConKUeror conkueror = new ConKUeror();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        Territory territory1 = new Territory();
        Territory territory2 = new Territory();
        Territory territory5 = new Territory();
        Territory territory6 = new Territory();

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

        Infantry infantry = new Infantry();

        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);
        territory1.getArmyList().add(infantry);

        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);
        territory5.getArmyList().add(infantry);

        territory2.getArmyList().add(infantry);
        territory2.getArmyList().add(infantry);

        conkueror.attack(player2, territory2, territory1, die);

        int range2 = territory1.getArmyList().size() + territory2.getArmyList().size();
        assertEquals(5, range2);

        assertEquals(player1, territory1.getOwner());

        conkueror.attack(player1, territory1, territory2, die);

        boolean and_output = territory2.getOwner().equals(player1) && territory2.getOwner().equals(player2);
        assertEquals(false, and_output);

        boolean or_output = territory2.getOwner().equals(player1) || territory2.getOwner().equals(player2);
        assertEquals(true, or_output);

        boolean range = territory1.getArmyList().size() + territory2.getArmyList().size() >= 3
                && territory1.getArmyList().size() + territory2.getArmyList().size() <= 4;
        assertEquals(true, range);

    }
}