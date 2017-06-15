import java.io.*;
import java.util.*;

/**
 * Created by Samin on 6/3/17.
 */

public class Scheduling {

    //[\\p{javaWhitespace}<>+]
    public static void main(String[] args) throws IOException {

        //takes in from the console
        Scanner in = new Scanner(System.in);

        System.out.println("Enter which data set you want to analyze");


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
        //get names


        //System.out.println(Arrays.toString(allText.split("\\)")));



        //smaller data set question get one expression parsed by ( )
        String[] parenthesisSplitArray= allText.split("[\\p{javaWhitespace}()]+");


       // System.out.println(Arrays.toString(parenthesisSplitArray));

        ArrayList<Student> studentArray = new ArrayList<Student>();


        for (String studentInfo:parenthesisSplitArray) {
            studentArray.add(new Student(studentInfo));
        }



        //printing the schedule
        int[][] schedule = new int[13][5];

        populate(studentArray,schedule);

//        for (int c = 0; c < studentArray.size() ; c++) {
//            for (String e:studentArray.get(c).getTimes()) {
//                int tempCol = checkCol(e);
//                for (Integer i:checkRows(e)) {
//                    schedule[i][tempCol]++;
//                }
//            }
//
//        }


        //System.out.println(mostPopular(schedule));
        printSchedule(schedule);
        mostPopuarts(schedule);

        //System.out.println(studentArray.get(2).getName());



        String[][] scheduleWithNames = new String[13][5];


        for (int c = 0; c < studentArray.size() ; c++) {

            for (String e:studentArray.get(c).getTimes()) {
                int tempCol = checkCol(e);
                for (Integer i:checkRows(e)) {

                }
            }

        }

        System.out.println();

        for (int row = 0; row <scheduleWithNames.length ; row++) {
            for (int col = 0; col < scheduleWithNames[row].length; col++) {
                System.out.print(scheduleWithNames[row][col]+"                   ");
            }
            System.out.println();
        }


    }


    public static void mostPopuarts(int[][] array){
        ArrayList<Integer> maxProperties = new ArrayList<Integer>();
        int max1 = 0;
        int max2 = 0;
        int max3 = 0; // assuming integer elements in the array

        int max1Row=0;
        int max1Col=0;

        int max2Row=0;
        int max2Col=0;

        int max3Row=0;
        int max3Col=0;


        for (int row = 0; row <array.length ; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col]>max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = array[row][col];
                    max1Row=row;
                    max1Col=col;
                }else if (array[row][col]>=max2){
                        max3 = max2;
                        max2 = array[row][col];
                        max2Row=row;
                        max2Col=col;
                }else if (array[row][col] >=max3) {
                        max3 = array[row][col];


                }
            }
        }


        for (int row = 0; row <array.length ; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col]==max3){
                    max3Col=col;
                    max3Row=row;
                }
            }
        }


        System.out.println("Most Popular Time: "+ colToTime(max1Col)+" at "+rowToTime(max1Row)+" Avaliable for "+max1+" students");
        System.out.println("Second Most Popular Time: "+ colToTime(max2Col)+" at "+rowToTime(max2Row)+" Avaliable for "+max2+" students");
        System.out.println("Thrid Most Popular Time: "+ colToTime(max3Col)+" at "+rowToTime(max3Row)+" Avaliable for "+max3+" students");
    }




    public static void populate(ArrayList<Student> studentArray,int[][] schedule){
        for  (int c = 0; c < studentArray.size() ; c++) {
            for (String e:studentArray.get(c).getTimes()) {
                int tempCol = checkCol(e);
                for (Integer i:checkRows(e)) {
                    schedule[i][tempCol]++;
                }
            }

        }
    }



    public static int checkCol(String timeInfo){
        if (timeInfo.contains("M")){
            return 0;
        }else if (timeInfo.contains("T")){
            return 1;
        }else if (timeInfo.contains("W")){
            return 2;
        }else if (timeInfo.contains("H")){
            return 3;
        }else if (timeInfo.contains("F")){
            return 4;
        }else return 0;

    }

    public static ArrayList<Integer> checkRows(String timeInfo){
        ArrayList<Integer> rows = new ArrayList<Integer>();
        if (timeInfo.contains("0900")){
            rows.add(0);
        }if (timeInfo.contains("1000")){
            rows.add(1);
        }if (timeInfo.contains("1100")){
            rows.add(2);
        }if (timeInfo.contains("1200")){
            rows.add(3);
        }if (timeInfo.contains("1300")){
            rows.add(4);
        }if (timeInfo.contains("1400")){
            rows.add(5);
        }if (timeInfo.contains("1500")){
            rows.add(6);
        }if (timeInfo.contains("1600")){
            rows.add(7);
        }if (timeInfo.contains("1700")){
            rows.add(8);
        }if (timeInfo.contains("1800")){
            rows.add(9);
        }if (timeInfo.contains("1900")){
            rows.add(10);
        }if (timeInfo.contains("2000")){
            rows.add(11);
        }if (timeInfo.contains("2100")){
            rows.add(12);
        }


        return rows;
    }

    public static String rowToTime(int row){
        switch (row){
            case 0:
                return "0900";
            case 1:
                return "1000";
            case 2:
                return "1100";
            case 3:
                return "1200";
            case 4:
                return "1300";
            case 5:
                return "1400";
            case 6:
                return "1500";
            case 7:
                return "1600";
            case 8:
                return "1700";
            case 9:
                return "1800";
            case 10:
                return "1900";
            case 11:
                return "2000";
            case 12:
                return "2100";
            default:
                return "Def";
        }
    }

    public static String colToTime(int col){
        switch (col){
            case 0:
                return "M";
            case 1:
                return "T";
            case 2:
                return "W";
            case 3:
                return "H";
            case 4:
                return "F";
            default:
                return "Def";
        }
    }


    public static void printSchedule(int[][] schedule){
        System.out.println("         _______________________");
        System.out.println("          M    T    W    H    F");
        System.out.println("         _______________________");
        for (int row = 0; row <schedule.length ; row++) {
            if (row==0){
                System.out.print("0900 |");
            }else {
                System.out.print(9+row+"00 |");
            }

            for (int col=0;col<schedule[row].length;col++){
                System.out.print("    ");
                System.out.print(schedule[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //method checks if expression is well formed and retruns a boolean if so using stacks

    public static boolean isWellFormed(String allText) {

        VerifyStack<Character> charStack = new VerifyStack<Character>();

        for(int i = 0; i < allText.length(); i++) {
            char letter = allText.charAt(i);
            if(letter == '[' || letter == '(' || letter == '{' || letter=='<') {

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
            }else if (letter=='>'){
                if (charStack.isEmpty())return false;
                if (charStack.pop()!='<')return false;
            }

        }

        return charStack.isEmpty();
    }


}