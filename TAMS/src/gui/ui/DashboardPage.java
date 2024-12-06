package ui;

import models.User;

import javax.swing.*;
import java.awt.*;

public class DashboardPage {
    private JFrame frame;
    private User user;

    public DashboardPage(User user) {
        this.user = user;
        frame = new JFrame("Dashboard Page");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername(), JLabel.CENTER);
        JButton packageManagementButton = new JButton("Manage Packages");
        JButton bookingButton = new JButton("Bookings");
        JButton customerSupportButton = new JButton("Customer Support");
        JButton analyticsButton = new JButton("Analytics");

        frame.add(welcomeLabel, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(packageManagementButton);
        panel.add(bookingButton);
        panel.add(customerSupportButton);
        panel.add(analyticsButton);
        frame.add(panel, BorderLayout.CENTER);

        packageManagementButton.addActionListener(e -> new PackageManagementPage());
        bookingButton.addActionListener(e -> new BookingPage(user));
        customerSupportButton.addActionListener(e -> new CustomerSupportPage(user));
        analyticsButton.addActionListener(e -> new AnalyticsPage(user));

        frame.setVisible(true);
    }
}
