package ru.job4j.parking.service;

import org.junit.jupiter.api.Test;
import ru.job4j.parking.car.Car;
import ru.job4j.parking.car.PassengerCar;
import ru.job4j.parking.car.Truck;
import ru.job4j.parking.exception.ParkingException;
import ru.job4j.parking.space.ParkingSpace;

import static org.assertj.core.api.Assertions.*;

class ParkingServiceTest {

    @Test
    void whenCarIsPlacedIntoSpace() throws ParkingException {
        ParkingService parkingService = new ParkingService(new ParkingSpace(10, 5));
        Car car = new PassengerCar("Nissan", 1);
        parkingService.placeCar(car);
        assertThat(parkingService.getParkingSpace().getSpace().contains(car));
    }

    @Test
    void whenCarIsRemovedFromSpace() throws ParkingException {
        ParkingService parkingService = new ParkingService(new ParkingSpace(10, 5));
        Car nissan = new PassengerCar("Nissan", 1);
        Car audi = new PassengerCar("Audi", 1);
        Car mercedes = new PassengerCar("Mercedes", 1);
        parkingService.placeCar(nissan);
        parkingService.placeCar(audi);
        parkingService.placeCar(mercedes);
        parkingService.removeCar(audi);
        assertThat(!parkingService.getParkingSpace().getSpace().contains(audi));
    }

    @Test
    void whenNoParkingSpaceAndError() throws ParkingException {
        ParkingSpace parkingSpace = new ParkingSpace(10, 5);
        ParkingService parkingService = new ParkingService(parkingSpace);
        Car nissan = new PassengerCar("Nissan", 1);
        Car audi = new PassengerCar("Audi", 1);
        Car mercedes = new PassengerCar("Mercedes", 1);
        Car vaz = new Truck("Vaz", 7);
        Car hyundai = new Truck("Hyundai", 7);
        parkingService.placeCar(nissan);
        parkingService.placeCar(audi);
        parkingService.placeCar(mercedes);
        parkingService.placeCar(vaz);
        parkingService.placeCar(hyundai);
        assertThatThrownBy(() -> parkingService.placeCar(hyundai)).isInstanceOf(ParkingException.class);
    }
}