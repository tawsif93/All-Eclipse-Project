package deitel.exercise.chapter26;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{

	private final ArrayBlockingQueue<Integer> buffer;
	
	public BlockingBuffer() {
	
		buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	@Override
	public void set(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		buffer.put(value);
		System.out.printf("Producer writes %2d\t Buffer Cells Occuppied : %2d\n" , value , buffer.size());
	}

	@Override
	public int get() throws InterruptedException {
		// TODO Auto-generated method stub
		int read = buffer.take();
		
		System.out.printf("Consumer reads %2d\t Buffer Cells Occuppied : %2d\n" , read , buffer.size());
		return read;
	}

}
