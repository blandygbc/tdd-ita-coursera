package main.java.com.blandy.cart;

import java.util.ArrayList;
import java.util.List;

import test.java.com.blandygbc.cart.CartObserver;

public class Cart {
    private List<Product> itens = new ArrayList<>();
    private List<CartObserver> observers = new ArrayList<>();

    public void addProduct(Product product) {
        itens.add(product);
        for (CartObserver observer : observers) {
            try {
                observer.addedProduct(product.getName(), product.getValue());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public int total() {
        int total = 0;
        for (Product p : itens)
            total += p.getValue();
        return total;
    }

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }
}
