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

    public Car() {
    }

    public Car(int priceInDollars, String modelName) {
        this.priceInDollars = priceInDollars;
        this.modelName = modelName;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (priceInDollars != car.priceInDollars) return false;
        return modelName.equals(car.modelName);

    }

    @Override
    public int hashCode() {
        int result = priceInDollars;
        result = 31 * result + modelName.hashCode();
        return result;
    }
}
