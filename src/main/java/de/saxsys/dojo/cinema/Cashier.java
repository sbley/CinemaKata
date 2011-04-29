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
		int price = totalPrice;
		if (ticketCount >= 10) {
			int discountedPrice = ticketCount * 600;
			if (discountedPrice < totalPrice) {
				price = discountedPrice;
			}
		}
		if (isOvertime()) {
			price += 100 * ticketCount;
		}
		return price;
	}

	private boolean isOvertime() {
		return title.equals("Titanic");
	}
}
