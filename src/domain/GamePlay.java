package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GamePlay {
    public static void sort(ArrayList<Player> list) {

        list.sort((o1, o2) -> o1.getfirstRoll().compareTo(
                o2.getfirstRoll()));
    }

    public static void main(String[] args) {
        // Controller class is created
        ConKUeror conkueror = new ConKUeror();
        ArrayList<Integer> dieValues = new ArrayList<Integer>();
        ArrayList<Integer> dieValues2 = new ArrayList<Integer>();
        Map wholeMap = new Map();
        Map enabledMap = new Map();
        Die die = new Die();
        Random rand;
        Deck deck = new Deck();

        
        // Player and AI count input is taken
        conkueror.createPlayer(2, 2);
        System.out.println(conkueror.playerList.size());
        conkueror.createTerritory(30);
        System.out.println("Should print 30:");
        System.out.println(conkueror.terList.size());

        //Players disable some territories
        conkueror.terList.get(5).disable();
        conkueror.terList.get(15).disable();
        conkueror.terList.get(25).disable();
       
        
        //Map and enabled map is created
        for(int a = 0; a < conkueror.terList.size(); a++)
        {
            if(conkueror.terList.get(a).isEnabled)
            {
                wholeMap.getTerritories().add(conkueror.terList.get(a));
            }
        }

        conkueror.setAdjacent(wholeMap);
        
        for(int b = 0; b < wholeMap.getTerritories().size(); b++)
        {
            wholeMap.checkReachability(wholeMap.getTerritories().get(b));
        }
        
        for(int c = 0; c < wholeMap.getTerritories().size(); c++)
        {
            if(wholeMap.getTerritories().get(c).isEnabled)
            {
                enabledMap.getTerritories().add(wholeMap.getTerritories().get(c));
            }
        }

        System.out.println("Should print 27:");
        System.out.println(wholeMap.getTerritories().size());
        System.out.println("Should print 27:");
        System.out.println(enabledMap.getTerritories().size());
        //main deck is created.
        conkueror.createMainDeck(5, 5, deck);
        System.out.println("Should print 5:");
        System.out.println(deck.getdipImmunityCardList().size());
        System.out.println("Should print 5:");
        System.out.println(deck.getDisasterCardList().size());
        System.out.println("Should print 5:");
        System.out.println(deck.getReinforcementCardList().size());
        System.out.println("Should print 5:");
        System.out.println(deck.getsabotageCardList().size());
        System.out.println("Should print 5:");
        System.out.println(deck.getSpyCardList().size());
        System.out.println("Should print 5:");
        System.out.println(deck.getWorldEventCardList().size());
        
        
        

        // Each player roll a die
        for (int i = 0; i < conkueror.playerList.size(); i++) {
            conkueror.playerList.get(i).getDie().roll();
            conkueror.playerList.get(i).firstRoll = conkueror.playerList.get(i).die.getDiceValue();
            dieValues.add(i, conkueror.playerList.get(i).firstRoll);
        }

        // Players turn number is sorted
        sort(conkueror.playerList);
        for (int i = 0; i< conkueror.playerList.size(); i++) {
        	conkueror.createInfantry(20, conkueror.playerList.get(i));
        	System.out.println(conkueror.playerList.get(i).getInfantryList().size());
        }
        
        //Until all territories is taken, players choose a territory(in there it is not chosen since it didn't bind)
        for (int i = 0; i < enabledMap.getTerritories().size(); i++) {

            conkueror.playerList.get(i%conkueror.playerList.size()).chooseATerritory(enabledMap.getTerritories().get(i));
            //System.out.println(i%conkueror.playerList.size() + " and " + i);
            conkueror.playerList.get(i%conkueror.playerList.size()).placeArmy(enabledMap.getTerritories().get(i),"Infantry");
        }

        System.out.println(conkueror.playerList.get(0).getInfantryList().size());
        //First Player place army to one of his/her territory 
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");
        System.out.println("Should print 4:");
        System.out.println(enabledMap.getTerritories().get(0).getArmyList().size());


        //First Player fortify army to one of his/her another territory
        conkueror.fortify(conkueror.playerList.get(0),enabledMap.getTerritories().get(0), enabledMap.getTerritories().get(4),2);
        System.out.println("Should print 1 + 2:");
        System.out.println(enabledMap.getTerritories().get(4).getArmyList().size());
        //First Player take random chance card
        deck.giveChanceCard(conkueror.playerList.get(0));
        
        System.out.println("One of them should be one, and other should be zero:");
        System.out.println(conkueror.playerList.get(0).getDeck().getdipImmunityCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getDisasterCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getReinforcementCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getsabotageCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getSpyCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getWorldEventCardList().size());
        
        System.out.println("One of them should be one, and other should be zero:");
        deck.giveArmyCard(conkueror.playerList.get(0));
        System.out.println(conkueror.playerList.get(0).getDeck().getInfantryCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getCavalryCardList().size());
        System.out.println(conkueror.playerList.get(0).getDeck().getArtilleryCardList().size());

         //First Player attack to another player
        conkueror.attack(conkueror.playerList.get(0), enabledMap.getTerritories().get(4), enabledMap.getTerritories().get(3), die);
        System.out.println("if player loses the attack, it should be 1 and cannot attack again, if player wins, it should be 3: " + enabledMap.getTerritories().get(4).getArmyList().size());
        System.out.println("if player wins the attack, they should be same " + conkueror.playerList.get(0) + " = " + enabledMap.getTerritories().get(3).owner);
        conkueror.attack(conkueror.playerList.get(0), enabledMap.getTerritories().get(4), enabledMap.getTerritories().get(3), die);
        conkueror.turnPass(0);
        
        
    }
}