import java.util.ArrayList;

/**
 * Created by Samin on 6/3/17.
 */
public class VerifyStack<T> {
    protected ArrayList<T> stackVal = new ArrayList<T>();
    protected int topIndex = -1;



    public void push(T inMove){
        stackVal.add(inMove);
    }
    public T pop(){
        T rChar;
        rChar = (T)stackVal.get(stackVal.size()-1);
        stackVal.remove(stackVal.size()-1);
        return rChar;
    }

    public void printStack(){
        for (T e: stackVal){
            System.out.print(e);
        }
    }

    public T top(){
        return stackVal.get(stackVal.size()-1);
    }

    public boolean isEmpty(){

        return  stackVal.isEmpty();
    }

    public boolean checkInStack(T elem){
        boolean inStack=false;
        for (T e: stackVal){
            if(e.equals(elem)){
                inStack=true;
            }else {
                inStack=false;
            }
        }
        return inStack;
    }




}
