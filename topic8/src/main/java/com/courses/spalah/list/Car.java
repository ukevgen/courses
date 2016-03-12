package com.courses.spalah.list;

/**
 * Вам необходимо понять, что не хватаем этому классу, чтобы он имел возможность
 * учавствовать в коллекциях (правильно)
 *
 * @author Ievgen Tararaka
 */
public class Car {
    private int priceInDollars;
    private String modelName;

    public Car(int priceInDollars, String modelName) {
        this.priceInDollars = priceInDollars;
        this.modelName = modelName;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        if (((Car) o).getPriceInDollars() == priceInDollars && ((Car) o).getModelName().equals(modelName)) {
            return true;
        }
        return false;
    }

}
