import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ComputerDetails {
    private static ArrayList<Desktop> desktops = new ArrayList<>();
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static ArrayList<Tablet> tablets = new ArrayList<>();
    public static ArrayList<Computer> computers = new ArrayList<>();

    public static ArrayList<Computer> createList() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/computers.txt"));
            String line = reader.readLine();
            if (line == null) {
                throw new IOException();
            }
            while (line != null) {
                String[] specs = line.split(",");
                switch (specs[0]) {
                    case "Desktop PC":
                        desktops.add(new Desktop(specs[0], specs[1], specs[2], specs[3], specs[4], Integer.parseInt(specs[5]), Integer.parseInt(specs[6]), Integer.parseInt(specs[7])));
                        break;
                    case "Laptop":
                        laptops.add(new Laptop(specs[0], specs[1], specs[2], specs[3], specs[4], Integer.parseInt(specs[5]), Integer.parseInt(specs[6]), Double.parseDouble(specs[7]), Integer.parseInt(specs[8])));
                        break;
                    case "Tablet":
                        tablets.add(new Tablet(specs[0], specs[1], specs[2], specs[3], specs[4], Double.parseDouble(specs[5]), Integer.parseInt(specs[6])));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        computers.addAll(desktops);
        computers.addAll(laptops);
        computers.addAll(tablets);
        return computers;
    }
}