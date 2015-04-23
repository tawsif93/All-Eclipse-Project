package deitel.exercise.chapter20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] suits = { "Diamond", "Hearts", "Clubs", "Spades" };

		List<String> list = Arrays.asList( suits);

		System.out.println( "Unsorted Array Element : " + list);

		Collections.sort( list);

		System.out.println( "Sorted Array Element : " + list);

	}

}
