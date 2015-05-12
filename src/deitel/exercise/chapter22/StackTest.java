package deitel.exercise.chapter22;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackInheritance<Integer> stack = new StackInheritance<Integer>();
		
		stack.push(1);
		stack.print();
		stack.push(2);
		stack.print();
		stack.push(-1);
		stack.print();
		stack.push(0);
		stack.print();
		
		try{
			int removeItem  ;
			
			while(true)
			{
				removeItem = stack.pop();
				System.out.printf( "\n%d popped\n", removeItem );
				stack.print();
			}
		}catch( EmptyListException exception)
		{
			exception.printStackTrace();
		}
	}

}
