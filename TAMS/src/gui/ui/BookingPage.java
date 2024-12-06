package ui;

import models.User;
import javax.swing.*;
import java.awt.*;

public class BookingPage {
    private JFrame frame;
    private User user;

    public BookingPage(User user) {
        this.user = user;
        frame = new JFrame("Booking Page");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Booking Page", JLabel.CENTER);
        JButton createBookingButton = new JButton("Create Booking");
        JButton viewBookingsButton = new JButton("View My Bookings");

        frame.add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(createBookingButton);
        panel.add(viewBookingsButton);
        frame.add(panel, BorderLayout.CENTER);

        createBookingButton.addActionListener(e -> {
            // Placeholder for booking creation logic
            JOptionPane.showMessageDialog(frame, "Create booking functionality not implemented yet.");
        });

        viewBookingsButton.addActionListener(e -> {
            // Placeholder for viewing bookings logic
            JOptionPane.showMessageDialog(frame, "View bookings functionality not implemented yet.");
        });

        frame.setVisible(true);
    }
}
