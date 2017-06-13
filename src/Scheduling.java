import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Samin on 6/3/17.
 */

public class Scheduling {

    public static void main(String[] args) throws IOException {

        //takes in from the console
        Scanner in = new Scanner(System.in);

        System.out.println("Enter which dataset you want to analyze");


        String fileLocation = "hw1_set"+in.nextInt()+".txt";

        //reads from the user which file and


        //locates the file
        File file = new File(fileLocation);

        //reads from the file
        Scanner input = new Scanner(file);

        //stores all text from file
        String allText = "";

        while (input.hasNext()) {
            allText = input.next();
        }

        if (!isWellFormed(allText)){
            System.out.println("Invalid Data");
            throw new IllegalArgumentException("expression is not well formed");
        }



        //now parse data from the expressions

        //smaller data set question get one expression parsed by ( )

        // even smaller
        //get the expression cat with ()
        String[] catArr = allText.split("\\)");

        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        for (String studentInfo: catArr){
            studentArrayList.add(new Student(studentInfo));
        }

        System.out.println(Arrays.toString(catArr));




    }

    //method checks if expression is well formed and retruns a boolean
    public static boolean isWellFormed(String allText) {

        VerifyStack<Character> charStack = new VerifyStack<Character>();

        for(int i = 0; i < allText.length(); i++) {
            char letter = allText.charAt(i);
            if(letter == '[' || letter == '(' || letter == '{' ) {

                charStack.push(letter);

            }else if(letter == ']') {
                if(charStack.isEmpty()) return false;
                if(charStack.pop() != '[') return false;

            }else if(letter == ')') {
                if(charStack.isEmpty()) return false;
                if(charStack.pop() != '(') return false;

            }else if(letter == '}') {
                if(charStack.isEmpty()) return false;
                if(charStack.pop() != '{') return false;
            }

        }

        return charStack.isEmpty();
    }

}