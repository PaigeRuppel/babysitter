package com.paigeruppel.babysitter;

public class PayCalculator {

	private int start;
	private int bed;
	private int end;
	private int totalPay;
	private final int START_TO_BED_RATE = 12;
	private final int BED_TO_MIDNIGHT_RATE = 8;
	private final int AFTER_MIDNIGHT_RATE = 16;

	public PayCalculator(int start, int bed, int end) {
		this.start = start;
		this.bed = bed;
		this.end = end;
	}

	public int getTotalPay() {
	    calculateTotalPay();
	    return totalPay;
    }

	public void calculateTotalPay() {
		if (end < 4) {
			totalPay = calculatePayFromStartToBed() + calculatePayFromBedToMidnight() + calculatePayFromMidnightToEnd();
		} else {
			totalPay = calculatePayFromStartToBed() + calculatePayFromBedToEndBeforeMidnight();
		}
	}

	public int calculatePayFromStartToBed() {
	    return (bed - start) * START_TO_BED_RATE;
	}

	public int calculatePayFromBedToMidnight() {
	    return (24 - bed) * BED_TO_MIDNIGHT_RATE;
	}

	public int calculatePayFromMidnightToEnd() {
	    return end * AFTER_MIDNIGHT_RATE;
	}

	public int calculatePayFromBedToEndBeforeMidnight() {
	    return (end - bed) * BED_TO_MIDNIGHT_RATE;
	}

}
