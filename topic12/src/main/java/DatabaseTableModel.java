
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * Created by Администратор on 27.03.2016.
 */
public class DatabaseTableModel extends AbstractTableModel {
    private ArrayList columnNames = new ArrayList();
    private ArrayList columnTypes = new ArrayList();
    private ArrayList data = new ArrayList();
    private boolean editable;

    // конструктор позволяет задать возможность редактирования
    public DatabaseTableModel(boolean editable) {
        this.editable = editable;
    }

    public int getRowCount() {
        synchronized (data) {
            return data.size();
        }
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    // тип данных столбца
    public Class getColumnClass(int column) {
        return (Class) columnTypes.get(column);
    }

    public String getColumnName(int column) {
        return (String) columnNames.get(column);
    }

    // данные в ячейке
    public Object getValueAt(int row, int column) {
        synchronized (data) {
            return ((ArrayList) data.get(row)).get(column);
        }
    }

    // возможность редактирования
    public boolean isEditable(int row, int column) {
        return editable;
    }

    // замена значения ячейки
    public void setValueAt(Object value, int row, int column) {
        synchronized (data) {
            ((ArrayList) data.get(row)).set(column, value);
        }
    }

    // получение данных из объекта ResultSet
    public void setDataSource(ResultSet rs) throws Exception {
// удаляем прежние данные
        data.clear();
        columnNames.clear();
        columnTypes.clear();
// получаем вспомогательную информацию о столбцах
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
            Class type = Class.forName(rsmd.getColumnClassName(i + 1));
            columnTypes.add(type);
        }
// сообщаем об изменениях в структуре данных
        fireTableStructureChanged();
// получаем данные
        while (rs.next()) {
// здесь будем хранить ячейки одной строки
            ArrayList row = new ArrayList();
            for (int i = 0; i < columnCount; i++) {
                if (columnTypes.get(i) == String.class)
                    row.add(rs.getString(i + 1));
                else
                    row.add(rs.getObject(i + 1));
            }
            synchronized (data) {
                data.add(row);
// сообщаем о прибавлении строки
                fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }
        }
    }

}
