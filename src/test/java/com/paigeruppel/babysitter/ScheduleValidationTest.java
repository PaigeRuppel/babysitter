package com.paigeruppel.babysitter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScheduleValidationTest {

    private ScheduleValidation underTest;

    @Before
    public void setup() {
        underTest = new ScheduleValidation();
    }

    @Test
    public void shouldReturn5PmAsValidStartTime() {
        assertTrue(underTest.isValidStart(17));
    }

    @Test
    public void shouldReturn4PmAsNotValidStartTime() {
        assertFalse(underTest.isValidStart(16));
    }

    @Test
    public void shouldReturn6PmAsValidStartTime() {
        assertTrue(underTest.isValidStart(18));
    }

    @Test
    public void shouldReturnMidnightAsValidStartTime() {
        assertTrue(underTest.isValidStart(0));
    }

    @Test
    public void shouldReturn1AmAsValidStartTime() {
        assertTrue(underTest.isValidStart(1));
    }

    @Test
    public void shouldReturn3AmAsValidStartTime() {
        assertTrue(underTest.isValidStart(1));
    }

    @Test
    public void shouldReturn4AmAsValidEndTime() {
        assertTrue(underTest.isValidEnd(4));
    }

    @Test
    public void shouldReturn5AmAsNotValidEndTime() {
        assertFalse(underTest.isValidEnd(5));
    }

    @Test
    public void shouldReturn3AmAsValidEndTime() {
        assertTrue(underTest.isValidEnd(3));
    }

    @Test
    public void shouldReturnMidnightAsValidEndTime() {
        assertTrue(underTest.isValidEnd(0));
    }

    @Test
    public void shouldReturn11PmAsValidEndTime() {
        assertTrue(underTest.isValidEnd(23));
    }

    @Test
    public void shouldReturn6PmAsValidEndTime() {
        assertTrue(underTest.isValidEnd(18));
    }

    @Test
    public void whenStartTime7PmIsAfterEndTime6PmShouldReturnNotValidSchedule() {
        assertFalse(underTest.isValidSchedule(19, 18));
    }

    @Test
    public void whenStartTime6PmIsBeforeEndTime7PmShouldReturnValidSchedule() {
        assertTrue(underTest.isValidSchedule(18, 19));
    }

    @Test
    public void whenStartTime6PmIsBeforeEndTimeMidnightShouldReturnValidSchedule() {
        assertTrue(underTest.isValidSchedule(18, 0));
    }

}
