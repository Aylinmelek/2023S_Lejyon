package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Die {
	int faceValue;
	public ArrayList<Integer> dice = new ArrayList<>();
	
	//yeni ekledim
	private static final int MAXVALUE=6;
	private int dice1;
	private int dice2;
	Random rand;
	
	
	
	public Die() {
		rand = new Random();
	}
	///////////////
	
	/*public int generateNum() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue+1;
	}*/
	
	
	//public List<Die> getDice() {
	//	return dice;
	//}


	public void calculateHighest() {
		
	}
	public void getFaceValue() {
		
	}
	
	//yeni ekledim
	public void roll() {
		dice1 = rand.nextInt(MAXVALUE)+1;
		//dice2 = rand.nextInt(MAXVALUE)+1;
	}
	
	public int getDiceValue() {
		return dice1;
		//return dice1+dice2;
	}
	///////////
}
