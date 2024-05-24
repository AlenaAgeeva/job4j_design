package ru.job4j.food;

import ru.job4j.food.model.Food;
import ru.job4j.food.store.Store;

import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void deleteStore(Store store) {
        stores.remove(store);
    }

    public Store allocateFood(Food food) {
        Store store = stores.stream()
                .filter(s -> s.checkExpiration(food))
                .findFirst().
                get();
        store.putIntoStore(food);
        return store;
    }
}
