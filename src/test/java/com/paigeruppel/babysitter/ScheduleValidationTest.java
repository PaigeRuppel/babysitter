package com.paigeruppel.babysitter;

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
        assertTrue(testSchedule(17,18).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs4PmAndBeforeEarliestStartIsNotValidSchedule() {
        assertFalse(testSchedule(16,17).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs6PmAndEndTimeIs10PmIsValidSchedule() {
        assertTrue(testSchedule(18, 22).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIsMidnightIsValidSchedule() {
        assertTrue(testSchedule(22, 0).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIs1AmIsValidSchedule() {
        assertTrue(testSchedule(22, 1).isValidSchedule());
    }

    @Test
    public void whenStartTimeIsMidnightAndEndTimeIs1AmIsValidSchedule() {
        assertTrue(testSchedule(0, 1).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs1AmAndEndTimeIs11PmIsNotValidSchedule() {
        assertFalse(testSchedule(1, 23).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs10PmAndEndTimeIs4AmIsValidSchedule() {
        assertTrue(testSchedule(22, 4).isValidSchedule());
    }

    @Test
    public void whenStartTimeIsMidnightAndEndTimeIs5AmAfterLatestEndIsNotValidSchedule() {
        assertFalse(testSchedule(0, 5).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs6PmAndEndTimeIs3AmIsValidSchedule() {
        assertTrue(testSchedule(18, 3).isValidSchedule());
    }

    @Test
    public void whenStartIs8PmAndEndIsMidnightIsValidSchedule() {
        assertTrue(testSchedule(20,0).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs2AmAndEndTimeIs11PmIsNotValidSchedule() {
        assertFalse(testSchedule(2, 23).isValidSchedule());
    }

    @Test
    public void whenStartTimeIs8PmAndEndTimeIs11PmIsValidSchedule() {
        assertTrue(testSchedule(20, 23).isValidSchedule());
    }


}
