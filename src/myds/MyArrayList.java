package myds;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**My ArrayList
 * (Imported from class-Iris)
 * 
 * @param <T>
 */
public class MyArrayList<T extends Comparable<T>>implements Iterable<T> {

	private T[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	/**Constructor
	 * 
	 */
	@SuppressWarnings("unchecked")//tells java that this is safe and to hide the error
	public MyArrayList() {
		this.elements = (T[]) new Comparable[DEFAULT_CAPACITY];	
	}
	
	/** increases the arraylist size
	 * 
	 */
	private void doubleCapacity() {
		int newSize = elements.length*2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	/** adds data to the arraylist
	 * @param element	the data being added
	 * @return			returns true
	 */
	public boolean add(T element) {
		if(elements.length == size) {
			doubleCapacity();
		}
		elements[size] = element;
		size++;
		return true;
	}
	
	/**Turns an arraylist into a string
	 * 
	 *@return returns an arraylist as a string sperated by , inside of brackets
	 */
	@Override
	public String toString() {
		String text = "[";
		for(int i = 0; i < size; i++) {
			if(i == size-1) {
				text = text + elements[i];
			}else {
				text = text + elements[i] + ", ";
			}
		}
		text = text + "]";
		return text;
	}
	
	/** gets the size of the arraylist
	 * @return an int of the size
	 */
	public int size() {
		return size;
	}
	
	/** checks if empty
	 * @return	true if empy else returns false
	 */
	public Boolean isEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**used for checking an index throws error if no value
	 * @param index the index being checked
	 */
	private void checkIndex(int index) {
		if(index>=size|| index< 0) {
			throw new IndexOutOfBoundsException("Index" + index + ", Size: "  + size);
		}
	}
	
	/** sets an certian index to be new data
	 * 
	 * @param index 		the int of where we are changing the data
	 * @param element	the data being served
	 * @return			returns the old data
	 */
	public T set(int index, T element) {
		checkIndex(index);
		T old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/** returns the data at an index
	 * @param index	the data's index being gotten
	 * @return		returns the data being stored
	 */
	public T get(int index) {
		checkIndex(index);
		return elements[index];
	}
	
	/**looks for an element
	 * @param element the element being searched for
	 * @return	 an int of the index of the data
	 */
	private int indexOf(T element) {
		if(element == null) {
			for(int i = 0; i < size; i++) {
				if(elements[i] == null) {
					return i;
				}
			}
		}else {
			for(int i = 0; i < size; i++) {
				if(element.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/** deletes data based on a element
	 * @param element	the element being removed
	 * @return			true if the item is removed false if not
	 */
	public boolean remove(T element) {
		int index = indexOf(element);
		if(index == -1) {
			return false;
		}
		for(int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		elements[size -1] = null;
		size--;
		return true;
	}
	
	/**checks for an element
	 * @param element 	the element being looked for
	 * @return			true if found false if not
	 */
	public boolean contains(T element) {
		return indexOf(element) >= 0;
	}
	
	/**combines two arrays
	 * 
	 * @param arr1	array 1 being combined
	 * @param arr2	array 2 being combined
	 * @return		returns a combination of the arrays
	 */
	@SuppressWarnings("unchecked")
	private T[] mergeTwoArrays(T[] arr1, T[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		T[] result = (T[]) new Comparable[n1 + n2];
		int i = 0, j = 0, k = 0;
		
		while (i < n1 && j < n2) {
			if (arr1[i].compareTo(arr2[j]) <= 0) {
				result[k++] = arr1[i++];
			}else {
				result[k++] = arr2[j++];
			}
		}
		while (i < n1) {
			result[k++] = arr1[i++];
		}
		while (j < n2) {
			result[k++] = arr2[j++];
		}
		return result;
	}

	/**sorts the array
	 * 
	 */
	public void sort() {
		elements = mergeSort(Arrays.copyOf(elements, size));
		}
	
	/**sorts by merging used in sort
	 * 
	 * @param arr combines two arrays
	 * @return	returns an array
	 */
	private T[] mergeSort(T[] arr) {
		int n = arr.length;
		if (n <= 1) { 
			return arr;
		}
		int mid = n / 2;
		T[] left = Arrays.copyOfRange(arr, 0, mid);
		T[] right = Arrays.copyOfRange(arr, mid, n);
		left = mergeSort(left);
		right = mergeSort(right);
		return mergeTwoArrays(left, right);
	}
		
	/** nested class for iterator
	 * 
	 */
	private class MyIterator implements Iterator<T> {
		private int cursor = 0;//index of next element to return
		@Override
		public boolean hasNext() {
			return cursor<size;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return elements[cursor++];
		}

	}


	/**Iterator
	 *
	 */
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

}

