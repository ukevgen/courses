import Forms.ButtonColumn;
import Forms.DataTable;
import Forms.DatabaseTableModel;
import Forms.Promo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ievgen Tararaka
 */
// как вынести все ошибки в одинк блок
// как сделать инсерт незная количество столбцов и их типов (универсальный метод инсерт)
public class Test {
    private static Promo promo;
    private static DataTable frameTable;
    private static Dbo dbo;
    private static DatabaseTableModel dbm;
    private static ButtonColumn buttonColumn;

    public Test() {
    }

    public static void main(String[] args) {

        try {
            dbo = new Dbo("jdbc:mysql://localhost:3306", "person", "root", "");
            dbo.dboConnection();
            ResultSet rs = dbo.makeSelect(dbo.selectAll());
            dbm = new DatabaseTableModel(false);
            JTable table = new JTable(dbm);
            dbm.setDataSource(rs);
            buttonColumn = new ButtonColumn(table, 7);
            buttonColumn.setMnemonic(KeyEvent.VK_D);
            frameTable = new DataTable();
            promo = new Promo();
            JButton button = frameTable.getButton();
            button.addActionListener(new ButtonSearch());
            JButton buttonPromo = frameTable.getButtonPromo();
            buttonPromo.addActionListener(new ButtonPromo());
            frameTable.setSize(400, 300);

            frameTable.getContentPane().add(new JScrollPane(table), BorderLayout.SOUTH);
            frameTable.show();
            //rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class ButtonSearch implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ArrayList<String> arrayList = new ArrayList();
            ArrayList<Integer> integerArrayList = new ArrayList<>();

            arrayList.add(frameTable.getCarName().getText());
            arrayList.add(frameTable.getCarModel().getText());
            boolean good = true;
            integerArrayList.add(Integer.parseInt(frameTable.getYearFrom().getText()));
            integerArrayList.add(Integer.parseInt(frameTable.getYearTo().getText()));
            integerArrayList.add(Integer.parseInt(frameTable.getPriceFrom().getText()));
            integerArrayList.add(Integer.parseInt(frameTable.getPriceTo().getText()));

            ResultSet resultSet = null;
            try {
                resultSet = dbo.findCars(arrayList, integerArrayList);
                dbm.setDataSource(resultSet);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    static class ButtonPromo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            promo.setVisible(true);
            try {
                dbo.addAdvertisement(dbo.getId(), promo.getMap());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

