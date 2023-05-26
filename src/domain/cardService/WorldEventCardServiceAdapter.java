package domain.cardService;

import java.util.ArrayList;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.Territory;

public class WorldEventCardServiceAdapter implements ICardServiceAdapter {

private WorldEventCardService worldEventCard;
	
	public WorldEventCardServiceAdapter() {
		worldEventCard = new WorldEventCardService();
		System.out.println("Using WorldEvent Card");
	}


	@Override
	public void removeArmy(Territory territory, Die die, Continent continent, Player player, int number, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		worldEventCard.worldEvent(territory, die, playerList);
	}
	
	@Override
	public void addArmy(Die die, Territory territory, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		worldEventCard.worldEvent(territory, die, playerList);
	}
	
	



}