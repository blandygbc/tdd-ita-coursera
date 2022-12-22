package main.java.com.blandy.rent;

import java.util.ArrayList;

public class Customer {

	private String name;
	private ArrayList<Rental> rentals = new ArrayList<>();
	int frequentRenterPoints = 0;
	double totalAmount = 0;

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		this.rentals.add(rental);
		frequentRenterPoints += rental.getFrequentRenterPoints();
		totalAmount += rental.getAmmount();
	}

	public String getName() {
		return name;
	}

	public String statement() {
		StringBuilder strBdr = new StringBuilder("Rental Record for ");
		strBdr.append(name).append("\n");
		for (Rental eachRental : rentals) {
			strBdr.append("\t")
					.append(eachRental.getMovie().getTitle())
					.append("\t")
					.append(eachRental.getAmmount())
					.append("\n");
		}
		// add footer lines
		strBdr.append("Amount owed is ").append(getTotalAmount()).append("\n")
				.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
		return strBdr.toString();
	}

	public int getTotalFrequentRenterPoints() {
		return frequentRenterPoints;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}