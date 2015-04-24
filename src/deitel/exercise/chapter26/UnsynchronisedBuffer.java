package deitel.exercise.chapter26;

public class UnsynchronisedBuffer implements Buffer{

	private int buffer = -1 ;
	
	@Override
	public void set(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		buffer = value ;
		System.out.printf("Producer writes\t%2d" , value );
	}

	@Override
	public int get() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.printf("Consumer Reads\t%2d" , buffer );

		return buffer;
	}

}
