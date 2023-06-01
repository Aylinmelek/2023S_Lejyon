package database;

import UI.*;

import domain.AdapterRecord;
import domain.Army;
import domain.Continent;
import domain.Map;
import domain.Player;
import domain.Territory;

import java.awt.Color;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MapRecordDB implements AdapterRecord {
    
    String url = "jdbc:sqlserver://localhost:1433;database=lejyon2023;integratedSecurity=true";
    String user = "root";
    String password = "Zeynepaydin20";

    
    public void saveTheMapDB(Map map) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();

            for (Territory territory : map.getTerritories()) {
                String SQL = "INSERT INTO Territories(name, armyList, owner) VALUES (?, ?, ?)";

                PreparedStatement pstmt = connection.prepareStatement(SQL);

                // This assumes that the Territory class has getName(), getArmyList() and getOwner() methods
                pstmt.setString(1, territory.getName());
                pstmt.setString(2, territory.getArmyList().toString()); // This assumes that armyList can be represented as a string. Usually, this would be a foreign key to an Armies table
                pstmt.setString(3, territory.getOwner().toString()); // This assumes that owner can be represented as a string. Usually, this would be a foreign key to a Players table

                pstmt.executeUpdate();
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public void loadTheMapDB(Map map) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();

            String SQL = "SELECT * FROM Territories";
            ResultSet rs = stmt.executeQuery(SQL);

            ArrayList<Territory> territories = new ArrayList<>();
            while (rs.next()) {
                Territory territory = new Territory();
                territory.setName(rs.getString("territory_name"));
                territory.setColor(Color.decode(rs.getString("territory_color")));  // assuming the color is stored as a hex string
                territory.setIndex(rs.getInt("territory_index"));
                territories.add(territory);
            }

            map.setTerritories(territories);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void saveTheContinentsDB(Map map) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Continents (continent_name) VALUES (?)");

            for (Continent continent : map.getContinents()) {
                //pstmt.setString(1, continent.getText());
                pstmt.executeUpdate();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadTheContinentsDB(Map map) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();

            String SQL = "SELECT * FROM Continents";
            ResultSet rs = stmt.executeQuery(SQL);

            ArrayList<Continent> continents = new ArrayList<>();
            while (rs.next()) {
                Continent continent = new Continent();
                continents.add(continent);
            }

            map.setContinents(continents);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods...
}
