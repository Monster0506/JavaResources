public class Main {
	/***
	 * Some general demonstrations of the different resources in this package.
	 * 
	 */
	public static void main(String[] args) {
		DynamicArray dynamicArray = new DynamicArray();
		dynamicArray.add(1);
		dynamicArray.add(null);
		dynamicArray.add("");
		dynamicArray.add("hi There!");
		dynamicArray.add("");
		dynamicArray.add("31");
		dynamicArray.add(true);
		System.out.println(dynamicArray);
		System.out.println(dynamicArray.get(9));
		DynamicIntArray dynamicIntArray = new DynamicIntArray(1);
		dynamicIntArray.add(1);
		dynamicIntArray.add(3);
		dynamicIntArray.add(9);
		dynamicIntArray.add(0);
		dynamicIntArray.add(0);
		dynamicIntArray.add(1);
		System.out.println(dynamicIntArray);
		dynamicIntArray.delete(3);
		dynamicIntArray.delete(0);
		System.out.println(dynamicIntArray);
		System.out.println(dynamicIntArray.get());
		System.out.println(dynamicIntArray.max());
		System.out.println(dynamicIntArray.min());
		System.out.println(dynamicIntArray.search(9));

	}

}
