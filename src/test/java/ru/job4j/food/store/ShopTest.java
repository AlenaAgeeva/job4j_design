package ru.job4j.food.store;

import org.junit.jupiter.api.Test;
import ru.job4j.food.model.Food;
import ru.job4j.food.model.Meat;
import ru.job4j.food.model.Milk;

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenExpirationFalse() {
        Food spoiled = new Meat(
                "beef",
                new GregorianCalendar(2019, 6, 27, 16, 16, 47),
                new GregorianCalendar(2018, 6, 27, 16, 16, 47),
                500.5,
                25.5);
        assertThat(new Shop().checkExpiration(spoiled)).isFalse();
    }

    @Test
    void whenExpirationTrue() {
        Food goatMilk = new Milk(
                "goat milk",
                new GregorianCalendar(2024, 8, 10, 16, 16, 47),
                new GregorianCalendar(2024, 1, 2, 8, 16, 47),
                45.5,
                30.);
        assertThat(new Shop().checkExpiration(goatMilk)).isTrue();
    }
}