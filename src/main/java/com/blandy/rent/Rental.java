package main.java.com.blandy.rent;

public class Rental {

	Movie movie;

	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}

	public double getAmmount() {
		return movie.getAmmount(daysRented);
	}
}