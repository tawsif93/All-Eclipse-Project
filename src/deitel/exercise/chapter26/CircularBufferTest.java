package deitel.exercise.chapter26 ;

import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;

public class CircularBufferTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newCachedThreadPool() ;

		Buffer shareLocation = new CircularBuffer() ;

		service.execute(new Producer(shareLocation)) ;
		service.execute(new Consumer(shareLocation)) ;

		service.shutdown() ;
	}

}
