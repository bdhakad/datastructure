/**
 * 
 */
package ds;

import java.util.Arrays;

/**
 * @author bdhakad
 *
 */
public class IntegerQueue {

	int front, end, size ; 
	int [] arr;
	/**
	 * 
	 */
	public IntegerQueue(int maxSize) {
		size = maxSize+1;
		front = end = 0;
		arr = new int[size];
	}

	
	public int size() {
		if(front > end) {
			return size + end - front;
		}
		return end -front;
	}
	
	public boolean isEmpty() {
		return front == end;
	}
	
	public int peek() {
		return arr[front];
	}
	
	public int dequeue() {
		int return_value = arr[front];
		if(++front == size) {
			front = 0;
		}
		return return_value;
	}

	public void enqueue(int data) {
       arr[end] = data;
       
       if(++end == size) end = 0;
       
       if(front == end ) throw new RuntimeException();
	}
	
	public void display() {
		Arrays.stream(arr).forEach(e-> System.out.println(e));
	}
	
	public static void main(String[] args) {
		IntegerQueue q = new IntegerQueue(5);
		q.enqueue(1);
		q.enqueue(1);
		q.enqueue(1);
		q.enqueue(1);
		q.enqueue(1);
		
		q.dequeue();
		q.enqueue(1);
		
		q.display();
	}
}
