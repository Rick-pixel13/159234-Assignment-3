import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class BrowseTab extends JPanel {
    private JLabel categoryLabel;
    private JLabel typeLabel;
    private JComboBox<String> category;
    private JComboBox<String> type;
    private ProductsTable products;
    private HashMap<String, ArrayList<String>> typeByCategory;

    public BrowseTab() {
        setLayout(new GridBagLayout());

        categoryLabel = new JLabel("Computer Category");
        typeLabel = new JLabel("Computer Type");
        category = new JComboBox();
        type = new JComboBox();
        products = new ProductsTable();
        JTable table = new JTable(products);

        // adding the items to the combo boxes
        category.addItem("All");
        category.addItem("Desktop PC");
        category.addItem("Laptop");
        category.addItem("Tablet");
        type.addItem("Gaming");
        type.addItem("Home & Study");
        type.addItem("Business");
        type.addItem("Compact");
        type.addItem("Thin & Light");
        type.addItem("Android");
        type.addItem("Apple");
        type.addItem("Windows");
        type.setSelectedItem(null);

        // setting dimensions of combo boxes
        category.setPreferredSize(new Dimension(200,20));
        type.setPreferredSize(new Dimension(200,20));

        GridBagConstraints catLabelConstraints = new GridBagConstraints();
        catLabelConstraints.gridx = 0;
        catLabelConstraints.gridy = 0;
        catLabelConstraints.ipadx = 1;
        catLabelConstraints.ipady = 1;
        catLabelConstraints.anchor = GridBagConstraints.WEST;
        catLabelConstraints.insets = new Insets(4, 4, 4, 4);
        add(categoryLabel, catLabelConstraints);

        GridBagConstraints categoryConstraints = new GridBagConstraints();
        categoryConstraints.gridx = 1;
        categoryConstraints.gridy = 0;
        categoryConstraints.ipadx = 1;
        categoryConstraints.ipady = 1;
        categoryConstraints.anchor = GridBagConstraints.WEST;
        categoryConstraints.insets = new Insets(4, 4, 4, 4);
        add(category, categoryConstraints);

        GridBagConstraints typeLabelConstraints = new GridBagConstraints();
        typeLabelConstraints.gridx = 0;
        typeLabelConstraints.gridy = 1;
        typeLabelConstraints.ipadx = 1;
        typeLabelConstraints.ipady = 1;
        typeLabelConstraints.anchor = GridBagConstraints.WEST;
        typeLabelConstraints.insets = new Insets(4, 4, 4, 4);
        add(typeLabel, typeLabelConstraints);

        GridBagConstraints typeConstraints = new GridBagConstraints();
        typeConstraints.gridx = 1;
        typeConstraints.gridy = 1;
        typeConstraints.ipadx = 1;
        typeConstraints.ipady = 1;
        typeConstraints.anchor = GridBagConstraints.WEST;
        typeConstraints.insets = new Insets(4, 4, 4, 4);
        add(type, typeConstraints);

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 2;
        tableConstraints.gridwidth = 2;
        tableConstraints.fill = GridBagConstraints.BOTH;
        tableConstraints.weightx = 1.0;
        tableConstraints.weighty = 1.0;
        tableConstraints.insets = new Insets(4, 4, 4, 4);
        add(table, tableConstraints);

        typeByCategory = new HashMap<>();
        typeByCategory.put("Desktop PC", new ArrayList<String>() {{
            add("Gaming");
            add("Home & Study");
            add("Business");
            add("Compact");
        }});
        typeByCategory.put("Laptop", new ArrayList<String>() {{
            add("Gaming");
            add("Home & Study");
            add("Thin & Light");
        }});
        typeByCategory.put("Tablet", new ArrayList<String>() {{
            add("Android");
            add("Apple");
            add("Windows");
        }});

        category.addItem("All");
        for (String cat : typeByCategory.keySet()) {
            category.addItem(cat);
        }

        updateType();
        updateProductTable();
        // action listeners
        category.addActionListener(e -> {
            updateType();
            updateProductTable();
        });

        type.addActionListener(e -> updateProductTable());

//        products.getSelectionModel().addListSelectionListener(e -> {
//           int selectedRow = products.getSelectedRow();
//           if (selectedRow != -1) {
//               String category = (String) table.getValueAt(selectedRow, 0);
//               String type = (String) table.getValueAt(selectedRow, 1);
//               String brand = (String) table.getValueAt(selectedRow, 2);
//               String cpu = (String) table.getValueAt(selectedRow, 3);
//               String memory = (String) table.getValueAt(selectedRow, 4);
//               String price = (String) table.getValueAt(selectedRow, 5);
//           }
//        });

    }

    private void updateType() {
        type.removeAllItems();
        String selectedCategory = (String) category.getSelectedItem();
        if (selectedCategory != null) {
            ArrayList<String> typeofComputers = typeByCategory.get(selectedCategory);
            if (type != null) {
                type.addItem("All"); // can use switch statement here to add placeholder of each type
                for (String typeOfComp : typeofComputers) {
                    type.addItem(typeOfComp);
                }
            }
        }
    }
    private void updateProductTable() {

    }




    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BrowseTab birthdayPartyPanel = new BrowseTab();
        frame.add(birthdayPartyPanel);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
