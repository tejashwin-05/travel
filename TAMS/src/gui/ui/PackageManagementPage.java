package ui;

import models.User;
import javax.swing.*;
import java.awt.*;

public class PackageManagementPage {
    private JFrame frame;
    private User user;

    public PackageManagementPage(User user) {
        this.user = user;
        frame = new JFrame("Package Management");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Package Management", JLabel.CENTER);
        JButton createPackageButton = new JButton("Create Package");
        JButton viewPackagesButton = new JButton("View Packages");

        frame.add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.add(createPackageButton);
        panel.add(viewPackagesButton);
        frame.add(panel, BorderLayout.CENTER);

        createPackageButton.addActionListener(e -> {
            // Placeholder for package creation logic
            JOptionPane.showMessageDialog(frame, "Package creation functionality not implemented yet.");
        });

        viewPackagesButton.addActionListener(e -> {
            // Placeholder for viewing packages logic
            JOptionPane.showMessageDialog(frame, "View packages functionality not implemented yet.");
        });

        frame.setVisible(true);
    }
}
