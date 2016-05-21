import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 16.05.2016.
 */
public class MyHttpServlet extends HttpServlet {
    private List advertisement;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            advertisement = Factory.getInstance().getAdDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("er");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().println("all is good");
    }
}
