package ui;

import dao.UserDAO;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField phoneField;
    private UserDAO userDAO;

    public RegisterPage() {
        frame = new JFrame("Register Page");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));
        userDAO = new UserDAO();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        JButton registerButton = new JButton("Register");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(new JLabel()); // Empty cell for alignment
        frame.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                String phone = phoneField.getText();

                // Simple validation
                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!");
                    return;
                }

                User newUser = new User(0, phone, phone, phone, phone);
                newUser.setUsername(username);
                newUser.setPassword(password);
                newUser.setEmail(email);
                newUser.setRole(phone);

                if (userDAO.addUser(newUser)) {
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                    frame.setVisible(false);
                    new LoginPage(); // Redirect to login page after registration
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration failed. Please try again.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterPage();
    }
}
