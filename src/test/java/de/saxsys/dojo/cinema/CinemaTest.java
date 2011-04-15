package de.saxsys.dojo.cinema;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class CinemaTest {

	@Test
	public void shouldPay8forSawForOneAdult() throws Exception {
		assertThat(new Kasse().finishPurchase(),
				CoreMatchers.is(new Integer(8)));
	}
}
