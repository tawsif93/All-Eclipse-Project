package deitel.exercise.chapter22;

public class EmptyListException extends RuntimeException {

	public EmptyListException(String name ) {
		// TODO Auto-generated constructor stub
		System.err.println(name + " is Empty");
		
	}
	
	public EmptyListException() {
		// TODO Auto-generated constructor stub
		this("list");
	}
}
