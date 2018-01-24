package com.paigeruppel.babysitter;

public class ScheduleValidation {

    private int startTime;
    private int endTime;
    private final int EARLIEST_START = 17;
    private final int LATEST_END = 4;
    private final int MIDNIGHT_UPPER_BOUND = 24;

    public ScheduleValidation(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean validate() {
        return isValidStart() && isValidEnd() && isValidSchedule();
    }

    public boolean isValidStart() {
        return startTime >= EARLIEST_START || startTime < LATEST_END;
    }

    public boolean isValidEnd() {
        return endTime <= LATEST_END || endTime > EARLIEST_START;
    }

    public boolean isValidSchedule() {
        if (endIsBeforeMidnight()) {
            return startTime < endTime;
        }
        return startTime > endTime;
    }

    private boolean endIsBeforeMidnight() {
        return endTime < MIDNIGHT_UPPER_BOUND && endTime > EARLIEST_START;
    }
}
