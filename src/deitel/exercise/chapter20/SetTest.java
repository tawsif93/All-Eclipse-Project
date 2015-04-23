/**
 * 
 */
package deitel.exercise.chapter20 ;

import java.util.Arrays ;
import java.util.Collection ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Set ;

/**
 * @author tawsif
 *
 */
public class SetTest {

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		String[] colors = { "red", "white", "blue", "green", "gray", "orange",
				"tan", "white", "cyan", "peach", "gray", "orange" } ;
		List< String> list = Arrays.asList(colors) ;

		System.out.println("List : " + list) ;

		printNonDuplicateElement(list) ;
	}

	private static void printNonDuplicateElement( Collection< String> list ) {
		// TODO Auto-generated method stub
		Set< String> set = new HashSet<>(list) ;

		System.out.println("Hash set : " + set) ;

	}

}
