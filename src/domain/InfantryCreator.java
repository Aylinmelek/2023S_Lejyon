package domain;

public class InfantryCreator {
    
    public void createInfantry(int number, Player player) {
		for (int i = 0; i < number; i++) {
			Infantry infantry = new Infantry();
			player.getInfantryList().add(infantry);
		}
	}
}
