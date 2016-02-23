package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

public class MyCarParkingSerializerJSON implements CarParkingSerializer {
    public String serialize(CarParking carParking) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        builder.append("  \"address\": "+"\"");
        builder.append(carParking.getAddress());
        builder.append("\", \n");
        builder.append("\"parkingName\": \"");
        builder.append(carParking.getParkingName());
        builder.append("\", \n \"cars\": [\n");

        for (Car car : carParking.getCars()) {
            builder.append("" + "    {\n");
            builder.append("      \"manufacturer\": \"");
            builder.append(car.getManufacturer());
            builder.append("\",\n");
            builder.append("      \"modelName\": \"");
            builder.append(car.getModelName());
            builder.append("\",\n");
            builder.append("      \"vin\": \"");
            builder.append(car.getVin());
            builder.append("\",\n");
            builder.append("      \"lengthMillimeters\": ");
            builder.append(car.getLengthMillimeters());
            builder.append(",\n");
            builder.append("      \"heightMillimeters\": ");
            builder.append(car.getHeightMillimeters());
            builder.append("\n" + "    },\n");
        }
        builder.deleteCharAt(builder.length() - 2);
        builder.append("  ]\n");
        builder.append("}");


        return builder.toString();
    }
}
