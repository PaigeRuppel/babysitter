package com.paigeruppel.babysitter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PayCalculatorTest {

	
	@Test
	public void shouldReturn5PmAsValidStartTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidStart(17), is(true));
	}
	
	@Test
	public void shouldReturn4PmAsNotValidStartTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidStart(16), is(false));
	}
	
	@Test
	public void shouldReturn6PmAsValidStartTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidStart(18), is(true));
	}
	
	@Test
	public void shouldReturn4AmAsValidEndTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidEnd(4), is(true));
	}
	
	@Test
	public void shouldReturn5AmAsNotValidEndTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidEnd(5), is(false));
	}
	@Test
	public void shouldReturn3AmAsValidEndTime() {
		PayCalculator underTest = new PayCalculator();
		assertThat(underTest.isValidEnd(3), is(true));
	}
	

}
