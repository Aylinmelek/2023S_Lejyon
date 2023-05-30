package TechnicalServices;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SaveLoad {
    public enum SignUpStatus {
        SUCCESSFUL,
        INVALID_USERNAME,
        USERNAME_IN_USE,
        INVALID_PASSWORD,
        PASSWORDS_DIFFERENT,
        OTHER_ERROR;

        private SignUpStatus() {

        }
    }

    ISaveLoadAdapter saveLoadFileAdapter = new SaveLoadFileAdapter();
    ISaveLoadAdapter saveLoadDatabaseAdapter = new SaveLoadDatabaseAdapter();
    ISaveLoadAdapter saveLoadAdapter;

    private MessageDigest messageDigest;

    private String playerInfoFile = "project/UserInfo.txt";
    private Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_]{4,16}$");
    private Pattern passwordPattern = Pattern.compile("^[a-zA-Z0-9_]{4,16}$");

    private static SaveLoad instance;
    private Timestamp timestamp;
    
    private SaveLoad() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static SaveLoad getInstance() {
        if (instance == null)
            instance = new SaveLoad();
        return instance;
    }

    private String encrypt(String plainText) {
        byte[] digest = messageDigest.digest(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(digest);
    }

    public boolean saveGame(String username, String saveName, ArrayList<String> data ,boolean toDatabase) {
        if (username.isEmpty()) {
            return false;
        }
        timestamp = new Timestamp(System.currentTimeMillis());
        String savedGameId = username + timestamp.toString();
        if (toDatabase) {
            saveLoadAdapter = saveLoadDatabaseAdapter;
        } else {
            saveLoadAdapter = saveLoadFileAdapter;
        }
        if (saveLoadAdapter.saveGame(savedGameId, data)) {
            addGameToUsersSavedGames(username, saveName, savedGameId);
        }
        return true;
    }

    private boolean addGameToUsersSavedGames(String username, String saveName, String savedGameId) {
        ArrayList<ArrayList<String>> playerInfoArray = SaveLoadFile.readDataFromFile(playerInfoFile);
        saveName += ",";
        saveName += savedGameId;
        for (ArrayList<String> playerInfo : playerInfoArray) {
            if (playerInfo.get(0).equals(username)) {
                playerInfo.add(saveName);
            }
        }
        return SaveLoadFile.saveAllDataToFile(playerInfoFile, playerInfoArray);
    }

    public HashMap<String, String> loadAllGamesByUser(String username) {
        if (username.isEmpty()) {
            return null;
        }
        HashMap<String, String> playerSavedGames = new HashMap<>();
        ArrayList<ArrayList<String>> playerInfoArray = SaveLoadFile.readDataFromFile(playerInfoFile);
        for (ArrayList<String> playerInfo : playerInfoArray) {
            if (playerInfo.get(0).equals(username)) {
                for (String element : playerInfo.subList(2, playerInfo.size())) {
                    String[] parts = element.split(",");
                    playerSavedGames.put(parts[0], parts[1]);
                }
            }
        }
        return playerSavedGames;
    }

    public ArrayList<String> loadGame(String gameId) {
        ArrayList<String> gameData = saveLoadFileAdapter.loadGame(gameId);
        if (gameData != null)
            return gameData;
        return saveLoadDatabaseAdapter.loadGame(gameId);
    }

    private ArrayList<String> getUsernames() {
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<ArrayList<String>> playerInfoArray = SaveLoadFile.readDataFromFile(playerInfoFile);
        for (ArrayList<String> playerInfo : playerInfoArray) {
            usernames.add(playerInfo.get(0));
        }
        return usernames;
    }

    private boolean addNewUser(String username, String password) {
        ArrayList<String> userInfo = new ArrayList<>();
        userInfo.add(username);
        userInfo.add(encrypt(password));
        return SaveLoadFile.saveDataToFile(playerInfoFile, userInfo);
    }

    public SignUpStatus tryAddingNewUser(String username, String password, String passwordCheck) {
        if (!checkValidUsername(username))
            return SignUpStatus.INVALID_USERNAME;
        if (!checkNewUsername(username))
            return SignUpStatus.USERNAME_IN_USE;
        if (!checkValidPassword(password))
            return SignUpStatus.INVALID_PASSWORD;
        if (!checkValidPassword(passwordCheck))
            return SignUpStatus.PASSWORDS_DIFFERENT;
        if (!passwordCheck.equals(password))
            return SignUpStatus.PASSWORDS_DIFFERENT;
        if(addNewUser(username, password))
            return SignUpStatus.SUCCESSFUL;
        return SignUpStatus.OTHER_ERROR;
    }

    public boolean checkValidUsername(String username) {
        Matcher matcher = usernamePattern.matcher(username);
        return matcher.matches();
    }

    public boolean checkValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public boolean checkNewUsername(String username) {
        ArrayList<String> usernames = getUsernames();
        for (String name : usernames) {
            if (name.equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLogIn(String username, String password) {
        if (username.isEmpty()) {
            return true;
        }
        if (!checkValidUsername(username) || !checkValidPassword(password)) {
            return false;
        }
        ArrayList<ArrayList<String>> playerInfoArray = SaveLoadFile.readDataFromFile(playerInfoFile);
        for (ArrayList<String> playerInfo : playerInfoArray) {
            if (playerInfo.get(0).equals(username)) {
                return playerInfo.get(1).equals(encrypt(password));
            }
        }
        return false;
    }
}
