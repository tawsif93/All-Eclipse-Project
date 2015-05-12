/**
 * 
 */
package deitel.exercise.chapter22;

/**
 * @author mohammedtawsif
 *
 */
public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer > queue = new Queue<Integer>();

		queue.enqueue(1);
		queue.print();
		queue.enqueue(2);
		queue.print();
		queue.enqueue(0);
		queue.print();
		queue.enqueue(-1);
		queue.print();

		try{
			int removeItem  ;

			while(true)
			{
				removeItem = queue.dequeue();
				System.out.printf( "\n%d popped\n", removeItem );
				queue.print();
			}
		}catch( EmptyListException exception)
		{
			exception.printStackTrace();
		}
	}

}
