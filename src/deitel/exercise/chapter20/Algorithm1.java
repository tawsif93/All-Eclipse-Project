package deitel.exercise.chapter20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithm1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Character[] letters = { 'P', 'C', 'M' };

		List<Character> list = Arrays.asList( letters);

		System.out.println( "List Contains : ");

		output( list);

		Collections.reverse( list);
		System.out.println( "List After Calling Reverse : ");
		output( list);

		Character[] lettersCopy = new Character[3];
		List<Character> copyList = Arrays.asList( lettersCopy);
		Collections.copy( copyList, list);

		System.out.println( "After Copying , CopyList Contains : ");
		output( copyList);

		Collections.fill( list, 'R');
		System.out.println( "List After Filling With R : ");
		output( list);
	}

	private static void output(List<Character> list)
	{
		// TODO Auto-generated method stub
		System.out.println( "The List is : ");

		for (Character character : list)
			System.out.printf( "%s ", character);

		System.out.println( "\nMax : " + Collections.max( list));
		System.out.println( "Min : " + Collections.min( list));

	}

}
