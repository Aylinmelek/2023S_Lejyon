package TechnicalServices;

import java.util.ArrayList;

public interface ISaveLoadAdapter {
    public boolean saveGame(String name, ArrayList<String> data);
    public ArrayList<String> loadGame(String name);
    public ArrayList<ArrayList<String>> loadAllGames();
    public ArrayList<ArrayList<String>> loadAllGamesByUser(String username);
}
