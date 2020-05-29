/**
 * 
 */
package ds;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author bdhakad
 *
 */
public class Stack <T> implements Iterable<T> {
	
	private LinkedList<T> list = new LinkedList<>();

	public Stack() {
		
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return size() == 0;

	}

	public void push(T data) {
		list.add(data);
	}

	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return list.removeLast();
	}
	
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		return list.peekLast();
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

}
