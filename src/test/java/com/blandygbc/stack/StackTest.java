package test.java.com.blandygbc.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.com.blandy.stack.EmptyStackException;
import main.java.com.blandy.stack.FullStackException;
import main.java.com.blandy.stack.Stack;

public class StackTest {

	private Stack s;

	@Before
	public void initStack() {
		s = new Stack(10);
	}

	@Test
	public void emptyStack() {
		assertTrue(s.isEmpty());
		assertEquals(0, s.size());
	}

	@Test
	public void stackOneElement() {
		s.stack("primeiro");
		assertFalse(s.isEmpty());
		assertEquals(1, s.size());
		assertEquals("primeiro", s.top());
	}

	@Test
	public void stackAndUnstack() {
		s.stack("primeiro");
		s.stack("segundo");
		assertEquals(2, s.size());
		assertEquals("segundo", s.top());
		Object unstacked = s.unstack();
		assertEquals(1, s.size());
		assertEquals("segundo", unstacked);
	}

	@Test(expected = EmptyStackException.class)
	public void removeFromEmptyStack() {
		s.unstack();
	}

	@Test
	public void addInFullStack() {
		for (int i = 0; i < 10; i++) {
			s.stack("element" + i);
		}
		try {
			s.stack("eleven");
			fail();
		} catch (FullStackException e) {
			// Catch in the right moment
		}
	}

}
