package main.java.com.courses.spalah;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import main.java.com.courses.spalah.DataBaseObjects.DataBaseConnection;
import main.java.com.courses.spalah.DataBaseObjects.DataBaseType;
import org.json.simple.JSONObject;

/**
 * @author ukEvgen
 */
public class MyHttpServlet extends HttpServlet {
    private static final int MAX_MAP_SIZE = 8;
    private static final String SELECT_ALL = "ALL";
    private static final String FIND_CARS = "FIND";
    private DataBaseConnection dbo;

    private ArrayList<String> model;
    private ArrayList<Integer> type;

    @Override
    public void init() throws ServletException {
        super.init();
        dbo = new DataBaseConnection("jdbc:mysql://localhost:3306", "person", "root", "");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map parameterMap = request.getParameterMap();
        try {
            dbo.dboConnection(DataBaseType.mySQL);
            if (parameterMap.size() != MAX_MAP_SIZE) {
                response.getWriter().write(makeJsonSelect(SELECT_ALL).toJSONString());
            } else {
                model = makeModel(request);
                type = makeType(request);
                response.getWriter().write(makeJsonSelect(FIND_CARS).toJSONString());
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map parameterMap = request.getParameterMap();
        try {
            dbo.dboConnection(DataBaseType.mySQL);
            if (parameterMap.size() != MAX_MAP_SIZE) {
                response.getOutputStream().println("Sorry, input all parametrs");
            } else {

                if (dbo.addRow(updateTable(request)))
                    response.getOutputStream().println("Ok");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private JSONObject makeJsonSelect(String query) throws SQLException {
        ResultSet rs;
        if (query.equals("ALL")) {
            rs = dbo.makeSelect();
        } else {
            rs = dbo.findCars(model, type);
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

        JSONObject obj;
        JSONObject resultJson = new JSONObject();
        for (int i = 0; i < data.size(); i++) {
            obj = new JSONObject();
            for (int j = 0; j < columnNames.size(); j++) {
                obj.put(columnNames.get(j), data.get(i).get(j));
            }
            resultJson.put(i, obj);
        }
        return resultJson;
    }

    private ArrayList makeModel(HttpServletRequest rq) {
        model.add(rq.getParameter("manufacturer"));
        model.add(rq.getParameter("modelName"));
        return model;
    }

    private ArrayList makeType(HttpServletRequest rq) {
        type.add(Integer.parseInt(rq.getParameter("yearFrom")));
        type.add(Integer.parseInt(rq.getParameter("yearTo")));
        type.add(Integer.parseInt(rq.getParameter("priceFrom")));
        type.add(Integer.parseInt(rq.getParameter("priceTo")));
        return type;
    }

    private ArrayList updateTable(HttpServletRequest rq) {
        model.add(rq.getParameter("manufacturer"));
        model.add(rq.getParameter("modelName"));
        model.add(rq.getParameter("year"));
        model.add(rq.getParameter("vin"));
        model.add(rq.getParameter("description"));
        model.add(rq.getParameter("price"));
        model.add(rq.getParameter("contact_phone"));
        model.add(rq.getParameter("name"));
        return model;
    }

}
