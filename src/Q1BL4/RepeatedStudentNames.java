package Q1BL4;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RepeatedStudentNames {
    public static void main(String[] args) throws IOException {
        header();


        TreeMap<String, Integer> nameList = new TreeMap<>();

        File listFile = new File("SE2205Students.txt");
        if (!listFile.exists()) {
            System.out.println("The File " + listFile.getName() + " Does NOT Exists.\nPlease Make Sure You Entered In The Correct File Name & Extension\nAnd Make Sure The File Is In The Correct Directory");
            footer();
            System.exit(0);
        }


        Scanner readFile = new Scanner(listFile);
        String[] currentLine;
        String currentName;
        while (readFile.hasNext()) {
            currentLine = readFile.nextLine().split("[ \\t]");
            currentName = currentLine[0];

            if (!nameList.containsKey(currentName))
                nameList.put(currentName, 1);

            else
                nameList.put(currentName, nameList.get(currentName) + 1);
        }
        readFile.close();


        System.out.println("""
                List Of The Number Of Students With The Same Last Names:
                Last Name\tNumbers
                -----------------------------""");

        Set<Map.Entry<String, Integer>> dupeLastNames = nameList.entrySet();
        for (Map.Entry<String, Integer> dupeLastName : dupeLastNames)
            if (dupeLastName.getValue() > 1)
                System.out.printf("%9s%4d%n", dupeLastName.getKey(), dupeLastName.getValue());


        nameList.clear();

        readFile = new Scanner(listFile);

        while (readFile.hasNext()) {
            currentLine = readFile.nextLine().split("[ \\t]");
            currentName = currentLine[currentLine.length - 1];

            if (!nameList.containsKey(currentName))
                nameList.put(currentName, 1);

            else
                nameList.put(currentName, nameList.get(currentName) + 1);
        }
        readFile.close();


        System.out.println("""
                                
                List Of The Number Of Students With The Same First Names:
                First Name\t Numbers
                -----------------------------""");

        dupeLastNames = nameList.entrySet();
        for (Map.Entry<String, Integer> dupeLastName : dupeLastNames)
            if (dupeLastName.getValue() > 1)
                System.out.printf("%10s%4d%n", dupeLastName.getKey(), dupeLastName.getValue());

        nameList.clear();


        footer();
    }


    public static void header() {
        System.out.println();
        //general lab header
        int n = 81;
        for (int i = 0; i < n; i++) System.out.print("*");
        System.out.println("""

                \t\t\t\tHello User, My Name Is Ahmad Sami Abu Shawarib
                \t\t\t\t\t\tStudent Number: 251149713
                \t\t\t\t\t\t Welcome To Bonus Lab #4""");
        for (int i = 0; i < n; i++) System.out.print("*");

        //specific lab header
        System.out.println("""

                Using Treesets And Map.Entry To Read From A File And Filler The Class's Students'
                \tNames By First And Last Names And Printing Out Only The Duplicate Names""");
        for (int i = 0; i < n; i++) System.out.print("*");
        System.out.println("\n");
    }


    public static void footer() {
        System.out.printf("%n****************%7s~The Program Has Stopped, GoodBye!~%7s****************", "", "");
    }
}
