package domain;

import java.io.Serializable;
import java.util.Random;

public class ReinforcementCard implements Rollable, Serializable {
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
	public static void addArmy(Territory territory) {
		territory.army ++;
	}
}