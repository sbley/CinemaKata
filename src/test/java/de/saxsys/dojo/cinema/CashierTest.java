package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CashierTest {

	@Test
	public void shouldPay800forSawForOneAdult() throws Exception {

		final Cashier kasse = new Cashier("Saw");
		kasse.startPurchase("Saw");
		kasse.addTicket(30);

		assertThat(kasse.finishPurchase(), is(800));
	}

	@Test
	public void shouldPay550forSawForOneChild() throws Exception {

		final Cashier kasse = new Cashier("Saw");
		kasse.startPurchase("Saw");
		kasse.addTicket(14);

		assertThat(kasse.finishPurchase(), is(550));
	}

	@Test
	public void shouldPay900forTitanicForOneAdult() throws Exception {

		final Cashier kasse = new Cashier("Titanic");
		kasse.startPurchase("Titanic");
		kasse.addTicket(15);

		assertThat(kasse.finishPurchase(), is(900));
	}

	@Test
	public void shouldPay4000forTitanicforThreeAdultsandTwoChildren()
			throws Exception {

		final Cashier kasse = new Cashier("Titanic");
		kasse.startPurchase("Titanic");
		kasse.addTicket(30);
		kasse.addTicket(15);
		kasse.addTicket(15);
		kasse.addTicket(14);
		kasse.addTicket(14);

		assertThat(kasse.finishPurchase(), is(4000));
	}

	@Test
	public void shouldPay6000forHarryPotterForTenAdults() throws Exception {

		final Cashier kasse = new Cashier("Harry Potter");
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 10, 30);

		assertThat(kasse.finishPurchase(), is(6000));
	}

	@Test
	public void shouldPay6600forSawForElevenAdults() throws Exception {

		final Cashier kasse = new Cashier("Saw");
		kasse.startPurchase("Saw");
		addTickets(kasse, 11, 30);

		assertThat(kasse.finishPurchase(), is(6600));
	}

	@Test
	public void shouldPay5500forSawForTenChildren() throws Exception {
		final Cashier kasse = new Cashier("Saw");
		kasse.startPurchase("Saw");
		addTickets(kasse, 10, 8 /* Age in years */);

		assertThat(kasse.finishPurchase(), is(5500));
	}

	@Test
	public void shouldPay7200forHarryPotterForEightChildrenAndFourAdults()
			throws Exception {
		final Cashier kasse = new Cashier("Harry Potter");
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 8, 8);
		addTickets(kasse, 4, 102);
		assertThat(kasse.finishPurchase(), is(7200));
	}

	@Test
	public void shouldPay7000forTitanicForTenAdults() throws Exception {
		final Cashier kasse = new Cashier("Titanic");
		kasse.startPurchase("Titanic");
		addTickets(kasse, 10, 77);
		assertThat(kasse.finishPurchase(), is(7000));
	}

	@Test
	public void shouldPay6500forTitanicForTenKids() throws Exception {
		final Cashier kasse = new Cashier("Titanic");
		kasse.startPurchase("Titanic");
		addTickets(kasse, 10, 8);
		assertThat(kasse.finishPurchase(), is(6500));
	}

	@Test(expected = Exception.class)
	public void shouldDenyUnknownMovieTicketPurchase() throws Exception {
		final Cashier kasse = new Cashier("Lola");
		kasse.startPurchase("Olaf");
	}

	@Test(expected = Exception.class)
	public void cashierShouldFailWithoutAMovie() throws Exception {
		new Cashier();
	}

	@Test
	public void couldCashierStartTwoMovies() throws Exception {
		new Cashier("Es", "Sie");

	}

	@Test
	public void shouldPay900ForOvertimeMovie() throws Exception {
		Movie herrDerRinge = new Movie("Herr der Ringe 1", true);
		Movie highlander = new Movie("Highlander", false);
		Cashier kasse = new Cashier(herrDerRinge, highlander);
		kasse.startPurchase("Herr der Ringe 1");
		kasse.addTicket(42);
		assertThat("Kasse muss Filme unterscheiden können.",
				kasse.finishPurchase(), is(900));
	}

	private void addTickets(Cashier kasse, int count, int age) {

		for (int i = 0; i < count; i++) {
			kasse.addTicket(age);
		}
	}

}