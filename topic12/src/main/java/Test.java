import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Ievgen Tararaka
 */
// как вынести все ошибки в одинк блок
// как сделать инсерт незная количество столбцов и их типов (универсальный метод инсерт)
public class Test {
    public static void main(String[] args) {
        try {
            Dbo dbo = new Dbo("localhost:3306","person", "root", "");
            dbo.dboConnection();
            //dbo.findCars();
            ResultSet rs = dbo.makeSelect(dbo.selectAll());
            DatabaseTableModel dbm = new DatabaseTableModel(false);
            JTable table = new JTable(dbm);
            dbm.setDataSource(rs);
            ButtonColumn buttonColumn = new ButtonColumn(table,6);
            buttonColumn.setMnemonic(KeyEvent.VK_D);

            JFrame frame = new JFrame("INFO");
            frame.setSize(400, 300);
            frame.getContentPane().add(new JScrollPane(table));
            frame.show();

            //rs.close();
            //ResultSet rs=dbo.findCars();
            //dbm.setDataSource(rs);

            dbo.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
