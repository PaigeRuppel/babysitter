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

	public boolean isValidStart() {
		return start >= 17 || start <= 3;
	}

	public boolean isValidEnd() {
		return end <= 4 || end >= 18;
	}

	public int calculateTotalPay() {
		int totalPay = 0;
		if (end < 4) {
			totalPay = calculatePayFromStartToBed() + calculatePayFromBedToMidnight() + calculatePayFromMidnightToEnd();
		} else {
			totalPay = calculatePayFromStartToBed() + calculatePayFromBedToEndBeforeMidnight();
		}
		return totalPay;
	}

	public int calculatePayFromStartToBed() {
		return (bed - start) * 12;
	}

	public int calculatePayFromBedToMidnight() {
		return (24 - bed) * 8;
	}

	public int calculatePayFromMidnightToEnd() {
		return end * 16;
	}

	public int calculatePayFromBedToEndBeforeMidnight() {
		return (end - bed) * 8;
	}

}
