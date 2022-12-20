package test.java.com.blandygbc.cart;

import static org.junit.Assert.assertEquals;

public class MockCartObserver implements CartObserver {

    private String receivedName;
    private int receivedValue;
    private boolean isError = false;

    @Override
    public void addedProduct(String name, int value) {
        if (isError)
            throw new RuntimeException("Simulated error");
        receivedName = name;
        receivedValue = value;

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
