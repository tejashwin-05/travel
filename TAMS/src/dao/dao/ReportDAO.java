package dao;

import models.Report;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String querySQL = "SELECT * FROM reports";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Report report = new Report();
                report.setId(rs.getInt("id"));
                report.setTitle(rs.getString("title"));
                report.setDateCreated(rs.getTimestamp("date_created"));
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public double getTotalRevenue(int userId) {
        double totalRevenue = 0.0;
        String querySQL = "SELECT SUM(amount) FROM transactions WHERE user_id = ? AND type = 'revenue'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalRevenue = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }

    public double getTotalExpenses(int userId) {
        double totalExpenses = 0.0;
        String querySQL = "SELECT SUM(amount) FROM transactions WHERE user_id = ? AND type = 'expense'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalExpenses = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalExpenses;
    }
}
