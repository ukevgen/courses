package mytask;


import mytask.*;
import mytask.domain.Client;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 21.05.2016.
 */
public class MyJpaApplication {
    public static void main(String[] args) {

        List clients=Factory.getInstance().getDaoBank().getAllClient();
        System.out.println(clients.size());
        Iterator iterator = clients.iterator();
        while (iterator.hasNext()){
            Client client = (Client)iterator.next();
            System.out.println(client.toString());
        }

    }
}
