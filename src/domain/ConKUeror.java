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

	
	

	public void initialSharingOfTerritory(ArrayList<Player> playerList, Map map) {
		boolean workUntil = true;
		boolean allTrue = false;
		while (workUntil) {
			if (!allTrue) {
				// System.out.println(playerList.size());
				for (int i = 0; i < playerList.size(); i++) {
					// System.out.println(grid.getRow());
					// playerList.get(i).chooseATerritory();
					// UI da seçtiği territoryi buraya parametre olarak yolluyoruz/
					System.out.println(playerList.get(i) + " will choose a territory.");
					map.getTerritories().get(i).isTaken = true;
					allTrue = true;
					for (Territory territory : map.territories) {
						if (!territory.isTaken) {
							allTrue = false;
							break;
						}
					}
				}
			} else {
				workUntil = false;
			}
		}

	}

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