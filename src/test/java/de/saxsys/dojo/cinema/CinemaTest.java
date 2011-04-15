package de.saxsys.dojo.cinema;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class CinemaTest {

	@Test
	public void shouldPay8forSawForOneAdult() throws Exception {
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Saw");
		kasse.addTicket(30);

		assertThat(kasse.finishPurchase(), CoreMatchers.is(new Integer(800)));
	}

	@Test
	public void shouldPay5_50forSawForOneChild() throws Exception {
		final Kasse kasse = new Kasse();
		kasse.startPurchase("Saw");
		kasse.addTicket(14);

		assertThat(kasse.finishPurchase(), CoreMatchers.is(new Integer(550)));

	}
}