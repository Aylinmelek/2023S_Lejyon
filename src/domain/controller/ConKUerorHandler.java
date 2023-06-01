package domain.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.Board;
import domain.Die;

public class ConKUerorHandler {
	
private Board board;
private static Board board2; // database saving için tanımladım
private static ConKUerorHandler instance;
	
	public ConKUerorHandler(Board board) {
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
	
	public static ConKUerorHandler getInstance() {
		if (instance == null)
			board2 = new Board();
			instance = new ConKUerorHandler(board2);
		return instance;
	}
	



}
