package deitel.exercise.chapter26;

import java.util.Random;

public class Producer implements Runnable{

	private final Buffer SharedLocation  ;
	private final Random genarator = new Random();
	

	public Producer(Buffer shared) {
		// TODO Auto-generated constructor stub
		SharedLocation = shared ;
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		int sum = 0 ;
		
		for (int count = 1 ; count <= 10 ; count++)
		{
			try {
				Thread.sleep(genarator.nextInt(3000));
				SharedLocation.set(count);
				sum += count ;
				System.out.printf("\t\t%2d\n" , sum);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("producer done producing\nTerminating Producer.");
	}
	
}
