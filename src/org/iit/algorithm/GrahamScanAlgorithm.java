package org.iit.algorithm ;

import java.awt.Point ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Stack ;

public class GrahamScanAlgorithm {

	public static void main( String[] args ) {
		ArrayList< Point> points = new ArrayList<>() ;
		points.add(new Point(0, 3)) ;
		points.add(new Point(1, 1)) ;
		points.add(new Point(2, 2)) ;
		points.add(new Point(4, 4)) ;
		points.add(new Point(0, 0)) ;
		points.add(new Point(1, 2)) ;
		points.add(new Point(3, 1)) ;
		points.add(new Point(3, 3)) ;

		ConvexHull(points) ;
	}

	private static Point	p0	= null ;

	public static Point nextToTop( Stack< Point> stack ) {

		Point firstPoint = stack.pop() ;
		Point secondPoint = stack.pop() ;
		stack.push(secondPoint) ;
		stack.push(firstPoint) ;

		return secondPoint ;
	}

	public static int Distance( Point p1, Point p2 ) {
		return (int) (Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(
				(p1.getY() - p2.getY()), 2)) ;
	}

	public static int Orientation( Point p, Point q, Point r ) {

		int value = ((q.y - p.y) * (r.x - q.x)) - ((q.x - p.x) * (r.y - q.y)) ;

		if (value == 0)
			return 0 ; // colinear

		return (value > 0) ? 1 : 2 ; // clock or counterclock wise
	}

	public static void ConvexHull( ArrayList< Point> points ) {
		int minumumY = points.get(0).y, min = 0 ;

		for (int i = 1; i < points.size(); i++)
		{
			int y = points.get(i).y ;

			if ((y < minumumY)
					|| ((minumumY == y) && (points.get(i).x < points.get(min).x)))
			{
				minumumY = points.get(i).y ;
				min = i ;
			}
		}

		Collections.swap(points, 0, min) ;

		p0 = points.get(0) ;

		Collections.sort(points, ( Point p1, Point p2 ) -> {

			int orientation = Orientation(p0, p1, p2) ;

			if (orientation == 0)
				return (Distance(p0, p2) >= Distance(p0, p1)) ? -1 : 1 ;

			return (orientation == 2) ? -1 : 1 ;
		}) ;

		Stack< Point> ConvexHull = new Stack<>() ;

		ConvexHull.push(points.get(0)) ;
		ConvexHull.push(points.get(1)) ;
		ConvexHull.push(points.get(min)) ;

		for (int i = 3; i < points.size(); i++)
		{
			while (Orientation(nextToTop(ConvexHull), ConvexHull.peek(),
					points.get(i)) != 2)
				ConvexHull.pop() ;
			ConvexHull.push(points.get(i)) ;
		}

		while (!ConvexHull.empty())
		{
			Point p = ConvexHull.peek() ;
			System.out.println("(" + p.x + ", " + p.y + ")") ;
			ConvexHull.pop() ;
		}
	}
}
