package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

import java.util.ArrayList;

public class MyCarParkingDeserializerJSON implements CarParkingDeserializer {
    public CarParking deserialize(String serializedCarParking) {

        // парсим строку к нужному мне формату и создаем арейлист масивов ключ: значение
        String[] strings = serializedCarParking.replace("\"", "").replace(",", "").split("\n");
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (String ss : strings) {
            while (ss.indexOf("  ") >= 0) {
                String replace = ss.replace("  ", "");
                ss = replace;
            }
            if (ss.length() > 1 || ss.equals("}"))
                arrayList.add(ss.split(": "));
        }
        // создаем объект Carparking && Car
        CarParking carParking = new CarParking();
        Car[] cars = new Car[]{};
        /////////////////////////////////////////////////
        carParking.setAddress(arrayList.get(0)[1]); // адрес парковки
        carParking.setParkingName(arrayList.get(1)[1]); // название парковки
        // заполняем паркинг
        int kol = 0;
        if (arrayList.size() > 6)
            kol = 1;

        for (int i = 3; i < arrayList.size(); i++) {
            if (arrayList.get(i).length == 1) { // пропускаем разделитель нового объекта в масиве car
                kol++;
                break;
            } else {
                cars[kol - 1] = new Car();
                for (int j = 0; j < arrayList.get(i).length; j++) {
                    cars[kol - 1].setManufacturer(arrayList.get(i)[1]);
                    cars[kol - 1].setModelName(arrayList.get(i)[1]);
                    cars[kol - 1].setVin(arrayList.get(i)[1]);
                    cars[kol - 1].setLengthMillimeters(Integer.parseInt(arrayList.get(i)[1]));
                    cars[kol - 1].setHeightMillimeters(Integer.parseInt(arrayList.get(i)[1]));
                }
            }
        }
        carParking.setCars(cars);
        return carParking;
    }

}
