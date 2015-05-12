/**
 * 
 */
package deitel.exercise.chapter22;

import java.util.Random;

/**
 * @author mohammedtawsif
 *
 */
public class TreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree <Integer> tree = new Tree<Integer>();

		int value ;
		Random randomNumber = new Random();

		System.out.println( "Inserting the following values: " );

		for(int i  = 0 ; i < 10 ; i++)
		{
			value = randomNumber.nextInt( 100 );
			System.out.printf( "%d ", value );
			tree.insertNode( value );
		}
		
		System.out.println ( "\n\nPreorder traversal" );
		tree.preorderTraversel();

		System.out.println ( "\n\nInorder traversal" );
		tree.inorderTraversel();

		System.out.println ( "\n\nPostorder traversal" );
		tree.postorderTraversel();

		System.out.println();
	}
}


