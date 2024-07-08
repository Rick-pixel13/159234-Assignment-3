import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDisplay extends JPanel {
    static JTable productTable;
    private static DefaultTableModel tableModel;
    private static JComboBox<String> categoryComboBox;
    private static JComboBox<String> typeComboBox;
    private static BrowseTab productPanel;
    private UpdateTab detailsPanel;
    private JPanel comboBoxPanel;
    public static ArrayList<Computer> compList = ComputerDetails.createList();
    private Map<String, ArrayList<String>> typeByCategory;

    public ProductDisplay() {
        // Set up the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane);

        // Set up the product display tab
        productPanel = new BrowseTab();
        productPanel.setLayout(new BorderLayout());

        // Set up the category and type combo boxes
        categoryComboBox = new JComboBox<>();
        typeComboBox = new JComboBox<>();
        comboBoxPanel = new JPanel();
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
        tabbedPane.addTab("Browse Products", productPanel);
        tabbedPane.addTab("Check/Update Product Details", detailsPanel);

        // Set up the category and sub-category data
        typeByCategory = new HashMap<>();
        typeByCategory.put("Desktop PC", new ArrayList<String>() {{
            add("Gaming");
            add("Home & Study");
            add("Business");
            add("Compact");
        }});
        typeByCategory.put("Laptop", new ArrayList<String>() {{
            add("Business");
            add("Gaming");
            add("Home & Study");
            add("Thin & Light");
        }});
        typeByCategory.put("Tablet", new ArrayList<String>() {{
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
        productTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) tableModel.getValueAt(selectedRow, 2);
                for (Computer comp : compList) {
                    if (comp.getId().equals(id)) {
                        detailsPanel.setModel(id);
                        detailsPanel.setCategory(comp.getCategory());
                        detailsPanel.setType(comp.getType());
                        detailsPanel.setBrand(comp.getBrand());
                        detailsPanel.setCpu(comp.getCpuFam());
                        detailsPanel.setPrice(String.valueOf(comp.getPrice()));
                        if (comp instanceof Desktop) {
                            detailsPanel.setMemory(String.valueOf(((Desktop) comp).getMemSize()));
                            detailsPanel.setSsd(String.valueOf(((Desktop) comp).getSsd()));
                            detailsPanel.setScreen(null);
                        }
                        if (comp instanceof Laptop) {
                            detailsPanel.setMemory(String.valueOf(((Laptop) comp).getMemSize()));
                            detailsPanel.setSsd(String.valueOf(((Laptop) comp).getSsd()));
                            detailsPanel.setScreen(String.valueOf(((Laptop) comp).getScreenSize()));
                        }
                        if (comp instanceof Tablet) {
                            detailsPanel.setMemory(null);
                            detailsPanel.setSsd(null);
                            detailsPanel.setScreen(String.valueOf(((Tablet) comp).getScreenSize()));
                        }
                    }
                }
            }
        });
        setVisible(true);
    }

    private void updateTypeComboBox() {
        typeComboBox.removeAllItems();
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        if (selectedCategory != null) {
            ArrayList<String> types = typeByCategory.get(selectedCategory);
            if (types != null) {
                typeComboBox.addItem("Select Type");
                for (String type : types) {
                    typeComboBox.addItem(type);
                }
            }
        }
    }

    public static void updateProductTable() {
        tableModel.setRowCount(0);
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String selectedType = (String) typeComboBox.getSelectedItem();
        for (Computer item : compList) {
            boolean matchesCategory = selectedCategory.equals("All") || item.getCategory().equals(selectedCategory);
            boolean matchesType = selectedType == null || selectedType.equals("Select Type") || item.getType().equals(selectedType);
            if (matchesCategory && matchesType) {
                String category = String.valueOf(item.getCategory());
                String type = String.valueOf(item.getType());
                String id = item.getId();
                String brand = item.getBrand();
                String cpu = item.getCpuFam();
                int price = item.getPrice();
                tableModel.addRow(new String[]{category, type, id, brand, cpu, String.valueOf(price)});
            }
        }
    }
    public static void enableEditing() {
        UpdateTab.setEditable(true);
    }

    public static void disableEditing() {
        UpdateTab.setEditable(false);
    }
}
