package ui;

import dao.ReportDAO;
import models.Report;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AnalyticsPage {
    private JFrame frame;
    private User user;
    private ReportDAO reportDAO;

    public AnalyticsPage(User user) {
        this.user = user;
        this.reportDAO = new ReportDAO();

        frame = new JFrame("Analytics");
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        // Create buttons for viewing reports and revenue/expense tracking
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton viewReportsButton = new JButton("View Reports");
        JButton revenueExpenseButton = new JButton("Revenue/Expense Tracking");

        buttonPanel.add(viewReportsButton);
        buttonPanel.add(revenueExpenseButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        // View reports functionality
        viewReportsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Report> reports = reportDAO.getAllReports();
                if (reports.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No reports available.");
                    return;
                }

                // Display reports in a table
                String[] columnNames = {"Report ID", "Title", "Date Created"};
                Object[][] data = new Object[reports.size()][3];
                for (int i = 0; i < reports.size(); i++) {
                    Report report = reports.get(i);
                    data[i][0] = report.getId();
                    data[i][1] = report.getTitle();
                    data[i][2] = report.getDateCreated();
                }

                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame reportFrame = new JFrame("Reports");
                reportFrame.setSize(600, 400);
                reportFrame.add(scrollPane, BorderLayout.CENTER);
                reportFrame.setVisible(true);
            }
        });

        // Revenue/Expense Tracking functionality
        revenueExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RevenueExpenseTrackingPage(user, reportDAO);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Sample user for testing, replace with actual login handling
        User testUser = new User(0, null, null, null, null);
        testUser.setId(1); // Replace with actual user ID
        new AnalyticsPage(testUser);
    }
}
