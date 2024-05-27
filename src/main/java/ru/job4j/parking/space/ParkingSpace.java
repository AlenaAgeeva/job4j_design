package ru.job4j.parking.space;

import ru.job4j.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
    private final List<Car> space;
    private int passengerCarQuantity;
    private int truckQuantity;

    public ParkingSpace(int passengerCarNumber, int truckNumber) {
        this.passengerCarQuantity = passengerCarNumber;
        this.truckQuantity = truckNumber;
        this.space = new ArrayList<>();
    }

    public int getPassengerCarQuantity() {
        return passengerCarQuantity;
    }

    public void setPassengerCarQuantity(int passengerCarQuantity) {
        this.passengerCarQuantity = passengerCarQuantity;
    }

    public int getTruckQuantity() {
        return truckQuantity;
    }

    public void setTruckQuantity(int truckQuantity) {
        this.truckQuantity = truckQuantity;
    }

    public List<Car> getSpace() {
        return space;
    }

    public int calculateFreeParkingSpace() {
        return 0;
    }
}