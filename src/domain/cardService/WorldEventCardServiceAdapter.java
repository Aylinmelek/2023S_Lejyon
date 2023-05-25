package domain.cardService;

import domain.Territory;

public abstract class WorldEventCardServiceAdapter implements ICardServiceAdapter {

private WorldEventCardService worldEventCard;
	
	public WorldEventCardServiceAdapter() {
		worldEventCard = new WorldEventCardService();
		System.out.println("Using Sabotage Card");
	}


	@Override
	public void removeArmyFromContinent(Territory territory) {
		// TODO Auto-generated method stub
		worldEventCard.removeArmy(territory);
	}
	
	public void addArmyToContinent(Territory territory) {
		// TODO Auto-generated method stub
		worldEventCard.addArmy(territory);
	}
	
	public int roll() {
		// TODO Auto-generated method stub
		return worldEventCard.rollDie();
	}



}