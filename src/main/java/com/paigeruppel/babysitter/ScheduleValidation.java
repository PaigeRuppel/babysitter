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

    public boolean isValidSchedule() {
        return isValidStart() && isValidEnd() && isValidStartAndEndCombination();
    }

    private boolean isValidStart() {
        return startTime >= EARLIEST_START || startTime < LATEST_END;
    }

    private boolean isValidEnd() {
        return endTime <= LATEST_END || endTime > EARLIEST_START;
    }

    private boolean isValidStartAndEndCombination() {
        if (startAndEndAreInSameTwelveHourPeriod()) {
            return startTime < endTime;
        }
        return startTime > endTime;
    }

    private boolean startAndEndAreInSameTwelveHourPeriod() {
        return isPm(startTime) && isPm(endTime) || !isPm(startTime) && !isPm(endTime);
    }

    private boolean isPm(int time) {
        return time < MIDNIGHT_UPPER_BOUND && time >= NOON;
    }

}
