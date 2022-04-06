public class DynamicArray {
	int size;
	int capacity = 10;
	Object[] array;

	

	public DynamicArray() {
		this.array = new Object[capacity];
	}

	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.array = new Object[capacity];
	}

        public Object get(int index) {
            return array[index];
        }

	

	public void add(Object data) {
		if(size >= capacity) {
			grow();
		}

		array[size] = data;
		size++;

	}
    public void remove (int index){
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

	public void insert(int index, Object data) {
		if(size >= capacity) {
			grow();
		}

		for(int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = data;
		size++;
	}

	

	public void delete(Object data) {
		for(int i = 0; i < size; i++) {
			if(array[i] == data) {
				for(int j = 0; j < (size - i - 1); j++){
					array[i + j] = array[i + j + 1];
				}

				array[size - 1] = null;
				size--;

				if(size <=(int) (capacity/3)) {
					shrink();
				}
				break;
			}
		}
	}

	public int search(Object data) {
		for(int i = 0; i < size; i++) {
			if(array[i] == data) {
				return i;
			}
		}
		return -1;
	}

	private void grow() {
		int newCapacity = (int)(capacity * 2);
		Object[] newArray = new Object[newCapacity];

		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}

		capacity = newCapacity;
		array = newArray;

	}

	private void shrink() {
		int newCapacity = (int)(capacity / 2);
		Object[] newArray = new Object[newCapacity];

		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}

		capacity = newCapacity;
		array = newArray;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		String string = "";

		for(int i = 0; i < size; i++) {
			string += array[i] + ", ";
		}
		if(!"".equals(string)) {
			string = "[" + string.substring(0, string.length() - 2) + "]";
		}else {
			string = "[]";
		}
		return string;

	}
	
	public int max() {
		int hi = (int)array[0];
		for (int i = 0; i < size; i++) {
			if ((int)array[i]> hi) {
				hi = (int)array[i];
			}
		}
		
		return hi;
		
	}	public int min() {
		int low = (int)array[0];
		for (int i = 0; i < size; i++) {
			if ((int)array[i]< low) {
				low = (int)array[i];
			}
		}
		
		return low;
		
	}
	
	
	
	
}