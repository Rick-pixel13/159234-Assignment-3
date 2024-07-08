import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginMenu extends JFrame {
    private JButton login = new JButton("Click to login", new ImageIcon("src/Computer Logo.jpg"));
    private JPanel container;
    private static JPanel loginPanel;

    public LoginMenu() {
        setTitle("Computer Products Management System");
        setBounds(200,200,600,250);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        loginPanel = new JPanel();


        login.setFont(new Font("Arial",Font.BOLD,30));
        loginPanel.add(login);


        add(container);
        container.add(loginPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        loginPanel.setVisible(true);

        pack();

        // action listeners
        login.addActionListener(e -> {
            new LoginWindow();
        });
    }
}
