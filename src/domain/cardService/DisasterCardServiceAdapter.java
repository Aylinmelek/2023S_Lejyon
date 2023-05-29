package domain.cardService;

import java.util.ArrayList;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.Territory;
import domain.sabotageCard;

public class DisasterCardServiceAdapter implements ICardServiceAdapter {

private DisasterCardService disasterCard;
	
	public DisasterCardServiceAdapter() {
		disasterCard = new DisasterCardService();
		System.out.println("Using Disaster Card");
	}


	@Override
	public void removeArmy(Territory territory, Die die, Continent continent, Player player, int number, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		disasterCard.disaster(continent, player,number);
	}


	@Override
	public void addArmy(Die die, Territory territory, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		
	}


}