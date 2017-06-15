import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by samin on 5/23/2017.
 */
public class Student {
    protected String name="";


   // ArrayList<TimesOfDay> times = new ArrayList<TimesOfDay>();
    protected ArrayList<String> times = new ArrayList<String>();

    Student(){}
    Student(String studentInfo){
        this.name=" ";
        this.times=timeInfoArray(studentInfo);
    }
    Student(String studnetInfo,String name){
        this.name=name;
        this.times=timeInfoArray(studnetInfo);
    }


    //getters and setters

    public ArrayList<String> getTimes() {
        return times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }


    //methods to get information
    private String makeName(String studentInfo){
        //Homer<M[1000]><W[1500]><F[1700]>
        if (studentInfo.length()>3) {
            String[] timeInfoArray2 = studentInfo.split("<");
            name = timeInfoArray2[0];
        }
        return name;
    }


    private String[] timeInfo(String studentInfo){
        String[] timeInfoArray = studentInfo.split("[\\p{javaWhitespace}<>]+");
        return timeInfoArray;
    }

    private ArrayList<String> timeInfoArray(String studentInfo){

        ArrayList<String> timesArray = new ArrayList<String>();

        for (String e:timeInfo(studentInfo)) {
            if (!e.contains(name)){
                timesArray.add(e);
            }
        }
        this.name=timesArray.get(0);
        timesArray.remove(0);
        return timesArray;
    }


}
