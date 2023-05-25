package domain;

import java.util.ArrayList;

public class AttackTest {

	public static void main(String[] args) {
		//Test1 if TerritoryTo is equal to TerritoryFrom.
		//Test2 if TerritoryFrom's owner is not player and TerritoryTo's owner is player.
		//Test3 if TerritoryTo and TerritoryFrom are not adjacents. 
		//Test4 if TerritoryFrom's power is not greater than TerritoryTo.
		//Test5 default.
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
		
		player1.getTerritoryList().add(territory1); // Should print "Player took a territory"
		player2.getTerritoryList().add(territory2); // Should print "Player took a territory"
		player3.getTerritoryList().add(territory5); // Should print "Player took a territory"
		player3.getTerritoryList().add(territory6); // Should print "Player took a territory"
		
		Infantry infantry = new Infantry();
		
		territory1.getArmyList().add(infantry);
		
		territory5.getArmyList().add(infantry); // Should print "Infantry is placed to territory"
		territory5.getArmyList().add(infantry); // Should print "Infantry is placed to territory"
		territory5.getArmyList().add(infantry); // Should print "Infantry is placed to territory"
		
		territory2.getArmyList().add(infantry); // Should print "Infantry is placed to territory"
		territory2.getArmyList().add(infantry); // Should print "Infantry is placed to territory"
		
		System.out.println("1:");
		conkueror.attack(player1, territory1, territory1, die); // Test1 if TerritoryTo is equal to TerritoryFrom.
		System.out.println("2:");
		conkueror.attack(player1, territory2, territory1, die); //Test2 if TerritoryFrom's owner is not player and TerritoryTo's owner is player.
		System.out.println("3:");
		conkueror.attack(player1, territory1, territory5, die); //Test3 if TerritoryTo and TerritoryFrom are not adjacents. 
		System.out.println("4:");
		conkueror.attack(player1, territory2, territory5, die); //Test4 if TerritoryFrom's power is not greater than TerritoryTo.
		System.out.println("5:");
		conkueror.attack(player2, territory2, territory1, die); //Test5 default.
	}

}
