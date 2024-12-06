package ui;

import dao.BookingDAO;
import models.Booking;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookingPage {
    private JFrame frame;
    private User user;
    private BookingDAO bookingDAO;

    public BookingPage(User user) {
        this.user = user;
        bookingDAO = new BookingDAO();

        frame = new JFrame("Booking Page");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create buttons for creating a booking and viewing bookings
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createBookingButton = new JButton("Create Booking");
        JButton viewBookingsButton = new JButton("View My Bookings");

        buttonPanel.add(createBookingButton);
        buttonPanel.add(viewBookingsButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        // Create booking functionality
        createBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new CreateBookingPage(user, bookingDAO);
            }
        });

        // View bookings functionality
        viewBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ViewBookingsPage(user, bookingDAO);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Sample user for testing, replace with actual login handling
        User testUser = new User(0, null, null, null, null);
        testUser.setId(1); // Replace with actual user ID
        new BookingPage(testUser);
    }
}
