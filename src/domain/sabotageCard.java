package domain;

import java.util.Random;

public class sabotageCard implements Rollable {
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
	public static void removeArmy(Territory territory) {
		territory.army --;
	}
	
	public void Sabotage(Die die, Territory territory) {
		int faceVal = die.generateNum();
		for(int i = 0; i < faceVal; i++) {
			int index = territory.getArmyList().size() - 1;
			territory.getArmyList().remove(index);
			System.out.println("Infantry is removed!");
		}
	}
}