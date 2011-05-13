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

	@Test
	public void sawIsNoOvertimeMovie() throws Exception {
		assertThat("Saw hat normale Länge",
				new Movie("Saw", false).isOverTime(), is(false));
	}

	@Test
	public void highlanderKnowsItsName() throws Exception {
		assertThat("Der Film sollte schon seinen Namen kennen... Tstststss",
				new Movie("Highlander", false).getTitle(), is("Highlander"));
	}

}
