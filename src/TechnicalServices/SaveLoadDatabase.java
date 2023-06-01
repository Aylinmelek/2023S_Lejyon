package TechnicalServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SaveLoadDatabase {

    public static boolean saveDataToDatabase(String url, String tableName, String gameId, ArrayList<String> data) {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String result = data.stream().collect(Collectors.joining(";"));
            String statementString = "INSERT INTO " + tableName + " VALUES ('" + gameId + "', '" + result + "')";
            int countUpdated = statement.executeUpdate(statementString);
            if (countUpdated > 0)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<ArrayList<String>> readDataFromDatabase(String url, String tableName) {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String statementString = "SELECT * FROM " + tableName;
            ResultSet result = statement.executeQuery(statementString);
            while (result.next()) {
                String gameId = result.getString("GameId");
                String dataString = result.getString("GameData");
                ArrayList<String> dataArray = new ArrayList<String>(Arrays.asList(dataString.split(";")));
                dataArray.add(0, gameId);
                data.add(dataArray);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
