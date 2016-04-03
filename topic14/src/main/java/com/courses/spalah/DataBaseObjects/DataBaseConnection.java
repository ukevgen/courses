package com.courses.spalah.DataBaseObjects;

import com.courses.spalah.Query.Request;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.registerDriver;

/**
 * Created by Администратор on 03.04.2016.
 */
public class DataBaseConnection {
    private String host;
    private String data;
    private String user;
    private String password;
    private Connection con;
    private Statement statement;
    private String sql;
    private Request query = new Request();

    public DataBaseConnection(String host, String data, String user, String password) {
        this.host = host;
        this.data = data;
        this.user = user;
        this.password = password;
    }

    public void dboConnection(DataBaseType type) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        registerDriver(new DataBaseFactory().creatConnection(type)); // или любой другой драйвер
        con = myConnection();
        statement = con.createStatement();

    }

    private Connection myConnection() throws SQLException {
        if (con == null)
            con = getConnection(host + "/" + data, user, password); // открытие соединения к базе
        return con;
    }

    public Connection getCon() {
        return con;
    }

    public ResultSet makeSelect() throws SQLException {
        return statement.executeQuery(query.getSelectAll());
    }

    public ResultSet findCars(ArrayList<String> arrayList, ArrayList<Integer> intList) throws SQLException {
        con = myConnection();
        System.out.println("Соединение утсановлено");
        sql = query.getFindCars();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setString(1, arrayList.get(0));
        pr.setString(2, arrayList.get(1));
        pr.setInt(3, intList.get(0));
        pr.setInt(4, intList.get(1));
        pr.setInt(5, intList.get(2));
        pr.setInt(6, intList.get(3));
        return pr.executeQuery();
    }
}
