import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SPLWindow extends JFrame {
    private JPanel loginPanel = new JPanel(new GridBagLayout());
    private JPanel buttonPanel = new JPanel(new GridBagLayout());
    private JLabel usernameLabel = new JLabel("Username:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField username = new JTextField(20);
    private JPasswordField password = new JPasswordField(20);
    private JButton login = new JButton("Login");
    private JButton cancel = new JButton("Cancel");

    public SPLWindow() {
        setLayout(new GridBagLayout());

        GridBagConstraints loginPanelConstraints = new GridBagConstraints();
        loginPanelConstraints.gridx = 0;
        loginPanelConstraints.gridy = 0;
        loginPanelConstraints.fill = GridBagConstraints.NORTH;
        add(loginPanel, loginPanelConstraints);

        GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 1;
        buttonPanelConstraints.anchor = GridBagConstraints.SOUTH;
        buttonPanelConstraints.insets = new Insets(4, 4, 4, 4);
        add(buttonPanel, buttonPanelConstraints);

        // Set layout and constraints for components in loginPanel
        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints usernameLabelConstraints = new GridBagConstraints();
        usernameLabelConstraints.gridx = 0;
        usernameLabelConstraints.gridy = 0;
        usernameLabelConstraints.ipadx = 1;
        usernameLabelConstraints.ipady = 1;
        usernameLabelConstraints.anchor = GridBagConstraints.WEST;
        loginPanel.add(usernameLabel, usernameLabelConstraints);

        GridBagConstraints usernameConstraints = new GridBagConstraints();
        usernameConstraints.gridx = 1;
        usernameConstraints.gridy = 0;
        usernameConstraints.ipadx = 1;
        usernameConstraints.ipady = 1;
        usernameConstraints.anchor = GridBagConstraints.WEST;
        loginPanel.add(username, usernameConstraints);

        GridBagConstraints passwordLabelConstraints = new GridBagConstraints();
        passwordLabelConstraints.gridx = 0;
        passwordLabelConstraints.gridy = 1;
        passwordLabelConstraints.ipadx = 1;
        passwordLabelConstraints.ipady = 1;
        passwordLabelConstraints.anchor = GridBagConstraints.WEST;
        loginPanel.add(passwordLabel, passwordLabelConstraints);

        GridBagConstraints passwordConstraints = new GridBagConstraints();
        passwordConstraints.gridx = 1;
        passwordConstraints.gridy = 1;
        passwordConstraints.ipadx = 1;
        passwordConstraints.ipady = 1;
        passwordConstraints.anchor = GridBagConstraints.WEST;
        loginPanel.add(password, passwordConstraints);

        // Set layout and constraints for components in buttonPanel
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints loginConstraints = new GridBagConstraints();
        loginConstraints.gridx = 1;
        loginConstraints.gridy = 2;
        loginConstraints.ipadx = 0;
        loginConstraints.ipady = 0;
        loginConstraints.anchor = GridBagConstraints.SOUTH;
        loginConstraints.insets = new Insets(0, 4, 4, 2);
        buttonPanel.add(login, loginConstraints);

        GridBagConstraints cancelConstraints = new GridBagConstraints();
        cancelConstraints.gridx = 2;
        cancelConstraints.gridy = 2;
        cancelConstraints.ipadx = 0;
        cancelConstraints.ipady = 0;
        cancelConstraints.anchor = GridBagConstraints.SOUTH;
        cancelConstraints.insets = new Insets(0, 2, 4, 4);
        buttonPanel.add(cancel, cancelConstraints);

        // ActionListeners
        cancel.addActionListener(e -> dispose());
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correct = false;
                for (Staff staff : Runner.staff) {
                    if (staff.getUsername().equals(username.getText()) && staff.getPassword().equals(password.getText())) {
                        correct = true;
                        break;
                    }
                }
                if (correct) {
                    MainMenu main = new MainMenu();
                    main.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                }
            }
        });

    }

    public static void createWindow() {
        SPLWindow win = new SPLWindow();
        win.setTitle("Sales Person Login");
        win.setBounds(200, 200, 350, 150);
        win.setVisible(true);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        win.pack();
    }
}
