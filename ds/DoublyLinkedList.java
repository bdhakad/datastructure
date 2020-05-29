/**
 * 
 */
package ds;

import java.util.Iterator;

/**
 * @author bdhakad
 *
 */
public class DoublyLinkedList<T> implements Iterable<T> {

	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;

	public class Node<T> {

		T data;
		Node<T> prev, next;

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addLast(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null, null);
		} else {
			tail.next = new Node<T>(data, tail, null);
			tail = tail.next;
		}

		size++;
	}

	public void add(T data) {
		addLast(data);
	}

	public void addFirst(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null, null);
		} else {
			head.prev = new Node<T>(data, null, head);
			head = head.prev;
		}
		size++;
	}
	
	public T peekFirst() {
		if(isEmpty()) 
			throw new RuntimeException("List is empty");
		return head.data;
	}
	
	public T peekLast() {
		if(isEmpty()) 
			throw new RuntimeException("List is empty");
		return tail.data;
	}
	
	
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty");
		T data = head.data;

		if (size() == 1) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		--size;

		return data;
	}
	
	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("List is empty");
		T data = tail.data;

		if (size() == 1) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		--size;

		return data;
	}
	
	private T remove(Node <T> node) {
		if (isEmpty())
			throw new RuntimeException("List is empty");
		T data = node.data;
		
		
		if (node.prev == null)
			removeFirst();
		else if (node.next == null)
			removeLast();
		else {
			node.next.prev = node.prev;
			node.prev.next = node.next;
			node = node.next = node.prev = null;
			--size;
		}
		return data;
	}
	
	public boolean removeByValue(T data) {
		Node<T> trav = head, temp;
		boolean bool = false;
		
		if(data == null) {
			while(trav != null) {
				if(trav.data == null) {
					temp = trav.next;
					remove(trav);
					trav = temp;
				}else {
					trav = trav.next;
				}
			}
			bool = true;
		}else {
			while(trav != null) {
				if(data.equals(trav.data)) {
					temp = trav.next;
					remove(trav);
					trav = temp;
				}else {
					trav = trav.next;
				}
			}
			bool= true;
		}
		
		return bool;
	}
	
	
	// Find the first index of a particular value in the linked list, O(n)
	public int indexOf(T data) {
		
		Node<T> trav = head;
		int index = 0;
		
		while(trav != null) {
			if(trav.data == data)
				return index;
			
			index++;
			trav = trav.next;
		}
		
		return -1;

	}
	
	public boolean contains(T data) {
		return indexOf(data) != -1;
	}
	
	public void clear() {
		Node<T> trav = head, temp;
		
		while(trav != null) {
			temp =  trav.next;
			
			trav.next = trav.prev = null;
			trav.data= null;
			
			trav = temp;
		}
		head = tail = trav = temp = null;
		size = 0;
	}
	

	// **********************************************
	public static void main(String[] args) {
		DoublyLinkedList<Integer> a = new DoublyLinkedList<Integer>();
		for (int i = 0; i <= 4; i++)
			a.add(i);

		
		a.add(2);
		System.out.println(a.toString());
		
		a.clear();
		System.out.println(a.toString());
		
	}

	
	@Override
	public String toString() {
		Node<T> trav= head;
		StringBuilder sb  = new StringBuilder();
		sb.append("[");
		while(trav != null) {
			sb.append(trav.data + "<-->");
			trav =trav.next;
		}
		sb.append("null");
		sb.append("]");
		return sb.toString();
		
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
