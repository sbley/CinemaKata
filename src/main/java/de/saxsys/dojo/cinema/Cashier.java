package de.saxsys.dojo.cinema;

public class Cashier {

	private int price;
	private String title;
	private int ticketCount;

	void startPurchase(String title) {
		this.title = title;
	}

	public void addTicket(int age) {
		ticketCount++;

		if (age > 14) {
			price += 800;
		} else {
			price += 550;
		}
		if (title.equals("Titanic")) {
			price += 100;
		}
	}

	public int finishPurchase() {
		int discounted = ticketCount * 600;

		if (ticketCount >= 10 && discounted < price)
			return discounted;

		return price;
	}
}
