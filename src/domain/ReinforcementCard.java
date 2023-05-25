package domain;

import java.util.Random;

import domain.cardService.ICardServiceAdapter;

public abstract class ReinforcementCard implements Rollable {
	
	Territory territory;
	
	/*public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}*/
	public void rollDie(ICardServiceAdapter armyService) {
		armyService.removeArmyFromContinent(territory);
		
	}
	/*public static void addArmy(Territory territory) {
		territory.army ++;
	}*/
	public void addArmy(ICardServiceAdapter armyService) {
		armyService.removeArmyFromContinent(territory);
		
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