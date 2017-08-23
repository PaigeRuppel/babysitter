package com.paigeruppel.babysitter;

public class PayCalculator {

	private int start;
	private int bed;
	private int end;

	public PayCalculator(int start, int bed, int end) {
		this.start = start;
		this.bed = bed;
		this.end = end;
	}

	// assuming for now that no babysitter will start after 11 pm
	public boolean isValidStart() {
		return start >= 17 || start <= 3;
	}

	public boolean isValidEnd() {
		return end <= 4 || end >= 18;
	}

	public int calculatePayFromStartToBed() {
		return 24;
	}

}
