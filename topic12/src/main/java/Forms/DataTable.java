package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Администратор on 29.03.2016.
 */
public class DataTable extends JFrame {
    private JButton button, buttonPromo;
    private JPanel grid;
    private JTextField yearFrom, yearTo, priceFrom, PriceTo, carName, carModel;

    public JButton getButton() {
        return button;
    }

    public JTextField getYearFrom() {
        return yearFrom;
    }

    public JTextField getYearTo() {
        return yearTo;
    }

    public JTextField getPriceFrom() {
        return priceFrom;
    }

    public JTextField getPriceTo() {
        return PriceTo;
    }

    public JTextField getCarName() {
        return carName;
    }

    public JTextField getCarModel() {
        return carModel;
    }

    public JButton getButtonPromo() {
        return buttonPromo;
    }

    public DataTable() {
        super("Лоты");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid = new JPanel();
        grid.setLayout(new GridLayout(2, 2, 2, 2));
        grid.add(button = new JButton("Search"));
        grid.add(new JLabel("Модель"));
        grid.add(carModel = new JTextField());
        grid.add(new JLabel("Марка "));
        grid.add(carName = new JTextField());
        grid.add(new JLabel("Год выпуска от"));
        grid.add(yearFrom = new JTextField());
        grid.add(buttonPromo = new JButton("Promo"));
        grid.add(new JLabel("Год выпуска До "));
        grid.add(yearTo = new JTextField());
        grid.add(new JLabel("Цена от"));
        grid.add(priceFrom = new JTextField());
        grid.add(new JLabel("Цена До "));
        grid.add(PriceTo = new JTextField());
        getContentPane().add(grid);
        pack();
        setVisible(true);

    }

}
