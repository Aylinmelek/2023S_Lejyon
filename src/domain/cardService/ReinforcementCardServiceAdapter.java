package domain.cardService;

import domain.Territory;

public abstract class ReinforcementCardServiceAdapter implements ICardServiceAdapter {

private ReinforcementCardService reinforcementCard;
	
	public ReinforcementCardServiceAdapter() {
		reinforcementCard = new ReinforcementCardService();
		System.out.println("Using Reinforcement Card");
	}


	@Override
	public void addArmyToContinent(Territory territory) {
		// TODO Auto-generated method stub
		reinforcementCard.addArmy(territory);
	}
	
	public int roll() {
		// TODO Auto-generated method stub
		return reinforcementCard.rollDie();
	}


}