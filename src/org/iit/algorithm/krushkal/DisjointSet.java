package org.iit.algorithm.krushkal ;

import java.util.HashMap ;
import java.util.Map ;

public class DisjointSet {

	Map< Character , Character>	PARENT	= new HashMap< Character , Character>() ;
	Map< Character , Integer>	RANK	= new HashMap< Character , Integer>() ;

	public char Find( char vertex ) {
		if (PARENT.get(vertex) == vertex)
			return PARENT.get(vertex) ;
		else
			return Find(PARENT.get(vertex)) ;
	}

	public void Union( char v1, char v2 ) {
		if (RANK.get(v1) > PARENT.get(v2))
			PARENT.put(v2, v1) ;
		else if (RANK.get(v1) < PARENT.get(v2))
			PARENT.put(v1, v2) ;
		else
		{
			PARENT.put(v1, v2) ;
			RANK.put(v2, (RANK.get(v2) + 1)) ;
		}
	}

	public void MakeSet( char vertex ) {
		PARENT.put(vertex, vertex) ;
		RANK.put(vertex, 0) ;
	}

}
