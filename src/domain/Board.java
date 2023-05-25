package domain;

import java.util.ArrayList;
import java.util.List;


public class Board {
	
	private List<BoardListener> listeners = new ArrayList<>();
	
	private Die die;
	int dieValue;
	
	public Board() {
		die = new Die();
		System.out.println("geliyo mu board'a");
	}
	
	public void rollDice() {
		die.roll();
		//publishBoardEvent();
		
	}
	
	public int getDiceValue() {
		return die.getDiceValue();
	}
	
	public void addBoardListener(BoardListener lis) {
		listeners.add(lis);
	}
	
	
	public void publishBoardEvent(int dieNum) {
		 System.out.println("(domain.Board)You rolled: " + dieNum);
		/*for(BoardListener l: listeners)
			l.onBoardEvent(String.format("You rolled %d: ",
					dieNum));//, (dieNum > 7)?"You Win":"I Win"));*/
		
	}
	
	
    
}
