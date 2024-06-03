import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField model;
    private JComboBox<String> category;
    private JComboBox<String> type;
    private JTextField brand;
    private JTextField cpu;
    private JTextField memory;
    private JTextField ssd;
    private JTextField screen;
    private JTextField price;
    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton clear;

    public void setCategory(JComboBox<String> category) {
        this.category = category;
    }

    public void setType(JComboBox<String> type) {
        this.type = type;
    }

    public void setModel(JTextField model) {
        this.model = model;
    }

    public void setBrand(JTextField brand) {
        this.brand = brand;
    }

    public void setCpu(JTextField cpu) {
        this.cpu = cpu;
    }

    public void setPrice(JTextField price) {
        this.price = price;
    }

    public UpdateTab() {
        setLayout(new GridLayout(0,2));

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

        // action listeners
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        UpdateTab window = new UpdateTab();
//        frame.add(window);
//        frame.setBounds(200,200,400,700);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
