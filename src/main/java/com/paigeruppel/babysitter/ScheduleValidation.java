package com.paigeruppel.babysitter;

public class ScheduleValidation {

    private final int EARLIEST_START = 17;
    private final int LATEST_END = 4;
    private final int MIDNIGHT_UPPER = 24;

    public boolean validate(int start, int end) {
        return isValidStart(start) && isValidEnd(end) && isValidSchedule(start, end);
    }


    public boolean isValidStart(int start) {
        return start >= EARLIEST_START || start < LATEST_END;
    }

    public boolean isValidEnd(int end) {
        return end <= LATEST_END || end > EARLIEST_START;
    }

    public boolean isValidSchedule(int start, int end) {
        if (endIsBeforeMidnight(end)) {
            return start < end;
        }
        return start > end;
    }

    private boolean endIsBeforeMidnight(int end) {
        return end < MIDNIGHT_UPPER && end > EARLIEST_START;
    }
}
