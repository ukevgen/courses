package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Администратор on 21.02.2016.
 */
public class MyCarParkingSerializerXML implements CarParkingSerializer {
   public String serialize(CarParking carParking){
       StringBuilder builder = new StringBuilder();
       builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<carParking>\n" +
               "    <address>");
       builder.append(carParking.getAddress());
       builder.append("</address>\n" +
               "    <parkingName>");
       builder.append(carParking.getParkingName());
       builder.append("</parkingName>\n" +
               "    <cars>\n" +
               "        ");
       for (Car car:carParking.getCars()){
           builder.append("<car>\n" +
                   "            ");
           builder.append("<manufacturer>"+ car.getManufacturer()+"</manufacturer>\n" +
                   "            ");
           builder.append("<modelName>"+car.getModelName()+"</modelName>\n" +
                   "            <vin>"+car.getVin()+"</vin>\n" +
                   "            <lengthMillimeters>"+car.getLengthMillimeters()+"</lengthMillimeters>\n" +
                   "            <heightMillimeters>"+car.getHeightMillimeters()+"</heightMillimeters>\n" +
                   "        </car>\n" +
                   "        ");
       }
       builder.append("\n" +               "    </cars>\n" +               "</carParking>");
        return builder.toString();
    }
}
