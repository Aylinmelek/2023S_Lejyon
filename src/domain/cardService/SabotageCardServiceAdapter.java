package domain.cardService;

import domain.Territory;
import domain.sabotageCard;

public abstract class SabotageCardServiceAdapter implements ICardServiceAdapter {

private SabotageCardService sabotageCard;
	
	public SabotageCardServiceAdapter() {
		sabotageCard = new SabotageCardService();
		System.out.println("Using Sabotage Card");
	}


	@Override
	public void removeArmyFromContinent(Territory territory) {
		// TODO Auto-generated method stub
		sabotageCard.removeArmy(territory);
	}
	
	public int roll() {
		// TODO Auto-generated method stub
		return sabotageCard.rollDie();
	}


}