package deitel.exercise.chapter26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Buffer shared = new UnsynchronisedBuffer() ;
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		System.out.println("Action\t\tValue\tSum Of Producder\tSum of Consumer");
		
		
		service.execute(new Producer(shared));
		service.execute(new Consumer(shared));
		
		service.shutdown();
	}

}
