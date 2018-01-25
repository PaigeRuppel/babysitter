package com.paigeruppel.babysitter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PayCalculatorTest {

	private PayCalculator underTest;

	public PayCalculator createTest(int start, int bed, int end) {
		return underTest = new PayCalculator(start, bed, end);
	}


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

	@Test
	public void shouldReturn16DollarsFromMidnightToEnd1Am() {
		assertThat(createTest(17, 20, 1).calculatePayFromMidnightToEnd(), is(16));
	}

	@Test
	public void shouldReturn32DollarsFromMidnightToEnd2Am() {
		assertThat(createTest(17, 20, 2).calculatePayFromMidnightToEnd(), is(32));
	}

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
		createTest(18,20,2);
		underTest.calculateTotalPay();
		assertThat(underTest.getTotalPay(), is(88));
	}
	
	@Test
	public void shouldReturn104DollarsFromStart6PmBed8PmEnd3Am() {
		createTest(18,20,3);
		underTest.calculateTotalPay();
		assertThat(underTest.getTotalPay(), is(104));
	}
	
	@Test
	public void shouldReturn30DollarsFromStart6PmBed8PmEnd10Pm() {
		createTest(18,20,22);
		underTest.calculateTotalPay();
		assertThat(underTest.getTotalPay(), is(40));
	}
}
