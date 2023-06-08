package domain;

public class MainDeckCreator {
    

    public void createMainDeck(int count, int armyCard, Deck deck) {
		for (int i = 0; i < count; i++) {
			DisasterCard disasterCard= new DisasterCard();
			DiplomaticImmunityCard diplomaticImmunity = new DiplomaticImmunityCard();
			sabotageCard sabotage = new sabotageCard();
			SpyCard spyCard = new SpyCard();
			WorldEventCard worldEventCard = new WorldEventCard();
			ReinforcementCard reinforcementCard = new ReinforcementCard();
			
			deck.getdipImmunityCardList().add(diplomaticImmunity);
			deck.getDisasterCardList().add(disasterCard);
			deck.getReinforcementCardList().add(reinforcementCard);
			deck.getsabotageCardList().add(sabotage);
			deck.getSpyCardList().add(spyCard);
			deck.getWorldEventCardList().add(worldEventCard);
		}
		for(int a = 0; a < armyCard; a ++) {
			InfantryCard infantryCard = new InfantryCard();
			ArtilleryCard artilleryCard = new ArtilleryCard();
			CavalryCard cavalryCard = new CavalryCard();
			deck.getInfantryCardList().add(infantryCard);
			deck.getArtilleryCardList().add(artilleryCard);
			deck.getCavalryCardList().add(cavalryCard);

			System.out.println("burasý calýsti");

		}
		
		
		
	}
    
    public void MainDeckTerCardCreator(Continent continent1, Continent continent2, Continent continent3, Continent continent4, Continent continent5, Continent continent6, Deck deck)
    {
    	for(int a = 0; a < continent1.getTerritoryList().size(); a++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent1.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    	for(int b = 0; b < continent2.getTerritoryList().size(); b++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent2.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    	for(int c = 0; c < continent3.getTerritoryList().size(); c++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent3.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    	for(int d = 0; d < continent4.getTerritoryList().size(); d++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent4.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    	for(int e = 0; e < continent5.getTerritoryList().size(); e++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent5.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    	for(int f = 0; f < continent6.getTerritoryList().size(); f++)
    	{
    		TerritoryCard terCard = new TerritoryCard(); 
    		continent6.getTerritoryCardList().add(terCard);
    		deck.getTerritoryCardList().add(terCard);
    		System.out.println(terCard);
    	}
    }
    
    
}
