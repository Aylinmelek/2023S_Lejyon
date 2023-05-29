package domain.cardService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.Territory;

public class SabotageCardService {
	
	
	Territory territory;
	
	public SabotageCardService() {
		territory = new Territory();
	}
	
	public static void sabotage(Territory territory, Die die, Continent continent, Player player, int number) {
		//observer için değiştirdim
		die.roll();
		int faceVal = die.getDiceValue();
		////////////
		//int faceVal = die.generateNum();
		for(int i = 0; i < faceVal; i++) {
			int index = territory.getArmyList().size() - 1;
			territory.getArmyList().remove(index);
			System.out.println("Infantry is removed!");
		}
	}
	
	
}
