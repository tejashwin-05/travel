package ui;

import dao.BookingDAO;
import models.Booking;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewBookingsPage {
    private JFrame frame;
    private User user;
    private BookingDAO bookingDAO;

    public ViewBookingsPage(User user, BookingDAO bookingDAO) {
        this.user = user;
        this.bookingDAO = bookingDAO;

        frame = new JFrame("View My Bookings");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        List<Booking> bookings = bookingDAO.getBookingsByUserId(user.getId());
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "You have no bookings.");
            frame.setVisible(false);
            new BookingPage(user);
            return;
        }

        String[] columnNames = {"Booking ID", "Package ID", "Booking Date"};
        Object[][] data = new Object[bookings.size()][3];
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            data[i][0] = b.getId();
            data[i][1] = b.getPackageId();
            data[i][2] = b.getBookingDate();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            new BookingPage(user);
        });

        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
