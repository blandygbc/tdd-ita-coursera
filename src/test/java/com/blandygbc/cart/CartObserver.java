package test.java.com.blandygbc.cart;

public interface CartObserver {
    public void addedProduct(String name, int value);

    public void verifyProductReceived(String name, int value);
}
