package ui;

import dao.BookingDAO;
import models.Booking;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBookingPage {
    private JFrame frame;
    private User user;
    private BookingDAO bookingDAO;
    private JTextField packageIdField;
    private JTextField bookingDateField;

    public CreateBookingPage(User user, BookingDAO bookingDAO) {
        this.user = user;
        this.bookingDAO = bookingDAO;

        frame = new JFrame("Create Booking");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        JLabel packageIdLabel = new JLabel("Package ID:");
        packageIdField = new JTextField();
        JLabel bookingDateLabel = new JLabel("Booking Date (YYYY-MM-DD):");
        bookingDateField = new JTextField();
        JButton createBookingButton = new JButton("Create Booking");

        frame.add(packageIdLabel);
        frame.add(packageIdField);
        frame.add(bookingDateLabel);
        frame.add(bookingDateField);
        frame.add(new JLabel()); // Empty cell for alignment
        frame.add(createBookingButton);

        createBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageIdStr = packageIdField.getText();
                String bookingDate = bookingDateField.getText();

                if (packageIdStr.isEmpty() || bookingDate.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!");
                    return;
                }

                try {
                    int packageId = Integer.parseInt(packageIdStr);
                    Booking newBooking = new Booking();
                    newBooking.setUserId(user.getId());
                    newBooking.setPackageId(packageId);
                    newBooking.setBookingDate(bookingDate);

                    if (bookingDAO.addBooking(newBooking)) {
                        JOptionPane.showMessageDialog(frame, "Booking created successfully!");
                        frame.setVisible(false);
                        new BookingPage(user);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to create booking. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Package ID must be a valid number!");
                }
            }
        });

        frame.setVisible(true);
    }
}
