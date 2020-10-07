package week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class vowelCount {
    public static void main(String[] args) {
        String filePath;
        Scanner input =  new Scanner(System.in);
        final HashSet<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        try {
            int constCount = 0;
            int vowCount = 0;

            System.out.println("please enter file path.");
            filePath = input.nextLine();
            File textFile = new File(filePath);
            FileInputStream reader = new FileInputStream(textFile);

            while (reader.available()>0) {
                char data = (char) reader.read();
                String s = Character.toString(data).toLowerCase().replaceAll("\n|\t|\r", "");

                if (vowels.contains(s)) {
                    vowCount++;
                }
                else if(s.equals("")){
                    System.out.print("");
                }

                else constCount++;
            }

            System.out.println("the amount vowels:" + vowCount + "\nthe amount consonants:" + constCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
