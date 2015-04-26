package deitel.exercise.chapter26 ;

import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;

public class SharedBufferTest2 {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		ExecutorService executorService = Executors.newCachedThreadPool() ;

		Buffer SharedLocation = new SynchronisedBuffer() ;

		executorService.execute(new Producer(SharedLocation)) ;
		executorService.execute(new Consumer(SharedLocation)) ;

		executorService.shutdown() ;
	}

}
