package domain.serviceFactory;

import domain.cardService.DisasterCardServiceAdapter;
import domain.cardService.ICardServiceAdapter;
import domain.cardService.ReinforcementCardServiceAdapter;
import domain.cardService.SabotageCardServiceAdapter;
import domain.cardService.WorldEventCardServiceAdapter;

public class CardServiceFactory {
	
	private ICardServiceAdapter cardService;
	
	public ICardServiceAdapter getCardServiceAdapter(String serviceUsed) {
		
		if (serviceUsed.equals("DisasterCard")) {
			cardService = new DisasterCardServiceAdapter();
		}
		else if (serviceUsed.equals("ReinforcementCard")) {
			cardService = new ReinforcementCardServiceAdapter();
		}
		else if (serviceUsed.equals("SabotageCard")) {
			cardService = new SabotageCardServiceAdapter();
		}
		else if (serviceUsed.equals("WorldEventCard")) {
			cardService = new WorldEventCardServiceAdapter();
		}
		else {
			
		}
		
		return cardService;
	}

}