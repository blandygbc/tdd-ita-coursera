package main.java.com.blandy.rent;

public class Regular extends Movie {

    public Regular(String title) {
        super(title);
    }

    @Override
    public double getAmmount(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }

}
