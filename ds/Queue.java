/**
 * 
 */
package ds;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author bdhakad
 *
 */
public class Queue<T> implements Iterable<T> {

	private LinkedList<T> list = new LinkedList<T>();
	
	/**
	 * 
	 */
	public Queue() {
		
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size() != 0;
	}
	
	// enqueue
	public void offer(T data) {
		list.addLast(data);
	}
	
	// or dequeue
	public T poll() {
		if(isEmpty()) throw new RuntimeException("list is empty");
		return list.removeFirst();
	}
	
	public T peek() {
		if(isEmpty()) throw new RuntimeException("list is empty");
		return list.peekFirst();
	}

	@Override
	public String toString() {
		return list.toString();
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

}
