package domain.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Board;
import domain.Die;

public class conKUerorHandler {
	
private Board board;
	
	public conKUerorHandler(Board board) {
		this.board = board;
	}
	
	
	public void rollDice() {
	
		board.rollDice();
		
	}
	
	public Board getBoard() {
		return board;
	}
	
	public String getWinner() {
		return String.format("You rolled %d:  %s",
				             board.getDiceValue());//, (board.getDiceValue() > 7)?"You Win":"I Win");
	}
	
	public int getDieValue() {
		return board.getDiceValue();
	}
	



}
