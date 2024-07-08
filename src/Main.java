import java.util.ArrayList;

public class Main {
    public static MainMenu mainMenu;
    public static ArrayList<Staff> staff = new ArrayList<>();
    public Main() {
        mainMenu = new MainMenu();
    }

    public static void main(String[] args) {
        Staff staff1 = new Staff("p1","p1");
        Staff staff2 = new Staff("p2","p2");
        Staff staff3 = new Staff("p3","p3");
        Staff staff4 = new Manager("m1","m1");
        Staff staff5 = new Manager("m2","m2");

        staff.add(staff1);
        staff.add(staff2);
        staff.add(staff3);
        staff.add(staff4);
        staff.add(staff5);

        new Main();
    }
}
