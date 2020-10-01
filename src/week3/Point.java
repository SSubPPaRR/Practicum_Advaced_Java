package week3;

import java.util.Arrays;

public class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
            }else return this.y - o.y;
        }
        else return this.x-o.x;
    }

    public static void main(String[] args) {
        Point[] arr = new Point[100];
        for (int i = 0; i < 100; i++){
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            arr[i] = new Point(x,y);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
