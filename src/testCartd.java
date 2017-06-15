import java.util.ArrayList;
import java.util.*;


/**
 * Created by Samin on 6/3/17.
 */
public class testCartd {
    public static void main(String[] args){

        String studentInfo =  " Homer<M[1000]><W[1500]><F[1700]>";

        //cat
        String[] timeInfoArray = studentInfo.split("[\\p{javaWhitespace}<>]+");
        String[] timeInfoArray2 = studentInfo.split("<");
        System.out.println(Arrays.toString(timeInfoArray2));


    }



}
