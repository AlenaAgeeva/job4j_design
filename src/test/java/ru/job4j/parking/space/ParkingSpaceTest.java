package ru.job4j.parking.space;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.parking.car.Car;
import ru.job4j.parking.car.PassengerCar;
import ru.job4j.parking.car.Truck;
import ru.job4j.parking.exception.ParkingException;
import ru.job4j.parking.service.ParkingService;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingSpaceTest {

    /*@Test*/
    void calculateFreeParkingSpaceWhenNoCarsIntoParkingSpace() {
        ParkingSpace parkingSpace = new ParkingSpace(10, 5);
        assertThat(parkingSpace.calculateFreeParkingSpace()).isEqualTo(15);
    }

    /*@Test*/
    void calculateFreeParkingSpaceWithPassengerCars() throws ParkingException {
        ParkingSpace parkingSpace = new ParkingSpace(10, 5);
        ParkingService parkingService = new ParkingService(parkingSpace);
        Car nissan = new PassengerCar("Nissan", 1);
        Car audi = new PassengerCar("Audi", 1);
        Car mercedes = new PassengerCar("Mercedes", 1);
        parkingService.placeCar(nissan);
        parkingService.placeCar(audi);
        parkingService.placeCar(mercedes);
        assertThat(parkingSpace.calculateFreeParkingSpace()).isEqualTo(12);
    }

    /*@Test*/
    void calculateFreeParkingSpaceWithPassengerAndTruckCars() throws ParkingException {
        ParkingSpace parkingSpace = new ParkingSpace(10, 5);
        ParkingService parkingService = new ParkingService(parkingSpace);
        Car nissan = new PassengerCar("Nissan", 1);
        Car audi = new PassengerCar("Audi", 1);
        Car mercedes = new PassengerCar("Mercedes", 1);
        Car vaz = new Truck("Vaz", 7);
        Car hyundai = new Truck("Hyundai", 4);
        parkingService.placeCar(nissan);
        parkingService.placeCar(audi);
        parkingService.placeCar(mercedes);
        parkingService.placeCar(vaz);
        parkingService.placeCar(hyundai);
        assertThat(parkingSpace.calculateFreeParkingSpace()).isEqualTo(1);
    }
}