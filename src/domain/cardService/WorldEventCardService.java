package domain.cardService;

import java.util.ArrayList;
import java.util.Random;

import domain.Die;
import domain.Infantry;
import domain.Player;
import domain.Territory;

public class WorldEventCardService {
	
	
	Territory territory;
	
	public WorldEventCardService() {
		territory = new Territory();
	}
	public void worldEvent(Territory territory, Die die, ArrayList<Player> playerList) {
		//observer için değiştirdim
		die.roll();
		int faceValue = die.getDiceValue();
		////////
		//int faceValue = die.generateNum();
		
		if (faceValue <= 2 || faceValue == 5) { //addarmy()
			for(int i = 0; i < playerList.size(); i++) {
				Infantry infantry = new Infantry();
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
			}
		}
		
		if ((faceValue <= 4) && (faceValue > 2)|| faceValue == 6) {//Removearmy()
			for(int i = 0; i < playerList.size(); i++) {
				int index = playerList.get(i).getTerritoryList().get(0).getArmyList().size() - 1;
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index);
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 1);
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 2);
			}
		}
	}
	
}