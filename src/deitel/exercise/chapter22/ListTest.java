package deitel.exercise.chapter22;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List< Integer> 	list = new List<Integer>() ;

		list.insertAtTheFront(-1);
		list.print();
		list.insertAtTheBack(0);
		list.print();
		list.insertAtTheFront(-2);
		list.print();
		list.insertAtTheBack(1);
		list.print();

		try
		{
			int removedItem = list.removeFromFront();
			System.out.printf( "\n%d removed\n", removedItem );
			list.print();
			
			removedItem = list.removeFromFront();
			System.out.printf( "\n%d removed\n", removedItem );
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf( "\n%d removed\n", removedItem );
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf( "\n%d removed\n", removedItem );
			list.print();
		} // end try
		catch ( EmptyListException emptyListException )
		{
			emptyListException.printStackTrace();
		}
	}

}
