package domain.cardService;

import java.util.Random;

import domain.Territory;

public class WorldEventCardService {
	
	
	Territory territory;
	
	public WorldEventCardService() {
		territory = new Territory();
	}
	
	public static void removeArmy(Territory territory) {
		territory.army --;
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