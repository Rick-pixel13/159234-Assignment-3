import javax.swing.*;
import java.awt.*;

public class CPMSWindow extends JFrame {
    private JButton login = new JButton("Click to login", new ImageIcon("src/Computer Logo.jpg"));
    public CPMSWindow() {
        setBounds(200,200,600,250);
        setTitle("Computer Products Management System");
        setVisible(true);
        login.setFont(new Font("Arial",Font.BOLD,30));
        add(login);
        login.addActionListener(e -> SPLWindow.createWindow());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
