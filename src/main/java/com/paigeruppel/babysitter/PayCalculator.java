package com.paigeruppel.babysitter;

public class PayCalculator {

	// assuming for now that no babysitter will start after 11 pm
	public boolean isValidStart(int start) {
		return start >= 17 || start <= 3;
	}

	public boolean isValidEnd(int end) {
		return end <= 4 || end >= 18;
	}

}
