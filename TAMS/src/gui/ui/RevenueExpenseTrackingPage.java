package ui;

import dao.ReportDAO;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevenueExpenseTrackingPage {
    private JFrame frame;
    private User user;
    private ReportDAO reportDAO;

    public RevenueExpenseTrackingPage(User user, ReportDAO reportDAO) {
        this.user = user;
        this.reportDAO = reportDAO;

        frame = new JFrame("Revenue/Expense Tracking");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(3, 2));

        JLabel revenueLabel = new JLabel("Total Revenue:");
        JLabel expenseLabel = new JLabel("Total Expenses:");
        JLabel revenueValue = new JLabel("$0.00");
        JLabel expenseValue = new JLabel("$0.00");

        // Fetch and display revenue and expense data
        double totalRevenue = reportDAO.getTotalRevenue(user.getId());
        double totalExpenses = reportDAO.getTotalExpenses(user.getId());

        revenueValue.setText("$" + String.format("%.2f", totalRevenue));
        expenseValue.setText("$" + String.format("%.2f", totalExpenses));

        frame.add(revenueLabel);
        frame.add(revenueValue);
        frame.add(expenseLabel);
        frame.add(expenseValue);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AnalyticsPage(user);
            }
        });

        frame.add(backButton);
        frame.setVisible(true);
    }
}
