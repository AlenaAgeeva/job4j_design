package ru.job4j.parking.service;

import ru.job4j.parking.car.Car;
import ru.job4j.parking.exception.ParkingException;
import ru.job4j.parking.space.ParkingSpace;

public class ParkingService {
    private ParkingSpace parkingSpace;

    public ParkingService(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public boolean placeCar(Car car) throws ParkingException {
        if (parkingSpace.calculateFreeParkingSpace() <= 0) {
            throw new ParkingException("No free parking space available.");
        }
        return parkingSpace.getSpace().add(car);
    }

    public boolean removeCar(Car car) throws ParkingException {
        if (!parkingSpace.getSpace().contains(car)) {
            throw new ParkingException("No such a car onto parking space.");
        }
        return parkingSpace.getSpace().remove(car);
    }
}
