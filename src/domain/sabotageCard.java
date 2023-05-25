package domain;

import java.util.Random;

import domain.cardService.ICardServiceAdapter;


public abstract class sabotageCard implements Rollable {
	
	Territory territory;
	
	/*public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}*/
	public void rollDie(ICardServiceAdapter armyService) {
		armyService.removeArmyFromContinent(territory);
		
	}
	
	/*public void removeArmy(Territory territory) {
		territory.army --;
	}*/
	public void removeArmy(ICardServiceAdapter armyService) {
		armyService.removeArmyFromContinent(territory);
		
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