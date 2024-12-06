package ui;

import dao.PackageDAO;
import models.Package;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewPackagesPage {
    private JFrame frame;
    private PackageDAO packageDAO;

    public ViewPackagesPage(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
        frame = new JFrame("View Packages");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        List<Package> packages = packageDAO.getAllPackages();
        if (packages.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No packages available.");
            frame.setVisible(false);
            new PackageManagementPage();
            return;
        }

        String[] columnNames = {"ID", "Name", "Price", "Description"};
        Object[][] data = new Object[packages.size()][4];
        for (int i = 0; i < packages.size(); i++) {
            Package p = packages.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getName();
            data[i][2] = p.getPrice();
            data[i][3] = p.getDescription();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            new PackageManagementPage();
        });

        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
