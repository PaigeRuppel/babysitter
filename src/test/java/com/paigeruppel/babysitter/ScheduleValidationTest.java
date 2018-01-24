package com.paigeruppel.babysitter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScheduleValidationTest {

    private ScheduleValidation underTest;

    public ScheduleValidation testSchedule(int startTime, int endTime) {
        return underTest = new ScheduleValidation(startTime, endTime);
    }

    @Test
    public void whenStartTimeIs5PmAndEndTimeIs6PmIsValidSchedule() {
        assertTrue(testSchedule(17,18).validate());
    }

    @Test
    public void whenStartTimeIs4PmAndBeforeEarliestStartIsNotValidSchedule() {
        assertFalse(testSchedule(16,17).validate());
    }

    @Test
    public void whenStartTimeIs6PmAndEndTimeIs10PmIsValidSchedule() {
        assertTrue(testSchedule(18, 22).validate());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIsMidnightIsValidSchedule() {
        assertTrue(testSchedule(22, 0).validate());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIs1AmIsValidSchedule() {
        assertTrue(testSchedule(22, 1).validate());
    }

    @Test
    public void whenStartTimeIsMidnightAndEndTimeIs1AmIsValidSchedule() {
        assertTrue(testSchedule(0, 1).validate());
    }

    @Test
    public void whenStartTimeIs1AmAndEndTimeIs11PmIsNotValidSchedule() {
        assertFalse(testSchedule(1, 23).validate());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIs4AmIsValidSchedule() {
        assertTrue(testSchedule(22, 4).validate());
    }

//    @Test
//    public void shouldReturn5AmAsNotValidEndTime() {
//        assertFalse(underTest.isValidEnd(5));
//    }
//
//    @Test
//    public void shouldReturn3AmAsValidEndTime() {
//        assertTrue(underTest.isValidEnd(3));
//    }
//
//    @Test
//    public void shouldReturnMidnightAsValidEndTime() {
//        assertTrue(underTest.isValidEnd(0));
//    }
//
//    @Test
//    public void shouldReturn11PmAsValidEndTime() {
//        assertTrue(underTest.isValidEnd(23));
//    }
//
//    @Test
//    public void shouldReturn6PmAsValidEndTime() {
//        assertTrue(underTest.isValidEnd(18));
//    }
//
//    @Test
//    public void whenStartTime7PmIsAfterEndTime6PmShouldReturnNotValidSchedule() {
//        assertFalse(underTest.isValidSchedule(19, 18));
//    }
//
//    @Test
//    public void whenStartTime6PmIsBeforeEndTime7PmShouldReturnValidSchedule() {
//        assertTrue(underTest.isValidSchedule(18, 19));
//    }
//
//    @Test
//    public void whenStartTime6PmIsBeforeEndTimeMidnightShouldReturnValidSchedule() {
//        assertTrue(underTest.isValidSchedule(18, 0));
//    }

}
