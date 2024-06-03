import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private BrowseTab browseTab;
    private UpdateTab updateTab;
    private JButton login = new JButton("Click to login", new ImageIcon("src/Computer Logo.jpg"));
    private JPanel container;
    private JPanel tabsPanel;
    private JPanel loginPanel;
    public static ArrayList<Staff> staff = new ArrayList<>();

    public MainMenu() {
        setTitle("Computer Products Management System");
        setBounds(200,200,600,250);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        tabsPanel = new JPanel();
        loginPanel = new JPanel();

        browseTab = new BrowseTab();
        updateTab = new UpdateTab();

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Browse Products", browseTab);
        tabs.add("Check/Update Products Details", updateTab);
        tabsPanel.add(tabs);
        login.setFont(new Font("Arial",Font.BOLD,30));
        loginPanel.add(login);

        add(container);
        container.add(tabsPanel);
        container.add(loginPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        tabsPanel.setVisible(true);
        loginPanel.setVisible(true);

        pack();

        // action listeners





    }

    public static void main(String[] args) {
        Staff staff1 = new Staff("Salesperson","p1","p1");
        Staff staff2 = new Staff("Salesperson","p2","p2");
        Staff staff3 = new Staff("Salesperson","p3","p3");
        Staff staff4 = new Staff("Manager","m1","m1");
        Staff staff5 = new Staff("Manager","m2","m2");

        staff.add(staff1);
        staff.add(staff2);
        staff.add(staff3);
        staff.add(staff4);
        staff.add(staff5);
        MainMenu menu = new MainMenu();
    }
}
