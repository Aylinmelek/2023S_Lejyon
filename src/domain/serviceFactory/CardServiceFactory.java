package domain.serviceFactory;

import domain.ClientSingleton;
import domain.cardService.DisasterCardServiceAdapter;
import domain.cardService.ICardServiceAdapter;
import domain.cardService.ReinforcementCardServiceAdapter;
import domain.cardService.SabotageCardServiceAdapter;
import domain.cardService.WorldEventCardServiceAdapter;

public class CardServiceFactory {
	
	private ICardServiceAdapter cardService;
	
	private static CardServiceFactory instance; //internal variable
	private CardServiceFactory() {} //constructor
	
	
	public static CardServiceFactory getInstance() {//name of the singleton method:
		if (instance == null) { //guarantees only one instance is created
			instance = new CardServiceFactory();
		}
		return instance;
	}
	
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
		else if (serviceUsed.equals("RollDie")) {//how can I use singleton pattern for rollDie() ???
			cardService = new WorldEventCardServiceAdapter();
		}
		else {
			
		}
		
		return cardService;
	}

}