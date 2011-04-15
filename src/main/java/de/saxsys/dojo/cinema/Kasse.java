package de.saxsys.dojo.cinema;

public class Kasse {

	private int price;
	private String title;
	private int ticketCount;

	void startPurchase(String title) {
		this.title = title;
		price = 0;
	}

	public void addTicket(int i) {
		ticketCount++;

		if (i > 14) {
			price += 800;
		} else {
			price += 550;
		}
		if (title.equals("Titanic")) {
			price += 100;
		}
	}

	public Integer finishPurchase() {
		if (ticketCount == 10)
			return 6000;
		return price;
	}
}
