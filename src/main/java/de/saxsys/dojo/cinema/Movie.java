package de.saxsys.dojo.cinema;

public class Movie {

	private final boolean overtime;

	public Movie(String title, boolean isOvertime) {
		overtime = isOvertime;
	}

	public boolean isOverTime() {
		return overtime;
	}

}
