package com.courses.spalah.Query;

/**
 * Created by Администратор on 29.03.2016.
 */
public final class Request {
    private static final String findCars = "SELECT +\n" +
            "  t1.CAR_NAME,\n" +
            "  t2.MANUFACTURER,\n" +
            "  t2.YEAR_OUT,\n" +
            "  t2.VIN,\n" +
            "  t2.DESCRIPTION,\n" +
            "  t1.PRICE,\n" +
            "  concat(t2.NAME,' ',t3.PHONE) as CONTACT\n" +

            "FROM advertisement AS t1\n" +
            "  JOIN cars AS t2 ON t1.ID= t2.ID\n" +
            "  JOIN owner AS t3 ON t2.NAME = t3.NAME\n" +

            "WHERE CAR_NAME = ? " +
            "      AND MANUFACTURER = ? " +
            "      AND YEAR_OUT BETWEEN ? AND ? " +
            "      AND PRICE BETWEEN ? AND ? ";

    private static final String selectAll = "SELECT\n" +
            "advertisement.ID,\n" +
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
    private static final String maxId = "select max(ID) from person.advertisement";
    private static final String updateAdvertisement = "INSERT INTO advertisement (CAR_NAME,PRICE,ID) " +
            "VALUES ( ? , ? , ? )";
    private static final String updateCars = "INSERT INTO cars (ID,NAME,MANUFACTURER,YEAR_OUT,VIN,DESCRIPTION) " +
            "VALUES (?,?,?,?,?,?)";
    private static final String updateOwner = "INSERT INTO owner (NAME,FIO,PHONE,ID) " +
            "VALUES (?,?,?,?)";
    private static final String deleteAdvertisement = "DELETE FROM advertisement where ID=?";
    private static final String deleteCars = "DELETE FROM cars where ID=?";
    private static final String deleteOwner = "DELETE FROM owner where ID=?";

    public String getFindCars() {
        return findCars;
    }

    public String getSelectAll() {
        return selectAll;
    }

    public String getMaxId() {
        return maxId;
    }

    public String getUpdateAdvertisement() {
        return updateAdvertisement;
    }

    public String getUpdateCars() {
        return updateCars;
    }

    public String getUpdateOwner() {
        return updateOwner;
    }

    public String getDeleteAdvertisement() {
        return deleteAdvertisement;
    }

    public String getDeleteCars() {
        return deleteCars;
    }

    public String getDeleteOwner() {
        return deleteOwner;
    }
}