/**
 * 
 */
package deitel.exercise.chapter22;

/**
 * @author mohammedtawsif
 *
 */
public class StackComposite<T> {

	private List<T> StackList ;
	
	public StackComposite() {
		// TODO Auto-generated constructor stub
		StackList = new List<T>("Stack");
	}
	
	public void push(T objectPush) {
		StackList.insertAtTheFront(objectPush);
	}
	
	public T pop() throws EmptyListException {
		T removedObject = StackList.removeFromFront();
		
		return removedObject ;
	}
	
	public boolean isEmpty() {
		return StackList.isEmpty();
	}
	
	public void print() {
		StackList.print();
	}
}
