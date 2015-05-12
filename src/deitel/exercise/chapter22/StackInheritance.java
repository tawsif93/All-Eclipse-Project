package deitel.exercise.chapter22;

public class StackInheritance<T> extends List<T>{

	
	public StackInheritance() {
		super("Stack");
		// TODO Auto-generated constructor stub
	}
	
	
	public void push(T pushObject) {
		insertAtTheFront(pushObject);
	}
	
	public T pop() throws EmptyListException
	{
		return removeFromFront() ;
	}
	
}
