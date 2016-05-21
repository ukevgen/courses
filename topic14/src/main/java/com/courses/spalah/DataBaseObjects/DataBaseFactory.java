package com.courses.spalah.DataBaseObjects;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;

/**
 * Created by Администратор on 03.04.2016.
 */
public class DataBaseFactory {
    public  Driver creatConnection (DataBaseType type) throws SQLException {
        if (type==DataBaseType.mySQL){
            return new com.mysql.jdbc.Driver();
        }
        else return null;
    }
}
