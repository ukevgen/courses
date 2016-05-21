

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static java.sql.DriverManager.*;
import static java.sql.DriverManager.getConnection;

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
    private Connection con;
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
        con = myConnection();
        statement = con.createStatement();
    }

    public void dellAdvertisement(int deleteId) throws SQLException {
        con = myConnection();
        sql = query.getDeleteAdvertisement();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, deleteId);
        pr.executeQuery();
        pr.close();
        sql = query.getDeleteCars();
        pr = con.prepareStatement(sql);
        pr.setInt(1, deleteId);
        pr.executeQuery();
        pr.close();
        sql = query.getUpdateOwner();
        pr = con.prepareStatement(sql);
        pr.setInt(1, deleteId);
        pr.executeQuery();
        pr.close();
    }

    public void addAdvertisement(int tekId, HashMap<String, ArrayList<String>> map) throws SQLException {
        sql = query.getUpdateAdvertisement();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, tekId);
        pr.setString(2, map.get("advert").get(0));
        pr.setInt(3, Integer.parseInt(map.get("advert").get(0)));
        pr.executeQuery();
        sql = query.getUpdateCars();
        pr.close();
        pr = con.prepareStatement(sql);
        pr.setInt(1, tekId);
        pr.setString(2, map.get("cars").get(0));
        pr.setString(3, map.get("cars").get(0));
        pr.setInt(4, Integer.parseInt(map.get("cars").get(0)));
        pr.setString(5, map.get("cars").get(0));
        pr.setString(6, map.get("cars").get(0));
        pr.executeQuery();
        sql = query.getUpdateOwner();
        pr.close();
        pr = con.prepareStatement(sql);
        pr.setString(1, map.get("owner").get(0));
        pr.setString(2, map.get("owner").get(1));
        pr.setString(3, map.get("owner").get(2));
        pr.setInt(4, tekId);
        pr.executeQuery();
        pr.close();
        System.out.println("database update");
    }

    public ResultSet findCars(ArrayList<String> arrayList, ArrayList<Integer> intList) throws SQLException {
        con = myConnection();
        System.out.println("Соединение утсановлено");
        sql = query.getFindCars();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setString(1, arrayList.get(0) + "%");
        pr.setString(2, arrayList.get(1) + "%");
        pr.setInt(3, intList.get(0));
        pr.setInt(4, intList.get(1));
        pr.setInt(5, intList.get(2));
        pr.setInt(6, intList.get(3));
        System.out.println("query done");
        return rs = pr.executeQuery();
    }

    public String selectAll() {
        return query.getSelectAll();
    }

    public int getId() {
        sql = query.getMaxId();
        try {
            rs = statement.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private Connection myConnection() throws SQLException {
        if (con == null)
            con = getConnection(host + "/" + data, user, password); // открытие соединения к базе
        return con;
    }

}
