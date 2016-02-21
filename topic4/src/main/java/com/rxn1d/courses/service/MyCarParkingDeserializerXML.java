package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

import java.util.ArrayList;

public class MyCarParkingDeserializerXML implements CarParkingDeserializer {
    @Override
    public CarParking deserialize(String serializedCarParking) {
        String[] strings = serializedCarParking.replace(">", "").replace("<", "").replace(" ", "").split("\n");
        for (String ss : strings) {
            while (ss.indexOf(" ") >= 0) {
                String replace = ss.replace(" ", "");
                ss = replace;
            }
        }
        ArrayList<String[]> carLists = new ArrayList<>();
        for (int i = 5; i < strings.length; i++) {
            if (strings[i].equals("cars"))
                break;
            if (strings[i].equals("car")) {
                String[] value = new String[5];
                value[0] = getValue(strings[i + 1]);
                value[1] = getValue(strings[i + 2]);
                value[2] = getValue(strings[i + 3]);
                value[3] = getValue(strings[i + 4]);
                value[4] = getValue(strings[i + 5]);
                carLists.add(value);
            }
        }
        CarParking carParking = new CarParking();
        carParking.setParkingName(strings[2].substring(strings[2].indexOf("address") + 7, strings[2].length() - 8));
        carParking.setAddress(strings[3].substring(strings[3].indexOf("parkingName") + 11, strings[3].length() - 12));
        Car[] cars = new Car[]{};
        if (carLists.size() != 0) {
            for (int i = 0; i < carLists.size(); i++) {
                cars[i].setManufacturer(carLists.get(i)[0]);
                cars[i].setModelName(carLists.get(i)[1]);
                cars[i].setVin(carLists.get(i)[2]);
                cars[i].setLengthMillimeters(Integer.parseInt(carLists.get(i)[3]));
                cars[i].setHeightMillimeters(Integer.parseInt(carLists.get(i)[4]));
            }
        }
        carParking.setCars(cars);
        return carParking;
    }

    public static String getValue(String value) {
        if (value.indexOf("manufacturer") >= 0)
            return value.substring(value.indexOf("manufacturer") + 12, value.length() - 13);
        else if (value.indexOf("modelName") >= 0)
            return value.substring(value.indexOf("modelName") + 9, value.length() - 10);
        else if (value.indexOf("vin") >= 0)
            return value.substring(value.indexOf("vin") + 3, value.length() - 4);
        else if (value.indexOf("lengthMillimeters") >= 0)
            return value.substring(value.indexOf("lengthMillimeters") + 17, value.length() - 18);
        else if (value.indexOf("heightMillimeters") >= 0)
            return value.substring(value.indexOf("heightMillimeters") + 17, value.length() - 18);
        else
            return "";
    }
}
