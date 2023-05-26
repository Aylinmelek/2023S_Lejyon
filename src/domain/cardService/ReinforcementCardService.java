package domain.cardService;

import java.util.Random;

import domain.Die;
import domain.Infantry;
import domain.Territory;

public class ReinforcementCardService {
	
	
	Territory territory;
	
	public ReinforcementCardService() {
		territory = new Territory();
	}
	
	public void reinforce(Die die, Territory territory) {
		int faceVal = die.generateNum();
		for(int i = 0; i < faceVal; i++) {
			Infantry infantry = new Infantry();
			territory.getArmyList().add(infantry);
			System.out.println("Infantry is added.");
		}
		
	}
	

	
}