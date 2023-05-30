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
        ArrayList<Integer> dieValues = new ArrayList<Integer>();
        Map wholeMap = new Map();
        Map enabledMap = new Map();
        Die die = new Die();
        Random rand;
        Deck deck = new Deck();

        
        // Player and AI count input is taken
        conkueror.createPlayer(2, 2);
        conkueror.createTerritory(30);

        //Players disable some territories
        conkueror.terList.get(5).disable();
        conkueror.terList.get(15).disable();
        conkueror.terList.get(25).disable();

        //Map and enabled map is created
        for(int a = 0; a < conkueror.terList.size() a++)
        {
            if(conkueror.terList.get(a).isEnabled)
            {
                wholeMap.getTerritories().add(conkueror.terList.get(a));
            }
        }

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



        

        // Each player roll a die
        for (int i = 0; i < conkueror.playerList.size(); i++) {
            conkueror.playerList.get(i).die.roll();
            conkueror.playerList.get(i).firstRoll = conkueror.playerList.get(i).die.getDiceValue();
            dieValues.add(i, conkueror.playerList.get(i).firstRoll);
        }

        // Players turn number is sorted
        sort(conkueror.playerList);

        //Until all territories is taken, players choose a territory(in there it is not choosen since it didn't bind)
        for (int i = 0; i < enabledMap.getTerritories().size(); i++) {

            conkueror.playerList.get(i%conkueror.playerList.size()).chooseATerritory(enabledMap.getTerritories().get(i));
            conkueror.playerList.get(i%conkueror.playerList.size()).placeArmy(enabledMap.getTerritories().get(i),"Infantry");
        }


        //First Player place army to one of his/her territory 
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");
        conkueror.playerList.get(0).placeArmy(enabledMap.getTerritories().get(0), "Infantry");


        //First Player fortify army to one of his/her another territory
        conkueror.fortify(conkueror.playerList.get(0),enabledMap.getTerritories().get(0), enabledMap.getTerritories().get(4),2);

        //First Player take random chance card
        deck.giveChanceCard(conkueror.playerList.get(0));

         //First Player attack to another player
        conkueror.attack(conkueror.playerList.get(0), enabledMap.getTerritories().get(4), enabledMap.getTerritories().get(3), die);

        
    }
}