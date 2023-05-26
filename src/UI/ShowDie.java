package UI;

import domain.Board;
import domain.BoardListener;

public class ShowDie implements BoardListener {
	public ShowDie(Board board) {
		board.addBoardListener(this);
	}
	
	private void showDie() {
		System.out.println("Die rolled...");
	}

	@Override
	public void onBoardEvent(String value) {
		showDie();
	}

	
}