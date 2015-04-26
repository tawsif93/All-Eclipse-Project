package deitel.exercise.chapter21;

public class GenericMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character[] charArray = { 'A', 'B', 'C', 'D', 'E' };

		System.out.print("Integer Array Contains : ");
		printArray(intArray);
		System.out.print("\nDouble Array Contains : ");
		printArray(doubleArray);
		System.out.print("\nCharachter Array Contains : ");
		printArray(charArray);
	}

	public static <T> void printArray(T[] array) {
		// TODO Auto-generated method stub
		for (T element : array) {
			System.out.printf(element + " ");
		}
	}

}
