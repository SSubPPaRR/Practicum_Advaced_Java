package week3;

import java.util.Arrays;

public class Point implements Comparable<Point>{
    private double x;
    private double y;

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }
    public Point(double x, double y) {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x){
            if (this.y == o.y){
                return 0;
            }else return (int) ((int) this.y - o.y);
        }
        else return (int) (this.x-o.x);
    }

    public static void main(String[] args) {
        Point[] arr = new Point[100];
        for (int i = 0; i < 100; i++){
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            arr[i] = new Point(x,y);
        }

        System.out.println("array sorted by x is:");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("array sorted by y is:");
        Arrays.sort(arr, new CompareY());
        System.out.println(Arrays.toString(arr));
    }
}
