package test.java.com.blandygbc.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.com.blandy.cart.Cart;
import main.java.com.blandy.cart.Product;

public class CartTest {

    @Test
    public void cartTotal() {
        Cart cart = new Cart();
        cart.addProduct(new Product("tenis", 100));
        cart.addProduct(new Product("camiseta", 50));
        cart.addProduct(new Product("bermuda", 70));
        assertEquals(220, cart.total());
    }

    @Test
    public void listenToAddProduct() {
        Cart cart = new Cart();
        MockCartObserver mock = new MockCartObserver();
        cart.addObserver(mock);
        cart.addProduct(new Product("tenis", 100));
        mock.verifyProductReceived("tenis", 100);
    }

    @Test
    public void stilNotifyingWithErrorInObserver() {
        Cart cart = new Cart();
        MockCartObserver mock1 = new MockCartObserver();
        MockCartObserverWithError mock2 = new MockCartObserverWithError();
        MockCartObserver mock3 = new MockCartObserver();
        mock2.errorMethod();
        cart.addObserver(mock1);
        cart.addObserver(mock2);
        cart.addObserver(mock3);
        cart.addProduct(new Product("tenis", 100));
        mock1.verifyProductReceived("tenis", 100);
        mock3.verifyProductReceived("tenis", 100);
    }
}
