package org.iit.algorithm.QuickHull;

import java.awt.Point ;
import java.util.ArrayList ;

public class QuickHullAlgorithm {

	public ArrayList< Point>	ConvexHull ;

	public QuickHullAlgorithm ( ArrayList< Point> points ) {
		// TODO Auto-generated constructor stub

		ConvexHull = new ArrayList<>() ;

		ConvexHull = QuickHull(points) ;

	}

	public int Orientation( Point p, Point q, Point r ) {

		int value = ((q.y - p.y) * (r.x - q.x)) - ((q.x - p.x) * (r.y - q.y)) ;

		if (value == 0)
			return 0 ;

		return (value > 0) ? 1 : -1 ;
	}

	public int distance( Point p, Point q, Point r ) {

		int value = ((q.x - p.x) * (r.y - p.y)) - ((q.y - p.y) * (r.x - p.x)) ;

		return Math.abs(value) ;
	}

	public ArrayList< Point> QuickHull( ArrayList< Point> points ) {

		ArrayList< Point> convexHull = new ArrayList< Point>() ;

		if (points.size() < 3)
			return points ;

		int minimumPoint = 0 ;
		int maximumPoint = 0 ;

		int minX = Integer.MAX_VALUE ;
		int maxX = Integer.MIN_VALUE ;

		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i).x < minX)
			{
				minX = points.get(i).x ;
				minimumPoint = i ;
			}
			if (points.get(i).x > maxX)
			{
				maxX = points.get(i).x ;
				maximumPoint = i ;
			}
		}

		Point A = points.get(minimumPoint) ;
		Point B = points.get(maximumPoint) ;

		convexHull.add(A) ;
		convexHull.add(B) ;

		points.remove(A) ;
		points.remove(B) ;

		ArrayList< Point> leftPartition = new ArrayList< Point>() ;
		ArrayList< Point> rightPartition = new ArrayList< Point>() ;

		for (int i = 0; i < points.size(); i++)
		{
			Point p = points.get(i) ;

			if (Orientation(A, B, p) == -1)
				leftPartition.add(p) ;
			else if (Orientation(A, B, p) == 1)
				rightPartition.add(p) ;
		}

		FindHull(A, B, rightPartition, convexHull) ;
		FindHull(B, A, leftPartition, convexHull) ;

		return convexHull ;
	}

	public void FindHull( Point A, Point B, ArrayList< Point> set,
			ArrayList< Point> convexHull ) {

		int insertionPoint = convexHull.indexOf(B) ;

		if (set.size() == 0)
			return ;

		if (set.size() == 1)
		{
			Point p = set.get(0) ;
			set.remove(p) ;
			convexHull.add(insertionPoint, p) ;
			return ;
		}

		int maximumDistance = Integer.MIN_VALUE ;
		int longestPoint = -1 ;

		for (int i = 0; i < set.size(); i++)
		{
			Point p = set.get(i) ;
			int distance = distance(A, B, p) ;
			if (distance > maximumDistance)
			{
				maximumDistance = distance ;
				longestPoint = i ;
			}
		}

		Point P = set.get(longestPoint) ;
		set.remove(longestPoint) ;
		convexHull.add(insertionPoint, P) ;

		ArrayList< Point> leftSetAP = new ArrayList< Point>() ;

		for (int i = 0; i < set.size(); i++)
		{
			Point M = set.get(i) ;
			if (Orientation(A, P, M) == 1)
				leftSetAP.add(M) ;
		}

		// Determine who's to the left of PB
		ArrayList< Point> leftSetPB = new ArrayList< Point>() ;
		for (int i = 0; i < set.size(); i++)
		{
			Point M = set.get(i) ;

			if (Orientation(P, B, M) == 1)
				leftSetPB.add(M) ;
		}

		FindHull(A, P, leftSetAP, convexHull) ;
		FindHull(P, B, leftSetPB, convexHull) ;

	}

}

/*
 * Tutorial Followed : https://www.youtube.com/watch?v=5D9F1HA6-f4
 */

