package ui;

import models.User;
import javax.swing.*;
import java.awt.*;

public class AnalyticsPage {
    private JFrame frame;
    private User user;

    public AnalyticsPage(User user) {
        this.user = user;
        frame = new JFrame("Analytics Page");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Analytics Page", JLabel.CENTER);
        JButton viewReportsButton = new JButton("View Reports");
        JButton revenueTrackingButton = new JButton("Revenue & Expense Tracking");

        frame.add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(viewReportsButton);
        panel.add(revenueTrackingButton);
        frame.add(panel, BorderLayout.CENTER);

        viewReportsButton.addActionListener(e -> {
            // Placeholder for report viewing logic
            JOptionPane.showMessageDialog(frame, "View reports functionality not implemented yet.");
        });

        revenueTrackingButton.addActionListener(e -> {
            // Placeholder for revenue and expense tracking logic
            JOptionPane.showMessageDialog(frame, "Revenue and expense tracking functionality not implemented yet.");
        });

        frame.setVisible(true);
    }
}
