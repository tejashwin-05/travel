package ui;

import dao.QueryDAO;
import models.Query;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewQueriesPage {
    private JFrame frame;
    private User user;
    private QueryDAO queryDAO;

    public ViewQueriesPage(User user, QueryDAO queryDAO) {
        this.user = user;
        this.queryDAO = queryDAO;

        frame = new JFrame("View My Queries");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        List<Query> queries = queryDAO.getQueriesByUserId(user.getId());
        if (queries.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "You have no queries.");
            frame.setVisible(false);
            new CustomerSupportPage(user);
            return;
        }

        String[] columnNames = {"Query ID", "Content", "Date Submitted"};
        Object[][] data = new Object[queries.size()][3];
        for (int i = 0; i < queries.size(); i++) {
            Query q = queries.get(i);
            data[i][0] = q.getId();
            data[i][1] = q.getContent();
            data[i][2] = q.getDateSubmitted();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            new CustomerSupportPage(user);
        });

        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
