package com.paigeruppel.babysitter;

public class PayCalculator {

	private int start;
	private int bed;
	private int end;
	private int totalPay;
	private final int EARLIEST_START = 17;
	private final int LATEST_END = 4;

	public PayCalculator(int start, int bed, int end) {
		this.start = start;
		this.bed = bed;
		this.end = end;
	}



	public boolean isValidEnd() {
		return end <= LATEST_END || end > EARLIEST_START;
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
