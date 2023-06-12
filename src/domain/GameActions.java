package domain;

import java.util.ArrayList;

public class GameActions {
    public ArrayList<Player> playerList = new ArrayList<Player>();
	public ArrayList<Territory> terList = new ArrayList<Territory>();

    public void turnPass(int index) {
		playerList.get(index).turn = false;
		playerList.get((index + 1) % playerList.size()).turn = true;
	}
    public void createTerritory(int terCount) {
		for (int i = 0; i < terCount; i++) {
			Territory terr = new Territory();
			terList.add(terr);
		}
	}
    public void attack(Player player, Territory territoryFrom, Territory territoryTo, int roll1, int roll2) {
    	//Specification:
    	//@Requires: Attacker should owns territoryFrom and shouldn't owns territoryTo
    	//territoryFrom and territoryTo should be linked, and the territoryFrom should be equal or more powerful than territoryTo
    	//@Modifies: territoryFrom's armyList, territoryTo's armyList, and territoryTo's owner
    	//@Effects: If player won the attack, territoryTo's armyList would be decreased by 1.
    	//If player lose the attack, territoryFrom's armyList would be decreased by 2
    	//If territoryTo's armyList is equal to 0 after the attack, player conquer the territoryTo
    	if(!territoryTo.getImmune()) {
		if (player.getTerritoryList().contains(territoryFrom) && !player.getTerritoryList().contains(territoryTo)) {
			if (player.canAttackTerritory(territoryFrom, territoryTo)
					&& territoryTo.adjacentTerritories.contains(territoryFrom)) {
				System.out.println(player + " is attacking now.");

				// if (die.generateNum() > die.generateNum()) {
				// observer iÃ§in deÄŸiÅŸtirdim
				/*die.roll();
				int firstRoll = die.getDiceValue();
				die.roll();
				int secondRoll = die.getDiceValue();*/
				if (roll1 > roll2) {
					/////////

					territoryTo.owner.loseTheDefend(territoryTo);
					System.out.println(player + " lose the defend.");
				} else {
					territoryFrom.owner.loseTheAttack(territoryFrom);
					System.out.println(player + " lose the attack.");
				}
				if (territoryTo.armyList.size() <= 0) {
					player.conquerTerritory(territoryTo);
					System.out.println(player + " conquer the territory.");
				}

			} else {
				System.out.println("There is a power imbalance between Territories or they are notLinked");
			}

		} else {
			System.out.println("Player doesn't own TerritoryFrom or owns TerritoryTo.");
	
		}
    }else
    {
    	System.out.println("TerritoryTo is immune");
    }

	}
    public void fortify(Player player, Territory territoryFrom, Territory territoryTo, Integer count) {
    	//Specification:
    	//@Requires: The territories' owners should be the same and territories should be adjacent or linked. The territoryFrom should have the army count as much as the parameter. 
    	//@Modifies: territoryFrom's armyList, territoryTo's armyList
    	//@Effects: If player choose to fortify, territoryFrom's armyList would decrease by the parameter and territoryTo's armyList would increase by the parameter.
    	
		if (player.getTerritoryList().contains(territoryTo) && player.getTerritoryList().contains(territoryFrom)
				&& territoryFrom.getAdjacentTerritories().contains(territoryTo)) {
			if (territoryFrom.getArmyList().size() >= count) {
				for (int i = 0; i < count; i++) {
					int index = territoryFrom.getArmyList().size() - 1;
					System.out.println(territoryFrom.getArmyList().get(index) + "is fortified from " + territoryFrom
							+ "to" + territoryTo);
					player.fortifying(territoryFrom, territoryTo, territoryFrom.getArmyList().get(index));
				}
			} else {

				System.out.println(
						"Player doesn't own TerritoryTo or TerritoryFrom or it is not adjacent to TerritoryTo");
			}

		} else {
			System.out.println("The territory has not this much army");
		}

	}
    /*public void ContinentMatch(Continent continent1, Continent continent2, Continent continent3, Continent continent4, Continent continent5, Continent continent6, Territory territory)
    {
    	if(territory.getColor().equals(Color.yellow))
    	{
    		
    	}
    }*/
    public void reinforce(int face, Territory territory, Player player) {
		if(player.getDeck().getReinforcementCardList().size()>0)
		{
			
			int faceVal = face;
			for(int i = 0; i < faceVal; i++) {
				Infantry infantry = new Infantry();
				territory.getArmyList().add(infantry);
				System.out.println("Infantry is added.");
			}
			int index = player.getDeck().getReinforcementCardList().size() - 1;
			player.getDeck().getReinforcementCardList().remove(index);
			
		}
		
	}
    public void sabotage(int face, Territory territory, Player player) {
    	if(player.getDeck().getsabotageCardList().size()>0)
		{
    	
		int faceVal = face;
		for(int i = 0; i < faceVal; i++) {
			if(territory.getArmyList().size()>0)
			{
				int index = territory.getArmyList().size() - 1;
				territory.getArmyList().remove(index);
				System.out.println("Infantry is removed!");
			}
			else
			{
				System.out.println("There is no more");
			}
			
		}
		int index = player.getDeck().getsabotageCardList().size() - 1;
		player.getDeck().getsabotageCardList().remove(index);
		
	}
	}
    public void spy(Territory territory, Player player)
    {
    	if(player.getDeck().getSpyCardList().size()>0)
		{
    	for(int i = 0; i < territory.getArmyList().size(); i++)
    	{
    		System.out.println(territory.getArmyList().get(i));
    	}
    	int index = player.getDeck().getSpyCardList().size() - 1;
		player.getDeck().getSpyCardList().remove(index);
		
	}
    }
    public void worldEvent(int face, Territory territory, ArrayList<Player> playerList, Player player) {
    	if(player.getDeck().getWorldEventCardList().size()>0)
		{
    	
    	int faceValue = face;
		if (faceValue <= 2 || faceValue == 5) {
			for(int i = 0; i < playerList.size(); i++) {
				System.out.println("Army Eklenecek Heyy :)");
				Infantry infantry = new Infantry();
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
				playerList.get(i).getTerritoryList().get(0).getArmyList().add(infantry);
			}
		}
		
		if ((faceValue <= 4) && (faceValue > 2)|| faceValue == 6) {
			for(int i = 0; i < playerList.size(); i++) {
				System.out.println("Army Çýkarýlacak :((((");
				int index = playerList.get(i).getTerritoryList().get(0).getArmyList().size() - 1;
				if(index >= 0)
				{
					playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index);
				}
				if(index >= 1)
				{
					playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 1);
				}
				if(index >= 2)
				{
					playerList.get(i).getTerritoryList().get(0).getArmyList().remove(index - 2);
				}
				
				
			}
		}
		int index = player.getDeck().getWorldEventCardList().size() - 1;
		player.getDeck().getWorldEventCardList().remove(index);
		
	}
	}
    public void disaster(Continent continent, Player player, int number) {
    	if(player.getDeck().getWorldEventCardList().size()>0)
		{
		int min = 100;
		Territory weakestTerritory = new Territory();
		
		for(int i = 0; i < continent.getTerritoryList().size(); i++) {
			if(continent.getTerritoryList().get(i).armyList.size() >= number) {
				for(int j = 0; j < number; j++) {
					int index = continent.getTerritoryList().get(i).armyList.size() -1;
					continent.getTerritoryList().get(i).armyList.remove(index);
				}
			}
		}
		for (Territory territory : continent.getTerritoryList()) {
            int count = territory.getArmyList().size();
            if (count < min) {
                min = count;
                weakestTerritory = territory;
            }
        }
		weakestTerritory.getOwner().getTerritoryList().remove(weakestTerritory);
		player.getTerritoryList().add(weakestTerritory);
		weakestTerritory.setOwner(player);
		int index = player.getDeck().getWorldEventCardList().size() - 1;
		player.getDeck().getWorldEventCardList().remove(index);
		
	}
	}
    public void immunize(Territory territory)
    {
    	territory.immunize();
    }
}
