package domain;

public  class DisasterCard extends DisasterAdapter{
	
	public void disaster(Continent continent, Player player, int number) {
		int min = 100;
		Territory weakestTerritory = new Territory();
		
		for(int i = 0; i < continent.getTerritoryList().size(); i++) {
			if(continent.getTerritoryList().get(i).armyList.size() >= number) {
				for(int j = 0; j < number; j++) {
					int index = continent.getTerritoryList().get(i).armyList.size() -1;
					continent.getTerritoryList().get(i).armyList.remove(index);
				}
			}
		}
		for (Territory territory : continent.getTerritoryList()) {
            int count = territory.getArmyList().size();
            if (count < min) {
                min = count;
                weakestTerritory = territory;
            }
        }
		weakestTerritory.getOwner().getTerritoryList().remove(weakestTerritory);
		weakestTerritory.setOwner(null);
	}


}
