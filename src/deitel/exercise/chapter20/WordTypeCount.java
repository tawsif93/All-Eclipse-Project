/**
 * 
 */
package deitel.exercise.chapter20 ;

import java.util.HashMap ;
import java.util.Map ;
import java.util.Scanner ;
import java.util.Set ;
import java.util.TreeSet ;

/**
 * @author tawsif
 *
 */
public class WordTypeCount {

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		Map< String , Integer> map = new HashMap<>() ;

		createMap(map) ;
		displayMap(map) ;
	}

	private static void createMap( Map< String , Integer> map ) {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in) ;
		System.out.println("Enter a String : ") ;

		String string = stdin.nextLine() ;

		String[] tokens = string.split(" ") ;

		for (String token : tokens) {

			String word = token.toLowerCase() ;

			if (map.containsKey(word)) {

				int count = map.get(word) ;
				map.put(word, count + 1) ;
			}

			else
				map.put(word, 1) ;
		}
	}

	private static void displayMap( Map< String , Integer> map ) {
		// TODO Auto-generated method stub

		Set< String> keys = map.keySet() ;

		TreeSet< String> sortedKeys = new TreeSet<>(keys) ;

		System.out.println("\nMap Contains: \nKey\t\tValue") ;
		for (String string : sortedKeys)
			System.out.printf("%-10s%10s\n", string, map.get(string)) ;

		System.out.printf("\nsize: %d\nisEmpty: %b\n", map.size(),
				map.isEmpty()) ;

	}

}
