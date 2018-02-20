//12, 1, 78, 90, 57, 89, 56 - 3
import java.util.*;
public class SlidingWinMaxByDeque{
    Deque<Integer> dq = new LinkedList<>();
    //based on indexation of deque
    void  getSlidingMax(int input[], int slideDist){
        int i=0;
        for(i =0; i < slideDist; ++i){
            while(!dq.isEmpty() && input[i] >= input[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i); //1.0, 2.0-1,3.2
        }
        for(;i<input.length; ++i){
            System.out.print(input[dq.peek()]+"-");
            //delete irrelevant elements if window fgreated than distance
            while(!dq.isEmpty() && dq.peek() <= i-slideDist){
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && input[i] >= input[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.println(input[dq.peek()]);
    }
    
    public static void main(String [] args){
        SlidingWinMaxByDeque swd = new SlidingWinMaxByDeque();
        int [] input = new int[]{12, 1, 78, 90, 57, 89, 56};
        swd.getSlidingMax(input,3);
    }
}
