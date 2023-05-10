package domain;

public class Infantry implements Army{
	Territory territory;
	Player owner;
	boolean inPlayer;
	int power = 1;
	
	public boolean isInPlayer() {
		return inPlayer;
	}
}
