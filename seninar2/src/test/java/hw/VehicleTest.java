package hw;

import org.assertj.core.api.AbstractBooleanAssert;
import org.example.hw.Car;
import org.example.hw.Motorcycle;
import org.example.hw.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {
//    Написать следующие тесты:

    private Car _car;
    private Motorcycle _motorcycle;

    @BeforeEach
    void setUp() {
        _car = new Car("Chevrolet", "Malibu", 2023);
        _motorcycle = new Motorcycle("Triumph", "Bonneville Speedmaster", 2021);
    }
    
//            - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)

    @Test
    @DisplayName("Test is instance of Vehicle")
    void testCarIsInstanceOfVehicle() {
        boolean aTrue = _car instanceof Vehicle;
        assertTrue(aTrue);

    }

//            - проверка того, объект Car создается с 4-мя колесами

    @ParameterizedTest
    @ValueSource(ints = {4})
    @DisplayName("Test the number of wheels of a car")
    void testObjectCarWithFourWheel(int argument) {
        int countOfWheels = _car.getNumWheels();
        assertEquals(argument, countOfWheels);
    }

//             - проверка того, объект Motorcycle создается с 2-мя колесами

    @ParameterizedTest
    @ValueSource(ints = {2})
    @DisplayName("Test the number of wheels of a motorcycle")
    void testObjectMotorcycleWithTwoWheel(int argument) {
        int countOfWheels = _motorcycle.getNumWheels();
        assertEquals(argument, countOfWheels);
    }

//             - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())

    @ParameterizedTest
    @ValueSource(ints = {60})
    @DisplayName("Test the car for speed")
    void testCarObjectReachesSpeedSixty(int argument) {
        _car.testDrive();
        int speed = _car.getSpeed();
        assertEquals(argument, speed);
    }

//            - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())

    @ParameterizedTest
    @ValueSource(ints = {75})
    @DisplayName("Test the motorcycle for speed")
    void testMotorcycleObjectReachesSpeedSeventyFive(int argument) {
        _motorcycle.testDrive();
        int speed = _motorcycle.getSpeed();
        assertEquals(argument, speed);
    }

//            - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("Test the car to stop")
    void testObjectCarParkingModeStops(int argument) {
        _car.testDrive();
        _car.park();
        int speedOnPark = _car.getSpeed();
        assertEquals(argument, speedOnPark);
    }

//            - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("Test the motorcycle to stop")
    void testObjectMotorcycleParkingModeStops(int argument) {
        _motorcycle.testDrive();
        _motorcycle.park();
        int speedOnPark = _motorcycle.getSpeed();
        assertEquals(argument, speedOnPark);
    }
}