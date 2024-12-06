package dao;

import models.Booking;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public boolean addBooking(Booking booking) {
        String query = "INSERT INTO bookings (user_id, package_id, booking_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getPackageId());
            stmt.setString(3, booking.getBookingDate());
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
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setPackageId(rs.getInt("package_id"));
                booking.setBookingDate(rs.getString("booking_date"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
