package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

import models.Booking;

public class BookingDAO {
    public boolean addBooking(Booking booking) {
        String query = "INSERT INTO bookings (user_id, package_id, booking_date, payment_status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getPackageId());
            stmt.setString(3, booking.getBookingDate());
            stmt.setString(4, booking.getPaymentStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("package_id"),
                        rs.getString("booking_date"),
                        rs.getString("payment_status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
