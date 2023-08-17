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
        Car car = new Car(29,
                Set.of(new Seat(false, false), new Seat(false, false)));
        CrashTester crashTester = new CrashTester(minimumSpeedToOpenTheAirbag);

        // Act
        crashTester.testCrash(car);

        // Assert
        assertFalse(car.seats().stream().anyMatch(Seat::isAirbagOpen),
                "Expected no airbag to open when speed is below limit and no seat is taken.");
    }

    @Test
    public void testCarCrashBelowSpeedLimitWithSeatTaken() {
        // Arrange
        Car car = new Car(29,
                Set.of(new Seat(true, false), new Seat(true, false)));
        CrashTester crashTester = new CrashTester(minimumSpeedToOpenTheAirbag);

        // Act
        crashTester.testCrash(car);

        // Assert
        assertFalse(car.seats().stream().anyMatch(Seat::isAirbagOpen),
                "Expected no airbag to open when speed is below limit and no seat is taken.");
    }
}
