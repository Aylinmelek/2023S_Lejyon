package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.ConKUeror;
import domain.Infantry;
import domain.Player;
import domain.Territory;

class FortifyBlackBoxTesting {

	
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
	        
	        int beforeFortifyTer1 = territory1.getArmyList().size();
	        
	        
	        conkueror.fortify(player1, territory1, territory2, 2);
	        assertEquals(2, territory2.getArmyList().size());
	        
	        int afterFortifyTer1 = territory1.getArmyList().size();
	        boolean  isFortified = beforeFortifyTer1 > afterFortifyTer1;
	        assertEquals(true, isFortified);
	        
	        conkueror.fortify(player1, territory2, territory3, 0);
	        assertEquals(0, territory3.getArmyList().size());
	        
	        territory1.getArmyList().add(infantry1);
	        territory1.getArmyList().add(infantry2);
	        
	        territory3.getArmyList().add(infantry1);
	        territory3.getArmyList().add(infantry2);
	        
	        int ter1And3 = territory1.getArmyList().size() + territory3.getArmyList().size();
	        conkueror.fortify(player1, territory1, territory2, 2);
	        conkueror.fortify(player1, territory3, territory2, 2);
	        assertEquals(ter1And3, territory2.getArmyList().size());
	        
	        assertEquals(territory2.getOwner() , territory3.getOwner());
	        
	        
	        
	        
		
	}

}
