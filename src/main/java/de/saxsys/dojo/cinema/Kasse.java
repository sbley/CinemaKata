package de.saxsys.dojo.cinema;

public class Kasse {

	private int price;

	public Integer finishPurchase() {
		return price;
	}

	void startPurchase(String string) {
		price = 0;
	}

	public void addTicket(int i) {
		if (i > 14) {
			price += 800;
		} else {
			price += 550;
		}
	}
}
