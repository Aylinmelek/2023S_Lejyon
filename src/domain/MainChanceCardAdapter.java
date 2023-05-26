package domain;

import domain.cardService.DisasterCardServiceAdapter;
import domain.cardService.ICardServiceAdapter;
import domain.cardService.ReinforcementCardServiceAdapter;
import domain.cardService.SabotageCardServiceAdapter;
import domain.cardService.WorldEventCardServiceAdapter;

public class MainChanceCardAdapter {
	public static void main(String[] args) {
		ICardServiceAdapter cardService;
		String cardType = "DisasterCard";
		
		if (cardType == "DisasterCard") {
			cardService = new DisasterCardServiceAdapter();
		}
		else if (cardType == "ReinforcementCard") {
			cardService = new ReinforcementCardServiceAdapter();
		}
		else if (cardType == "SabotageCard") {
			cardService = new SabotageCardServiceAdapter();
		}
		else if (cardType == "WorldEventCard") {
			cardService = new WorldEventCardServiceAdapter();
		}
		else {
			
		}
		
		/*Sale s = new Sale();
		//...
		s.saveSale(storageService);
		//...
		s.getSale(storageService);*/
	
	}
}
