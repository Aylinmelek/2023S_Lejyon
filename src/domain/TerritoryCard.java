package domain;

import java.io.Serializable;

public class TerritoryCard implements Serializable{
	String continent;
	Territory territory;
	boolean inPlayer;
	
	public boolean isInPlayer() {
		return inPlayer;
	}
}
