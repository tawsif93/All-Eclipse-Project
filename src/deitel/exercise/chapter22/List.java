package deitel.exercise.chapter22 ;

public class List<T extends Comparable< T>> {

	private ListNode< T>	lastNode ;
	private ListNode< T>	firstNode ;
	private String			name ;

	public List ( ) {
		// TODO Auto-generated constructor stub
		this("list") ;

	}

	public List ( String string ) {
		// TODO Auto-generated constructor stub
		name = string ;
		firstNode = lastNode = null ;
	}

	public void insertAtTheFront( T insertItem ) {
		if (isEmpty())
			firstNode = lastNode = new ListNode< T>(insertItem) ;
		else
			firstNode = new ListNode< T>(insertItem, firstNode) ;
	}

	public void insertAtTheBack( T insertItem ) {
		if (isEmpty())
			firstNode = lastNode = new ListNode< T>(insertItem) ;
		else
			lastNode = lastNode.nextNode = new ListNode< T>(insertItem) ;
	}

	/*
	 * This Insert at the Back without tail reference added for exercise 22.27
	 */
	public void insertAtTheBackWithoutTail( T insertItem ) {

		ListNode< T> currentNode = firstNode ;

		if (firstNode == null)
		{
			firstNode = new ListNode< T>(insertItem) ;
			return ;
		}

		while (currentNode.nextNode != null)
			currentNode = currentNode.nextNode ;

		currentNode.nextNode = new ListNode< T>(insertItem) ;
	}

	public void insertOrder( T element ) {

		if (firstNode == null)
		{
			firstNode = lastNode = new ListNode< T>(element) ;
			return ;
		}

		else if (element.compareTo(firstNode.data) < 0)
		{
			insertAtTheFront(element) ;
			return ;
		}
		else if (element.compareTo(lastNode.data) >= 0)
		{
			insertAtTheBack(element) ;
			return ;
		}

		ListNode< T> current = firstNode ;

		while (current != lastNode)
			if (element.compareTo(current.getNextNode().data) <= 0)
			{
				current.nextNode = new ListNode< T>(element,
						current.getNextNode()) ;
				return ;
			}
			else
				current = current.getNextNode() ;
	}

	/*
	 * This method Insert at any position added for exercise 22.26
	 */
	public void insertAtAnyPosition( T value, T afterValue ) {
		ListNode< T> currentNode = firstNode ;
		boolean insertAtTheBack = true ;

		while (true)
			if (firstNode.data.compareTo(afterValue) > 0)
			{
				insertAtTheBack = false ;
				insertAtTheFront(value) ;
				break ;
			}
			else if (currentNode.nextNode == null)
				break ;
			else if ((currentNode.data.compareTo(afterValue) <= 0)
					&& (currentNode.nextNode.data.compareTo(afterValue) > 0))
			{
				currentNode.nextNode = new ListNode< T>(value,
						currentNode.nextNode) ;
				insertAtTheBack = false ;
				break ;
			}

			else
				currentNode = currentNode.nextNode ;
		if (insertAtTheBack == true)
			insertAtTheBack(value) ;
	}

	/*
	 * This method Delete at any position added for exercise 22.26
	 */

	public void deleteAtAnyPosition( T value ) {
		ListNode< T> currentNode = firstNode ;
		ListNode< T> old = firstNode ;

		if (currentNode == null)
			System.out.println("List is Empty") ;

		while (true)
		{
			if (currentNode.data.equals(value))
			{
				if (firstNode.equals(currentNode))
				{
					firstNode = currentNode.nextNode ;
					currentNode.nextNode = null ;
					currentNode = firstNode ;
				}
				else
				{
					old.nextNode = currentNode.nextNode ;
					currentNode.nextNode = null ;
					currentNode = old ;
				}
				break ;
			}
			if (currentNode.nextNode == null)
			{
				System.out.println("No Roll Found") ;
				break ;
			}
			else
			{
				old = currentNode ;
				currentNode = currentNode.nextNode ;
			}
		}
	}

	public void mergeSortList( List< T> secondList ) {
		try
		{
			while (true)
				this.insertOrder(secondList.removeFromFront()) ;
		} catch ( EmptyListException exception )
		{
			return ;
		}
	}

	public T removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name) ;

		T removeData = firstNode.data ;

		if (lastNode == firstNode)
			lastNode = firstNode = null ;

		else
			firstNode = firstNode.nextNode ;

		return removeData ;
	}

	public T removeFromBack() throws EmptyListException {
		T removeData = lastNode.data ;

		if (isEmpty())
			throw new EmptyListException() ;

		if (firstNode == lastNode)
			firstNode = lastNode = null ;
		else
		{
			ListNode< T> currentNode = firstNode ;

			while (currentNode.nextNode != lastNode)
				currentNode = currentNode.nextNode ;

			lastNode = currentNode ;
			lastNode.nextNode = null ;
		}

		return removeData ;
	}

	/*
	 * added for Exercise 22.20
	 */
	public void printListBackward() {
		reverse(firstNode) ;
	}

	private void reverse( ListNode< T> node ) {
		if (node != null)
		{
			reverse(node.nextNode) ;
			System.out.print(node.data + " ") ;
		}
	}

	public void print() {
		if (isEmpty())
		{
			System.out.println("Empty " + name) ;
			return ;
		}

		System.out.printf("The %s is: ", name) ;

		ListNode< T> current = firstNode ;

		while (current != null)
		{
			System.out.print(current.data + " ") ;
			current = current.nextNode ;
		}
		System.out.println() ;
	}

	/*
	 * Search List added for Exercise 22.21
	 */
	public T searchList( T value ) {
		ListNode< T> currentNode = firstNode ;

		while (currentNode != null)
			if (currentNode.data.equals(value))
				return currentNode.data ;
			else
				currentNode = currentNode.nextNode ;

		return null ;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (firstNode == null)
			return true ;

		return false ;
	}
}

class ListNode<T extends Comparable< T>> {

	T				data ;

	ListNode< T>	nextNode ;

	public ListNode ( T data , ListNode< T> node ) {
		this.data = data ;
		this.nextNode = node ;
	}

	public ListNode ( T data ) {
		this(data, null) ;
	}

	public ListNode< T> getNextNode() {
		return nextNode ;
	}

}
