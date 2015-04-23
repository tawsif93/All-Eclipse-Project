package deitel.exercise.chapter26 ;

import java.util.Random ;

public class PrintTask implements Runnable {

	private final int			sleepTime ;
	private final String		TaskName ;
	private final static Random	genarator	= new Random() ;

	public PrintTask ( String name ) {
		// TODO Auto-generated constructor stub
		TaskName = name ;
		sleepTime = genarator.nextInt(5000) ;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try
		{
			System.out.println(TaskName + " going to sleep for " + sleepTime
					+ " miliseconds") ;
			Thread.sleep(sleepTime) ;

		} catch ( Exception e )
		{
			// TODO: handle exception
			System.out.println(TaskName
					+ " terminated permanently due to Interuption") ;
		}

		System.out.println(TaskName + " done sleeping") ;
	}

}
