package ru.job4j.food.store;

import ru.job4j.food.model.Food;

import java.util.Calendar;
import java.util.List;

public abstract class AbstractStore implements Store {

    abstract public List<Food> getStore();

    abstract public void setStore(List<Food> listFood);

    abstract public void clearStore();

    abstract public void putIntoStore(Food food);

    abstract public boolean removeFromStore(Food food);

    abstract public boolean findInStore(Food food);

    public double countPercentageOfExpiration(Food food) {
        long created = food.getCreateDate().getTimeInMillis();
        long expire = food.getExpiryDate().getTimeInMillis();
        return (((Calendar.getInstance().getTimeInMillis() - created) * 100) / (expire - created));
    }
}
