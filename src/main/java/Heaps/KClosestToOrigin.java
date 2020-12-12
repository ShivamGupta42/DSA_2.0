package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestToOrigin {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distFromOrigin() {
			// ignoring sqrt
			return (x * x) + (y * y);
		}
	}

	public static List<Point> findClosestPoints(Point[] points, int k) {
		PriorityQueue<Point> p = new PriorityQueue<Point>((a, b) -> b.distFromOrigin() - a.distFromOrigin());

		for (int i = 0; i < k; i++) {
			p.add(points[i]);
		}
		
		for(int i=k;i<points.length;i++) {
			if(points[i].distFromOrigin()<p.peek().distFromOrigin()) {
				p.poll();
				p.add(points[i]);
			}
		}
		
		return new ArrayList<>(p);
	}

}
