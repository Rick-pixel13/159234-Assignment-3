import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ProductsTable implements TableModel {
    private static ArrayList<Computer> compList = ComputerDetails.createList();

    @Override
    public int getRowCount() { return compList.size(); }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Computer comp = compList.get(row);

        switch(col) {
            case 0:
                return comp.getCategory();
            case 1:
                return comp.getType();
            case 2:
                return comp.getId();
            case 3:
                return comp.getBrand();
            case 4:
                return comp.getCpuFam();
            case 5:
                return comp.getPrice();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Category";
            case 1: return "Type";
            case 2: return "ID";
            case 3: return "Brand";
            case 4: return "CPU Family";
            case 5: return "Price($)";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
