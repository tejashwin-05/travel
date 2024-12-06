package dao;

import models.Package;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {

    public boolean addPackage(Package pkg) {
        String query = "INSERT INTO packages (name, price, description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pkg.getName());
            stmt.setDouble(2, pkg.getPrice());
            stmt.setString(3, pkg.getDescription());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        String query = "SELECT * FROM packages";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Package pkg = new Package();
                pkg.setId(rs.getInt("id"));
                pkg.setName(rs.getString("name"));
                pkg.setPrice(rs.getDouble("price"));
                pkg.setDescription(rs.getString("description"));
                packages.add(pkg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }
}
