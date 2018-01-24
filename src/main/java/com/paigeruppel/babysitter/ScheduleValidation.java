package com.paigeruppel.babysitter;

public class ScheduleValidation {

    private int startTime;
    private int endTime;
    private final int EARLIEST_START = 17;
    private final int LATEST_END = 4;
    private final int NOON = 12;
    private final int MIDNIGHT_UPPER_BOUND = 24;

    public ScheduleValidation(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean validate() {
        return isValidStart() && isValidEnd() && isValidSchedule();
    }

    private boolean isValidStart() {
        return startTime >= EARLIEST_START || startTime < LATEST_END;
    }

    private boolean isValidEnd() {
        return endTime <= LATEST_END || endTime > EARLIEST_START;
    }

    private boolean isValidSchedule() {
        if (!startIsPm() && !endIsPm() || startIsPm() && endIsPm()) {
            return startTime < endTime;
        }
        return startTime > endTime;
    }

    private boolean startIsPm() {
        return startTime < MIDNIGHT_UPPER_BOUND && startTime >= NOON;
    }

    private boolean endIsPm() {
        return endTime < MIDNIGHT_UPPER_BOUND && endTime >= NOON;
    }
}
