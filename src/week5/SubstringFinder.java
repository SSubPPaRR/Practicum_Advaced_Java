package week5;

import java.util.Scanner;

public class SubstringFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1,s2;

        System.out.println("please enter string");
        s1 = input.nextLine().trim().toLowerCase();
        System.out.println("please enter substring");
        s2 = input.nextLine().trim().toLowerCase();

        if(s1.matches(".*"+ s2 +".*")){
            System.out.println("the substring index is: " + substringSearch(s1,s2,getCharIndex(s1,s2,0),-1));
        }
        else System.out.println("Can't display index: no substring found.");
    }
    //returns index of character after given index startIndex
    private static int getCharIndex(String s1,String s2, int startIndex){
        int index = -1;
        char[] list =  s1.toCharArray();
        for (int i = startIndex; i < list.length; i++){
            if (list[i] == s2.charAt(0)){
                index = i;
                break;
            }

        }
        return index;
    }
    //recursive method that
    private static int substringSearch(String s1,String s2,int startIndex, int lastIndex){
        int index = -1;
        int lastStartIndex = startIndex;
        if(s1.regionMatches(startIndex,s2,0,s2.length())){
            index = startIndex;

        }
        else {
            startIndex = getCharIndex(s1,s2,startIndex+1);
            if (lastIndex != startIndex) {
                index = substringSearch(s1, s2, startIndex, lastStartIndex);
            }
        }
        return index;
    }
}
