package domain;

import java.util.ArrayList;
import java.util.Random;

import domain.cardService.ICardServiceAdapter;
import domain.serviceFactory.CardServiceFactory;

public class WorldEventCard { //implements Rollable, Changable{
	//implements Rollable??
	Territory territory;
	Die die;
	Continent continent;
	Player player;
	int number;
	ICardServiceAdapter cardService;
	
	public int rollDie() {
		//int faceValue = CardServiceFactory.getInstance().getCardServiceAdapter("RollDie").rollDie();
		
		//return faceValue;
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue+1;
	}
	

	public void worldEvent(ICardServiceAdapter cardService, ArrayList<Player> playerList) { 
		int faceValue = die.generateNum();
		
		if (faceValue <= 2 || faceValue == 5) { //addarmy()
			cardService.addArmy(die, territory, playerList);
			
		}
		
		if ((faceValue <= 4) && (faceValue > 2)|| faceValue == 6) {//Removearmy()
			cardService.removeArmy(territory, die, continent, player, number, playerList);
			
		}
	}

}