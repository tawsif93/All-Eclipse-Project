package org.iit.algorithm.prims ;

import java.util.Arrays ;
import java.util.HashMap ;
import java.util.Map ;
import java.util.PriorityQueue ;
import java.util.Queue ;
import java.util.Vector ;

import javafx.util.Pair ;

public class PrimAlgorithm {

	public static void main( String[] args ) {
		Character[] t = { 'a', 'b', 'c', 'd', 'e', 'f' } ;

		PrimGraph graph = new PrimGraph() ;

		graph.vertics.addAll(Arrays.asList(t)) ;

		graph.edges.addElement(new PrimEdge('a', 'b', 4)) ;
		graph.edges.addElement(new PrimEdge('a', 'f', 2)) ;
		graph.edges.addElement(new PrimEdge('f', 'b', 3)) ;
		graph.edges.addElement(new PrimEdge('c', 'b', 6)) ;
		graph.edges.addElement(new PrimEdge('c', 'f', 1)) ;
		graph.edges.addElement(new PrimEdge('f', 'e', 4)) ;
		graph.edges.addElement(new PrimEdge('d', 'e', 2)) ;
		graph.edges.addElement(new PrimEdge('d', 'c', 3)) ;

		prim(graph) ;
	}

	public static void prim( PrimGraph graph ) {

		Map< Character , Character> mst = new HashMap<>() ;
		Map< Character , Character> PARENT = new HashMap<>() ;
		Map< Character , Integer> KEY = new HashMap<>() ;

		for (Character character : graph.vertics)
		{
			PARENT.put(character, null) ;
			KEY.put(character, Integer.MAX_VALUE) ;
		}

		Queue< Character> queue = new PriorityQueue<>(( Character o1,
				Character o2 ) -> {
					if (KEY.get(o1) > KEY.get(o2))
						return 1 ;
					else if (KEY.get(o1) < KEY.get(o2))
						return -1 ;
					else
						return 0 ;
				}) ;

		queue.addAll(graph.vertics) ;

		KEY.put('a', 0) ;

		while (!queue.isEmpty())
		{
			char u = queue.poll() ;
			if (PARENT.get(u) != null)
				mst.put(u, PARENT.get(u)) ;

			Vector< Pair< Character , PrimEdge>> adjacentEdge = graph
					.adjacent(u) ;

			for (Pair< Character , PrimEdge> adjacentVertex : adjacentEdge)
				if (queue.contains(adjacentVertex.getKey()))
					if (adjacentVertex.getValue().weight < KEY
							.get(adjacentVertex.getKey()))
					{
						PARENT.put(adjacentVertex.getKey(), u) ;
						KEY.put(adjacentVertex.getKey(),
								adjacentVertex.getValue().weight) ;
						queue.add(queue.poll()) ;
					}
		}

		for (Character character : mst.keySet())
			System.out.println(character + "---" + mst.get(character)) ;
	}
}

class PrimEdge {
	char	Vertex1 ;
	char	Vertex2 ;
	int		weight ;

	public PrimEdge ( char vertex1 , char vertex2 , int weight ) {
		Vertex1 = vertex1 ;
		Vertex2 = vertex2 ;
		this.weight = weight ;
	}
}

class PrimGraph {

	Vector< Character>	vertics	= new Vector<>() ;
	Vector< PrimEdge>	edges	= new Vector<>() ;

	public Vector< Pair< Character , PrimEdge>> adjacent( Character u ) {
		Vector< Pair< Character , PrimEdge>> res = new Vector<>() ;

		for (PrimEdge edge : edges)
			if (u.equals(edge.Vertex1))
				res.add(new Pair< Character , PrimEdge>(edge.Vertex2, edge)) ;

			else if (u.equals(edge.Vertex2))
				res.add(new Pair< Character , PrimEdge>(edge.Vertex1, edge)) ;

		return res ;
	}

}
