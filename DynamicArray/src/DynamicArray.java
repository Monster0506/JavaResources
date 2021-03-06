/***
 * A general purpose dynamically sized array.
 * 
 * @author Monster0506
 */
public class DynamicArray {

	int size;
	int capacity = 10;
	Object[] array;

	/**
	 *
	 * Describes the type of the array
	 * 
	 * Sets the current capacity of the array to the {@code capacity} variable.
	 * 
	 * @custom.see {@link #DynamicIntArray(int)}
	 */
	public DynamicArray() {
		this.array = new Object[capacity];
	}

	/**
	 * Overrides DynamicArray with a capacity.
	 * 
	 * @param capacity int - the initial size of the array.
	 * 
	 * @custom.see {@link #DynamicIntArray()}
	 */
	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.array = new Object[capacity];
	}

	/**
	 * Get an item at a user specified index
	 * 
	 * @param index int - the location to get the item of the array from.
	 * 
	 * @return Object - the Object at the index position. Returns null if that
	 *         position does not exist.
	 * 
	 * @custom.see {@link #get()}
	 */
	public Object get(int index) {
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
	 * @param data Object - the item to add to the end of the array.
	 * 
	 * @custom.calls {@link #grow()}
	 * 
	 * @custom.see {@link #insert()}
	 * 
	 */
	public void add(Object data) {
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
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];

		}
		if (size > capacity) {
			shrink();
		}

		size--;

	}

	/**
	 * Adds an Object to a user defined position in the array.
	 * 
	 * @param index int - the place to insert the Object in
	 * 
	 * @param data  Object - the item to insert into the array.
	 * 
	 * @custom.calls {@link #grow()}
	 * 
	 * @custom.see :#add()
	 * 
	 */
	public void insert(int index, Object data) {
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
	 * Removes a user specified Object from the array.
	 * 
	 * @param data Object - The Object to be removed
	 * 
	 * @custom.calls {@link #shrink()}
	 * 
	 * @custom.see {@link #remove()}
	 */
	public void delete(Object data) {
		for (int i = 0; i < size; i++) {
			if (array[i] == data) {
				for (int j = 0; j < (size - i - 1); j++) {
					array[i + j] = array[i + j + 1];
				}

				array[size - 1] = null;
				size--;

				if (size <= (capacity / 3)) {
					shrink();
				}
				break;
			}
		}
	}

	/**
	 * Returns the position of the Object in the array.
	 * 
	 * @param data Object - the int to search for.
	 * 
	 * @return Object - the position of the Object in the array. If the Object does
	 *         not exist, returns -1
	 * 
	 * @custom.see {@link #get()}
	 */
	public int search(Object data) {
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
		int newCapacity = (capacity * 2);
		Object[] newArray = new Object[newCapacity];

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
		int newCapacity = (capacity / 2);
		Object[] newArray = new Object[newCapacity];

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
}