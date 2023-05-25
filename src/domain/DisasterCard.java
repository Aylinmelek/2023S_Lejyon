package domain;

import java.util.ArrayList;

import domain.cardService.DisasterCardServiceAdapter;
import domain.cardService.ICardServiceAdapter;



public class DisasterCard {//implements Changable {//extends DisasterAdapter{
	//implements Changable'ı sildim çünkü onun yerine 
	//ICardServiceAdapter interface'i ekledim.
	//Changable ile aynı
	Continent continent;
	Player player;
	int number;
	ArrayList<Player> playerList;
	
	
public void disaster(ICardServiceAdapter cardService) { //remove army olucak ismi. parametrelere bak
	cardService.removeArmy(null, null, continent, player, number, playerList);
}




}
