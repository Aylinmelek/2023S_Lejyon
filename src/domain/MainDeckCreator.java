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
}
