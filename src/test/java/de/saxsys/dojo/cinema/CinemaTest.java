package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CinemaTest {

	@Test
	public void shouldPay800forSawForOneAdult() throws Exception {

		final Cashier kasse = new Cashier();
		kasse.startPurchase("Saw");
		kasse.addTicket(30);

		assertThat(kasse.finishPurchase(), is(800));
	}

	@Test
	public void shouldPay550forSawForOneChild() throws Exception {

		final Cashier kasse = new Cashier();
		kasse.startPurchase("Saw");
		kasse.addTicket(14);

		assertThat(kasse.finishPurchase(), is(550));
	}

	@Test
	public void shouldPay900forTitanicForOneAdult() throws Exception {

		final Cashier kasse = new Cashier();
		kasse.startPurchase("Titanic");
		kasse.addTicket(15);

		assertThat(kasse.finishPurchase(), is(900));
	}

	@Test
	public void shouldPay4000forTitanicforThreeAdultsandTwoChildren()
			throws Exception {

		final Cashier kasse = new Cashier();
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

		final Cashier kasse = new Cashier();
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 10, 30);

		assertThat(kasse.finishPurchase(), is(6000));
	}

	@Test
	public void shouldPay6600forSawForElevenAdults() throws Exception {

		final Cashier kasse = new Cashier();
		kasse.startPurchase("Saw");
		addTickets(kasse, 11, 30);

		assertThat(kasse.finishPurchase(), is(6600));
	}

	@Test
	public void shouldPay5500forSawForTenChildren() throws Exception {
		final Cashier kasse = new Cashier();
		kasse.startPurchase("Saw");
		addTickets(kasse, 10, 8 /* Age in years */);

		assertThat(kasse.finishPurchase(), is(5500));
	}

	@Test
	public void shouldPay7200forHarryPotterForEightChildrenAndFourAdults()
			throws Exception {
		final Cashier kasse = new Cashier();
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 8, 8);
		addTickets(kasse, 4, 102);
		assertThat(kasse.finishPurchase(), is(7200));
	}

	private void addTickets(Cashier kasse, int count, int age) {

		for (int i = 0; i < count; i++) {
			kasse.addTicket(age);
		}
	}

}