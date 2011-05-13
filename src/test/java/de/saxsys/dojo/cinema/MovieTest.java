package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MovieTest {

	@Test
	public void overtimeMovieAndKnowsIt() throws Exception {
		assertThat("Überlängefilm teilt Überlänge mit", new Movie("Titanic",
				true).isOverTime(), is(true));
	}
}
