/**
 * 
 */
package deitel.exercise.chapter20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author tawsif
 *
 */
public class CollectionTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] color = { "Megenta", "Red", "Green", "Blue", "Yellow" };

		List<String> list = new ArrayList<>();

		for (String string : color)
		{
			list.add( string);
		}

		String[] removeColor = { "Red", "Blue" };

		List<String> removeList = new ArrayList<>();

		for (String string : removeColor)
		{
			removeList.add( string);
		}
		
		System.out.println("ArayList : " );
		System.out.println(list);
		
		removeColors(list , removeList);
		
		System.out.println("ArrayList After removing : ");
		
		System.out.println(list);
	}
	
	public static void removeColors(Collection <String> l1 , Collection<String> l2)
	{
		Iterator<String> iterator = l1.iterator();
		
		while(iterator.hasNext())
		{
			if(l2.contains( iterator.next()))
			{
				iterator.remove();
			}
		}
	}

}
