package domain;


import java.io.Serializable;
public class SpyCard implements Serializable{
	public static void spyOn(Territory territory, Player player, int option) {
		if (option == 0) {
			int armyCardCount = player.getDeck().getArtilleryCardList().size() + player.getDeck().getCavalryCardList().size() + player.getDeck().getInfantryCardList().size();
			System.out.println("ArtilleryCard count of " + player + " is " + player.getDeck().getArtilleryCardList().size());
			System.out.println("InfantryCard count of " + player + " is " + player.getDeck().getInfantryCardList().size());
			System.out.println("CavalryCard count of " + player + " is " + player.getDeck().getCavalryCardList().size());
		}
		else {
			System.out.println("Territory has " + territory.getArmyList().size() + " armies.");
		}

	}
}
