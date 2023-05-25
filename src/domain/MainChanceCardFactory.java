package domain;

import domain.serviceFactory.CardServiceFactory;

public class MainChanceCardFactory {
	
	public static void main(String[] args) {
		
		/****for factory*******/
		//CardServiceFactory serviceFactory = new CardServiceFactory();
		
		//ClientFactory clientDisaster = new ClientFactory(serviceFactory, "DisasterCard");
		//ClientFactory clientReinforcement = new ClientFactory(serviceFactory, "ReinforcementCard");
		//ClientFactory clientSabotage = new ClientFactory(serviceFactory, "SabotageCard");
		//ClientFactory clientWorldEvent = new ClientFactory(serviceFactory, "WorldEvent");
		
		/*clientDisaster.pickDisaster();
		clientReinforcement.pickReinforcement();
		clientSabotage.pickSabotage();
		clientWorldEvent.pickWorldEvent();*/
		
		
		/****for singleton*******/
		ClientSingleton clientSingleton = new ClientSingleton("RollDie");
		
		clientSingleton.rollDie();

	}

}
