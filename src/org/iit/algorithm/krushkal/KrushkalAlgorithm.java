package org.iit.algorithm.krushkal ;

import java.util.Arrays ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.Vector ;

public class KrushkalAlgorithm {

	public static void main( String[] args ) {
		Character[] t = { 'a', 'b', 'c', 'd', 'e', 'f' } ;

		KrushkalGraph graph = new KrushkalGraph() ;

		graph.vertices.addAll(Arrays.asList(t)) ;

		graph.edges.addElement(new KrushkalEdge('a', 'b', 4)) ;
		graph.edges.addElement(new KrushkalEdge('a', 'f', 2)) ;
		graph.edges.addElement(new KrushkalEdge('f', 'b', 5)) ;
		graph.edges.addElement(new KrushkalEdge('c', 'b', 6)) ;
		graph.edges.addElement(new KrushkalEdge('c', 'f', 1)) ;
		graph.edges.addElement(new KrushkalEdge('f', 'e', 4)) ;
		graph.edges.addElement(new KrushkalEdge('d', 'e', 2)) ;
		graph.edges.addElement(new KrushkalEdge('d', 'c', 3)) ;

		krushkal(graph) ;
	}

	public static void krushkal( KrushkalGraph graph ) {
		DisjointSet set = new DisjointSet() ;
		Vector< KrushkalEdge> edges = new Vector<>() ;

		for (Character vertices : graph.vertices)
			set.MakeSet(vertices) ;

		Collections.sort(graph.edges, new Comparator< KrushkalEdge>() {

			@Override
			public int compare( KrushkalEdge o1, KrushkalEdge o2 ) {

				if (o1.weight > o2.weight)
					return 1 ;
				else if (o1.weight < o2.weight)
					return -1 ;
				else
					return 0 ;
			}
		}) ;

		for (KrushkalEdge edge : graph.edges)
		{
			char root1 = set.Find(edge.vertex1) ;
			char root2 = set.Find(edge.vertex2) ;

			if (root1 != root2)
			{
				edges.add(edge) ;
				set.Union(root1, root2) ;
			}
		}

		for (KrushkalEdge krushkalEdge : edges)
			System.out.println(krushkalEdge.vertex1 + " --- "
					+ krushkalEdge.vertex2 + "   " + krushkalEdge.weight) ;
	}
}

class KrushkalGraph {
	Vector< Character>		vertices	= new Vector<>() ;
	Vector< KrushkalEdge>	edges		= new Vector<>() ;
}

class KrushkalEdge {
	char	vertex1 ;
	char	vertex2 ;
	int		weight ;

	public KrushkalEdge ( char v1 , char v2 , int w ) {
		// TODO Auto-generated constructor stub
		vertex1 = v1 ;
		vertex2 = v2 ;
		weight = w ;
	}
}
