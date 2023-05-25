package domain;

import java.util.Random;

import domain.cardService.ICardServiceAdapter;


public class sabotageCard { //implements Rollable {//, Changable {
	//implements rollable ??
	Territory territory;
	Die die;
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}

	

	
	
	public void sabotage(ICardServiceAdapter cardService) {
		cardService.removeArmy(territory, die, null, null, 0, null);
	}

	
	
	
}