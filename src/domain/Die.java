package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Die {
	int faceValue;
	public ArrayList<Integer> dice = new ArrayList<>();
	
	//yeni ekledim
	private static final int MAXVALUE=6;
	private int dice1;
	private int dice2;
	//public int high_index;
	
	Random rand;
	
	
	
	public Die() {
		rand = new Random();
	}
	public void setFaceValue() {
		
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


	public int calculateHighest(ArrayList<Integer> arrlist) {
		int highest = arrlist.get(0);  // Assume first element is the highest

        for(int number : arrlist) {
            if(number > highest) {
                highest = number;  // Update the highest number
                
               
            }
        }
        
		return highest;
	}
	
	
	public int calcHighIndex(ArrayList<Integer> arrlist) {
		int highest = arrlist.get(0);  // Assume first element is the highest
		int high_index = 0;
        for(int number : arrlist) {
            if(number > highest) {
                highest = number;  // Update the highest number
                high_index = (arrlist.indexOf(highest));
               
            }
        }
        
		return high_index;
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
