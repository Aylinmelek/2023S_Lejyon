package test;

import static org.junit.jupiter.api.Assertions.*;
import domain.*;

import org.junit.jupiter.api.Test;

class TradeTerCardListBlackBoxTesting {

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
    
    Continent continent2 = new Continent();
    
	@Test
	void equalOwner() {
		
		
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
	    
	    player4.tradeTerritoryCards(continent);
	    assertEquals(player4, territory1.getOwner());
	    
	    
	}

	@Test
	void afterTradeTerList() {
		
		
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
	    
	    player4.tradeTerritoryCards(continent);
	    
	    assertEquals(0, player4.getTerritoryCardList().size());
	    
	    
	    
	}

	
	@Test
	void afterTradeOwner() {
		
		
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
	    
	    player4.tradeTerritoryCards(continent);
	    
	    player1.tradeTerritoryCards(continent);
	    assertNotEquals(player4, territory1.getOwner());
	    
	    
	}

	
	@Test
	void remainOtherTerCard() {
		
		
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
	    
	    player4.tradeTerritoryCards(continent);
	    
	    player1.tradeTerritoryCards(continent);
	    
	    player4.getTerritoryCardList().add(trc1);
	    player4.getTerritoryCardList().add(trc2);
	    player4.getTerritoryCardList().add(trc3);
	    
	    TerritoryCard trc4 = new TerritoryCard(); 
	    
	    player4.getTerritoryCardList().add(trc4);
	    
	    player4.tradeTerritoryCards(continent);
	    assertEquals(1, player4.getTerritoryCardList().size());  
	}

	
	@Test
	void otherContinent() {
		
		
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
	    
	    player4.tradeTerritoryCards(continent);
	    
	    player1.tradeTerritoryCards(continent);
	    
	    player4.getTerritoryCardList().add(trc1);
	    player4.getTerritoryCardList().add(trc2);
	    player4.getTerritoryCardList().add(trc3);
	    
	    TerritoryCard trc4 = new TerritoryCard(); 
	    
	    player4.getTerritoryCardList().add(trc4);
	    
	    player4.tradeTerritoryCards(continent);
	    
	    int beforeTradePlayer1 = player1.getTerritoryList().size();
	    player1.tradeTerritoryCards(continent2);
	    int afterTradePlayer1 = player1.getTerritoryList().size();
	    assertEquals(beforeTradePlayer1, afterTradePlayer1);
	    
	    
	    
	}

}