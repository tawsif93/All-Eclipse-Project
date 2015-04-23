package deitel.exercise.chapter20;

import java.util.Arrays;
import java.util.LinkedList;

public class UsingToArray
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String[] color = { "red", "green", "blue" };

		LinkedList<String> links = new LinkedList<>( Arrays.asList( color));

		links.add( "Black");
		links.add( 3, "pink");
		links.addFirst( "cayan");

		color = links.toArray( new String[links.size()]);

		System.out.println( "Colors : ");

		for (String string : color)
			System.out.println( string);
	}

}
