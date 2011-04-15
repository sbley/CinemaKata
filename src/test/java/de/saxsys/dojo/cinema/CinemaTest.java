package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CinemaTest {

	@Test
	public void shouldPay8forSawForOneAdult() throws Exception {
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Saw");
		kasse.addTicket(30);

		assertThat(kasse.finishPurchase(), is(800));
	}

	@Test
	public void shouldPay550forSawForOneChild() throws Exception {
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Saw");
		kasse.addTicket(14);

		assertThat(kasse.finishPurchase(), is(550));

	}

	@Test
	public void shouldPay900forTitanicForOneAdult() throws Exception {
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Titanic");
		kasse.addTicket(15);

		assertThat(kasse.finishPurchase(), is(900));

	}

	@Test
	public void shouldPay4000forTitanicforThreeAdultsandTwoChildren()
			throws Exception {
		final Kasse kasse = new Kasse();
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
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Harry Potter");
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		kasse.addTicket(30);
		assertThat(kasse.finishPurchase(), is(6000));

	}
}