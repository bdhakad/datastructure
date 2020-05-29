/**
 * 
 */
package ds;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author bdhakad
 *
 */
@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

	private int len = 0;
	private int capacity = 0;
	private T arr[];

	public Array() {
		this.capacity = 16;
		arr = (T[]) new Object[capacity];

	}

	public Array(int capacity1) {
		if (capacity1 < 0)
			throw new IllegalArgumentException("capacity is :" + capacity1);
		this.capacity = capacity1;
		arr = (T[]) new Object[capacity];
	}

	public Array(T[] arr) {
		super();
		this.arr = arr;
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return len == 0;
	}
	
	public void set(int index, T data) {
		if(index > len)
			throw new IndexOutOfBoundsException();
		arr[index] = data;
	}
	
	public T get(int index) {
		if(index >= len)
			throw new IndexOutOfBoundsException();
		 return arr[index] ;
	}
	
	public void clear() {
		System.out.println("clear ");
		for(int i=0; i< capacity; i++){
			arr[i]=null;
		}
		len =0;
	}

	public void add(T data) {

		if (len >= capacity) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity *= 2;

			T[] new_arr = (T[]) new Object[capacity];

			for (int i = 0; i < len; i++)
				new_arr[i] = arr[i];
			arr = new_arr;
		}
		arr[len++] = data;
	}
	
	public void removeAt(int rm_index) {
		if(rm_index <0 && rm_index >=len) 
			throw new IndexOutOfBoundsException();
		int k= capacity / 2;
		if (len <= k) {
			T[] new_arr = (T[]) new Object[len-1];
			for (int i = 0, j = 0; i < len; i++, j++) {
				if (i == rm_index)
					j--;
				else
					new_arr[j] = arr[i];

				arr = new_arr;
				capacity = --len;
			}
		}else {
			for(int i = rm_index; i < len; i++) {
				if (i == len - 1) {
					arr[i] = null;
				} else {
					arr[i] = arr[i + 1];
				}
			}
			len--;
		}
	}
	
	
	public void display() {
		Arrays.stream(arr).forEach(e->System.out.println(e));
		System.out.println("length "+len);
		System.out.println("capacity "+capacity);
	}
	public static void main(String[] args) {
		Array<Integer> a  = new Array<Integer>(0);
		
		for (int i = 0; i < 4; i++)
			a.add(i);
		a.display();
		
		a.removeAt(1);a.display();
		a.removeAt(1);a.display();
		a.removeAt(1);
		a.display();
	}
	
	
	public boolean remove(T data) {
		
		for(int i = 0; i < len; i++) {
			if(arr[i].equals(data)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(T obj) {
		for(int i = 0; i < len; i++) {
			if(arr[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}
	

	//*************************************
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
