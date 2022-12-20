package test.java.com.blandygbc.cart;

import static org.junit.Assert.assertEquals;

public class MockCartObserverWithError implements CartObserver {

    private String receivedName;
    private int receivedValue;
    private boolean isError = false;

    @Override
    public void addedProduct(String name, int value) {
        throw new RuntimeException("Simulated error");
    }

    @Override
    public void verifyProductReceived(String expectedName, int expectedValue) {
        assertEquals(expectedName, receivedName);
        assertEquals(expectedValue, receivedValue);

    }

    public void errorMethod() {
        isError = true;
    }

}
