package ui;

import models.User;
import javax.swing.*;
import java.awt.*;

public class CustomerSupportPage {
    private JFrame frame;
    private User user;

    public CustomerSupportPage(User user) {
        this.user = user;
        frame = new JFrame("Customer Support");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Customer Support", JLabel.CENTER);
        JButton submitQueryButton = new JButton("Submit Query");
        JButton viewQueriesButton = new JButton("View My Queries");

        frame.add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(submitQueryButton);
        panel.add(viewQueriesButton);
        frame.add(panel, BorderLayout.CENTER);

        submitQueryButton.addActionListener(e -> {
            // Placeholder for query submission logic
            JOptionPane.showMessageDialog(frame, "Submit query functionality not implemented yet.");
        });

        viewQueriesButton.addActionListener(e -> {
            // Placeholder for viewing queries logic
            JOptionPane.showMessageDialog(frame, "View queries functionality not implemented yet.");
        });

        frame.setVisible(true);
    }
}
