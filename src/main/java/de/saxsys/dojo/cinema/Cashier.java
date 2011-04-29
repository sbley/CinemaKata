package de.saxsys.dojo.cinema;

public class Cashier {

	private int totalPrice;
	private String title;
	private int ticketCount;

	void startPurchase(String title) {
		this.title = title;
	}

	public void addTicket(int age) {
		ticketCount++;

		if (age > 14) {
			totalPrice += 800;
		} else {
			totalPrice += 550;
		}
	}

	public int finishPurchase() {
		int discounted;
		if (isOvertime()) {
			totalPrice += 100 * ticketCount;
		}
		if (ticketCount >= 10) {
			if (isOvertime()) {
				discounted = ticketCount * 700;
			} else {
				discounted = ticketCount * 600;
			}
			if (discounted < totalPrice) {
				return discounted;
			}

		}

		return totalPrice;
	}

	private boolean isOvertime() {
		return title.equals("Titanic");
	}
}
