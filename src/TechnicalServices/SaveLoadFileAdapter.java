package TechnicalServices;

import java.util.ArrayList;

public class SaveLoadFileAdapter implements ISaveLoadAdapter {
    private String savedGamesFile = "/SavedGames.txt";

    @Override
    public boolean saveGame(String name, ArrayList<String> data) {
        data.add(0, name);
        return SaveLoadFile.saveDataToFile(savedGamesFile, data);
    }

    @Override
    public ArrayList<String> loadGame(String name) {
        ArrayList<ArrayList<String>> allGames = loadAllGames();
        for (ArrayList<String> game : allGames) {
            if (game.get(0).equals(name)) {
                return game;
            }
        }
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> loadAllGames() {
        return SaveLoadFile.readDataFromFile(savedGamesFile);
    }

    @Override
    public ArrayList<ArrayList<String>> loadAllGamesByUser(String username) {
        ArrayList<ArrayList<String>> allGames = loadAllGames();
        ArrayList<ArrayList<String>> allGamesByUser = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> game : allGames) {
            String name = game.get(0);
            if (name.substring(0, name.length()-23).equals(username)) {
                allGamesByUser.add(game);
            }
        }
        return allGamesByUser;
    }
}
