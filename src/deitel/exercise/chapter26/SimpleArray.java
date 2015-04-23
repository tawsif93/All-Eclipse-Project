package deitel.exercise.chapter26 ;

import java.util.Arrays ;
import java.util.Random ;

public class SimpleArray {

	private final int[]			array ;
	private int					writeIndex ;
	private final static Random	genarator	= new Random() ;

	public SimpleArray ( int size ) {
		// TODO Auto-generated constructor stub
		array = new int[size] ;
	}

	public synchronized void add( int value ) {
		int position = writeIndex ;
		try
		{
			Thread.sleep(genarator.nextInt(5000)) ;

		} catch ( InterruptedException exception )
		{
			exception.printStackTrace() ;
		}

		array[position] = value ;

		System.out.println(Thread.currentThread().getName() + " wrote " + value
				+ " to element " + position) ;

		++writeIndex ;

		System.out.println("Next write index : " + writeIndex) ;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Contents of the Array : " + Arrays.toString(array) ;
	}
}
