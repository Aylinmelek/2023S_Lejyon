package domain.cardService;

import java.util.ArrayList;
import java.util.Random;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.Territory;

public interface ICardServiceAdapter {
	
	
	//void removeArmyFromContinent(Territory territory);//naming??
	void removeArmy(Territory territory, Die die, Continent continent, Player player, int number, ArrayList<Player> playerList);//naming??
	void addArmy(Die die, Territory territory, ArrayList<Player> playerList);//naming??
	
	
	

}
