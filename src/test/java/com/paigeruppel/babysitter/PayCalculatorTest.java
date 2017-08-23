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
		assertThat(createTest(1, 0 ,0 ).isValidStart(), is(true));
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
	
	@Test
	public void shouldReturn24DollarsFromStart6PmToBed8Pm() {
		assertThat(createTest(18,20,0).calculatePayFromStartToBed(), is(24));
	}

}
