package deitel.exercise.chapter20;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String[] color1 = { "red", "Green", "Blue", "Black", "Yellow" };

		List<String> list1 = new LinkedList<>();

		for (String string : color1)
			list1.add( string);

		String[] color2 = { "Grey", "pink", "White", "Brown", "Silver", "Gold" };

		List<String> list2 = new LinkedList<>();

		for (String string : color2)
			list2.add( string);

		list1.addAll( list2);

		list2.clear();

		printList( list1);

		convertLowercaseToUppercase( list1);

		printList( list1);

		System.out.println( "Deleting element 4 to 6 : ");

		deleteElement( list1, 4, 7);

		printList( list1);

		System.out.println( "Print Reversely : ");

		reversePrint( list1);
	}

	private static void reversePrint(List<String> list)
	{
		// TODO Auto-generated method stub
		ListIterator<String> iterator = list.listIterator( list.size());

		while (iterator.hasPrevious())
		{
			String string = iterator.previous();
			System.out.println( string);
		}

	}

	private static void deleteElement(List<String> list, int start, int end)
	{
		// TODO Auto-generated method stub

		list.subList( start, end).clear();
	}

	private static void convertLowercaseToUppercase(List<String> list)
	{
		// TODO Auto-generated method stub
		ListIterator<String> iterator = list.listIterator();

		while (iterator.hasNext())
		{
			String string = iterator.next();
			iterator.set( string.toUpperCase());

		}
	}

	private static void printList(List<String> list)
	{
		// TODO Auto-generated method stub
		System.out.println( "List : ");

		for (String string : list)
			System.out.println( string);
	}
}
