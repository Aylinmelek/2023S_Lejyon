package domain;

import java.util.ArrayList;
import java.util.Hashtable;

import UI.BuildingMode;
import UI.Grid;
import UI.LoginScreen;

public class ConKUeror {

	
	
	
	Grid grid = new Grid();
	public Die die = new Die();

	public Hashtable<Player, Boolean> player_turn = new Hashtable<Player, Boolean>();

	


	public int addToPlayerTurnHash(LoginScreen loginScreen) {
		for (int i = 0; i < loginScreen.getPlayerNum(); i++) {
			Player player = new Player();
			playerList.add(player);
			System.out.println(player);
			// player.setNumOfInfantry();
			player_turn.put(player, player.turn);

		}
		return player_turn.size();
	}

	public void addToList(int num) {
		for (int j = 0; j < playerList.size(); j++) {
			Infantry inf = new Infantry();
			for (int i = 0; i < num; i++) {
				playerList.get(j).getInfantryList().add(inf);
			}
		}

	}
}