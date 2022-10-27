package main.java.com.blandy.stack;

public class Stack {

	private Object[] elements;
	private int quantity = 0;

	public Stack(int max) {
		elements = new Object[max];
	}

	public int size() {
		return quantity;
	}

	public boolean isEmpty() {
		return (quantity == 0);
	}

	public void stack(Object element) {
		if (quantity == elements.length)
			throw new FullStackException("The stack is full already!");
		this.elements[quantity] = element;
		quantity++;
	}

	public Object top() {
		return elements[quantity - 1];
	}

	public Object unstack() {
		if (isEmpty())
			throw new EmptyStackException("The stack is already empty!");
		Object unstacked = top();
		quantity--;
		return unstacked;
	}

}
