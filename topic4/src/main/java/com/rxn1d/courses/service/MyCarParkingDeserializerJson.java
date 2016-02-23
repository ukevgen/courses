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

        /////////////////////////////////////////////////
        carParking.setAddress(arrayList.get(0)[0]); // адрес парковки
        carParking.setParkingName(arrayList.get(1)[1]); // название парковки
        // заполняем паркинг
        int kol = 0;
        if (arrayList.size() > 6)
            kol = 1;
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 3; i < arrayList.size(); i++) {
            if (arrayList.get(i).length == 1) { // пропускаем разделитель нового объекта в масиве car
                kol++;
                break;
            } else {

                for (int j = 0; j < 2; j++) {
                    cars.add(new Car(arrayList.get(i)[1],arrayList.get(i)[1],arrayList.get(i)[1],Integer.parseInt(arrayList.get(i)[1]),Integer.parseInt(arrayList.get(i)[1])));

                }
            }
        }
        carParking.setCars(cars.toArray(new Car[cars.size()]));
        return carParking;
    }

}
