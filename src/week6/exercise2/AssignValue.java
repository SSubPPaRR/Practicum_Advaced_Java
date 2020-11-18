package week6.exercise2;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class AssignValue extends RecursiveAction {
    double[] list;
    int start;
    int end;

    public AssignValue( int start,int end, double[] list) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        int THRESHOLD = 1000000;
        if ((end- start) < THRESHOLD) {
            for (int i = start; i < end; i++){
                list[i] = new Random().nextDouble();
            }
        }
        else {
            int middle = (start+end)/2;
            invokeAll( new AssignValue(start,middle, list));
        }
    }
}
