package ui;

import dao.UserDAO;
import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserDAO userDAO;

    public LoginPage() {
        frame = new JFrame("Login Page");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));
        userDAO = new UserDAO();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                User user = userDAO.authenticate(username, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    frame.setVisible(false);
                    new DashboardPage(user);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RegisterPage();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
