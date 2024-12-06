package dao;

import models.Feedback;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public boolean addFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (user_id, comments, rating) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, feedback.getUserId());
            stmt.setString(2, feedback.getComments());
            stmt.setInt(3, feedback.getRating());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                feedbacks.add(new Feedback(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("comments"),
                        rs.getInt("rating")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
