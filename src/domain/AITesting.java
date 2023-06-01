package domain;

public class AITesting {

	public static void main(String[] args) {
	AI AI1 = new AI();
	AI AI2 = new AI();
	Map map = new Map();
	

	Territory territory1 = new Territory();
	Territory territory2 = new Territory();
	Territory territory5 = new Territory();
	Territory territory6 = new Territory(); 
	territory1.getAdjacentTerritories().add(territory2);
	territory2.getAdjacentTerritories().add(territory1);
	territory5.getAdjacentTerritories().add(territory6);
	territory6.getAdjacentTerritories().add(territory5);
	map.getTerritories().add(territory1);
	map.getTerritories().add(territory2);
	map.getTerritories().add(territory5);
	map.getTerritories().add(territory6);
	
	AI1.map =  map;
	AI2.map = map;
	
	AI1.turn = true;
	AI1.initialShare = true;
	AI1.chooseTer();
	System.out.println("Should print 1: ");
	System.out.println(AI1.playerAI.getTerritoryList().size());
	System.out.println("One of them should be player and others null : ");
	System.out.println(territory1.owner);
	System.out.println(territory2.owner);
	System.out.println(territory5.owner);
	System.out.println(territory6.owner);
	
	AI1.chooseTer();
	System.out.println("Should print 2: ");
	System.out.println(AI1.playerAI.getTerritoryList().size());
	System.out.println("Two of them should be player and others null : ");
	System.out.println(territory1.owner);
	System.out.println(territory2.owner);
	System.out.println(territory5.owner);
	System.out.println(territory6.owner);
	
	Infantry infantry1 = new Infantry();
	Infantry infantry2 = new Infantry();
	
	territory1.getArmyList().add(infantry1);
	AI1.playerAI.getTerritoryList().add(territory1);
	territory1.setOwner(AI1.playerAI);
	AI1.playerAI.getTerritoryList().add(territory2);
	territory2.setOwner(AI1.playerAI);
	//System.out.println("\n" + territory1.owner + "\n");
	
	AI1.initialShare = false;
	//AI1.attackAI(); 
	
	AI1.fortifyAI();
	//System.out.println(territory2.getArmyList().size());
	
	
	
	
	
	}

}