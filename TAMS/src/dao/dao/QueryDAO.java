package dao;

import models.Query;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {

    public boolean addQuery(Query query) {
        String querySQL = "INSERT INTO queries (user_id, content, date_submitted) VALUES (?, ?, NOW())";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setInt(1, query.getUserId());
            stmt.setString(2, query.getContent());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Query> getQueriesByUserId(int userId) {
        List<Query> queries = new ArrayList<>();
        String querySQL = "SELECT * FROM queries WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Query query = new Query();
                query.setId(rs.getInt("id"));
                query.setUserId(rs.getInt("user_id"));
                query.setContent(rs.getString("content"));
                query.setDateSubmitted(rs.getDate("date_submitted"));
                queries.add(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }
}
