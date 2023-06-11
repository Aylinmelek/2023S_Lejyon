package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import domain.controller.ConKUerorHandler;

public class AI {
    Player playerAI = new Player();
    Map map = new Map();
    boolean turn, initialShare, fortifyable;
   
    ConKUerorHandler conKUerorHandler = new ConKUerorHandler(); 
    Die die = new Die();

    public void chooseTer() {
        if (turn && initialShare) {
            int terIndex = generateNum(map.getTerritories().size());
            while (!findNotTakenTer(terIndex)) {
                terIndex = generateNum(map.getTerritories().size());
            }
            playerAI.chooseATerritory(map.getTerritories().get(terIndex));

        }
    }

    public void attackAI(int first, int second) {
        if (turn && !initialShare) {
            int fromIndex = generateNum(playerAI.getTerritoryList().size());
            int destIndex = generateNum(playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().size());
            while (!playerAI.canAttackTerritory(playerAI.getTerritoryList().get(fromIndex),
                    playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().get(destIndex))) {
                fromIndex = generateNum(playerAI.getTerritoryList().size());
                destIndex = generateNum(playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().size());
            }
            conKUerorHandler.attack(playerAI, playerAI.getTerritoryList().get(fromIndex),
                    playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().get(destIndex), first, second); // Burası
                                                                                                              // da
                                                                                                              // bağlanacak
        }

    }

    public int generateNum(int size) {
        Random random = new Random();
        int faceValue = random.nextInt(size);
        return faceValue;
    }

    public boolean findNotTakenTer(int num) {
        if (map.getTerritories().get(num).getOwner() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void fortifyAI(boolean forceFortify, int armyCounter) {
        int isTime = generateNum(2);
        if (isTime == 1) {
            fortifyable = true;
        } else {
            fortifyable = false;
        }
        if ((turn && fortifyable) || forceFortify) {
            int fromIndex = generateNum(playerAI.getTerritoryList().size());
            int destIndex = generateNum(playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().size());
            while (!playerAI.getTerritoryList()
                    .contains(playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().get(destIndex))) {
                fromIndex = generateNum(playerAI.getTerritoryList().size());
                destIndex = generateNum(playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().size());
            }
            int armyCount = generateNum(playerAI.getTerritoryList().get(fromIndex).getArmyList().size());
            conKUerorHandler.fortify(playerAI, playerAI.getTerritoryList().get(fromIndex),
                    playerAI.getTerritoryList().get(fromIndex).getAdjacentTerritories().get(destIndex), armyCounter);
        }
    }
    public Player getPlayerAI() {
		return playerAI;
	}

	public void setPlayerAI(Player playerAI) {
		this.playerAI = playerAI;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public boolean isInitialShare() {
		return initialShare;
	}

	public void setInitialShare(boolean initialShare) {
		this.initialShare = initialShare;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}


    /*
     * Territory terTo, terFrom;
     * for(int i = 0;i<playerAI.getTerritoryList().size();i++)
     * {
     * for (int j = 0; j <
     * playerAI.getTerritoryList().get(i).getAdjacentTerritories().size(); j++)
     * if (playerAI.getTerritoryList()
     * .contains(playerAI.getTerritoryList().get(i).getAdjacentTerritories().get(j))
     * ) {
     * terTo = playerAI.getTerritoryList().get(i);
     * terFrom = playerAI.getTerritoryList().get(i).getAdjacentTerritories().get(j);
     * break;
     * }
     * break;
     * }
     */

}