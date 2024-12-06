package dao;

import models.Report;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    public boolean addReport(Report report) {
        String query = "INSERT INTO reports (title, content, generated_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, report.getTitle());
            stmt.setString(2, report.getContent());
            stmt.setString(3, report.getGeneratedDate());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM reports";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                reports.add(new Report(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("generated_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
}
