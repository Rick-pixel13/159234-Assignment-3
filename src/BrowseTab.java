import javax.swing.*;
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
    private JTable table;

    public BrowseTab() {
        setLayout(new GridBagLayout());

        categoryLabel = new JLabel("Computer Category");
        typeLabel = new JLabel("Computer Type");
        category = new JComboBox();
        type = new JComboBox();

        // setting up table
        products = new ProductsTable();
        table = new JTable(products);

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
    }
}
