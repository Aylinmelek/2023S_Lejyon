package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Die {
	int faceValue;
	private List<Die> dice = new ArrayList<>();
	
	public static int generateNum() {
		Random random = new Random();
		int faceValue = random.nextInt(6);
		return faceValue+1;
	}
	
	public List<Die> getDice() {
		return dice;
	}


	public void calculateHighest() {
		
	}
	public void getFaceValue() {
		
	}
}
