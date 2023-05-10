package domain;

public class Cavalry implements Army{
	Territory territory;
	Player owner;
	boolean inPlayer;
	
	public boolean isInPlayer() {
		return inPlayer;
	}
}