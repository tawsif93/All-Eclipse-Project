/**
 * 
 */
package deitel.exercise.chapter22;

/**
 * @author mohammedtawsif
 * May 12, 2015 8:05:49 PM
 * 
 */
public class Tree <T extends Comparable<T>>{

	private TreeNode<T> root ;

	public Tree() {
		// TODO Auto-generated constructor stub
		root = null ;
	}

	/**
	 * @param node
	 */
	public void insertNode(T node) {

		if(root == null )
			root = new TreeNode<T>(node);
		else 
			root.insert(node);
		
	}
	
	
	public void preorderTraversel()
	{
		preorderHelper(root);
	}

	/**
	 * @param root
	 */
	private void preorderHelper(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if ( node == null )
			return;
		
		System.out.printf( "%s ", node.data );
		preorderHelper( node.leftChild ); 
		preorderHelper( node.rightChild );
	}
	
	public void inorderTraversel()
	{
		inorderHelper(root);
	}

	/**
	 * @param node
	 */
	private void inorderHelper(TreeNode<T> node) {
		// TODO Auto-generated method stub
		
		if ( node == null )
			return;
		
		
		inorderHelper( node.leftChild ); 
		System.out.printf( "%s ", node.data );
		inorderHelper( node.rightChild );
	}
	
	public void postorderTraversel()
	{
		postorderHelper(root);
	}

	/**
	 * @param node
	 */
	private void postorderHelper(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if ( node == null )
			return;
		
		postorderHelper( node.leftChild ); 
		postorderHelper( node.rightChild );
		System.out.printf( "%s ", node.data );
	}
	
}

class TreeNode<T extends Comparable<T>> {

	TreeNode<T> leftChild ;
	T data ;
	TreeNode<T> rightChild ;


	public TreeNode(T nodeData) {
		// TODO Auto-generated constructor stub
		data = nodeData ;
		leftChild = rightChild = null ;
	}

	/**
	 * @param insertValue
	 */
	public void insert(T insertValue) {

		if(insertValue.compareTo(data)< 0 )
		{
			if(leftChild == null )
				leftChild = new TreeNode<T>(insertValue);
			else 
				leftChild.insert(insertValue);
		}

		else if(insertValue.compareTo(data)> 0 )
		{
			if ( rightChild == null )
				rightChild = new TreeNode<T>(insertValue);

			else 
				rightChild.insert(insertValue);
		}
	}
}