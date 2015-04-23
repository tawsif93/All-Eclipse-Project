package deitel.exercise.chapter26 ;

import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;
import java.util.concurrent.TimeUnit ;

public class SharedArrayTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		SimpleArray sharedSimpleArray = new SimpleArray(6) ;

		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray) ;
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray) ;

		ExecutorService service = Executors.newCachedThreadPool() ;

		service.execute(writer1) ;
		service.execute(writer2) ;

		service.shutdown() ;

		System.out.println() ;

		try
		{
			boolean end = service.awaitTermination(1, TimeUnit.MINUTES) ;

			if (end)
				System.out.println(sharedSimpleArray) ; // print contents
			else
				System.out
						.println("Timed out while waiting for tasks to finish.") ;
		} catch ( InterruptedException exception )
		{

			System.err.println("Inturrupt during waiting for Finish") ;
		}
	}
}
