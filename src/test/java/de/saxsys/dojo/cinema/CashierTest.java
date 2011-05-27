package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CashierTest {

	private Cashier kasse;

	@Before
	public void initializeCashier() {
		Movie highlander = new Movie("Highlander", false);
		Movie saw = new Movie("Saw", false);
		Movie harryPotter = new Movie("Harry Potter", false);
		Movie siebenLeben = new Movie("Sieben Leben", false);
		Movie titanic = new Movie("Titanic", true);
		Movie herrDerRinge = new Movie("Herr der Ringe 1", true);
		kasse = initCashier(saw, titanic, harryPotter, herrDerRinge,
				highlander, siebenLeben);
	}

	@Test
	public void shouldPay800forSawForOneAdult() throws Exception {
		kasse.startPurchase("Saw");
		kasse.addTicket(30);
		assertThat(kasse.finishPurchase(), is(800));
	}

	@Test
	public void shouldPay550forSawForOneChild() throws Exception {
		kasse.startPurchase("Saw");
		kasse.addTicket(14);
		assertThat(kasse.finishPurchase(), is(550));
	}

	@Test
	public void shouldPay900forTitanicForOneAdult() throws Exception {
		kasse.startPurchase("Titanic");
		kasse.addTicket(15);
		assertThat(kasse.finishPurchase(), is(900));
	}

	@Test
	public void shouldPay4000forTitanicforThreeAdultsandTwoChildren()
			throws Exception {
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
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 10, 30);
		assertThat(kasse.finishPurchase(), is(6000));
	}

	@Test
	public void shouldPay6600forSawForElevenAdults() throws Exception {
		kasse.startPurchase("Saw");
		addTickets(kasse, 11, 30);
		assertThat(kasse.finishPurchase(), is(6600));
	}

	@Test
	public void shouldPay5500forSawForTenChildren() throws Exception {
		kasse.startPurchase("Saw");
		addTickets(kasse, 10, 8 /* Age in years */);
		assertThat(kasse.finishPurchase(), is(5500));
	}

	@Test
	public void shouldPay7200forHarryPotterForEightChildrenAndFourAdults()
			throws Exception {
		kasse.startPurchase("Harry Potter");
		addTickets(kasse, 8, 8);
		addTickets(kasse, 4, 102);
		assertThat(kasse.finishPurchase(), is(7200));
	}

	@Test
	public void shouldPay7000forTitanicForTenAdults() throws Exception {
		kasse.startPurchase("Titanic");
		addTickets(kasse, 10, 77);
		assertThat(kasse.finishPurchase(), is(7000));
	}

	@Test
	public void shouldPay6500forTitanicForTenKids() throws Exception {
		kasse.startPurchase("Titanic");
		addTickets(kasse, 10, 8);
		assertThat(kasse.finishPurchase(), is(6500));
	}

	@Test(expected = Exception.class)
	public void shouldDenyUnknownMovieTicketPurchase() throws Exception {
		kasse.startPurchase("Olaf");
	}

	@Test(expected = Exception.class)
	public void cashierShouldFailWithoutAMovie() throws Exception {
		Movie[] movies = null;
		initCashier(movies);
	}

	@Test
	public void couldCashierStartTwoMovies() throws Exception {
		initCashier(new Movie("Es", false), new Movie("Sie", false));
	}

	@Test
	public void shouldPay900ForOvertimeMovie() throws Exception {
		kasse.startPurchase("Herr der Ringe 1");
		kasse.addTicket(42);
		assertThat("Kasse muss Filme unterscheiden können.",
				kasse.finishPurchase(), is(900));
	}

	@Test
	public void shouldRunMultipleTimes() throws Exception {
		kasse.startPurchase("Herr der Ringe 1");
		kasse.addTicket(42);
		assertThat(kasse.finishPurchase(), is(900));
		kasse.startPurchase("Highlander");
		kasse.addTicket(10);
		assertThat(kasse.finishPurchase(), is(550));
	}

	@Test
	public void shouldPay550ForSiebenLebenForDisabled() throws Exception {
		kasse.startPurchase("Sieben Leben");
		kasse.addTicketForDisabled(false);
		assertThat(kasse.finishPurchase(), is(550));
	}

	@Test
	public void shouldPay550ForSiebenLebenForDisabledAndAccompanyingPerson()
			throws Exception {
		kasse.startPurchase("Sieben Leben");
		kasse.addTicketForDisabled(true);
		assertThat(kasse.finishPurchase(), is(550));
	}

	private void addTickets(Cashier kasse, int count, int age) {
		for (int i = 0; i < count; i++) {
			kasse.addTicket(age);
		}
	}

	private Cashier initCashier(Movie... movies) {
		final MovieManager movieManager = new MovieManager();
		movieManager.setKnownMovies(Arrays.asList(movies));
		return new Cashier(movieManager);
	}
}