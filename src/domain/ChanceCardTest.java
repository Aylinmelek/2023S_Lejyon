package domain;

import java.util.ArrayList;
import domain.cardService.*;

public class ChanceCardTest extends DisasterAdapter{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisasterCard disCard = new DisasterCard();
		Continent cont = new Continent();
		Player player = new Player();
		DisasterCardServiceAdapter disCardAp = new DisasterCardServiceAdapter();
		int number = 2;
		ArrayList<Player> playerList = new ArrayList<Player>();
		disCard.continent = cont;
		disCard.disaster(disCardAp);
		Continent cont2 = new Continent();
		disCard.continent = cont2;
		disCard.disaster(disCardAp);
	}

	

}
