import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginGUI extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton;
    private LoginManager loginManager;

    public LoginGUI(){
        loginManager = new LoginManager();
        setTitle("Airline Management System - Login");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setOpaque(true);
        getContentPane().setBackground(new Color(240, 248, 255));

        //TITLE
        JLabel TitleLabel = new JLabel("Welcome to Airline Management System",SwingConstants.CENTER);
        TitleLabel.setFont(new Font("Arial",Font.BOLD,30));
        TitleLabel.setForeground(new Color(0x456778));
        add(TitleLabel,BorderLayout.NORTH);

        //FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(2,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30,40,10,40));
        formPanel.setOpaque(false);
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);
        add(formPanel,BorderLayout.CENTER);

        //BUTTON PANEL
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setOpaque(false);
        Color buttonColor = new Color(100, 149, 237); // Cornflower blue
        loginButton.setBackground(buttonColor);
        signUpButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        signUpButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        signUpButton.setFocusPainted(false);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        ButtonPanel.add(signUpButton);
        ButtonPanel.add(loginButton);
        add(ButtonPanel,BorderLayout.SOUTH);

        //BUTTON ACTION
        loginButton.addActionListener(e -> handleLogin());
        signUpButton.addActionListener(e -> handleSignUp());
    }
    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = loginManager.Login(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, " Login Successfull. Welcome! " + user.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
        }
    }
    private void handleSignUp() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean success = loginManager.Signup(username, password);
        if (success) {
            JOptionPane.showMessageDialog(this, "SignUp Successfull. Welcome! " + username + " you can log in now");
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists.Try diiferent");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI LoginWindow = new LoginGUI();
            LoginWindow.setVisible(true);
        });
    }

}
