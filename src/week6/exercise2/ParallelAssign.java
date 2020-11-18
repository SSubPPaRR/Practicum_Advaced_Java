package week6.exercise2;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ParallelAssign {

    public static void parallelAssignValues(double[] list){
        RecursiveAction mainTask = new AssignValue(0,list.length,list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }
    public static void assignValues(double[] list){

        for (int i = 0; i < list.length; i++) {

            list[i] = new Random().nextDouble();

        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        double[] list = new double[9000000];
        double[] list2 = new double[list.length];

        parallelAssignValues(list);
        long endTime = System.currentTimeMillis();

        System.out.println("parallel duration: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();

        assignValues(list2);

        endTime = System.currentTimeMillis();

        System.out.println("sequential duration: " + (endTime-startTime) + "ms");

    }
}
