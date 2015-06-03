/**
 * 
 */
package deitel.exercise.chapter22 ;

import java.util.LinkedList ;
import java.util.Queue ;

/**
 * @author mohammedtawsif May 12, 2015 8:05:49 PM
 * 
 */
public class Tree<T extends Comparable< T>> {

	private TreeNode< T>	root ;

	private int				currentDepth ;
	private int				depth ;

	public Tree ( ) {
		// TODO Auto-generated constructor stub
		root = null ;
		currentDepth = 0 ;
		depth = 0 ;
	}

	/**
	 * @param node
	 */
	public void insertNode( T node ) {

		if (root == null)
			root = new TreeNode< T>(node) ;
		else
			root.insert(node) ;
	}

	public void preorderTraversel() {
		preorderHelper(root) ;
	}

	/**
	 * @param root
	 */

	public int getDepth() {
		return depth(root) ;
	}

	private int depth( TreeNode< T> n ) {
		if (n != null)
		{
			currentDepth++ ;

			// record total depth if current depth is greater than total depth
			if (currentDepth > depth)
				depth = currentDepth ;

			// recursively traverse entire tree
			depth(n.leftChild) ;
			depth(n.rightChild) ;

			// decrement as we traverse up the binary tree
			currentDepth-- ;
		}
		return depth ;
	}

	public void inorderTraversel() {
		inorderHelper(root) ;
	}

	/**
	 * @param node
	 */
	private void inorderHelper( TreeNode< T> node ) {
		// TODO Auto-generated method stub

		if (node == null)
			return ;

		inorderHelper(node.leftChild) ;
		System.out.printf("%s ", node.data) ;
		inorderHelper(node.rightChild) ;
	}

	public void postorderTraversel() {
		postorderHelper(root) ;
	}

	private void preorderHelper( TreeNode< T> node ) {
		// TODO Auto-generated method stub
		if (node == null)
			return ;

		System.out.printf("%s ", node.data) ;
		preorderHelper(node.leftChild) ;
		preorderHelper(node.rightChild) ;
	}

	/**
	 * @param node
	 */
	private void postorderHelper( TreeNode< T> node ) {
		// TODO Auto-generated method stub
		if (node == null)
			return ;

		postorderHelper(node.leftChild) ;
		postorderHelper(node.rightChild) ;
		System.out.printf("%s ", node.data) ;
	}

	/*
	 * This Method added for exercise 22.24
	 */
	public void levelOrderTraversal() {
		Queue< TreeNode< T>> queue = new LinkedList<>() ;

		queue.add(root) ;

		while (!queue.isEmpty())
		{
			TreeNode< T> currentNode = queue.poll() ;
			System.out.print(currentNode.data + " ") ;
			if (currentNode.leftChild != null)
				queue.add(currentNode.leftChild) ;
			if (currentNode.rightChild != null)
				queue.add(currentNode.rightChild) ;

		}
	}

	/*
	 * OutputTree Method added for exercise 22.25
	 */

	public void outputTree() {
		outputTreeHelper(0, root) ;
	}

	private void outputTreeHelper( int totalSpace, TreeNode< T> current ) {
		// TODO Auto-generated method stub
		while (current != null)
		{
			outputTreeHelper(totalSpace + 5, current.rightChild) ;

			for (int i = 0; i < totalSpace; i++)
				System.out.print(" ") ;

			System.out.println(current.data) ;

			current = current.leftChild ;

			totalSpace += 5 ;
		}
	}

	/*
	 * Method FindKey & Method search added for Exercise 22.23
	 */

	private TreeNode< T> findKey( T key ) {
		if (root == null)
			System.out.println("Tree Empty") ;

		TreeNode< T> currentNode = root ;

		while (currentNode != null)
			if (currentNode.data.equals(key))
				return currentNode ;
			else if (currentNode.data.compareTo(key) > 0)
				currentNode = currentNode.leftChild ;
			else if (currentNode.data.compareTo(key) < 0)
				currentNode = currentNode.rightChild ;
		return currentNode ;
	}

	public T searchList( T value ) {
		if (findKey(value) != null)
			return value ;
		else
			return null ;
	}
}

class TreeNode<T extends Comparable< T>> {

	TreeNode< T>	leftChild ;
	T				data ;
	TreeNode< T>	rightChild ;

	public TreeNode ( T nodeData ) {
		// TODO Auto-generated constructor stub
		data = nodeData ;
		leftChild = rightChild = null ;
	}

	/**
	 * @param insertValue
	 */
	public void insert( T insertValue ) {

		if (insertValue.compareTo(data) < 0)
		{
			if (leftChild == null)
				leftChild = new TreeNode< T>(insertValue) ;
			else
				leftChild.insert(insertValue) ;
		}

		else if (insertValue.compareTo(data) > 0)
			if (rightChild == null)
				rightChild = new TreeNode< T>(insertValue) ;

			else
				rightChild.insert(insertValue) ;
	}
}
