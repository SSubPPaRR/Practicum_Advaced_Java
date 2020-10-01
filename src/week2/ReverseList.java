package week2;

import java.util.ArrayList;

public class ReverseList extends ArrayList<Object> {
    @Override
    public boolean add(Object o) {
         super.add(0,o);
        return true;
    }

    public static void main(String[] args) {
        ReverseList myList = new ReverseList();
        myList.add("cool");
        myList.add("chill");
        myList.add("cold");
        System.out.println(myList.toString());
    }
}
