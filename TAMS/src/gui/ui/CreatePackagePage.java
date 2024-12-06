package ui;

import dao.PackageDAO;
import models.Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePackagePage {
    private JFrame frame;
    private JTextField packageNameField;
    private JTextField packagePriceField;
    private JTextField packageDescriptionField;
    private PackageDAO packageDAO;

    public CreatePackagePage(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
        frame = new JFrame("Create Package");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Package Name:");
        packageNameField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        packagePriceField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description:");
        packageDescriptionField = new JTextField();
        JButton createButton = new JButton("Create Package");

        frame.add(nameLabel);
        frame.add(packageNameField);
        frame.add(priceLabel);
        frame.add(packagePriceField);
        frame.add(descriptionLabel);
        frame.add(packageDescriptionField);
        frame.add(new JLabel()); // Empty cell for alignment
        frame.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = packageNameField.getText();
                String priceStr = packagePriceField.getText();
                String description = packageDescriptionField.getText();

                if (name.isEmpty() || priceStr.isEmpty() || description.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!");
                    return;
                }

                try {
                    double price = Double.parseDouble(priceStr);
                    Package newPackage = new Package();
                    newPackage.setName(name);
                    newPackage.setPrice(price);
                    newPackage.setDescription(description);

                    if (packageDAO.addPackage(newPackage)) {
                        JOptionPane.showMessageDialog(frame, "Package created successfully!");
                        frame.setVisible(false);
                        new PackageManagementPage();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to create package. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Price must be a valid number!");
                }
            }
        });

        frame.setVisible(true);
    }
}
