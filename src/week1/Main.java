package week1;

import java.util.Arrays;

public class Main {
    public static <E> void SwapArray(E[]arr){
        E medium = arr[0];

        arr[0]= arr[2];

        arr[2] = medium;
    }

    public static void main(String[] args) {
        String[] stringArr = {"pog","champ","poggers"};
        Integer[] numbers = {1,2,3,4};
        SwapArray(stringArr);
        SwapArray(numbers);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(Arrays.toString(numbers));
        }
}
