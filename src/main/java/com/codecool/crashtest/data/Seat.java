package com.codecool.crashtest.data;

public class Seat {
    private boolean isUsed;
    private boolean isAirbagOpen;

    public Seat(boolean isUsed, boolean isAirbagOpen) {
        this.isUsed = isUsed;
        this.isAirbagOpen = isAirbagOpen;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public boolean isAirbagOpen() {
        return isAirbagOpen;
    }

    public void setAirbagOpen(boolean airbagOpen) {
        isAirbagOpen = airbagOpen;
    }
}
