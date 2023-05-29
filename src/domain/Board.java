package domain;

import java.util.ArrayList;
import java.util.List;


public class Board {
	
	private List<BoardListener> listeners = new ArrayList<>();
	
	private Die die;
	int dieValue;
	
	public Board() {
		die = new Die();
		System.out.println("board created");
		System.out.println("-----------------");
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
	
	
	public String publishBoardEvent(int dieNum) {
		 System.out.println("(domain.Board)You rolled: " + dieNum);
		 String num = Integer.toString(dieNum);
		 return num;
		/*for(BoardListener l: listeners)
			l.onBoardEvent(String.format("You rolled %d: ",
					dieNum));//, (dieNum > 7)?"You Win":"I Win"));*/
		
	}
	
	
    
}
