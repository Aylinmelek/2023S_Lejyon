package domain;

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
	public void worldEvent(Territory territory) {
		int dieValue = rollDie();
		if (dieValue < 3) {
			addArmy(territory);//terX
		}
		else if (dieValue < 5) {
			removeArmy(territory);//terX
		}
		else {
			System.out.println("territories have changed." );
			
		}
	}

}