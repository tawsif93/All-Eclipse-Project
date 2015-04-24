package deitel.exercise.chapter26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new BlockingBuffer();
		
		service.execute(new Producer(sharedLocation));
		service.execute(new Consumer(sharedLocation));
		
		service.shutdown();
	}

}
