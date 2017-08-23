package com.paigeruppel.babysitter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PayCalculatorTest {

	public PayCalculator createTest(int start, int bed, int end) {
		return new PayCalculator(start, bed, end);
	}

	@Test
	public void shouldReturn5PmAsValidStartTime() {
		assertThat(createTest(17, 0, 0).isValidStart(), is(true));
	}

	@Test
	public void shouldReturn4PmAsNotValidStartTime() {
		assertThat(createTest(16, 0, 0).isValidStart(), is(false));
	}

	@Test
	public void shouldReturn6PmAsValidStartTime() {
		assertThat(createTest(18, 0, 0).isValidStart(), is(true));
	}

	@Test
	public void shouldReturnMidnightAsValidStartTime() {
		assertThat(createTest(0, 0, 0).isValidStart(), is(true));
	}

	@Test
	public void shouldReturn1AmAsValidStartTime() {
		assertThat(createTest(1, 0, 0).isValidStart(), is(true));
	}

	@Test
	public void shouldReturn3AmAsValidStartTime() {
		assertThat(createTest(3, 0, 0).isValidStart(), is(true));
	}

	@Test
	public void shouldReturn4AmAsValidEndTime() {
		assertThat(createTest(0, 0, 4).isValidEnd(), is(true));
	}

	@Test
	public void shouldReturn5AmAsNotValidEndTime() {
		assertThat(createTest(0, 0, 5).isValidEnd(), is(false));
	}

	@Test
	public void shouldReturn3AmAsValidEndTime() {
		assertThat(createTest(0, 0, 3).isValidEnd(), is(true));
	}

	@Test
	public void shouldReturnMidnightAsValidEndTime() {
		assertThat(createTest(0, 0, 0).isValidEnd(), is(true));
	}

	@Test
	public void shouldReturn11PmAsValidEndTime() {
		assertThat(createTest(0, 0, 23).isValidEnd(), is(true));
	}

	@Test
	public void shouldReturn6PmAsValidEndTime() {
		assertThat(createTest(0, 0, 18).isValidEnd(), is(true));
	}

	// calculate pay from start to bed @ rate $12
	@Test
	public void shouldReturn24DollarsFromStart6PmToBed8Pm() {
		assertThat(createTest(18, 20, 0).calculatePayFromStartToBed(), is(24));
	}

	@Test
	public void shouldReturn36DollarsFromStart5PmToBed8Pm() {
		assertThat(createTest(17, 20, 0).calculatePayFromStartToBed(), is(36));
	}

	@Test
	public void shouldReturn48DollarsFromStart5PmToBed9Pm() {
		assertThat(createTest(17, 21, 0).calculatePayFromStartToBed(), is(48));
	}

	// calculate pay from bed to midnight @ rate $8
	@Test
	public void shouldReturn32DollarsFromBed8PmToMidnight() {
		assertThat(createTest(17, 20, 0).calculatePayFromBedToMidnight(), is(32));
	}

	@Test
	public void shouldReturn40DollarsFromBed7PmToMidnight() {
		assertThat(createTest(17, 19, 0).calculatePayFromBedToMidnight(), is(40));
	}

	@Test
	public void shouldReturn24DollarsFromBed9PmToMidnight() {
		assertThat(createTest(17, 21, 0).calculatePayFromBedToMidnight(), is(24));
	}

	// calculate pay from midnight to end (if end is after midnight) @ rate $16
	@Test
	public void shouldReturn16DollarsFromMidnightToEnd1Am() {
		assertThat(createTest(17, 20, 1).calculatePayFromMidnightToEnd(), is(16));
	}

	@Test
	public void shouldReturn32DollarsFromMidnightToEnd2Am() {
		assertThat(createTest(17, 20, 2).calculatePayFromMidnightToEnd(), is(32));
	}

	// calculate pay from bedtime to end if end is before midnight @rate $8
	@Test
	public void shouldReturn24DollarsFromBed8PmToEndAt11Pm() {
		assertThat(createTest(17, 20, 23).calculatePayFromBedToEndBeforeMidnight(), is(24));
	}

	@Test
	public void shouldReturn32DollarsFromBed7PmToEndAt11Pm() {
		assertThat(createTest(17, 19, 23).calculatePayFromBedToEndBeforeMidnight(), is(32));
	}

	@Test
	public void shouldReturn88DollarsFromStart6PmBed8PmEnd2Am() {
		assertThat(createTest(18, 20, 2).calculateTotalPay(), is(88));
	}
	
	@Test
	public void shouldReturn104DollarsFromStart6PmBed8PmEnd3Am() {
		assertThat(createTest(18, 20, 3).calculateTotalPay(), is(104));
	}
	
	@Test
	public void shouldReturn30DollarsFromStart6PmBed8PmEnd10Pm() {
		assertThat(createTest(18, 20, 22).calculateTotalPay(), is(40));
	}
}
