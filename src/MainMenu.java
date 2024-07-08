import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private JButton login = new JButton("Click to login", new ImageIcon("src/Computer Logo.jpg"));
    private JButton logout = new JButton("Click to log out", new ImageIcon("src/Computer Logo.jpg"));
    private JPanel container;
    static JPanel loginPanel;
    static JPanel tabsPanel;
    static JPanel logoutPanel;
    private static Staff loggedInUser;

    public MainMenu() {
        setTitle("Computer Products Management System");
        setBounds(200,200,640,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        tabsPanel = new ProductDisplay();
        loginPanel = new JPanel();
        logoutPanel = new JPanel();

        login.setFont(new Font("Arial",Font.BOLD,30));
        logout.setFont(new Font("Arial",Font.BOLD,30));
        loginPanel.add(login);
        logoutPanel.add(logout);

        add(container);
        container.add(tabsPanel);
        container.add(loginPanel);
        container.add(logoutPanel);
        loginPanel.setVisible(true);
        tabsPanel.setVisible(false);
        logoutPanel.setVisible(false);

        pack();

        // action listeners
        login.addActionListener(e -> {
            new LoginWindow();
        });

        logout.addActionListener(e -> {
            loginPanel.setVisible(true);
            tabsPanel.setVisible(false);
            logoutPanel.setVisible(false);
            pack();
        });
    }

    public static void setLoggedInUser(Staff user) {
        loggedInUser = user;
        ProductDisplay.disableEditing();
        if (loggedInUser.isManager()) {
            ProductDisplay.enableEditing();
        }
        loginPanel.setVisible(false);
        tabsPanel.setVisible(true);
        logoutPanel.setVisible(true);
    }
}
