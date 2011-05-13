package de.saxsys.dojo.cinema;

public class Movie {

	private final boolean overtime;
	private final String title;

	public Movie(String title, boolean isOvertime) {
		overtime = isOvertime;
		this.title = title;
	}

	public boolean isOverTime() {
		return overtime;
	}

	public String getTitle() {
		return title;
	}

}
