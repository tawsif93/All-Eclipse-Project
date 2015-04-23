package deitel.exercise.chapter20 ;

import java.util.EmptyStackException ;
import java.util.Stack ;

public class StackTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		Stack< Number> stack = new Stack<>() ;

		stack.push(1200L) ;
		System.out.println("Pushed 1200L") ;
		printStack(stack) ;
		stack.push(32678) ;
		System.out.println("Pushed 32678") ;
		printStack(stack) ;
		stack.push(1.0F) ;
		System.out.println("Pushed 1.0F") ;
		printStack(stack) ;
		stack.push(1234.5678) ;
		System.out.println("Pushed 1234.5678") ;
		printStack(stack) ;

		try {
			Number removeObject = null ;

			while (true) {
				removeObject = stack.pop() ;
				System.out.println("Popped : " + removeObject) ;
				printStack(stack) ;

			}

		} catch ( EmptyStackException emptyStackException ) {
			// TODO: handle exception
			emptyStackException.printStackTrace() ;
		}

	}

	private static void printStack( Stack< Number> stack ) {
		// TODO Auto-generated method stub
		if (stack.empty())
			System.out.println("Stack Is Empty") ;
		else
			System.out.println("Stack Contains : " + stack) ;
	}

}
