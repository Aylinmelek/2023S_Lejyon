package domain.cardService;

import java.util.Random;

import domain.Territory;

public interface ICardServiceAdapter {
	
	
	void removeArmyFromContinent(Territory territory);
	void addArmyToContinent(Territory territory);
	int roll();
	
	

}
