package week5;

import week3.Point;

public class Pair implements Comparable<Pair> {
    private Point p1;
    private Point p2;

    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistance() {
        return Math.sqrt((p2.getX()-p1.getX())+(p2.getY()-p1.getY()));
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(double[][] points){
        return null;
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(Point[] points){
        return null;
    }

    /** Return the distance of the closest pair of points
     * in pointsOrderedOnX[low..high]. This is a recursive
     * method. pointsOrderedOnX and pointsOrderedOnY are
     * not changed in the subsequent recursive calls.
     */
    public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY){
        return null;
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
