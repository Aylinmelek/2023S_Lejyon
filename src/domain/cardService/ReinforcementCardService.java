package domain.cardService;

import java.util.Random;

import domain.Territory;

public class ReinforcementCardService {
	
	
	Territory territory;
	
	public ReinforcementCardService() {
		territory = new Territory();
	}
	
	public void addArmy(Territory territory) {
		territory.army ++;
	}
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
	
}