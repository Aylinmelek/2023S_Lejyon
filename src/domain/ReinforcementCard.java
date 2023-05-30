package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import domain.cardService.ICardServiceAdapter;

public class ReinforcementCard implements Rollable, Serializable {// implements Rollable{//, Changable {
	

	Die die;
	Territory territory;
	ArrayList<Player> playerList;

	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue + 1;
	}

	public void reinforce(ICardServiceAdapter cardService) {
		cardService.addArmy(die, territory, playerList);
	}
	


	
}