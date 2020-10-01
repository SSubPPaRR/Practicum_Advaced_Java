package week4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class JavaToHTML {
    public static void main(String[] args) {
        String javaFilePath;
        Scanner input =  new Scanner(System.in);

        try {
            // get java file
            System.out.println("please enter path to a .java file");
            javaFilePath = input.nextLine();//"C:\\Users\\clayt\\OneDrive\\Documents\\practjavaweek clayton\\src\\week4\\Welcome.java" ;//
            File textFile = new File(javaFilePath);

            // get html file name
            System.out.println("please enter html file name.");
            String htmlFileName = input.nextLine() + ".html";

            //creating html file
            File htmlFile = new File(htmlFileName);
            if(htmlFile.createNewFile()){
                System.out.println("File created: " + htmlFile.getName());

                //creating writer and reader
                FileWriter writer = new FileWriter(htmlFile);
                Scanner reader = new Scanner(textFile);
                writer.write("<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\"><title></title></head><body>");
                //reading file and making changes for html
                while (reader.hasNextLine()){
                    String data = reader.nextLine();
                    writer.write(syntaxFormatter(data));

                }
                writer.write("</body></html>");
                //close writer and reader
                writer.close();
                reader.close();

            }
            else System.out.println("File already exists.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        input.close();

    }

    private static String syntaxFormatter(String origin){

        if(origin.equals("")){
            return  "<span>&nbsp</span>";
        }else {
            //check if a comment
            if (origin.trim().startsWith("//")) {
                String commentSpace = origin.substring(0, origin.indexOf("/")).replaceAll("\\s", "<span>&nbsp</span>");
                return commentSpace + "<span style=\"color: green\">" + origin.trim() + "</span>" + "<br>\n";
            } else {
                boolean retType = false;

                String[] splitLine = origin.split("[ ]+(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                StringBuilder fullString = new StringBuilder();

                //check for keywords
                for (int i = 0; i < splitLine.length; i++) {
                    if (keywords.contains(splitLine[i])) {
                        splitLine[i] = "<b style=\"color: navy\">" + splitLine[i] + " " + "</b>";
                        retType = true;
                    }

                    //empty space
                    else if (splitLine[i].equals("")) {
                        splitLine[i] = "<span>&nbsp</span>";
                    }

                    //check for literals
                    else if (splitLine[i].matches("(.*((=*|\\s)\\d+\\s*;))|(.*(\"(.*?)\").*)|(.*('(.*?)').*)")) {
                        retType = true;
                        // stuck to "=" e.g a =5
                        if (splitLine[i].startsWith("=")) {
                            splitLine[i] = splitLine[i].replace("=", "");
                            splitLine[i] = "=<span style=\"color: blue\">" + splitLine[i] + "</span>";
                        } else {
                            //if digit is loose from "=" or is a String literal;
                            splitLine[i] = splitLine[i].replaceAll("\\s*\\d+|('(.*?)')|(\"(.*?)\")", "<span style=\"color: blue\">$0</span>");
                        }
                    }

                    fullString.append(splitLine[i]);
                }

                return (retType) ? fullString.toString() + "<br>" : origin + "<br>\n";

            }
        }
    }

    // Array of all Java keywords + true, false and null
    private  static HashSet<String> keywords = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case",
            "catch", "char", "class", "const", "continue", "default",
            "do", "double", "else", "enum", "extends", "for", "final",
            "finally", "float", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"));

}
