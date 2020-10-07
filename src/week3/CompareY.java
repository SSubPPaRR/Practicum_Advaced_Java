package week3;

import java.util.Comparator;

public class CompareY extends Point implements Comparator<Point> {
    
    @Override
    public int compare(Point o1, Point o2) {
        if(o1.getY() == o2.getY()){
            if (o1.getX() == o2.getX()){
                return 0;
            }else return (int) (o1.getX() - o2.getX());
        }
        else return (int) (o1.getY()-o2.getY());
    }
}
