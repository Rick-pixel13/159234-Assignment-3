import java.util.ArrayList;

public class Runner {
    public static ArrayList<Staff> staff = new ArrayList<>();

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

        CPMSWindow program = new CPMSWindow();
    }
}
