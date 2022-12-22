package main.java.com.blandy.rent;

public class NewRelease extends Movie {

    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double getAmmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }

}
