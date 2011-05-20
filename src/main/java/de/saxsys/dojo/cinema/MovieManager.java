package de.saxsys.dojo.cinema;

import java.util.List;

public class MovieManager {
	private List<Movie> knownMovies;

	public MovieManager() {
	}

	public void setKnownMovies(List<Movie> knownMovies) {
		this.knownMovies = knownMovies;
	}

	public Movie getMovieByName(String movieTitle) throws Exception {
		for (Movie movie : knownMovies) {
			if (movie.getTitle().equals(movieTitle)) {
				return movie;
			}
		}
		throw new Exception("unknown movie");
	}
}