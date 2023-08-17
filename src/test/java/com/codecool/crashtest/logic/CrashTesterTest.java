package com.codecool.crashtest.logic;

import com.codecool.crashtest.data.Car;
import com.codecool.crashtest.data.Seat;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CrashTesterTest {
    int minimumSpeedToOpenTheAirbag = 30;

    @Test
    public void testCarCrashBelowSpeedLimitNoSeatTaken() {
        // Arrange
        Car car = new Car(29, // Speed is below limit
                Set.of(new Seat(false, false), new Seat(false, false))); // The seats are not taken
        CrashTester crashTester = new CrashTester(minimumSpeedToOpenTheAirbag); // Airbag speed limit is 30

        // Act
        crashTester.testCrash(car);

        // Assert
        assertFalse(car.seats().stream().anyMatch(Seat::isAirbagOpen),
                "Expected no airbag to open when speed is below limit and no seat is taken.");
    }

    @Test
    public void testCarCrashBelowSpeedLimitSeatTaken() {
        // Arrange
        Car car = new Car(29, // Speed is below limit
                Set.of(new Seat(true, false), new Seat(true, false))); // The seats are taken
        CrashTester crashTester = new CrashTester(minimumSpeedToOpenTheAirbag); // Airbag speed limit is 30

        // Act
        crashTester.testCrash(car);

        // Assert
        assertFalse(car.seats().stream().anyMatch(Seat::isAirbagOpen),
                "Expected no airbag to open when speed is below limit and all seats are taken.");
    }

    @Test
    public void testCarCrashBelowSpeedLimitSomeSeatTaken() {
        // Arrange
        Car car = new Car(29, // Speed is below limit
                Set.of(new Seat(true, false), new Seat(false, false))); // Some seats are taken
        CrashTester crashTester = new CrashTester(minimumSpeedToOpenTheAirbag); // Airbag speed limit is 30

        // Act
        crashTester.testCrash(car);

        // Assert
        assertFalse(car.seats().stream().anyMatch(Seat::isAirbagOpen),
                "Expected no airbag to open when speed is below limit and at least one seat is taken.");
    }
}