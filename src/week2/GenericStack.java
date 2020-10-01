package week2;

import java.util.Arrays;

public class GenericStack<E> {
    private Object[] arr = new  Object[2];

    private int addPos = 0;

    public int getSize() {
        return arr.length;
    }
    public void add(E o){
        //check available space (null values)
        int count = 0;
        for (int l = arr.length - 1; l >= 0; l--) {
            if (arr[l] == null) {
                count++;
            }
        }

        //determine addPos by setting it to last null value in array
        if (count > 0) {
            for (int k = arr.length - 1; k >= 0; k--) {
                if (arr[k] == null) {
                    addPos = k;
                }
            }
        }else addPos = arr.length;


        add(addPos,o);

    }
    public void add(int a, E o) {
        //check available space (null values)
        int count = 0;
        for (int l = arr.length - 1; l >= 0; l--) {
            if (arr[l] == null) {
                count++;
            }
        }

        //determine addPos by setting it to last null value in array
        if (count > 0) {
            for (int k = arr.length - 1; k >= 0; k--) {
                if (arr[k] == null) {
                    addPos = k;

                }
            }
        }
        else addPos = arr.length;

        //double array size if not enough space
        if(count < 1){
            //double size of array
            arr = Arrays.copyOf(arr,arr.length*2);
        }

        //add value to array and move existing values
        Object[] copy;
        copy = Arrays.copyOfRange(arr,a,arr.length);
        arr[a]= o;
        int j = 0;
        for(int i = a+1; i < arr.length; i++){
              arr[i] = copy[j];
              j++;
           }


    }
    public void remove(int a){

        Object[] copy;
        copy = Arrays.copyOfRange(arr,a+1,arr.length);
        int j = a;
        for (Object elem:copy ) {
            arr[j]= elem;
            j++;
        }
    }
    public E peek() {

        return (E) arr[getSize() - 1];
    }
    public void push(E o) {
        add(0,o);
    }
    public E pop() {
        E o = (E) arr[getSize() - 1];
        remove(getSize() - 1);
        return o;
    }
    public void print(){
        System.out.println(toString());
    }
    public boolean isEmpty() {
        int count = 0;
        for (Object elem:arr) {
            if (elem == null){
                count++;
            }
        }
        return count == arr.length;
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(arr);
    }


    //testing out the stack
    public static void main(String[] args) {

        GenericStack<String> testStack = new GenericStack<>();
        System.out.println("is array empty: " + testStack.isEmpty());
        testStack.add("yo");
        testStack.add("sup");
        testStack.add(1,"cool");
        testStack.add("you?");
        testStack.add("what now?");
        testStack.print();
        testStack.remove(2);
        testStack.print();
        System.out.println("is array empty: " + testStack.isEmpty());
        System.out.println("Peek: " + testStack.peek());
        System.out.println("Pop: " + testStack.pop());
        System.out.print("push: ");
        testStack.push("pushed");
        testStack.print();






    }
}

