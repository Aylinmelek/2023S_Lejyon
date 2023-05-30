package domain;

import java.io.Serializable;
import java.util.Random;

public class sabotageCard implements Rollable, Serializable{
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
	public static void removeArmy(Territory territory) {
		territory.army --;
	}
}