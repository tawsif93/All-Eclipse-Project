package org.iit.algorithm.QuickHull ;

import java.awt.Point ;
import java.util.ArrayList ;

public class QuickHullTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		ArrayList< Point> points = new ArrayList< Point>() ;

		points.add(new Point(3, -2)) ;
		points.add(new Point(-3, -1)) ;
		points.add(new Point(3, 0)) ;
		points.add(new Point(0, 3)) ;
		points.add(new Point(-4, -3)) ;
		points.add(new Point(3, 3)) ;
		points.add(new Point(3, -3)) ;
		points.add(new Point(-3, 3)) ;
		points.add(new Point(-2, 2)) ;
		points.add(new Point(-2, -2)) ;

		QuickHullAlgorithm quickHull = new QuickHullAlgorithm(points) ;

		for (Point p : quickHull.ConvexHull)
			System.out.println(p.x + " " + p.y ) ;

	}

}
