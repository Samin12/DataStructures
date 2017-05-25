import java.util.ArrayList;
import java.util.*;
/**
 * Created by samin on 5/23/2017.
 */
public class Student {
    private String name;
    private int StudentID;
    private static int credits;


    private ArrayList<Integer> courseInfo = new ArrayList<>();



    Student(){}

    Student(String name,int StudnetID){
        this.name=name;
        this.StudentID=StudnetID;
    }

    public String getName(){
        return this.name;
    }
    public int getStudentID(){
        return this.StudentID;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setStudentID(int StudentID){
        this.StudentID=StudentID;
    }


    public void sendNYUClassEmail(){
        System.out.println("Sent NYU Classes Email to"+this.name);
    }

    public void enroll(int courseNum,int day, int start, int end,int credits)throws IllegalArgumentException {

        this.credits+=credits;

        courseInfo.add(courseNum);
        courseInfo.add(day);



        courseInfo.add(start);
        courseInfo.add(end);

        if (this.credits > 9) {
            throw new IllegalArgumentException("Cannot take over 9 credits");
        }else {
            courseInfo.add(this.credits);
        }




    }


    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return !start1.after(end2) && !start2.after(end1);
    }




    //incomplete
    public void printSchedule(){



    }

}
