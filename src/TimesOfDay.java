import java.util.ArrayList;

/**
 * Created by Samin on 6/10/17.
 */
public class TimesOfDay {
    private char day;
    private ArrayList<Integer> times = new ArrayList<Integer>();
    private String timeInfo;

    TimesOfDay(){}

    TimesOfDay(char day, String studentInfo){
        this.day=day;
        //(Mario<T[1100][2000]><H[2000]>)
        this.timeInfo = studentInfo.substring(studentInfo.indexOf(day),studentInfo.indexOf('>'));

        //from here
        String[] timesArray =timeInfo.split("\\W");

        ArrayList<Integer> times = new ArrayList<Integer>();


        for(String e:timesArray){
            if (e.length()>2){
                times.add(Integer.parseInt(e));
            }
        }


    }

    public void setDay(char day) {
        this.day = day;
    }

    public char getDay() {
        return day;
    }

    public ArrayList<Integer> getTimes() {
        return times;
    }

    public void setTimeInfo(String timeInfo) {
        this.timeInfo = timeInfo;
    }

    public String getTimeInfo() {
        return timeInfo;
    }

    public void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }
}
