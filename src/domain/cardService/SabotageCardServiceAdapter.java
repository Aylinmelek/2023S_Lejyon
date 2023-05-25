package domain.cardService;

import java.util.ArrayList;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.Territory;
import domain.sabotageCard;

public class SabotageCardServiceAdapter implements ICardServiceAdapter {

private SabotageCardService sabotageCard;
	
	public SabotageCardServiceAdapter() {
		sabotageCard = new SabotageCardService();
		System.out.println("Using Sabotage Card");
	}


	@Override
	public void removeArmy(Territory territory, Die die, Continent continent, Player player, int number,
			ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addArmy(Die die, Territory territory, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		
	}
	
	

}