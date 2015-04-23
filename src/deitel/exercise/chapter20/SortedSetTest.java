package deitel.exercise.chapter20 ;

import java.util.Arrays ;
import java.util.SortedSet ;
import java.util.TreeSet ;

public class SortedSetTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		String[] colors = { "red", "white", "blue", "green", "gray", "orange",
				"tan", "white", "cyan", "peach", "gray", "orange" } ;

		SortedSet< String> set = new TreeSet<>(Arrays.asList(colors)) ;

		System.out.println("Sorted Set : " + set) ;

		System.out.println("Head Set : " + set.headSet("orange")) ;
		System.out.println("Tail Set : " + set.tailSet("orange")) ;

		System.out.println("First Element : " + set.first()) ;
		System.out.println("Last Element : " + set.last()) ;
	}

}
