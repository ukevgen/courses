import Dao.Imp.BankDaoImp;
import Domain.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 26.05.2016.
 */
public class MySpringIoc {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("home.xml");
        BankDaoImp bankDaoImp = context.getBean("factory",Factory.class).getDaoBank();
        List<Client> clients = bankDaoImp.getAllClient();
        System.out.println(clients.size());
        Iterator iterator = clients.iterator();
        while (iterator.hasNext()){
            Client client = (Client)iterator.next();
            System.out.println(client.toString());
        }
    }
}
