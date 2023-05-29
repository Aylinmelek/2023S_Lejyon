package domain.cardService;

import java.util.ArrayList;

import domain.Continent;
import domain.Die;
import domain.Player;
import domain.ReinforcementCard;
import domain.Territory;

public class ReinforcementCardServiceAdapter implements ICardServiceAdapter {

private ReinforcementCardService reinforcementCard;
	

	public ReinforcementCardServiceAdapter() {
		reinforcementCard = new ReinforcementCardService();
		System.out.println("Using Reinforcement Card");
	}


	@Override
	public void addArmy(Die die, Territory territory, ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		reinforcementCard.reinforce(die, territory);
	}


	@Override
	public void removeArmy(Territory territory, Die die, Continent continent, Player player, int number,
			ArrayList<Player> playerList) {
		// TODO Auto-generated method stub
		
	}
	
	


}