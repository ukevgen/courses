package Forms;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Администратор on 29.03.2016.
 */
public class DataTable extends JFrame {
    private JButton button;
    private JPanel grid;
    private JTextField yearFrom, yearTo, priceFrom, PriceTo, carName,carModel;

    public DataTable(){
        super("Лоты");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid = new JPanel();
        grid.setLayout(new GridLayout(1, 2));
        grid.add(new JLabel("Модель"));
        grid.add(carModel =new JTextField());
        grid.add(new JLabel("Марка "));
        grid.add(carName =new JTextField());
        grid.add(new JLabel("Год выпуска от"));
        grid.add(yearFrom =new JTextField());
        grid.add(new JLabel("До "));
        grid.add(yearTo =new JTextField());
        grid.add(new JLabel("Цена от"));
        grid.add(priceFrom =new JTextField());
        grid.add(new JLabel("До "));
        grid.add(PriceTo =new JTextField());
        getContentPane().add(grid);
        pack();
        setVisible(true);
    }
}
