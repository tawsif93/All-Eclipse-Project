package deitel.exercise.chapter26 ;

public class CircularBuffer implements Buffer {

	private final int[]	buffer			= { -1, -1, -1 } ;
	private int			occupiedCells	= 0 ;
	private int			writeIndex		= 0 ;
	private int			readIndex		= 0 ;

	@Override
	public synchronized void set( int value ) throws InterruptedException {
		// TODO Auto-generated method stub
		while (occupiedCells == buffer.length)
		{
			System.out.println("Buffer is full , Producer Waits") ;
			wait() ;
		}

		buffer[writeIndex] = value ;

		writeIndex = (writeIndex + 1) % buffer.length ;

		++occupiedCells ;

		displayState("Producer writes : " + value) ;
		notifyAll() ;

	}

	@Override
	public synchronized int get() throws InterruptedException {
		// TODO Auto-generated method stub
		while (occupiedCells == 0)
		{
			System.out.println("Buffer empty , Consumer waits") ;
			wait() ;
		}

		int readValue = buffer[readIndex] ;

		readIndex = (readIndex + 1) % buffer.length ;

		displayState("Consumer Reads : " + readValue) ;

		--occupiedCells ;

		notifyAll() ;

		return readValue ;
	}

	private void displayState( String string ) {
		// TODO Auto-generated method stub
		System.out.printf("%s%s%d)\n%s", string, " (buffer cells occupied: ",
				occupiedCells, "buffer cells : ") ;

		for (int value : buffer)
			System.out.printf(" %2d ", value) ;

		System.out.print("\n                ") ;

		for (int element : buffer)
			System.out.print("---- ") ;

		System.out.print("\n                ") ;

		for (int i = 0; i < buffer.length; i++)
			if ((i == writeIndex) && (i == readIndex))
				System.out.print(" WR") ; // both write and read index
			else if (i == writeIndex)
				System.out.print(" W") ; // just write index
			else if (i == readIndex)
				System.out.print(" R ") ; // just read index
			else
				System.out.print("  ") ;
		System.out.println("\n") ;
	}
}
