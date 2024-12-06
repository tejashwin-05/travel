package ui;

import dao.PackageDAO;
import models.Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PackageManagementPage {
    private JFrame frame;
    private PackageDAO packageDAO;

    public PackageManagementPage() {
        frame = new JFrame("Manage Packages");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        packageDAO = new PackageDAO();

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createPackageButton = new JButton("Create Package");
        JButton viewPackageButton = new JButton("View Packages");

        buttonPanel.add(createPackageButton);
        buttonPanel.add(viewPackageButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        // Create package functionality
        createPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new CreatePackagePage(packageDAO);
            }
        });

        // View package functionality
        viewPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ViewPackagesPage(packageDAO);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PackageManagementPage();
    }
}
