import Customer.Ad;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 15.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        //Ad ad = new Ad(55, "Test", 1000);
        List advertisement = null;
        try {
            advertisement = Factory.getInstance().getAdDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("er");
        }
        System.out.println("all is good");
        Iterator iterator =advertisement.iterator();
        while (iterator.hasNext()){
            Ad ad = (Ad) iterator.next();
            System.out.println(ad.toString());
        }

    }
}
