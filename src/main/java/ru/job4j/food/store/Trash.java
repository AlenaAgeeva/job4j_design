package ru.job4j.food.store;

import ru.job4j.food.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    private List<Food> trashFood;

    public Trash() {
        this.trashFood = new ArrayList<>();
    }

    public List<Food> getStore() {
        return trashFood;
    }

    public void setStore(List<Food> trashFood) {
        this.trashFood = trashFood;
    }

    public void clearStore() {
        trashFood.clear();
    }

    public void putIntoStore(Food food) {
        trashFood.add(food);
    }

    public boolean removeFromStore(Food food) {
        return trashFood.remove(food);
    }

    @Override
    public boolean findInStore(Food food) {
        return trashFood.contains(food);
    }

    @Override
    public boolean checkExpiration(Food food) {
        return countPercentageOfExpiration(food) > 99.;
    }
}
