package com.codecool.crashtest.logic;

import com.codecool.crashtest.data.Car;
import com.codecool.crashtest.data.Seat;

import java.util.Set;

public class CrashTester {
    private final int minimumSpeedToOpenTheAirbag;

    public CrashTester(int minimumSpeedToOpenTheAirbag) {
        this.minimumSpeedToOpenTheAirbag = minimumSpeedToOpenTheAirbag;
    }

    public void testCrash(Car car) {
        if (car.speed() < minimumSpeedToOpenTheAirbag) {
            return;
        }
        Set<Seat> seats = car.seats();
        for (Seat seat : seats) {
            if (seat.isUsed()) {
                seat.setAirbagOpen(true);
            }
        }
    }
}
