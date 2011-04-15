package de.saxsys.dojo.cinema;

public class Kasse {

	private int price;
	private String title;

	public Integer finishPurchase() {
		return price;
	}

	void startPurchase(String title) {
		this.title = title;
		price = 0;
	}

	public void addTicket(int i) {
		if (i > 14) {
			price += 800;
		} else {
			price += 550;
		}
		if (title.equals("Titanic")) {
			price += 100;
		}
	}
}
