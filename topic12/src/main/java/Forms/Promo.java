package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Администратор on 29.03.2016.
 */
public class Promo extends JFrame {
    private JTextField manufacturer, carName, year, vin, price, name, surname, phone;
    private JTextArea description;
    private JButton button;
    private JPanel grid;
    private ArrayList<String> array;
    private HashMap<String, ArrayList<String>> map;


    public Promo() {
        super("LOT");
        setSize(300, 300);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3, 5, 5));
        grid.add(manufacturer = new JTextField("manufacturer"));
        grid.add(carName = new JTextField("model"));
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
        setVisible(false);

    }

    private void CreateArray() {
        if (array == null)
            array = new ArrayList();
        else
            array.clear();
    }

    private boolean chekForm() {
        if (array.contains("")) {
            return true;
        } else
            return false;
    }


    class ButtonL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            setVisible(true);
            CreateArray();
            array = new ArrayList();
            array.add(manufacturer.getText());
            array.add(carName.getText());
            array.add(year.getText());
            array.add(vin.getText());
            array.add(price.getText());
            array.add(name.getText());
            array.add(surname.getText());
            array.add(phone.getText());
            array.add(description.getText());
            if (chekForm()) {
                JOptionPane.showMessageDialog(null, "Необходимо заполнить все поля!");
                array.clear();
            }
            JOptionPane.showMessageDialog(null, "Запись успешна добавлена");
            dispose();
            // нужно создать сущности car person ..
            System.out.println("Запись успешно добавлена");
            setMap();
        }
    }

    private void setMap() {
        ArrayList<String> advert = new ArrayList<>();
        ArrayList<String> cars = new ArrayList<>();
        ArrayList<String> owner = new ArrayList<>();
        advert.add(array.get(1));
        advert.add(array.get(4));
        map.put("advert", advert);
        cars.add(array.get(5));
        cars.add(array.get(0));
        cars.add(array.get(2));
        cars.add(array.get(3));
        cars.add(array.get(8));
        map.put("cars", cars);
        owner.add(array.get(5));
        owner.add(array.get(6));
        owner.add(array.get(7));
        map.put("owner", owner);
    }

    public HashMap<String, ArrayList<String>> getMap() {
        return map;
    }
}
