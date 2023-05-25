package domain.cardService;

import domain.Territory;
import domain.sabotageCard;

public abstract class DisasterCardServiceAdapter implements ICardServiceAdapter {

private DisasterCardService disasterCard;
	
	public DisasterCardServiceAdapter() {
		disasterCard = new DisasterCardService();
		System.out.println("Using Disaster Card");
	}


	@Override
	public void removeArmyFromContinent(Territory territory) {
		// TODO Auto-generated method stub
		disasterCard.removeArmy(territory);
	}


}