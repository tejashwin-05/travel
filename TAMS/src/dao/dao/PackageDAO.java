package dao;

import models.Package;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {
    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        String query = "SELECT * FROM packages";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                packages.add(new Package(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("availability")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }
}
