import com.sun.prism.impl.Disposer;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.*;


/**
 * Created by Администратор on 27.03.2016.
 */
public class Dbo {
    private String host;
    private String data;
    private String user;
    private String password;
    private Statement statement;
    private ResultSet rs;
    private Connection con;
    private int id;
    String sql;

    public Dbo(String host, String data, String user, String password) {
        this.host = host;
        this.data = data;
        this.user = user;
        this.password = password;
    }

    public ResultSet makeSelect(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void dboConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        registerDriver(new com.mysql.jdbc.Driver()); // или любой другой драйвер
        con = getConnection("jdbc:mysql://" + host + "/" + data, user, password); // открытие соединения к базе
        statement = con.createStatement();

    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    public void addAdvertisement(String carName, int price) throws SQLException {
        sql = "INSERT INTO person.advertisement (CAR_NAME,PRICE) " +
                "VALUES (" + "'" + carName + "'" + "," + price + ")";
        // statement.executeUpdate(sql);
        rs = statement.executeQuery("select max(ID) from person.advertisement");
        rs.next();
        id = rs.getInt(1);
        System.out.println("database update");
    }

    public ResultSet findCars() throws SQLException {
        String carName, manufacturer = "";
        carName = "M";
        manufacturer = "M";

        sql = "SELECT" +
                "  t1.CAR_NAME," +
                "  t2.MANUFACTURER," +
                "  t2.YEAR_OUT," +
                "  t2.VIN," +
                "  t2.DESCRIPTION," +
                "  t1.PRICE," +
                "  concat(t2.NAME,' ',t3.PHONE) as CONTACT" +
                " " +
                "FROM advertisement AS t1" +
                "  JOIN cars AS t2 ON t1.ID = t2.ID" +
                "  JOIN owner AS t3 ON t2.NAME = t3.NAME" +
                " " +
                "WHERE CAR_NAME LIKE ? " +
                "      AND MANUFACTURER LIKE ? " +
                "      AND YEAR_OUT BETWEEN ? AND ? " +
                "      AND PRICE BETWEEN ? AND ? ";

        PreparedStatement pr = con.prepareStatement(sql);
        pr.setString(1, carName+"%");
        pr.setString(2, manufacturer+"%");
        pr.setInt(3, 2000);
        pr.setInt(4, 2010);
        pr.setInt(5, 1000);
        pr.setInt(6, 50000);
        System.out.println("query done");
        return rs = pr.executeQuery();

    }

    public String selectAll() {
        return "SELECT\n" +
                "  advertisement.CAR_NAME,\n" +
                "  cars.MANUFACTURER,\n" +
                "  cars.YEAR_OUT,\n" +
                "  cars.VIN,\n" +
                "  cars.DESCRIPTION,\n" +
                "  advertisement.PRICE,\n" +
                "  concat(cars.NAME,' ',owner.PHONE) as CONTACT\n" +
                "\n" +
                "FROM advertisement\n" +
                "  JOIN cars ON cars.ID = advertisement.ID\n" +
                "  JOIN owner  ON cars.NAME = owner.NAME;\n" +
                "\n" +
                "\n";
    }

}
