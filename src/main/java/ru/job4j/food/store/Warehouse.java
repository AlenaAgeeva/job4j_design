package ru.job4j.food.store;

import ru.job4j.food.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    private List<Food> wareHouseFood;

    public Warehouse() {
        this.wareHouseFood = new ArrayList<>();
    }

    public List<Food> getStore() {
        return wareHouseFood;
    }

    public void setStore(List<Food> wareHouseFood) {
        this.wareHouseFood = wareHouseFood;
    }

    public void clearStore() {
        wareHouseFood.clear();
    }

    public void putIntoStore(Food food) {
        wareHouseFood.add(food);
    }

    public boolean removeFromStore(Food food) {
        return wareHouseFood.remove(food);
    }

    @Override
    public boolean findInStore(Food food) {
        return wareHouseFood.contains(food);
    }

    @Override
    public boolean checkExpiration(Food food) {
        return countPercentageOfExpiration(food) < 25.;
    }
}
