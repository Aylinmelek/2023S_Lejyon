package domain;

import java.util.ArrayList;

public class PlayerCreator {
    public ArrayList<Player> playerList = new ArrayList<Player>();
    public ArrayList<String> playerName = new ArrayList<String>();
    
    
    public ArrayList<Player> createPlayer(int playerCount, int AICount) {
		for (int i = 0; i < playerCount; i++) {
			Player player = new Player();
			playerList.add(player);
		}
		for (int j = 0; j < AICount; j++) {
			AI ai = new AI();
			playerList.add(ai.playerAI);
		}
		
		return playerList;
	}
    public int getNumOfPlayer() {
    	return playerList.size();
    }
    
    public ArrayList<String> createPlayerName(int totalPlayerCount) {
		for (int i = 0; i < totalPlayerCount; i++) {
			Player player = new Player();
			playerName.add(player.getName());
		}
		
		
		return playerName;
	}
}
