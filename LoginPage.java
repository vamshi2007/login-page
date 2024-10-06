import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JButton loginButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        loginButton = new JButton("Login");

        // Add Action Listener to button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String name = nameField.getText();

                // Display the entered details on a new page
                new DetailsPage(username, password, name);
                dispose(); // Close the login page
            }
        });

        // Create a panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(loginButton);

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });
    }
}

class DetailsPage extends JFrame {
    public DetailsPage(String username, String password, String name) {
        setTitle("Details Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a label to display details
        String details = "<html><h2>User Details</h2>"
                       + "<p>Username: " + username + "</p>"
                       + "<p>Password: " + password + "</p>"
                       + "<p>Name: " + name + "</p></html>";
        JLabel detailsLabel = new JLabel(details);
        detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add label to frame
        add(detailsLabel);
        setVisible(true);
    }
}
