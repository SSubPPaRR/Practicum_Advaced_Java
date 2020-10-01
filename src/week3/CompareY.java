package week3;

import java.util.Arrays;

public class CompareY extends Point implements Comparable<Point> {

    private int x;
    private int y;

    public CompareY(int x, int y) {
        super(x, y);
    }


    @Override
    public int compareTo(Point o) {
        if(this.y == o.getY()){
            if (this.x == o.getX()){
                return 0;
            }else return this.x - o.getX();
        }
        else return this.y-o.getY();
    }

    @Override
    public String toString() {
        return "Point{" +
                "y=" + super.getY() +
                ", x=" + super.getX() +
                '}';
    }

    public static void main(String[] args) {
        CompareY[] arr = new CompareY[100];
        for (int i = 0; i < 100; i++){
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            arr[i] = new CompareY(x,y);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
