import Forms.ButtonColumn;
import Forms.DataTable;
import Forms.DatabaseTableModel;
import Forms.Promo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

/**
 * @author Ievgen Tararaka
 */
// как вынести все ошибки в одинк блок
// как сделать инсерт незная количество столбцов и их типов (универсальный метод инсерт)
public class Test {
    private static Promo promo;
    public static void main(String[] args) {
        try {
            Dbo dbo = new Dbo("jdbc:mysql://localhost:3306","person", "root", "");
            dbo.dboConnection();
            //dbo.findCars();
            ResultSet rs = dbo.makeSelect(dbo.selectAll());
            DatabaseTableModel dbm = new DatabaseTableModel(false);
            JTable table = new JTable(dbm);
            dbm.setDataSource(rs);
            ButtonColumn buttonColumn = new ButtonColumn(table,7);
            buttonColumn.setMnemonic(KeyEvent.VK_D);

            JFrame frame = new DataTable();
            frame.setSize(400, 300);
            frame.getContentPane().add(new JScrollPane(table), BorderLayout.SOUTH);
            frame.show();

            //rs.close();
            //ResultSet rs=dbo.findCars();
            //dbm.setDataSource(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
