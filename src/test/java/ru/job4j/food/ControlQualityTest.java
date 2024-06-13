package ru.job4j.food;

import org.junit.jupiter.api.Test;
import ru.job4j.food.model.Fish;
import ru.job4j.food.model.Food;
import ru.job4j.food.model.Meat;
import ru.job4j.food.model.Milk;
import ru.job4j.food.store.Shop;
import ru.job4j.food.store.Trash;
import ru.job4j.food.store.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenAllocateTrashFood() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Shop(), new Trash(), new Warehouse()));
        Food beef = new Meat(
                "beef",
                new GregorianCalendar(2019, 6, 27, 16, 16, 47),
                new GregorianCalendar(2018, 6, 27, 16, 16, 47),
                500.5,
                25.5);
        assertThat(controlQuality.allocateFood(beef)).isInstanceOf(Trash.class);
    }

    @Test
    void whenAllocateShopFood() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Shop(), new Trash(), new Warehouse()));
        Food goatMilk = new Milk(
                "goat milk",
                new GregorianCalendar(Calendar.getInstance().getWeekYear(), 8, 10, 16, 16, 47),
                new GregorianCalendar(Calendar.getInstance().getWeekYear(), 1, 2, 8, 16, 47),
                45.5,
                30.);
        assertThat(controlQuality.allocateFood(goatMilk)).isInstanceOf(Shop.class);
    }

    @Test
    void whenAllocateWareHouseFood() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Shop(), new Trash(), new Warehouse()));
        Food haddock = new Fish(
                "haddock",
                new GregorianCalendar(Calendar.getInstance().getWeekYear() + 1, 9, 23, 16, 16, 47),
                new GregorianCalendar(2024, 1, 2, 8, 16, 47),
                103.5,
                65.);
        assertThat(controlQuality.allocateFood(haddock)).isInstanceOf(Warehouse.class);
    }

    @Test
    void whenResortAllFoodFromAllStores() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Shop(), new Trash(), new Warehouse()));
        Food haddock = new Fish(
                "haddock",
                new GregorianCalendar(Calendar.getInstance().getWeekYear() + 1, 9, 23, 16, 16, 47),
                new GregorianCalendar(2024, 1, 2, 8, 16, 47),
                103.5,
                65.);
        Food goatMilk = new Milk(
                "goat milk",
                new GregorianCalendar(Calendar.getInstance().getWeekYear(), 8, 10, 16, 16, 47),
                new GregorianCalendar(Calendar.getInstance().getWeekYear(), 1, 2, 8, 16, 47),
                45.5,
                30.);
        Food beef = new Meat(
                "beef",
                new GregorianCalendar(2019, 6, 27, 16, 16, 47),
                new GregorianCalendar(2018, 6, 27, 16, 16, 47),
                500.5,
                25.5);
        assertThat(controlQuality.allocateFood(haddock)).isInstanceOf(Warehouse.class);
        assertThat(controlQuality.allocateFood(goatMilk)).isInstanceOf(Shop.class);
        assertThat(controlQuality.allocateFood(beef)).isInstanceOf(Trash.class);
        assertThat(controlQuality.getStores().get(1).getStore().contains(haddock)).isFalse();
        haddock.setExpiryDate(new GregorianCalendar(2019, 6, 27, 16, 16, 47));
        haddock.setCreateDate(new GregorianCalendar(2018, 6, 27, 16, 16, 47));
        controlQuality.resort();
        assertThat(controlQuality.allocateFood(haddock)).isInstanceOf(Trash.class);
        assertThat(controlQuality.getStores().get(1).getStore().contains(haddock)).isTrue();
    }
}