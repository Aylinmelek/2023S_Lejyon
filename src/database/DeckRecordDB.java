package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import domain.AdapterRecord;
import domain.ArtilleryCard;
import domain.Card;
import domain.CavalryCard;
// ...
import domain.Deck;
import domain.InfantryCard;

public class DeckRecordDB implements AdapterRecord {
    // ...128.0.0.0
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=lejyon2023;integratedSecurity=true";
    private static final String USER = "root";
    private static final String PASS = "Zeynepaydin20";
    Gson gson = new Gson();

    public void saveTheDeckDB(Deck deck) {
        try (Connection conn = DriverManager.getConnection(URL)) {

            // Create a prepared statement for inserting data
            String sql = "INSERT INTO card_lists(infantry_cardlist, artillery_cardlist, cavalry_cardlist, territory_cardlist) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gson.toJson(deck.getInfantryCardList()));
            pstmt.setString(2, gson.toJson(deck.getArtilleryCardList()));
            pstmt.setString(3, gson.toJson(deck.getCavalryCardList()));
            pstmt.setString(4, gson.toJson(deck.getTerritoryCardList()));

            // Execute the statement
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // ... Similarly implement loadTheTDeckDB() here ...
    public Deck loadTheDeckDB() {
    	Deck deck = new Deck();
        try (Connection conn = DriverManager.getConnection(URL)) {

            // Create a prepared statement for inserting data
            String sql = "SELECT * FROM card_lists WHERE condition";


            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gson.toJson(deck.getInfantryCardList()));
            pstmt.setString(2, gson.toJson(deck.getArtilleryCardList()));
            pstmt.setString(3, gson.toJson(deck.getCavalryCardList()));
            pstmt.setString(4, gson.toJson(deck.getTerritoryCardList()));

            // Execute the statement
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return deck;
    }


    public void loadTheTDeckDB(Deck deck) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            // Create a prepared statement for selecting data
            String sql = "SELECT * FROM card_lists WHERE condition";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Type type = new TypeToken<ArrayList<Card>>(){}.getType();
                deck.setTerritoryCardList(gson.fromJson(rs.getString("column4"), type));

                Type typeInfantry = new TypeToken<ArrayList<InfantryCard>>(){}.getType();
                deck.setInfantryCardList(gson.fromJson(rs.getString("column1"), typeInfantry));

                Type typeCavalry = new TypeToken<ArrayList<CavalryCard>>(){}.getType();
                deck.setCavalryCardList(gson.fromJson(rs.getString("column2"), typeCavalry));

                Type typeArtillery = new TypeToken<ArrayList<ArtilleryCard>>(){}.getType();
                deck.setArtilleryCardList(gson.fromJson(rs.getString("column3"), typeArtillery));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
