package deitel.exercise.chapter26 ;

import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;

public class PrintTaskTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		PrintTask task1 = new PrintTask("Task 1") ;
		PrintTask task2 = new PrintTask("Task 2") ;
		PrintTask task3 = new PrintTask("Task 3") ;

		System.out.println("Starting Executor ") ;

		ExecutorService service = Executors.newCachedThreadPool() ;

		service.execute(task1) ;
		service.execute(task2) ;
		service.execute(task3) ;

		service.shutdown() ;

		System.out.println("Main Task End") ;

	}

}
