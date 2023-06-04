package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class FortifyingGlassBoxTesting {
	//Specification:
	//@Requires: The territories' owners should be the same and territories should be adjacent or linked. The territoryFrom should have the army count as much as the parameter. 
	//@Modifies: territoryFrom's armyList, territoryTo's armyList
	//@Effects: If player choose to fortify, territoryFrom's armyList would decrease by the parameter and territoryTo's armyList would increase by the parameter.
	
	Player player1 = new Player();
    Player player2 = new Player();

    Territory territory1 = new Territory();
    Territory territory2 = new Territory();
    Territory territory3 = new Territory();
    Territory territory4 = new Territory();
    

    Infantry infantry1 = new Infantry();
    Infantry infantry2 = new Infantry();
    
    GameActions conkueror = new GameActions();
    
    @Test
	void armyCountZero() {
    	
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);


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


    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); // If army count of a territory is = 0, the code will not work.
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();
    	 assertEquals(2,output);
	}

    @Test
	void territoriesNotAdjacent() {
    	
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);


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


    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); 
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();
    	 
    	 conkueror.fortify(player1, territory1, territory3, 2); // If territoryTo is not adjacent of TerritoryFrom, the code will not work.
    	 int output2 = territory3.getArmyList().size();
    	 assertEquals(0,output2);
    	 
	}

    @Test
	void playerDoesntOwnTerTo() {
    	
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);


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


    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); 
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();
    	 
    	 conkueror.fortify(player1, territory1, territory3, 2); 
    	 int output2 = territory3.getArmyList().size();
    	 
    	 conkueror.fortify(player1, territory1, territory4, 2); // If Player doesn't own territoryTo, the code will not work.
    	 int output3 = territory4.getArmyList().size();
    	 assertEquals(0,output3);
	}

    @Test
	void playerDoesntOwnTerFrom() {
    	
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);


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


    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); 
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();
    	 
    	 conkueror.fortify(player1, territory1, territory3, 2); 
    	 int output2 = territory3.getArmyList().size();
    	 
    	 conkueror.fortify(player1, territory1, territory4, 2); 
    	 int output3 = territory4.getArmyList().size();
    	 
    	 conkueror.fortify(player2, territory1, territory4, 2); // If Player doesn't own territoryFrom, the code will not work.
    	 int output4 = territory4.getArmyList().size();
    	 assertEquals(0,output4);
    	 
	}

    @Test
	void workingCase() {
    	
        territory1.getAdjacentTerritories().add(territory2);
        territory2.getAdjacentTerritories().add(territory1);
        territory1.getAdjacentTerritories().add(territory4);
        territory3.getAdjacentTerritories().add(territory4);
        territory4.getAdjacentTerritories().add(territory3);


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


    	 
    	 conkueror.fortify(player1, territory2, territory1, 2); 
    	 System.out.println(territory1.getArmyList().size());
    	 int output = territory1.getArmyList().size();

    	 
    	 conkueror.fortify(player1, territory1, territory3, 2); 
    	 int output2 = territory3.getArmyList().size();

    	 
    	 conkueror.fortify(player1, territory1, territory4, 2); 
    	 int output3 = territory4.getArmyList().size();

    	 
    	 conkueror.fortify(player2, territory1, territory4, 2); 
    	 int output4 = territory4.getArmyList().size();

    	 
    	 conkueror.fortify(player1, territory1, territory2, 2); 
    	 int output5 = territory2.getArmyList().size();
    	 assertEquals(2,output5);
	}

}
