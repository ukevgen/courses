package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Администратор on 29.03.2016.
 */
public class Promo extends JFrame {
    private JTextField manufacturer, model, year, vin, price, name, surname, phone;
    private JTextArea description;
    private JButton button;
    private JPanel grid;
    private ArrayList array;

    public Promo() {
        super("LOT");
        setSize(300, 300);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3, 5, 5));
        grid.add(manufacturer = new JTextField("manufacturer"));
        grid.add(model = new JTextField("model"));
        grid.add(year = new JTextField("year"));
        grid.add(vin = new JTextField("vin"));
        grid.add(price = new JTextField("price"));
        grid.add(name = new JTextField("name"));
        grid.add(surname = new JTextField("surname"));
        grid.add(phone = new JTextField("phone"));
        grid.add(description = new JTextArea("description", 1, 16));
        grid.add(button = new JButton("Добавить лот"));
        getContentPane().add(grid);
        button.addActionListener(new ButtonL());
        //getContentPane().add(grid1);
        pack();
        setVisible(true);

    }

    private void CreateArray() {
        if (array == null)
            array = new ArrayList();
        else
            array.clear();
    }

    private boolean chekForm() {
        if (array.contains("")) {
            return false;
        } else
            return true;
    }

    public ArrayList getInfoArray() {
        return array;
    }

    class ButtonL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            CreateArray();
            array = new ArrayList();
            array.add(manufacturer.getText());
            array.add(model.getText());
            array.add(year.getText());
            array.add(vin.getText());
            array.add(price.getText());
            array.add(name.getText());
            array.add(surname.getText());
            array.add(phone.getText());
            array.add(description.getText());
            if (!chekForm()) {
                JOptionPane.showMessageDialog(null, "Необходимо заполнить все поля!");
                array.clear();
            }
            dispose();
            // нужно создать сущности car person ..
            System.out.println("Запись успешно добавлена");

        }
    }
}
