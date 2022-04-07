
/***
 * A dynamically sized array of integers.
 * 
 * 
 * @author Monster0506
 */
public class DynamicIntArray {

	/**
	 * The visible size of the array.
	 */
	int size;
	int capacity = 10;
	int[] array;

	/**
	 *
	 * Describes the type of the array
	 * 
	 * Sets the current capacity of the array to the {@code capacity} variable.
	 * 
	 * @custom.see {@link #DynamicIntArray(int)}
	 */
	public DynamicIntArray() {
		this.array = new int[capacity];
	}

	/**
	 * Overrides DynamicArray with a capacity.
	 * 
	 * @param capacity int - the initial size of the array.
	 * 
	 * @custom.see {@link #DynamicIntArray()}
	 */
	public DynamicIntArray(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
	}

	/**
	 * Get an item at a user specified index
	 * 
	 * @param index int - the location to get the item of the array from.
	 * 
	 * @return int - the int at the index position. Returns null if that position
	 *         does not exist.
	 * 
	 * @custom.see {@link #get()}
	 */
	public int get(int index) {
		return array[index];
	}

	/**
	 * The default value for the get module, returns the first item in the array.
	 * 
	 * @return Object - the object at the initial position.
	 * 
	 * @custom.see {@link #get(int index)}
	 */
	public Object get() {
		return array[0];
	}

	/**
	 * Appends an item to the end of the array.
	 * 
	 * @param data int - the item to add to the end of the array.
	 * 
	 * @custom.calls {@link #grow()}
	 * 
	 * @custom.see {@link #insert()}
	 * 
	 */
	public void add(int data) {
		if (size >= capacity) {
			grow();
		}

		array[size] = data;
		size++;

	}

	/**
	 * Removes an item at a specific index.
	 * 
	 * @param index int - the index to remove from the array.
	 * 
	 * @custom.calls {@link #shrink()}
	 * 
	 * @custom.see {@link #delete()}
	 */
	public void remove(int index) {
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];

		}
		if (size > capacity) {
			shrink();
		}

		size--;

	}

	/**
	 * Adds an int to a user defined position in the array.
	 * 
	 * @param index int - the place to insert the int in
	 * 
	 * @param data  int - the item to insert into the array.
	 * 
	 * @custom.calls {@link #grow()}
	 * 
	 * @custom.see :#add()
	 * 
	 */
	public void insert(int index, int data) {
		if (size >= capacity) {
			grow();
		}

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = data;
		size++;
	}

	/**
	 * Removes a user specified int from the array.
	 * 
	 * @param data int - The int to be removed
	 * 
	 * @custom.calls {@link #shrink()}
	 * 
	 * @custom.see {@link #remove()}
	 */
	public void delete(int data) {
		for (int i = 0; i < size; i++) {
			if (array[i] == data) {
				remove(i);
			}
		}
	}

	/**
	 * Returns the position of the int in the array.
	 * 
	 * @param data int - the int to search for.
	 * 
	 * @return int - the int position in the array. If the int does not exist,
	 *         returns -1
	 * 
	 * @custom.see {@link #get()}
	 */
	public int search(int data) {
		for (int i = 0; i < size; i++) {
			if (array[i] == data) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * increases the capacity of the array.
	 * 
	 * @custom.see {@link #shrink()}
	 */
	private void grow() {
		int newCapacity = (capacity + 1);
		int[] newArray = new int[newCapacity];

		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}

		capacity = newCapacity;
		array = newArray;

	}

	/**
	 * Decreases the capacity of the array.
	 * 
	 * @custom.see {@link #grow()}
	 */
	private void shrink() {
		int newCapacity = (capacity - 1);
		int[] newArray = new int[newCapacity];

		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}

		capacity = newCapacity;
		array = newArray;
	}

	/**
	 * Determines if the array is empty.
	 * 
	 * @return boolean - true if the array is empty, else false.
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Returns the array in a list format.
	 * 
	 * @returns String - The values that exist in the size of the array. Appears as
	 * "[1, 2, 4]"
	 */
	public String toString() {
		String string = "";

		for (int i = 0; i < size; i++) {
			string += array[i] + ", ";
		}
		if (!"".equals(string)) {
			string = "[" + string.substring(0, string.length() - 2) + "]";
		} else {
			string = "[]";
		}
		return string;

	}

	/**
	 * Return the maximum value in the array.
	 * 
	 * @return int - the maximum value in the array.
	 * 
	 * @custom.see {@link #min()}
	 */
	public int max() {
		int hi = array[0];
		for (int i = 0; i < size; i++) {
			if (array[i] > hi) {
				hi = array[i];
			}
		}
		return hi;
	}

	/**
	 * Returns the minimum value in the array
	 * 
	 * @return int - the minimum value in the array
	 * 
	 * @custom.see {@link #max()}
	 */
	public int min() {
		int low = array[0];
		for (int i = 0; i < size; i++) {
			if (array[i] < low) {
				low = array[i];
			}
		}

		return low;

	}

}
