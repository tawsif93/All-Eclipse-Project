package deitel.exercise.chapter26 ;

public class SynchronisedBuffer implements Buffer {

	private int		Buffer		= -1 ;

	private boolean	occupied	= false ;

	@Override
	public synchronized void set( int value ) throws InterruptedException {
		// TODO Auto-generated method stub

		while (occupied)
		{
			System.out.println("Producer tries to write ") ;
			displayState("Buffer Full , Producer waits ") ;
			wait() ;
		}

		Buffer = value ;

		occupied = true ;

		displayState("Producer writes " + Buffer) ;

		notifyAll() ;

	}

	@Override
	public synchronized int get() throws InterruptedException {
		// TODO Auto-generated method stub
		while (!occupied)
		{
			System.out.println("consumer tries to read ") ;
			displayState("Buffer Empty , Consumer Waits") ;
			wait() ;
		}

		occupied = false ;

		displayState("Consumer Reads : " + Buffer) ;

		notifyAll() ;

		return Buffer ;
	}

	private void displayState( String operation ) {
		// TODO Auto-generated method stub
		System.out.printf("%-40s%d\t\t%b\n\n", operation, Buffer, occupied) ;
	}

}
