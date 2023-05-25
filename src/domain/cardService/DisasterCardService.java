package domain.cardService;

import domain.Territory;

public class DisasterCardService {
	Territory territory;
	
	public DisasterCardService() {
		territory = new Territory();
	}
	
	public static void removeArmy(Territory territory) {
		territory.army --;
	}
}
