package de.saxsys.dojo.cinema;

public class Cashier {

	private static final int RATE_CHILD = 550;
	private static final int RATE_ADULT = 800;
	private static final int GROUP_RATE = 600;
	private static final int OVERTIME_RATE = 100;
	private static final int MIN_GROUP_MEMBERS = 10;
	private static final int MAX_AGE_CHILD = 14;

	private int standardPrice;
	private int ticketCount;
	private Movie movie;

	private MovieManager movieManager;

	public Cashier(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

	public void startPurchase(String movieTitle) throws Exception {
		resetPurchase();
		movie = movieManager.getMovieByName(movieTitle);
	}

	public void addTicket(int age) {
		ticketCount++;

		if (age <= MAX_AGE_CHILD) {
			standardPrice += RATE_CHILD;
		} else {
			standardPrice += RATE_ADULT;
		}
	}

	public void addTicketForDisabled(boolean withAccompanyingPerson) {
		ticketCount++;
		standardPrice += RATE_CHILD;
	}

	public int finishPurchase() {
		int price = standardPrice;
		if (ticketCount >= MIN_GROUP_MEMBERS) {
			int groupPrice = ticketCount * GROUP_RATE;
			price = Math.min(groupPrice, standardPrice);
		}
		if (movie.isOverTime()) {
			price += ticketCount * OVERTIME_RATE;
		}

		return price;
	}

	private void resetPurchase() {
		ticketCount = 0;
		standardPrice = 0;
	}
}
