package domain;

import java.util.ArrayList;
import java.util.Random;

public class WorldEventCard implements Rollable, Changable{
	
	public int rollDie() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue+1;
	}
	
	public void addArmy(Territory territory) {
		territory.army ++;
	}
	
	public void removeArmy(Territory territory) {
		territory.army --;
	}
	public void worldEvent(Territory territory, Die die, ArrayList<Player> playerList) {
		int faceValue = die.generateNum();
		if (faceValue <= 2 || faceValue == 5) {
			for(int i = 0; i < playerList.size(); i++) {
				Infantry infantry = new Infantry();
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
			}
		}
		
		if ((faceValue <= 4) && (faceValue > 2)|| faceValue == 6) {
			for(int i = 0; i < playerList.size(); i++) {
				int index = playerList.get(i).getTerritoryList().get(0).getArmyList().size() - 1;
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index);
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 1);
				playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 2);
			}
		}
	}

}