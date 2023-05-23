package domain;

import java.util.Random;

public class ReinforcementCard implements Rollable {
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}
	public static void addArmy(Territory territory) {
		territory.army ++;
	}
	
	public void Reinforce(Die die, Territory territory) {
		int faceVal = die.generateNum();
		for(int i = 0; i < faceVal; i++) {
			Infantry infantry = new Infantry();
			territory.getArmyList().add(infantry);
			System.out.println("Infantry is added.");
		}
	}
}