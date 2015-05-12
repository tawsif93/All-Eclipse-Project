package deitel.exercise.chapter22;

public class List <T extends Comparable<T>>{

	private ListNode<T> lastNode ;
	private ListNode<T> firstNode ;
	private String name ;

	public List() {
		// TODO Auto-generated constructor stub
		this("list");

	}

	public List(String string) {
		// TODO Auto-generated constructor stub
		name = string ;
		firstNode = lastNode = null ;
	}

	public void insertAtTheFront(T insertItem) {
		if(isEmpty())
			firstNode= lastNode = new ListNode<T>(insertItem);
		else 
			firstNode = new ListNode<T>(insertItem, firstNode);
	}

	public void insertAtTheBack( T insertItem )
	{
		if(isEmpty()) 
			firstNode = lastNode = new ListNode<T>(insertItem);
		else 
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem	);
	}

	public void insertOrder(T element) {
		
		
		if(firstNode == null )
		{
			firstNode= lastNode = new ListNode<T>(element);
			return ;
		}
		
		else if(element.compareTo(firstNode.data)< 0)
		{
			insertAtTheFront(element);
			return ;
		}
		else if (element.compareTo(lastNode.data) >= 0 )
		{
			insertAtTheBack(element);
			return;
		}
		
		ListNode<T> current = firstNode; 
		
		while(current != lastNode )
		{
			if(element.compareTo(current.getNextNode().data) <= 0 )
			{
				current.nextNode = new ListNode<T>(element, current.getNextNode());
				return ;
			}
			else 
				current = current.getNextNode();
		}
	}
	
	public void mergeSortList(List<T> secondList )
	{
		try
		{
			while(true)
			{
				this.insertOrder(secondList.removeFromFront());
			}
		}catch (EmptyListException exception)
		{
			return  ;
		}
	}
	
	public T removeFromFront() throws EmptyListException
	{
		if(isEmpty())
			throw new EmptyListException(name );

		T removeData = firstNode.data ;

		if(lastNode == firstNode)
			lastNode = firstNode = null ;

		else 
			firstNode = firstNode.nextNode ;

		return removeData ;
	}

	public T removeFromBack() throws EmptyListException
	{
		T removeData = lastNode.data ;

		if(isEmpty()) {
			throw new EmptyListException();
		}

		if(firstNode == lastNode) 
			firstNode = lastNode = null ;
		else 
		{
			ListNode<T> currentNode = firstNode ;

			while(currentNode.nextNode != lastNode)
				currentNode = currentNode.nextNode ;

			lastNode = currentNode ;
			lastNode.nextNode = null ;
		}

		return removeData ;
	}

	public void print()
	{
		if(isEmpty())
		{
			System.out.println("Empty " + name );
			return ;
		}

		System.out.printf( "The %s is: ", name );

		ListNode<T> current = firstNode ;

		while(current != null)
		{
			System.out.print(current.data + " " );
			current = current.nextNode ;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(firstNode == null) return true  ;

		return false;
	}
}

class ListNode <T extends Comparable<T>>{

	T data ;

	ListNode<T> nextNode ;

	public ListNode(T data, ListNode<T> node) {
		this.data = data;
		this.nextNode = node;
	}


	public ListNode(T data )
	{
		this(data , null);
	}


	public ListNode<T> getNextNode() {
		return nextNode;
	}

}