import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class UpdateTab extends JPanel {
    private JLabel modelLabel;
    private JLabel categoryLabel;
    private JLabel typeLabel;
    private JLabel brandLabel;
    private JLabel cpuLabel;
    private JLabel memoryLabel;
    private JLabel ssdLabel;
    private JLabel screenLabel;
    private JLabel priceLabel;
    private static JTextField model;
    private static JComboBox<String> category;
    private static JComboBox<String> type;
    private static JTextField brand;
    private static JTextField cpu;
    private static JTextField memory;
    private static JTextField ssd;
    private static JTextField screen;
    private static JTextField price;
    private static JButton add;
    private static JButton update;
    private static JButton delete;
    private static JButton clear;

    // constructor
    public UpdateTab() {
        setLayout(new GridLayout(0, 2));

        modelLabel = new JLabel("Model ID:");
        categoryLabel = new JLabel("Category:");
        typeLabel = new JLabel("Type:");
        brandLabel = new JLabel("Brand:");
        cpuLabel = new JLabel("CPU Family:");
        memoryLabel = new JLabel("Memory Size:");
        ssdLabel = new JLabel("SSD Capacity:");
        screenLabel = new JLabel("Screen Size:");
        priceLabel = new JLabel("Price:");

        model = new JTextField();
        category = new JComboBox<>();
        type = new JComboBox<>();
        brand = new JTextField();
        cpu = new JTextField();
        memory = new JTextField();
        ssd = new JTextField();
        screen = new JTextField();
        price = new JTextField();

        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        clear = new JButton("Clear");

        modelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        categoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        cpuLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        memoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ssdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        screenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        add(modelLabel);
        add(model);
        add(categoryLabel);
        add(category);
        add(typeLabel);
        add(type);
        add(brandLabel);
        add(brand);
        add(cpuLabel);
        add(cpu);
        add(memoryLabel);
        add(memory);
        add(ssdLabel);
        add(ssd);
        add(screenLabel);
        add(screen);
        add(priceLabel);
        add(price);
        add(add);
        add(update);
        add(delete);
        add(clear);

        category.addItem("Desktop PC");
        category.addItem("Laptop");
        category.addItem("Tablet");
        type.addItem("Gaming");
        type.addItem("Home & Study");
        type.addItem("Business");
        type.addItem("Thin & Light");
        type.addItem("Android");
        type.addItem("Apple");
        type.addItem("Windows");

        // action listeners
        add.addActionListener(e -> {
            String id = getModel();
            try {
                // check to make sure all ids are unique
                for (Computer comp : ProductDisplay.compList) {
                    if (comp.getId().equals(id)) {
                        throw new IllegalArgumentException();
                    }
                }
                String category = String.valueOf(getCategory());
                String type = String.valueOf(getType());
                String brand = getBrand();
                String cpu = getCpu();
                int memory;
                int ssd;
                int price = Integer.parseInt(getPrice());
                double screen;
                switch (category) {
                    case "Desktop PC":
                        memory = Integer.parseInt(getMemory());
                        ssd = Integer.parseInt(getSsd());
                        ProductDisplay.compList.add(new Desktop(category, type, id, brand, cpu, memory, ssd, price));
                        break;
                    case "Laptop":
                        memory = Integer.parseInt(getMemory());
                        ssd = Integer.parseInt(getSsd());
                        screen = Double.parseDouble(getScreen());
                        ProductDisplay.compList.add(new Laptop(category, type, id, brand, cpu, memory, ssd, screen, price));
                        break;
                    case "Tablet":
                        screen = Double.parseDouble(getScreen());
                        ProductDisplay.compList.add(new Tablet(category, type, id, brand, cpu, screen, price));
                        break;
                }
                // updates the table
                ProductDisplay.updateProductTable();
                JOptionPane.showMessageDialog(null, "The record for the computer is added successfully!");
            } catch (IllegalArgumentException ex) {
                System.err.println("Computer ID must be unique.");
                JOptionPane.showMessageDialog(null, "Computer ID must be unique.");
            }
        });
        update.addActionListener(e -> {
            String id = getModel();
            boolean found = false;
            try {
                // check to see if id is in system
                for (Computer comp : ProductDisplay.compList) {
                    if (comp.getId().equals(id)) {
                        found = true;
                        // Update the computer's details
                        comp.setCategory((String) category.getSelectedItem());
                        comp.setType((String) type.getSelectedItem());
                        comp.setBrand(brand.getText());
                        comp.setCpuFam(cpu.getText());
                        comp.setPrice(Integer.parseInt(price.getText()));

                        // Update details specific to the category
                        switch ((String) category.getSelectedItem()) {
                            case "Desktop PC":
                                if (comp instanceof Desktop desktop) {
                                    desktop.setMemSize(Integer.parseInt(memory.getText()));
                                    desktop.setSsd(Integer.parseInt(ssd.getText()));
                                }
                                break;
                            case "Laptop":
                                if (comp instanceof Laptop laptop) {
                                    laptop.setMemSize(Integer.parseInt(memory.getText()));
                                    laptop.setSsd(Integer.parseInt(ssd.getText()));
                                    laptop.setScreenSize(Double.parseDouble(screen.getText()));
                                }
                                break;
                            case "Tablet":
                                if (comp instanceof Tablet tablet) {
                                    tablet.setScreenSize(Double.parseDouble(screen.getText()));
                                }
                                break;
                        }
                        // Break out of the loop once the computer is found and updated
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException();
                }
                // Update the product table
                ProductDisplay.updateProductTable();
                JOptionPane.showMessageDialog(null, "The computer record has been updated successfully!");
            } catch (IllegalArgumentException ex) {
                System.err.println("ID not in system.");
                JOptionPane.showMessageDialog(null, "ID not in system.");
            }
        });

        delete.addActionListener(e -> {
            String id = getModel();
            // check if the ID is found
            boolean found = false;
            try {
                Iterator<Computer> itr = ProductDisplay.compList.iterator();
                while (itr.hasNext()) {
                    Computer comp = itr.next();
                    if (comp.getId().equals(id)) {
                        itr.remove();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException();
                }
                // updates the table
                ProductDisplay.updateProductTable();
                JOptionPane.showMessageDialog(null, "The record for the computer is deleted successfully!");
            } catch (IllegalArgumentException ex) {
                System.err.println("ID not in system.");
                JOptionPane.showMessageDialog(null, "ID not in system.");
            }
        });
        clear.addActionListener(e -> {
            // Clear the details panel fields
            brand.setText("");
            model.setText("");
            cpu.setText("");
            price.setText("");
            memory.setText("");
            ssd.setText("");
            screen.setText("");
        });
    }

    // setters and getters
    public void setModel(String model) {
        this.model.setText(model);
    }

    public String getModel() {
        return model.getText();
    }

    public void setCategory(String cat) {
        category.setSelectedItem(cat);
    }

    public String getCategory() {
        return (String) category.getSelectedItem();
    }

    public void setType(String ty) {
        type.setSelectedItem(ty);
    }

    public String getType() {
        return (String) type.getSelectedItem();
    }

    public void setBrand(String brand) {
        this.brand.setText(brand);
    }

    public String getBrand() {
        return brand.getText();
    }

    public void setCpu(String cpu) {
        this.cpu.setText(cpu);
    }

    public String getCpu() {
        return cpu.getText();
    }

    public void setMemory(String memory) {
        this.memory.setText(memory);
    }

    public String getMemory() {
        return memory.getText();
    }

    public void setSsd(String ssd) {
        this.ssd.setText(ssd);
    }

    public String getSsd() {
        return ssd.getText();
    }

    public void setScreen(String screen) {
        this.screen.setText(screen);
    }

    public String getScreen() {
        return screen.getText();
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }

    public String getPrice() {
        return price.getText();
    }

    public static void setEditable(boolean editable) {
        // Assume you have buttons or other components for editing
        add.setEnabled(editable);
        update.setEnabled(editable);
        delete.setEnabled(editable);
        model.setEnabled(editable);
        category.setEnabled(editable);
        type.setEnabled(editable);
        brand.setEnabled(editable);
        cpu.setEnabled(editable);
        memory.setEnabled(editable);
        ssd.setEnabled(editable);
        screen.setEnabled(editable);
        price.setEnabled(editable);
        clear.setEnabled(editable);
    }
}
