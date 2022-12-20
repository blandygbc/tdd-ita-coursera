package main.java.com.blandy.cart;

public class Product {
    private String name;
    private int value;

    public Product(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int valor) {
        this.value = valor;
    }

}
