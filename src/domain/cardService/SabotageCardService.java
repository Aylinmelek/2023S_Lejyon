package domain.cardService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import domain.Territory;

public class SabotageCardService {
	
	
	Territory territory;
	
	public SabotageCardService() {
		territory = new Territory();
	}
	
	public static void removeArmy(Territory territory) {
		territory.army --;
	}
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
}
