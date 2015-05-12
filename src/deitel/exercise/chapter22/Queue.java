/**
 * 
 */
package deitel.exercise.chapter22;

/**
 * @author mohammedtawsif
 * @param <T>
 *
 */
public class Queue<T> {

	private List<T> queueList ;
	
	public Queue() {
		// TODO Auto-generated constructor stub
		queueList = new  List<T>("Queue");
	}
	
	public void	 enqueue( T object) {
		queueList.insertAtTheBack(object);
	}
	
	public T dequeue() throws EmptyListException 
	{
		T removedObject  = queueList.removeFromFront();
		
		return removedObject ;
	}
	
	public void print() {
		queueList.print();
	}
	
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
}
