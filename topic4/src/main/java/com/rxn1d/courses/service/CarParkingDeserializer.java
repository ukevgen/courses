package com.rxn1d.courses.service;

import com.rxn1d.courses.model.CarParking;

/**
 * Интерфейс для парс
 *
 * @author Ievgen Tararaka
 */
public interface CarParkingDeserializer {
    CarParking deserialize(String serializedCarParking);
}
