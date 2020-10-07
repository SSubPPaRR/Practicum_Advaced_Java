package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DupliText {
    public static void main(String[] args) {
        String filePath;
        Scanner input =  new Scanner(System.in);

        try {
            HashSet<String> wordList = new HashSet<>();
            System.out.println("please enter file path.");
            filePath = input.nextLine();
            File textFile = new File(filePath);
            Scanner reader = new Scanner(textFile);

            while (reader.hasNextLine()){
                String data = reader.nextLine();
                wordList.add(data);
            }

            Object[] arr = wordList.toArray();
            Arrays.sort(arr);

            for (Object i : arr) {
                System.out.println(i);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input.close();


    }
}
