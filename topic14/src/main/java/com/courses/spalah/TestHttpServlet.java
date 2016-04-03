package com.courses.spalah;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import com.courses.spalah.DataBaseObjects.DataBaseConnection;
import com.courses.spalah.DataBaseObjects.DataBaseType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Ievgen Tararaka
 */
public class TestHttpServlet extends HttpServlet {
    private Statement st;
    private ResultSet rs;
    private Connection connection;
    private DataBaseConnection dbo;
    private ArrayList<String> model;
    private ArrayList<Integer> type;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbo = new DataBaseConnection("jdbc:mysql://localhost:3306", "person", "root", "");
        Map parameterMap = request.getParameterMap();
        try {
            dbo.dboConnection(DataBaseType.mySQL);
            connection = dbo.getCon();
            if (parameterMap.size()!=6){
                response.getWriter().write(makeJsonSelect("ALL").toJSONString());
            }
            else{
                model=new ArrayList<>();
                type=new ArrayList<>();
                model.add(request.getParameter("manufacturer"));
                model.add(request.getParameter("modelName"));
                type.add(Integer.parseInt(request.getParameter("yearFrom")));
                type.add(Integer.parseInt(request.getParameter("yearTo")));
                type.add(Integer.parseInt(request.getParameter("priceFrom")));
                type.add(Integer.parseInt(request.getParameter("priceTo")));
                response.getWriter().write(makeJsonSelect("").toJSONString());
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private JSONObject makeJsonSelect(String query) throws SQLException {
        if (query.equals("ALL")) {
             rs= dbo.makeSelect();
        }
        else{
            rs=dbo.findCars(model,type);
        }

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<String> columnNames = new ArrayList();
        ArrayList<ArrayList> data = new ArrayList();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
        }
        while (rs.next()) {
            ArrayList<String> row = new ArrayList();
            for (int i = 0; i < columnCount; i++) {
                row.add(rs.getString(i + 1));
            }
            data.add(row);
        }

        JSONArray ar = null;
        JSONObject obj = null;
        JSONObject resultJson = new JSONObject();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            obj = new JSONObject();
            for (int j = 0; j < columnNames.size(); j++) {
                obj.put(columnNames.get(j), data.get(i).get(j));
            }
            resultJson.put(i, obj);
        }
        return resultJson;
    }

}
