package domain;

public class Artillery implements Army{
	Territory territory;
	Player owner;
	boolean inPlayer;
	
	public boolean isInPlayer() {
		return inPlayer;
	}

}