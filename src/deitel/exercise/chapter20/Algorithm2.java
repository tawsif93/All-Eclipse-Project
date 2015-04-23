package deitel.exercise.chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithm2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] colors = { "red", "green", "blue" };

		List<String> list1 = Arrays.asList( colors);

		List<String> list2 = new ArrayList<>();

		list2.add( "red");
		list2.add( "gold");
		list2.add( "silver");

		System.out.println( "List 2 Before Add all : " + list2);

		Collections.addAll( list2, colors);

		System.out.println( "List 2 After Add all " + list2);

		int frequency = Collections.frequency( list2, "red");

		System.out.println( "Frequency of Red in List2 : " + frequency);

		boolean disjoint = Collections.disjoint( list1, list2);

		System.out.println( "List1 & list2 "
				+ (disjoint ? "do not have common " : "Have common ")
				+ "element .");
	}

}
