/**
 * Suffix tree
 */
package org.iit.algorithm;

import java.util.ArrayList;

/**
 * @author tawsif
 *
 */
public class SuffixTree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.Root = new Node ("");

		String text = "ATCGGATTCGGG" ;

		ArrayList<String> literals = new ArrayList<>();

		final int TEXT_SIZE = text.length() ;

		for( int i = 1 ; i <= TEXT_SIZE ; i++)
		{
			literals.add( text.substring( TEXT_SIZE-i));
		}

		for (String string : literals)
		{
			System.out.println(string);
			Node currentNode = tree.Root ;

			if (Util.EdgeContainAnyLabel(string , currentNode.edges));
			{

			}
		}
	}
}

class Node 
{
	public String index ;
	public String Key ;


	public ArrayList<Node> nodes ;
	public ArrayList<Edge> edges ;

	public Node (String key)
	{
		Key = key ;
		nodes = new ArrayList<Node>() ;
		edges = new ArrayList<Edge>() ;
	}
}

class Edge
{
	public int Index ;
	public  String Label ;
	public Node Source ;
	public Node Terminal ;

	public Edge (int index , String label , Node source , Node terminal )
	{
		Index = index ;
		Label = label ;
		Source = source ;
		Terminal = terminal ;

	}
}

class Tree 
{
	public Node Root ;
}

class Util 
{
	public static boolean EdgeContainAnyLabel(String item , ArrayList<Edge>edges)
	{
		return true ;
	}
}