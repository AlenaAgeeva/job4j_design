package ru.job4j.food.store;

import ru.job4j.food.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    private List<Food> shopFood;

    public Shop() {
        this.shopFood = new ArrayList<>();
    }

    public List<Food> getStore() {
        return shopFood;
    }

    public void setStore(List<Food> shopFood) {
        this.shopFood = shopFood;
    }

    public void clearStore() {
        shopFood.clear();
    }

    public void putIntoStore(Food food) {
        if (!shopFood.contains(food)) {
            shopFood.add(food);
        }
    }

    public boolean removeFromStore(Food food) {
        return shopFood.remove(food);
    }

    @Override
    public boolean findInStore(Food food) {
        return shopFood.contains(food);
    }

    @Override
    public boolean checkExpiration(Food food) {
        if (countPercentageOfExpiration(food) >= 75. && countPercentageOfExpiration(food) < 99.) {
            food.setDiscount(20.);
            return true;
        }
        return countPercentageOfExpiration(food) >= 25. && countPercentageOfExpiration(food) < 75.;
    }
}
