package domain;

import java.util.ArrayList;

import domain.cardService.ICardServiceAdapter;
import domain.serviceFactory.CardServiceFactory;

public class ClientFactory {
	
	private ICardServiceAdapter cardService;
	ArrayList<Player> playerList;
	
	public ClientFactory(CardServiceFactory factory, String serviceUsed) {
		cardService = factory.getCardServiceAdapter(serviceUsed);
	}
	
	public void pickDisaster() {
		DisasterCard disasterCard = new DisasterCard();
		//..some work
		disasterCard.disaster(cardService);
	}
	
	public void pickReinforcement() {
		ReinforcementCard reinforcementCard = new ReinforcementCard();
		//..some work
		reinforcementCard.reinforce(cardService);
	}
	
	public void pickSabotage() {
		sabotageCard sabotageCard = new sabotageCard();
		//..some work
		sabotageCard.sabotage(cardService);
	}
	
	public void pickWorldEvent() {
		WorldEventCard worldEventCard = new WorldEventCard();
		//..some work
		worldEventCard.worldEvent(cardService, playerList);
	}

}
