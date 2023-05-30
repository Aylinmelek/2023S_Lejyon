package domain;

import java.io.Serializable;

public class Artillery implements Army, Serializable{
	Territory territory;
	Player owner;
	boolean inPlayer;
	
	public boolean isInPlayer() {
		return inPlayer;
	}

}