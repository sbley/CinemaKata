package de.saxsys.dojo.cinema;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class MovieManagerTest {
	@Test
	public void doesMovieExistInManager() throws Exception {
		MovieManager movieManager = new MovieManager();
		Movie movie = new Movie("Titanic", true);
		movieManager.setKnownMovies(Arrays.asList(movie));
		assertThat(movieManager.getMovieByName("Titanic"), is(movie));
	}

	@Test(expected = Exception.class)
	public void doesMovieNotExistInManager() throws Exception {
		MovieManager movieManager = new MovieManager();
		Movie movie = new Movie("Titanic", true);
		movieManager.setKnownMovies(Arrays.asList(movie));
		movieManager.getMovieByName("blub");
	}
}
