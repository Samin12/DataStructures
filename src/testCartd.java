import java.util.ArrayList;
import java.util.*;


/**
 * Created by Samin on 6/3/17.
 */
public class testCartd {
    public static void main(String[] args){

        String studentInfo =  "(Homer<M[1000]><W[1500]><F[1700]>)(Bart<M[1200]><W[1500]><F[1200]>)(Marge<M[1400]><W[1100]><F[1200]>)(Burns<M[1400]><W[2000]><H[2000]>)(Lisa<T[2000]><W[1600]><H[1100]>)(Flanders<M[1200]><W[1600]><F[1700]>)(Moe<M[1400]><H[1100][2000]>)(Apu<T[2000]><W[1100]><H[1700]>)(Milhouse<T[2000]><H[1700][2000]>)(Barney<M[1000]><W[1500]><T[2000]>)(Krusty<M[1200]><H[1100][2000]>)(Skinner<F[1200]><W[1100]><T[2000]>)(Lenny<M[1400]><W[1500]><H[2000]>)(Carl<W[1600]><T[2000][1400]>)(Nelson<M[1000]><F[1700]><H[2000]>)";



        //cat
        String[] timeInfoArray = studentInfo.split("[\\p{javaWhitespace}<>]+");
        String[] timeInfoArray2 = studentInfo.split("<");
        System.out.println(Arrays.toString(timeInfoArray2));
        for (String e:timeInfoArray2) {
            if (e.contains("T[2000]")){
                System.out.println(e);
            }
        }

    }



}
