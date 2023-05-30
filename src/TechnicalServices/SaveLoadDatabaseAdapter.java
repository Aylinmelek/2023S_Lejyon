package TechnicalServices;

import java.util.ArrayList;

public class SaveLoadDatabaseAdapter implements ISaveLoadAdapter {
    private static String savedGamesUrl = "jdbc:sqlserver://localhost:3306;database=lejyon2023;integratedSecurity=true";
    private static String tableName = "savedGames";

    @Override
    public boolean saveGame(String gameId, ArrayList<String> data) {
        return SaveLoadDatabase.saveDataToDatabase(savedGamesUrl, tableName, gameId, data);
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
        return SaveLoadDatabase.readDataFromDatabase(savedGamesUrl, tableName);
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
