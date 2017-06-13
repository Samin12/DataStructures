import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by samin on 5/23/2017.
 */
public class Student extends TimesOfDay {
    protected String studentInfo;
    protected String name;
    protected ArrayList<Character> days = new ArrayList<Character>();
    protected ArrayList<Integer> times = new ArrayList<Integer>();

    protected ArrayList<TimesOfDay> studentTimes = new ArrayList<TimesOfDay>();

    Student(){}

    Student(String studentInfo){
        //(Mario<T[1100][2000]><H[2000]>)
        this.name = studentInfo.substring(1,studentInfo.indexOf('<'));

        //find better ways to get days
        String[] splitStudentInfo  = studentInfo.split("\\W");

        for (String c:splitStudentInfo){
            if (c.length()==1){
                //days.add(c.charAt(0));
            }
        }

        //gets times of days
        for (Character day: days) {
            studentTimes.add(new TimesOfDay(day,studentInfo));
        }


    }

    Student(String name, ArrayList days, ArrayList times){
        this.name=name;
        this.days = days;
        this.times = times;
    }

    public ArrayList<Integer> getTimes() {
        return times;
    }

    public ArrayList<Character> getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTimeInfo() {
        return super.getTimeInfo();
    }

    @Override
    public char getDay() {
        return super.getDay();
    }

    public ArrayList<TimesOfDay> getStudentTimes() {
        return studentTimes;
    }

    public String getStudentInfo() {
        return studentInfo;
    }


    public void setDays(ArrayList<Character> days) {
        this.days = days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }
}
