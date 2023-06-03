package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class TradeTerCardListGlassBoxTesting {
	
	Player player1 = new Player(); 
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();

    Territory territory1 = new Territory();
    Territory territory2 = new Territory(); 
    Territory territory3 = new Territory();
    Territory territory4 = new Territory();
    
    Infantry infantry1 = new Infantry();
    Infantry infantry2 = new Infantry();
    
    TerritoryCard trc1 = new TerritoryCard(); 
    TerritoryCard trc2 = new TerritoryCard(); 
    TerritoryCard trc3 = new TerritoryCard(); 
    
    Continent continent = new Continent();

	@Test
	void unSufficientterritoryCardList() {
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
			    player2.getTerritoryList().add(territory4);
			
			    
			    territory1.getArmyList().add(infantry1);  
			    territory1.getArmyList().add(infantry2);  
			    
			    
			    
			    
			    continent.getTerritoryCardList().add(trc1);
			    continent.getTerritoryCardList().add(trc2);
			    continent.getTerritoryCardList().add(trc3);
			    
			    player1.getTerritoryCardList().add(trc1);
			    player1.getTerritoryCardList().add(trc2);
			    player1.getTerritoryCardList().add(trc3);
			    
			    player4.getTerritoryCardList().add(trc1);
			    player4.getTerritoryCardList().add(trc2);
			    player4.getTerritoryCardList().add(trc3);
			    
			    player2.getTerritoryCardList().add(trc1);
			    player2.getTerritoryCardList().add(trc2);
			    
			    continent.getTerritoryList().add(territory1);
			    continent.getTerritoryList().add(territory2);
			    continent.getTerritoryList().add(territory3);
			    
			    player2.tradeTerritoryCards(continent);//Test1: if territoryCardList does not contain all of the continent's territoryCardList.
			    boolean player2ContainsTer3 = player2.getTerritoryList().contains(territory3);
			    assertEquals(false, player2ContainsTer3);
			  
			
		
	}
	
	@Test
	void emptyTerritoryCardList() {
				
				
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
			    player2.getTerritoryList().add(territory4);
			
			    
			    territory1.getArmyList().add(infantry1);  
			    territory1.getArmyList().add(infantry2);  
			    
			    
			    
			    
			    continent.getTerritoryCardList().add(trc1);
			    continent.getTerritoryCardList().add(trc2);
			    continent.getTerritoryCardList().add(trc3);
			    
			    player1.getTerritoryCardList().add(trc1);
			    player1.getTerritoryCardList().add(trc2);
			    player1.getTerritoryCardList().add(trc3);
			    
			    player4.getTerritoryCardList().add(trc1);
			    player4.getTerritoryCardList().add(trc2);
			    player4.getTerritoryCardList().add(trc3);
			    
			    player2.getTerritoryCardList().add(trc1);
			    player2.getTerritoryCardList().add(trc2);
			    
			    continent.getTerritoryList().add(territory1);
			    continent.getTerritoryList().add(territory2);
			    continent.getTerritoryList().add(territory3);
			    
			    player2.tradeTerritoryCards(continent);
			    boolean player2ContainsTer3 = player2.getTerritoryList().contains(territory3);
			   
			    player3.tradeTerritoryCards(continent);//Test2: if territoryCardList is empty. 
			    assertEquals(0, player3.getTerritoryList().size());
			    
			
			    
		
	}
	
	@Test
	void playerOwnsSomeOf() {
				
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
			    player2.getTerritoryList().add(territory4);
			
			    
			    territory1.getArmyList().add(infantry1);  
			    territory1.getArmyList().add(infantry2);  
			    
			    
			    
			    
			    continent.getTerritoryCardList().add(trc1);
			    continent.getTerritoryCardList().add(trc2);
			    continent.getTerritoryCardList().add(trc3);
			    
			    player1.getTerritoryCardList().add(trc1);
			    player1.getTerritoryCardList().add(trc2);
			    player1.getTerritoryCardList().add(trc3);
			    
			    player4.getTerritoryCardList().add(trc1);
			    player4.getTerritoryCardList().add(trc2);
			    player4.getTerritoryCardList().add(trc3);
			    
			    player2.getTerritoryCardList().add(trc1);
			    player2.getTerritoryCardList().add(trc2);
			    
			    continent.getTerritoryList().add(territory1);
			    continent.getTerritoryList().add(territory2);
			    continent.getTerritoryList().add(territory3);
			    
			    player2.tradeTerritoryCards(continent);
			    boolean player2ContainsTer3 = player2.getTerritoryList().contains(territory3);
			    assertEquals(false, player2ContainsTer3);
			  
			    player3.tradeTerritoryCards(continent);
			    assertEquals(0, player3.getTerritoryList().size());
			    
			    int beforeTradePlayer1 = player1.getTerritoryList().size();
			    player1.tradeTerritoryCards(continent);
			    int afterTradePlayer1 = player1.getTerritoryList().size();
			    System.out.println(beforeTradePlayer1);
			    System.out.println(afterTradePlayer1);
			    assertEquals(beforeTradePlayer1 + 1, afterTradePlayer1);
			    
			   
			   
			    
		
	}
	
	@Test
	void nullContinent() {
		//Test1: if territoryCardList does not contain all of the continent's territoryCardList.
				//Test2: if territoryCardList is empty. 
				//Test3: if player owns some territories of this continent. 
				//Test4: if continent is null.
				//Test5: default.
				
				
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
			    player2.getTerritoryList().add(territory4);
			
			    
			    territory1.getArmyList().add(infantry1);  
			    territory1.getArmyList().add(infantry2);  
			    
			    
			    
			    
			    continent.getTerritoryCardList().add(trc1);
			    continent.getTerritoryCardList().add(trc2);
			    continent.getTerritoryCardList().add(trc3);
			    
			    player1.getTerritoryCardList().add(trc1);
			    player1.getTerritoryCardList().add(trc2);
			    player1.getTerritoryCardList().add(trc3);
			    
			    player4.getTerritoryCardList().add(trc1);
			    player4.getTerritoryCardList().add(trc2);
			    player4.getTerritoryCardList().add(trc3);
			    
			    player2.getTerritoryCardList().add(trc1);
			    player2.getTerritoryCardList().add(trc2);
			    
			    continent.getTerritoryList().add(territory1);
			    continent.getTerritoryList().add(territory2);
			    continent.getTerritoryList().add(territory3);
			    
			    player2.tradeTerritoryCards(continent);
			    boolean player2ContainsTer3 = player2.getTerritoryList().contains(territory3);
			    
			  
			    player3.tradeTerritoryCards(continent);
			   
			    
			    int beforeTradePlayer1 = player1.getTerritoryList().size();
			    player1.tradeTerritoryCards(continent); 
			    int afterTradePlayer1 = player1.getTerritoryList().size();
			    System.out.println(beforeTradePlayer1);
			    System.out.println(afterTradePlayer1);
			   
			    
			    int beforeTradePlayer2 = player2.getTerritoryList().size();
			    player2.tradeTerritoryCards(null);//Test4: if continent is null.
			    int afterTradePlayer2 = player2.getTerritoryList().size();
			    assertEquals(beforeTradePlayer2, afterTradePlayer2);
			    
			   
			   
			    
		
	}
	
	@Test
	void WorkingCase() {
				
				
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
			    player2.getTerritoryList().add(territory4);
			
			    
			    territory1.getArmyList().add(infantry1);  
			    territory1.getArmyList().add(infantry2);  
			    
			    
			    
			    
			    continent.getTerritoryCardList().add(trc1);
			    continent.getTerritoryCardList().add(trc2);
			    continent.getTerritoryCardList().add(trc3);
			    
			    player1.getTerritoryCardList().add(trc1);
			    player1.getTerritoryCardList().add(trc2);
			    player1.getTerritoryCardList().add(trc3);
			    
			    player4.getTerritoryCardList().add(trc1);
			    player4.getTerritoryCardList().add(trc2);
			    player4.getTerritoryCardList().add(trc3);
			    
			    player2.getTerritoryCardList().add(trc1);
			    player2.getTerritoryCardList().add(trc2);
			    
			    continent.getTerritoryList().add(territory1);
			    continent.getTerritoryList().add(territory2);
			    continent.getTerritoryList().add(territory3);
			    
			    player2.tradeTerritoryCards(continent);
			    boolean player2ContainsTer3 = player2.getTerritoryList().contains(territory3);
			    
			  
			    player3.tradeTerritoryCards(continent);
			   
			    int beforeTradePlayer1 = player1.getTerritoryList().size();
			    player1.tradeTerritoryCards(continent);
			    int afterTradePlayer1 = player1.getTerritoryList().size();
			    System.out.println(beforeTradePlayer1);
			    System.out.println(afterTradePlayer1);
			   
			    
			    int beforeTradePlayer2 = player2.getTerritoryList().size();
			    player2.tradeTerritoryCards(null);
			    int afterTradePlayer2 = player2.getTerritoryList().size();
			
			    
			    player4.tradeTerritoryCards(continent);//Test5: default.
			    assertEquals(3, player4.getTerritoryList().size());
			    
		
	}

}