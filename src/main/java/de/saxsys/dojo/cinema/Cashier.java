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
		if (title.equals("Titanic")) {
			totalPrice += 100;
		}
	}

	public int finishPurchase() {

		if (ticketCount >= 10) {
			int discounted = ticketCount * 600;

			if (discounted < totalPrice) {
				return discounted;
			}
		}

		return totalPrice;
	}
}
