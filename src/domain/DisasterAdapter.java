package domain;

public class DisasterAdapter implements Changable{
	

	public void addArmy(Territory territory) {
		// TODO Auto-generated method stub
		
	}

	public void removeArmy(Territory territory) {
			for (int i = 0; i < territory.continent.territoryCount; i++) {
				territory.continent.territorylist[i].army --;
				}
		
	}

	
}
