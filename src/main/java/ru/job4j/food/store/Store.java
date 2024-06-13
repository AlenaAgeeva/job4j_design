package ru.job4j.food.store;

import ru.job4j.food.model.Food;

import java.util.List;

public interface Store {
    void clearStore();

    void putIntoStore(Food food);

    boolean removeFromStore(Food food);

    boolean checkExpiration(Food food);

    boolean findInStore(Food food);

    List<Food> getStore();
}
