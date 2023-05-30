package domain;

import java.io.Serializable;

public class SpyCard implements Serializable{
	public static void spyOn(Territory territory) {
		System.out.println(territory.army);
	}
}
