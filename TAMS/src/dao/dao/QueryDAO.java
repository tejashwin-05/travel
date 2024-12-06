package dao;

import models.Query;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {
    public boolean addQuery(Query query) {
        String queryStr = "INSERT INTO queries (user_id, message, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryStr)) {
            stmt.setInt(1, query.getUserId());
            stmt.setString(2, query.getMessage());
            stmt.setString(3, query.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Query> getAllQueries() {
        List<Query> queries = new ArrayList<>();
        String queryStr = "SELECT * FROM queries";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryStr)) {
            while (rs.next()) {
                queries.add(new Query(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("message"),
                        rs.getString("status")
                ));
            }

        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }
}
