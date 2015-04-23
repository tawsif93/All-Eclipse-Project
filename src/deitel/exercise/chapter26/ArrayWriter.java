package deitel.exercise.chapter26 ;

public class ArrayWriter implements Runnable {

	private final SimpleArray	SharedSimpleArray ;
	private final int			startValue ;

	public ArrayWriter ( int value , SimpleArray array ) {
		// TODO Auto-generated constructor stub
		startValue = value ;
		SharedSimpleArray = array ;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = startValue; i < (startValue + 3); i++)
			SharedSimpleArray.add(i) ;
	}

}
