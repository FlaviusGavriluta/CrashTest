package com.codecool.crashtest.data;

import java.util.Set;

public record Car(int speed, Set<Seat> seats) {
}
