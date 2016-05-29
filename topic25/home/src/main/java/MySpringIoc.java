import Dao.Imp.BankDaoImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Администратор on 26.05.2016.
 */
public class MySpringIoc {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("home.xml");
        BankDaoImp bankDaoImp = context.getBean("factory",Factory.class).getDaoBank();
        bankDaoImp.test();
    }
}
