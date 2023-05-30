package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import domain.*;

class FortifyTest {
	
    @Test
	void test() {
    	Player player1 = new Player();
        Player player2 = new Player();

        Territory territory1 = new Territory();
        Territory territory2 = new Territory();
        Territory territory3 = new Territory();
        Territory territory4 = new Territory();
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);

        Infantry infantry1 = new Infantry();
        Infantry infantry2 = new Infantry();

        territory1.setOwner(player1);
        territory2.setOwner(player1);
        territory3.setOwner(player1);
        territory4.setOwner(player2);

        player1.getTerritoryList().add(territory1);
        player1.getTerritoryList().add(territory2);
        player1.getTerritoryList().add(territory3);
        player2.getTerritoryList().add(territory4);
        territory1.getArmyList().add(infantry1);
        territory1.getArmyList().add(infantry2);

        ConKUeror conkueror = new ConKUeror();

    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); // If army count of a territory is = 0, the code will not work.
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();
    	 assertEquals(2,output);
    	 
    	 conkueror.fortify(player1, territory1, territory3, 2); // If territoryTo is not adjacent of TerritoryFrom, the code will not work.
    	 int output2 = territory3.getArmyList().size();
    	 assertEquals(0,output2);
    	 
    	 conkueror.fortify(player1, territory1, territory4, 2); // If Player doesn't own territoryTo, the code will not work.
    	 int output3 = territory4.getArmyList().size();
    	 assertEquals(0,output3);
    	 
    	 conkueror.fortify(player2, territory1, territory4, 2); // If Player doesn't own territoryFrom, the code will not work.
    	 int output4 = territory4.getArmyList().size();
    	 assertEquals(0,output4);
    	 
    	 conkueror.fortify(player1, territory1, territory2, 2); // Working Test Case
    	 int output5 = territory2.getArmyList().size();
    	 assertEquals(2,output5);
    	 //fail("Not yet implemented");
	}

}