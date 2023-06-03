package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class FortifyingBlackBoxTesting {
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
		void defaultFortify() {
			
			
		       
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

		      
		        
		        int beforeFortifyTer1 = territory1.getArmyList().size();
		        
		        
		        conkueror.fortify(player1, territory1, territory2, 2);
		        assertEquals(2, territory2.getArmyList().size());
		   
		}
		
		@Test
		void isFortified() {
			
			
		       
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

		      
		        
		        int beforeFortifyTer1 = territory1.getArmyList().size();
		        
		        
		        conkueror.fortify(player1, territory1, territory2, 2);
		        
		        int afterFortifyTer1 = territory1.getArmyList().size();
		        boolean  isFortified = beforeFortifyTer1 > afterFortifyTer1;
		        assertEquals(true, isFortified);
		       
		}

		@Test
		void zeroFortify() {
			
			
		       
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

		      
		        
		        int beforeFortifyTer1 = territory1.getArmyList().size();
		        
		        
		        conkueror.fortify(player1, territory1, territory2, 2);
		        
		        int afterFortifyTer1 = territory1.getArmyList().size();
		        boolean  isFortified = beforeFortifyTer1 > afterFortifyTer1;
		        
		        conkueror.fortify(player1, territory2, territory3, 0);
		        assertEquals(0, territory3.getArmyList().size());
		}

		@Test
		void mixedFortify() {
			
			
		       
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

		      
		        
		        int beforeFortifyTer1 = territory1.getArmyList().size();
		        
		        
		        conkueror.fortify(player1, territory1, territory2, 2);
		      
		        int afterFortifyTer1 = territory1.getArmyList().size();
		        boolean  isFortified = beforeFortifyTer1 > afterFortifyTer1;
		        
		        conkueror.fortify(player1, territory2, territory3, 0);
		       
		        territory1.getArmyList().add(infantry1);
		        territory1.getArmyList().add(infantry2);
		        
		        territory3.getArmyList().add(infantry1);
		        territory3.getArmyList().add(infantry2);
		        
		        int ter1And3 = territory1.getArmyList().size() + territory3.getArmyList().size();
		        conkueror.fortify(player1, territory1, territory2, 2);
		        conkueror.fortify(player1, territory3, territory2, 2);
		        assertEquals(ter1And3, territory2.getArmyList().size());
		       
		}

		@Test
		void sameOwner() {
			
			
		       
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

		      
		        
		        int beforeFortifyTer1 = territory1.getArmyList().size();
		        
		        
		        conkueror.fortify(player1, territory1, territory2, 2);
		        
		        int afterFortifyTer1 = territory1.getArmyList().size();
		        boolean  isFortified = beforeFortifyTer1 > afterFortifyTer1;
		       
		        conkueror.fortify(player1, territory2, territory3, 0);
		       
		        territory1.getArmyList().add(infantry1);
		        territory1.getArmyList().add(infantry2);
		        
		        territory3.getArmyList().add(infantry1);
		        territory3.getArmyList().add(infantry2);
		        
		        int ter1And3 = territory1.getArmyList().size() + territory3.getArmyList().size();
		        conkueror.fortify(player1, territory1, territory2, 2);
		        conkueror.fortify(player1, territory3, territory2, 2);
		       
		        assertEquals(territory2.getOwner() , territory3.getOwner());
			
		}


}

