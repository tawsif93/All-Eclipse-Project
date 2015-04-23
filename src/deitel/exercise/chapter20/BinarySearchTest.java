package deitel.exercise.chapter20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String[] colors = { "Red", "Green", "Blue", "Black", "Silver", "Gold",
				"Pink", "White", "Purple" };

		List<String> list = Arrays.asList( colors);

		System.out.println( "List as Unsorted way : " + list);

		Collections.sort( list);
		System.out.println( "Sorted List : " + list);

		printSearchResult( list, colors[0]);
		printSearchResult( list, colors[6]);
		printSearchResult( list, colors[3]);
		printSearchResult( list, "Gray");
		printSearchResult( list, "Hagy");
		printSearchResult( list, "A");
	}

	private static void printSearchResult(List<String> list, String key)
	{
		// TODO Auto-generated method stub
		int result = Collections.binarySearch( list, key);

		if (result >= 0)
			System.out.println( "Element Found at : " + result);
		else
			System.out.println( "Element not found : (" + result + ")");

	}

}
