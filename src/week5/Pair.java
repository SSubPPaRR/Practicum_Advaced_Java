package week5;
import week3.CompareY;
import week3.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Pair implements Comparable<Pair> {
    private Point p1;
    private Point p2;

    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistance() {
        return distance(p1,p2);
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(double[][] points){

        Point[] points2 = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            points2[i] = new Point(points[i][0], points[i][1]);
        }
        return getClosestPair(points2);
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(Point[] points){
        Arrays.sort(points); // pointsOrderedOnX
        Point[] pointsOrderedOnY = points.clone(); //pointsOrderedOnY
        Arrays.sort(pointsOrderedOnY, new CompareY());
        return distance(points, 0, points.length - 1, pointsOrderedOnY);
    }

    /** Return the distance of the closest pair of points
     * in pointsOrderedOnX[low..high]. This is a recursive
     * method. pointsOrderedOnX and pointsOrderedOnY are
     * not changed in the subsequent recursive calls.
     */
    public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY)
    {
        if(low >= high)
        {
            return null;
        } else if (low + 1 == high)
        {
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]); // only 1 pair present
        }

        /*
         * Divide S into two subsets, S1 and S2, of equal size using the midpoint in the sorted list.
         * Let the midpoint be in S1. Recursively find the closest pair in S1 and S2.
         * Let d1: leftPair.getDistance()
         * and d2: rightPair.getDistance()
         * denote the distance of the closest pairs in the two subsets, respectively.
         */
        int midPoint = (low + high) / 2; // divide into 2 subset

        // return the closet pair on the left side( including midpoint) - S1
        Pair leftPair = distance(pointsOrderedOnX, low, midPoint, pointsOrderedOnY);
        // return the closet pair on the right side( not including midpoint) - S2
        Pair rightPair = distance(pointsOrderedOnX, midPoint + 1, high, pointsOrderedOnY);

        double d;
        Pair p;

        if (leftPair == null && rightPair == null)  // no pairs present on both sides
        {
            d = 0;
            p = null;
        } else if (leftPair == null)  // no pairs on the left side, then the right pair is the shortest
        {
            d = rightPair.getDistance(); // get d2
            p = rightPair;
        } else if (rightPair == null) // no pairs on the right side, then the left pair is the shortest
        {
            d = leftPair.getDistance(); //get d1
            p = leftPair;
        } else
        {
            // get the minimum distance of d1 and d2: d = min(d1,d2)
            d = Math.min(leftPair.getDistance(), rightPair.getDistance());
            // get the point that has minimum distance d
            if(leftPair.getDistance() <= rightPair.getDistance())
            {
                p =leftPair;
            }else
            {
                p=rightPair;
            }

        }
		/*
		 * Obtaining stripL and stripR algorithm
		 * for each point p in pointsOrderedOnY
				if (p is in S1 and mid.x – p.x <= d)
					append p to stripL;
				else if (p is in S2 and p.x - mid.x <= d)
					append p to stripR;
		 */

        //create list stripL and stripR to hold the points
        ArrayList<Point> stripL = new ArrayList<>();
        ArrayList<Point> stripR = new ArrayList<>();
        for (Point point : pointsOrderedOnY) {
            if ((point.getX() <= pointsOrderedOnX[midPoint].getX()) &&
                    (pointsOrderedOnX[midPoint].getX() - point.getX() <= d)) {
                stripL.add(point);
            } else if ((point.getX() > pointsOrderedOnX[midPoint].getX()) &&
                    (point.getX() - pointsOrderedOnX[midPoint].getX() <= d)) {
                stripR.add(point);
            }
        }

		/*
		 * finding the closet pair algorithm
		 * d = min(d1, d2);
 		   r = 0; // r is the index of a point in stripR
 		   for (each point p in stripL)
 		   {
				// Skip the points in stripR below p.y - d
				while (r < stripR.length && q[r].y <= p.y - d) r++;
				let r1 = r;
				while (r1 < stripR.length && |q[r1].y – p.y| <= d)
				{
					// Check if (p, q[r1]) is a possible closest pair
					if (distance(p, q[r1]) < d) {
					d = distance(p, q[r1]);
					(p, q[r1]) is now the current closest pair;
      			}
			r1 = r1 + 1 ;
			}
		 */

        int r = 0;
        for (Point point : stripL) {
            while (r < stripR.size() && stripR.get(r).getY() <= point.getY() - d) {
                r++;
            }
            int r1 = r;
            while (r1 < stripR.size() && Math.abs(stripR.get(r1).getY() - point.getY()) <= d) {
                if (distance(point, stripR.get(r1)) < d) {
                    d = distance(point, stripR.get(r1));
                    assert p != null;
                    p.p1 = point;
                    p.p2 = stripR.get(r1);
                }
                r1++;
            }
        }

        return p;
    }

    /** Compute the distance between two points p1 and p2 */
    public static double distance(Point p1, Point p2){

        return Math.sqrt((p2.getX()-p1.getX())+(p2.getY()-p1.getY()));
    }

    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2-x1)+(y2-y1));
    }

    @Override
    public int compareTo(Pair o) {
        return (int) (this.getDistance() - o.getDistance());
    }
}
