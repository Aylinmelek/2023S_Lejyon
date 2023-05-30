package domain;

import java.io.Serializable;

public class Cavalry implements Army, Serializable {
	Territory territory;
	Player owner;
	boolean inPlayer;
	
	public boolean isInPlayer() {
		return inPlayer;
	}
}