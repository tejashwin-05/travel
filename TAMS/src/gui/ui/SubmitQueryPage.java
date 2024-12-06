package ui;

import dao.QueryDAO;
import models.Query;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitQueryPage {
    private JFrame frame;
    private User user;
    private QueryDAO queryDAO;
    private JTextArea queryTextArea;

    public SubmitQueryPage(User user, QueryDAO queryDAO) {
        this.user = user;
        this.queryDAO = queryDAO;

        frame = new JFrame("Submit Query");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel instructionsLabel = new JLabel("Enter your query below:");
        queryTextArea = new JTextArea(10, 30);
        JButton submitButton = new JButton("Submit");

        frame.add(instructionsLabel, BorderLayout.NORTH);
        frame.add(new JScrollPane(queryTextArea), BorderLayout.CENTER);
        frame.add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queryContent = queryTextArea.getText().trim();
                if (queryContent.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Query content cannot be empty!");
                    return;
                }

                Query newQuery = new Query();
                newQuery.setUserId(user.getId());
                newQuery.setContent(queryContent);

                if (queryDAO.addQuery(newQuery)) {
                    JOptionPane.showMessageDialog(frame, "Query submitted successfully!");
                    frame.setVisible(false);
                    new CustomerSupportPage(user);
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to submit query. Please try again.");
                }
            }
        });

        frame.setVisible(true);
    }
}
