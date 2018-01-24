package com.paigeruppel.babysitter;

public class ScheduleValidation {

    private final int EARLIEST_START = 17;
    private final int LATEST_END = 4;

    public boolean isValidStart(int start) {
        return start >= EARLIEST_START || start < LATEST_END;
    }

    public boolean isValidEnd(int end) {
        return end <= LATEST_END || end > EARLIEST_START;
    }
}
