package domain;

import java.io.Serializable;

public class DiplomaticImmunityCard implements Serializable{
	public void immunizeTerritory(Territory territory) {
		territory.immunize();
	}
}
