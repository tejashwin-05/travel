package ui;

import dao.QueryDAO;
import models.Query;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerSupportPage {
    private JFrame frame;
    private User user;
    private QueryDAO queryDAO;

    public CustomerSupportPage(User user) {
        this.user = user;
        this.queryDAO = new QueryDAO();

        frame = new JFrame("Customer Support");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create buttons for submitting a query and viewing queries
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton submitQueryButton = new JButton("Submit Query");
        JButton viewQueriesButton = new JButton("View My Queries");

        buttonPanel.add(submitQueryButton);
        buttonPanel.add(viewQueriesButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        // Submit query functionality
        submitQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SubmitQueryPage(user, queryDAO);
            }
        });

        // View queries functionality
        viewQueriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ViewQueriesPage(user, queryDAO);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Sample user for testing, replace with actual login handling
        User testUser = new User(0, null, null, null, null);
        testUser.setId(1); // Replace with actual user ID
        new CustomerSupportPage(testUser);
    }
}
