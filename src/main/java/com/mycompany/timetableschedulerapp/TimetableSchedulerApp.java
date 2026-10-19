package com.mycompany.timetableschedulerapp;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TimetableSchedulerApp {

    private static final Map<String, String> users = new HashMap<>();
    private static JFrame frame;
    private static JTextField txtUser;
    private static JPasswordField txtPass;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> createLoginPage());
    }

    private static void createLoginPage() {
        frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Timetable Scheduler", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));

        JLabel userLabel = new JLabel("Username:");
        txtUser = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        txtPass = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnSignup = new JButton("Sign Up");
        JButton btnContact = new JButton("Contact Us");

        btnLogin.addActionListener(e -> loginUser());
        btnSignup.addActionListener(e -> signupUser());
        btnContact.addActionListener(e -> contactUs());

        panel.add(title);
        panel.add(userLabel);
        panel.add(txtUser);
        panel.add(passLabel);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(btnSignup);
        panel.add(btnContact);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private static void loginUser() {
        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter username and password.");
            return;
        }

        if (users.containsKey(username) && users.get(username).equals(password)) {
            createHomePage(username);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
        }
    }

    private static void signupUser() {
        String username = JOptionPane.showInputDialog(frame, "Enter username:");
        if (username == null || username.trim().isEmpty()) {
            return;
        }

        String email = JOptionPane.showInputDialog(frame, "Enter email:");
        if (email == null || email.trim().isEmpty()) {
            return;
        }

        String password = JOptionPane.showInputDialog(frame, "Enter password:");
        if (password == null || password.trim().isEmpty()) {
            return;
        }

        if (users.containsKey(username.trim())) {
            JOptionPane.showMessageDialog(frame, "User already exists.");
            return;
        }

        users.put(username.trim(), password);

        JOptionPane.showMessageDialog(frame, "Account created successfully.");
    }

    private static void createHomePage(String username) {
        frame.dispose();

        JFrame home = new JFrame("Home");
        home.setSize(420, 220);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 15, 15));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel welcome = new JLabel("Welcome, " + username + "!", JLabel.CENTER);
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 24));

        JButton btnContact = new JButton("Contact Us");
        JButton btnLogout = new JButton("Logout");

        btnContact.addActionListener(e -> contactUs());
        btnLogout.addActionListener(e -> {
            home.dispose();
            createLoginPage();
        });

        panel.add(welcome);
        panel.add(btnContact);
        panel.add(btnLogout);

        home.setContentPane(panel);
        home.setVisible(true);
    }

    private static void contactUs() {
        JOptionPane.showMessageDialog(frame,
                "Mubashir Behram\nmubashirbehram@gmail.com");
    }
}