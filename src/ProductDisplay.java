import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDisplay extends JFrame {
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> typeComboBox;
    private BrowseTab productPanel;
    private UpdateTab detailsPanel;
    private static ArrayList<Computer> compList = ComputerDetails.createList();
    private Map<String, ArrayList<String>> typeByCategory;

    public ProductDisplay() {
        // Set up the JFrame
        setTitle("Product Display");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);

        // Set up the product display tab
        productPanel = new BrowseTab();
        productPanel.setLayout(new BorderLayout());

        // Set up the category and sub-category combo boxes
        categoryComboBox = new JComboBox<>();
        typeComboBox = new JComboBox<>();
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(categoryComboBox);
        comboBoxPanel.add(typeComboBox);
        productPanel.add(comboBoxPanel, BorderLayout.NORTH);

        // Set up the product table
        tableModel = new DefaultTableModel(new String[]{"Category", "Type", "ID", "Brand", "CPU Family", "Price($)"}, 0);
        productTable = new JTable(tableModel);
        productPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Set up the details tab
        detailsPanel = new UpdateTab();

        // Add the tabs to the tabbed pane
        tabbedPane.addTab("Product Display", productPanel);
        tabbedPane.addTab("Product Details", detailsPanel);

        // Set up the category and sub-category data
        typeByCategory = new HashMap<>();
        typeByCategory.put("Desktop PC", new ArrayList<String>() {{
//            add(); need a placeholder
            add("Gaming");
            add("Home & Study");
            add("Business");
            add("Compact");
        }});
        typeByCategory.put("Laptop", new ArrayList<String>() {{
//            add(); need a placeholder
            add("Gaming");
            add("Home & Study");
            add("Thin & Light");
        }});
        typeByCategory.put("Tablet", new ArrayList<String>() {{
//            add(); need a placeholder
            add("Android");
            add("Apple");
            add("Windows");
        }});

        categoryComboBox.addItem("All");
        for (String category : typeByCategory.keySet()) {
            categoryComboBox.addItem(category);
        }

        // Set up the sub-category combo box
        updateTypeComboBox();

        // Set up the product table
        updateProductTable();

        // Set up the category combo box listener
        categoryComboBox.addActionListener(e -> {
            updateTypeComboBox();
            updateProductTable();
        });

        // Set up the sub-category combo box listener
        typeComboBox.addActionListener(e -> {
            updateProductTable();
        });

        // Set up the product table listener
//        productTable.getSelectionModel().addListSelectionListener(e -> {
//            int selectedRow = productTable.getSelectedRow();
//            if (selectedRow != -1) {
//                String category = (String) tableModel.getValueAt(selectedRow, 0);
//                String type = (String) tableModel.getValueAt(selectedRow, 1);
//                String id = (String) tableModel.getValueAt(selectedRow, 2);
//                String brand = (String) tableModel.getValueAt(selectedRow, 3);
//                String cpu = (String) tableModel.getValueAt(selectedRow, 4);
//                String price = (String) tableModel.getValueAt(selectedRow, 5);
//                setText((name != null) ? name : "");
//                priceTextField.setText((price != null) ? price : "");
//                descriptionTextField.setText((description != null) ? description : "");
//                nameTextField.setText((name != null) ? name : "");
//                priceTextField.setText((price != null) ? price : "");
//                priceTextField.setText((description != null) ? description : "");
//            }
//        });

        setVisible(true);
    }

    private void updateTypeComboBox() {
        typeComboBox.removeAllItems();
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        if (selectedCategory != null) {
            ArrayList<String> subCategories = typeByCategory.get(selectedCategory);
            if (subCategories != null) {
                typeComboBox.addItem("All");
                for (String subCategory : subCategories) {
                    typeComboBox.addItem(subCategory);
                }
            }
        }
    }

    private void updateProductTable() {
        tableModel.setRowCount(0);
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String selectedSubCategory = (String) typeComboBox.getSelectedItem();
        for (Computer item : compList) { // replace with actual product data
            String category = item.getCategory();
            String type = item.getType();
            String id = item.getId();
            String brand = item.getBrand();
            String cpu = item.getCpuFam();
            double price = item.getPrice();
            tableModel.addRow(new String[]{category, type, id, brand, cpu, String.valueOf(price)});
            }
    }

public static void main(String[] args) {
    ProductDisplay display = new ProductDisplay();
    }
}
