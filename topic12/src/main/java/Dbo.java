

import java.sql.*;
import static java.sql.DriverManager.*;
import Query.*;

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
    private Request query = new Request();
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
        Connection con = getConnection(host + "/" + data, user, password); // открытие соединения к базе
        statement = con.createStatement();
    }

    public void addAdvertisement(String carName, int price) throws SQLException {
        sql = "INSERT INTO person.advertisement (CAR_NAME,PRICE) " +
                "VALUES (" + "'" + carName + "'" + "," + price + ")";
        // statement.executeUpdate(sql);
        rs = statement.executeQuery(query.getMaxId());
        rs.next();
        id = rs.getInt(1);
        System.out.println("database update");
    }

    public ResultSet findCars() throws SQLException {
        String carName, manufacturer = "";
        carName = "M";
        manufacturer = "M";
        Connection con = getConnection(host + "/" + data, user, password); // открытие соединения к базе
        sql = query.getFindCars();
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
        return query.getSelectAll();
    }

}
